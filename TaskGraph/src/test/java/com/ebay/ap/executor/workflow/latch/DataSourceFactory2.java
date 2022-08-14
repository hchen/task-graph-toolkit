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

package com.ebay.ap.executor.workflow.latch;

import com.ebay.ap.executor.ICallableTaskFuture;
import com.ebay.ap.executor.workflow.DataSourceTask;
import com.ebay.ap.executor.workflow.ITaskFactory;

public class DataSourceFactory2 implements ITaskFactory<LatchWorkflowBuilder, String> {

    @Override
    public ICallableTaskFuture<String> create(LatchWorkflowBuilder builder) {
        return builder.addTask(new DataSourceTask("secondTask", builder.async, "secondResponse", builder.request.secondTime));
    }

}
