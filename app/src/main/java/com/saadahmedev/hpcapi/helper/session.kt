/*
 * Copyright 2018-2023 Saad Ahmed
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

package com.saadahmedev.hpcapi.helper

import android.content.Context
import com.saadahmedev.hpcapi.util.SessionManager

fun Context.getToken(): String? = SessionManager.getInstance(this).token
fun Context.getBearerToken(): String? = SessionManager.getInstance(this).bearerToken
fun Context.getPhone(): String? = SessionManager.getInstance(this).number

fun Context.setToken(token: String) {
    SessionManager.getInstance(this).setToken(token)
}

fun Context.setBearerToken(bearerToken: String) {
    SessionManager.getInstance(this).setBearerToken(bearerToken)
}

fun Context.setPhone(phone: String) {
    SessionManager.getInstance(this).setNumber(phone)
}