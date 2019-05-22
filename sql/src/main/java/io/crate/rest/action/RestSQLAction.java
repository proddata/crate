/*
 * Licensed to Crate under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Crate licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial
 * agreement.
 */

package io.crate.rest.action;

import io.crate.action.sql.SQLOperations;
import io.crate.auth.user.UserManager;
import io.crate.breaker.CrateCircuitBreakerService;
import io.crate.plugin.PipelineRegistry;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Provider;
import org.elasticsearch.common.inject.Singleton;
import org.elasticsearch.common.settings.Settings;

@Singleton
public class RestSQLAction {

    @Inject
    public RestSQLAction(Settings settings,
                         SQLOperations sqlOperations,
                         PipelineRegistry pipelineRegistry,
                         Provider<UserManager> userManagerProvider,
                         CrateCircuitBreakerService breakerService) {
        UserManager userManager = userManagerProvider.get();
        pipelineRegistry.addBefore(new PipelineRegistry.ChannelPipelineItem(
            "handler",
            "sql_handler",
            corsConfig -> new SqlHttpHandler(
                settings,
                sqlOperations,
                breakerService::getBreaker,
                userManager,
                userManager::getAccessControl,
                corsConfig
            )
        ));
    }
}
