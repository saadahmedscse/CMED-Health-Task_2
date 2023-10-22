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

import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.saadahmedev.hpcapi.R

fun View.navigate(id: Int) {
    val navBuilder = NavOptions.Builder()
    navBuilder
        .setEnterAnim(R.anim.fade_enter)
        .setExitAnim(R.anim.fade_exit)
        .setPopEnterAnim(R.anim.fade_enter)
        .setPopExitAnim(R.anim.fade_exit)

    Navigation.findNavController(this).navigate(id, null, navBuilder.build())
}