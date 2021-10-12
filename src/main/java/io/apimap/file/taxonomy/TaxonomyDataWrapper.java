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

package io.apimap.file.taxonomy;

import io.apimap.file.exceptions.MissingRequiredFieldException;
import io.apimap.file.validation.ContentValidation;

import java.util.ArrayList;

public class TaxonomyDataWrapper implements ContentValidation {
    protected String taxonomy;
    protected ArrayList<String> classifications;

    public TaxonomyDataWrapper() {
    }

    public TaxonomyDataWrapper(String taxonomy, ArrayList<String> classifications) {
        this.taxonomy = taxonomy;
        this.classifications = classifications;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public ArrayList<String> getClassifications() {
        return classifications;
    }

    @Override
    public String toString() {
        return "TaxonomyDataWrapper{" +
                "taxonomy='" + taxonomy + '\'' +
                ", classifications=" + classifications +
                '}';
    }

    @Override
    public boolean validContent() throws MissingRequiredFieldException {
        if (taxonomy == null) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_TAXONOMY_NAME_PROPERTY_TEXT);
        }

        if (classifications == null || classifications.size() < 1) {
            throw new MissingRequiredFieldException(MissingRequiredFieldException.MISSING_TAXONOMY_CLASSIFICATIONS_PROPERTY_TEXT);
        }

        return true;
    }
}
