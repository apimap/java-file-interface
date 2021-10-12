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

package io.apimap.file;

import io.apimap.file.metadata.MetadataFile;
import io.apimap.file.exceptions.UnsupportedVersionException;
import io.apimap.file.metadata.MetadataDataWrapper;
import io.apimap.file.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetadataFileTest {
    @Test
    public void allContent_didSucceed() throws MissingRequiredFieldException, UnsupportedVersionException {
        MetadataDataWrapper data = new MetadataDataWrapper(
                "My First API",
                "This is my first api description",
                "Public",
                "1.0.0",
                "In Production",
                "TM Forum Open API - Account Management API",
                "OpenAPI Specification",
                "DC",
                "Apimap.io",
                "SYS1010",
                Arrays.asList("url1", "url2")
        );

        MetadataFile file = new MetadataFile(MetadataFile.SUPPORTED_VERSION, data);
        assertEquals(true, file.validContent());
    }
}
