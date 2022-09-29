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

package com.ebay.taskgraph.executor;

/**
 * Simple interface for submitting tasks to an executor.
 */
public interface ICallableTaskExecutor {

    /**
     * Submits a task to the executor.  Wraps the task in a profile decorator.
     */
    <T> ICallableTaskFuture<T> addTask(ICallableTask<T> task);
    
    /**
     * Fetch a task by name.
     */
    <T> ICallableTaskFuture<T> getTask(String name);

    /**
     * Aggregate all task response contexts.
     */
    void collectResponseContext(ICallableTask<?> parentTask);

}