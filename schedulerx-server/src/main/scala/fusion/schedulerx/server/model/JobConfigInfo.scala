/*
 * Copyright 2019 akka-fusion.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fusion.schedulerx.server.model

import java.time.OffsetDateTime

import fusion.schedulerx.protocol.{ ExecuteMode, JobType }

case class JobConfigInfo(
    namespace: String,
    jobId: String,
    groupId: String,
    jobType: JobType,
    name: String,
    executeMode: ExecuteMode,
    parameters: Map[String, String] = Map(),
    description: Option[String] = None,
    className: Option[String] = None,
    jarUrl: Option[String] = None,
    // 当非Java任务执行时，在此填写代码内容
    codeContent: Option[String] = None,
    maxConcurrency: Option[Int] = Some(1),
    maxAttempt: Option[Int] = Some(0),
    // 错误重试间隔（秒）
    attemptInterval: Option[Int] = Some(30),
    timeType: Option[Int] = Some(1),
    timeExpression: Option[String] = None,
    // Job执行超时（秒）
    timeout: Option[Long] = Some(7200),
    // 是否允许杀死JOB？
    killEnable: Option[Boolean] = None,
    // 第一次触发时间
    triggerStartTime: Option[OffsetDateTime] = None,
    // 最后一次触发时间
    triggerEndTime: Option[OffsetDateTime] = None,
    tags: Map[String, String] = Map(),
    createdAt: OffsetDateTime = OffsetDateTime.now())
