/*
 *  Copyright 2019 Curity AB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.curity.identityserver.plugin.anonymous.descriptor

import io.curity.identityserver.plugin.anonymous.authentication.AnonymousAuthenticatorPluginConfig
import io.curity.identityserver.plugin.anonymous.authentication.AnonymousAuthenticatorRequestHandler
import se.curity.identityserver.sdk.haapi.RepresentationFunction
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor

class AnonymousAuthenticatorPluginDescriptor : AuthenticatorPluginDescriptor<AnonymousAuthenticatorPluginConfig> {
    override fun getAuthenticationRequestHandlerTypes() =
            mapOf("index" to AnonymousAuthenticatorRequestHandler::class.java)

    override fun getConfigurationType() =
            AnonymousAuthenticatorPluginConfig::class.java

    override fun getPluginImplementationType(): String = "anonymous"

    override fun getRepresentationFunctions(): MutableMap<String, Class<out RepresentationFunction>> = mutableMapOf()
}
