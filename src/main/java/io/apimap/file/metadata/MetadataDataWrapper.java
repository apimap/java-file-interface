/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */

package io.apimap.file.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimap.file.exceptions.MissingRequiredFieldException;
import io.apimap.file.validation.ContentValidation;

import java.util.List;

public class MetadataDataWrapper implements ContentValidation {

    /*
    Name
     */
    protected String name; // Required value
    protected String description; // Optional value
    protected String visibility; // Required value

    /*
    Version
     */
    @JsonProperty("api version")
    protected String apiVersion; // Required value

    @JsonProperty("release status")
    protected String releaseStatus; // Required value

    @JsonProperty("system identifier")
    protected String systemIdentifier; // Optional value

    protected List<String> documentation; // Optional value

    /*
    Implementation
     */
    @JsonProperty("interface specification")
    protected String interfaceSpecification; // Required value

    @JsonProperty("interface description language")
    protected String interfaceDescriptionLanguage; // Required value

    /*
    Organization
     */
    @JsonProperty("architecture layer")
    protected String architectureLayer; // Required value

    @JsonProperty("business unit")
    protected String businessUnit; // Required value

    public MetadataDataWrapper() {
    }

    public MetadataDataWrapper(
            String name,
            String description,
            String visibility,
            String apiVersion,
            String releaseStatus,
            String interfaceSpecification,
            String interfaceDescriptionLanguage,
            String architectureLayer,
            String businessUnit,
            String systemIdentifier,
            List<String> documentation) {
        this.name = name;
        this.description = description;
        this.visibility = visibility;
        this.apiVersion = apiVersion;
        this.releaseStatus = releaseStatus;
        this.interfaceSpecification = interfaceSpecification;
        this.interfaceDescriptionLanguage = interfaceDescriptionLanguage;
        this.architectureLayer = architectureLayer;
        this.businessUnit = businessUnit;
        this.systemIdentifier = systemIdentifier;
        this.documentation = documentation;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public String getInterfaceSpecification() {
        return interfaceSpecification;
    }

    public String getInterfaceDescriptionLanguage() {
        return interfaceDescriptionLanguage;
    }

    public String getArchitectureLayer() {
        return architectureLayer;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public String getSystemIdentifier() {
        return systemIdentifier;
    }

    public List<String> getDocumentation() {
        return documentation;
    }

    @Override
    public boolean validContent() throws MissingRequiredFieldException {
        if (name == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_NAME_PROPERTY_TEXT);
        }

        if (visibility == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_VISIBILITY_PROPERTY_TEXT);
        }

        if (apiVersion == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_API_VERSION_PROPERTY_TEXT);
        }

        if (releaseStatus == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_RELEASE_STATUS_PROPERTY_TEXT);
        }

        if (interfaceSpecification == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_INTERFACE_SPECIFICATION_PROPERTY_TEXT);
        }

        if (interfaceDescriptionLanguage == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_INTERFACE_DESCRIPTION_LANGUAGE_PROPERTY_TEXT);
        }

        if (architectureLayer == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_ARCHITECTURE_LAYER_PROPERTY_TEXT);
        }

        if (businessUnit == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_BUSINESS_UNIT_PROPERTY_TEXT);
        }

        return true;
    }

    @Override
    public String toString() {
        return "MetadataDataWrapper{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visibility='" + visibility + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                ", releaseStatus='" + releaseStatus + '\'' +
                ", systemIdentifier='" + systemIdentifier + '\'' +
                ", documentation=" + documentation +
                ", interfaceSpecification='" + interfaceSpecification + '\'' +
                ", interfaceDescriptionLanguage='" + interfaceDescriptionLanguage + '\'' +
                ", architectureLayer='" + architectureLayer + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                '}';
    }
}