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

import io.apimap.file.exceptions.UnsupportedVersionException;
import io.apimap.file.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadMetadataFileTest {
    @Test()
    public void readMetadataWithoutContent_didFailOnMissingVersion() throws UnsupportedVersionException, MissingRequiredFieldException, IOException {
        String initialString = "{}";
        InputStream input = new ByteArrayInputStream(initialString.getBytes());

        Assertions.assertThrows(MissingRequiredFieldException.class, () -> {
            FileFactory.metadataFromInputStream(input);
        });
    }

    @Test()
    public void readMetadataWithoutContent_didFailOnMissingData() throws UnsupportedVersionException, MissingRequiredFieldException, IOException {
        String initialString = "{\"api catalog version\":\"1\"}";
        InputStream input = new ByteArrayInputStream(initialString.getBytes());

        Assertions.assertThrows(MissingRequiredFieldException.class, () -> {
            FileFactory.metadataFromInputStream(input);
        });
    }

    @Test()
    public void readMetadataWithoutContent_didFailOnWrongVersion() throws UnsupportedVersionException, MissingRequiredFieldException, IOException {
        String initialString = "{\"data\": {}, \"api catalog version\":\"2\"}";
        InputStream input = new ByteArrayInputStream(initialString.getBytes());

        Assertions.assertThrows(UnsupportedVersionException.class, () -> {
            FileFactory.metadataFromInputStream(input);
        });
    }

    @Test()
    public void readMetadataWithoutContent_didFailOnEmptyData() throws UnsupportedVersionException, MissingRequiredFieldException, IOException {
        String initialString = "{\"data\": {}, \"api catalog version\":\"1\"}";
        InputStream input = new ByteArrayInputStream(initialString.getBytes());

        Assertions.assertThrows(MissingRequiredFieldException.class, () -> {
            FileFactory.metadataFromInputStream(input);
        });
    }
}
