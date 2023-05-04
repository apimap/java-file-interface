/*
Copyright 2021-2023 TELENOR NORGE AS

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package io.apimap.file.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimap.file.exceptions.MissingRequiredFieldException;
import io.apimap.file.exceptions.UnsupportedVersionException;
import io.apimap.file.validation.ContentValidation;

public class MetadataFile implements ContentValidation {
    public static final String FILENAME = "metadata.apicatalog";
    public static final String SUPPORTED_VERSION = "1";

    @JsonProperty("api catalog version")
    protected String version;
    protected MetadataDataWrapper data;

    public MetadataFile() {
    }

    public MetadataFile(String version, MetadataDataWrapper data) {
        this.version = version;
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public MetadataDataWrapper getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MetadataFile{" +
                "version='" + version + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean validContent() throws MissingRequiredFieldException, UnsupportedVersionException {
        if (version == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_VERSION_TEXT);
        }

        if (data == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_DATA_OBJECT_TEXT);
        }

        if (!version.equals(SUPPORTED_VERSION)) {
            throw new UnsupportedVersionException("Supported versions: [" + SUPPORTED_VERSION + "]");
        }

        return data.validContent();
    }
}
