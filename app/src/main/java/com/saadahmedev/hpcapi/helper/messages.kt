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
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

interface SnackbarActionListener {
    fun onActionClicked(snackbar: Snackbar)
}

fun snackBar(view: View, message: String, action: String, duration: Int, listener: SnackbarActionListener) {
    val snackbar = Snackbar.make(view, message, duration)
    snackbar.setAction(action) {
            listener.onActionClicked(snackbar)
        }
    snackbar.show()
}

fun toast(context: Context, message: String, duration: Int) {
    Toast.makeText(context, message, duration).show()
}