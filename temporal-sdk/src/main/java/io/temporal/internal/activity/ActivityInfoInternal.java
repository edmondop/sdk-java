/*
 * Copyright (C) 2022 Temporal Technologies, Inc. All Rights Reserved.
 *
 * Copyright (C) 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Modifications copyright (C) 2017 Uber Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this material except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.temporal.internal.activity;

import io.temporal.activity.ActivityInfo;
import io.temporal.api.common.v1.Header;
import io.temporal.api.common.v1.Payloads;
import io.temporal.workflow.Functions;
import java.util.Optional;

/**
 * An extension for {@link ActivityInfo} with information about the activity task that the current
 * activity is handling that should be available for Temporal SDK, but shouldn't be available or
 * exposed to Activity implementation code.
 */
interface ActivityInfoInternal extends ActivityInfo {
  /**
   * @return function shat should be triggered after activity completion with any outcome (success,
   *     failure, cancelling)
   */
  Functions.Proc getCompletionHandle();

  /**
   * @return input parameters of the activity execution
   */
  Optional<Payloads> getInput();

  /**
   * @return header that is passed with the activity execution
   */
  Optional<Header> getHeader();
}
