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

package io.curity.identityserver.plugin.anonymous.authentication

import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.attribute.Attributes
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.attribute.ContextAttributes
import se.curity.identityserver.sdk.attribute.SubjectAttributes
import se.curity.identityserver.sdk.authentication.AuthenticationResult
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler
import se.curity.identityserver.sdk.config.Configuration
import se.curity.identityserver.sdk.config.annotation.DefaultBoolean
import se.curity.identityserver.sdk.config.annotation.DefaultString
import se.curity.identityserver.sdk.config.annotation.Description
import se.curity.identityserver.sdk.web.Request
import se.curity.identityserver.sdk.web.Response
import java.util.Date
import java.util.Optional
import java.util.UUID


interface AnonymousAuthenticatorPluginConfig : Configuration {
    @DefaultBoolean(true)
    @Description("Create a random username for each request. When disabled, a static username will be used.")
    fun useRandomUserName(): Boolean

    @DefaultString("static-username")
    @Description("When random username is disabled, use this static username for all requests.")
    fun staticUserName(): String
}

class AnonymousAuthenticatorRequestHandler(private val config: AnonymousAuthenticatorPluginConfig) : AuthenticatorRequestHandler<Any> {
    override fun preProcess(request: Request?, response: Response?): Any = Object()

    override fun post(requestModel: Any?, response: Response?): Optional<AuthenticationResult> = Optional.empty()

    override fun get(requestModel: Any, response: Response): Optional<AuthenticationResult> {
        val userName = if (config.useRandomUserName()) UUID.randomUUID().toString() else config.staticUserName()
        return Optional.of(
                AuthenticationResult(
                        AuthenticationAttributes.of( SubjectAttributes.of(userName, Attributes.empty()),
                                ContextAttributes.of(Attributes.of(Attribute.of("iat", Date().time))))))
    }
}
