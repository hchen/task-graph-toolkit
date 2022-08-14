/*
 * Copyright 2022 eBay Inc.
 *  Author/Developer: Damian Dolan
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.ebay.ap.diagnostic;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fenzhang
 * Test case
 */
public class DiagnosticHolderTest {

    @Test
    public void testAddDiagnostics() {

        DiagnosticConfig config = new DiagnosticConfig(true, true, true);
        IDiagnosticHolder holder1 = DiagnosticHolder.getDiagnosticHolder(config);
        IDiagnosticHolder holder2 = DiagnosticHolder.getDiagnosticHolder(config);

        holder1.addDiagnostic("sender1", "value1");

        holder2.addDiagnostic("sender1", "value2");

        holder2.addDiagnostic("sender2", "value3");

        Assert.assertTrue(holder1.getDiagnostics().size() == 1);

        holder1.addDiagnostic(holder2);

        Assert.assertTrue(holder1.getDiagnostics().size() == 2);

        List<Diagnostic> list = holder1.getDiagnostics();

        for (Diagnostic diagnostic : list) {
            if (diagnostic.getSender().equalsIgnoreCase("sender1")) {
                Assert.assertTrue(diagnostic.getValue().size() == 2);
            } else {
                Assert.assertEquals("value3", diagnostic.getValue().get(0));
            }
        }

    }

}
