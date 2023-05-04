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

package io.apimap.file.exceptions;

public class MissingRequiredFieldException extends Exception {
    public static final String MISSING_VERSION_TEXT = "Missing required version identifier";
    public static final String MISSING_DATA_OBJECT_TEXT = "Missing required data object";
    public static final String MISSING_NAME_PROPERTY_TEXT = "Missing required property: \"name\"";
    public static final String MISSING_VISIBILITY_PROPERTY_TEXT = "Missing required property: \"visibility\"";
    public static final String MISSING_API_VERSION_PROPERTY_TEXT = "Missing required property: \"api version\"";
    public static final String MISSING_RELEASE_STATUS_PROPERTY_TEXT = "Missing required property: \"release status\"";
    public static final String MISSING_INTERFACE_SPECIFICATION_PROPERTY_TEXT = "Missing required property: \"interface specification\"";
    public static final String MISSING_INTERFACE_DESCRIPTION_LANGUAGE_PROPERTY_TEXT = "Missing required property: \"interface description language\"";
    public static final String MISSING_ARCHITECTURE_LAYER_PROPERTY_TEXT = "Missing required property: \"architecture layer\"";
    public static final String MISSING_BUSINESS_UNIT_PROPERTY_TEXT = "Missing required property: \"business unit\"";
    public static final String MISSING_TAXONOMY_NAME_PROPERTY_TEXT = "Missing required property: \"taxonomy\"";
    public static final String MISSING_TAXONOMY_CLASSIFICATIONS_PROPERTY_TEXT = "Missing or empty required property: \"classifications\"";

    public MissingRequiredFieldException(String message) {
        super(message);
    }
}
