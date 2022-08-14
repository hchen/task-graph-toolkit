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

import com.ebay.ap.executor.CallableTaskConfig;
import com.ebay.ap.executor.ICallableTask;
import com.ebay.ap.executor.Task;

/**
 * Task that blocks on a single countdown latch.
 *
 * @param <T>
 */
public class WaitForSingleCountDownLatchTask<T> extends Task implements ICallableTask<T> {

    private final SingleCountDownLatch<T> latch;

    public WaitForSingleCountDownLatchTask(
            CallableTaskConfig config,
            SingleCountDownLatch<T> latch) {
        super(config);
        this.latch = latch;
    }

    public WaitForSingleCountDownLatchTask(
            String taskName,
            CallableTaskConfig config,
            SingleCountDownLatch<T> latch) {
        super(taskName, config);
        this.latch = latch;
    }

    @Override
    public T call() throws Exception {
        
        return this.latch.await(this.getTaskConfig().timeout, this);
    }
    
}
