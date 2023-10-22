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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

fun linearLayoutManager(context: Context) = LinearLayoutManager(context)
fun staggeredGridLayoutManager(itemCount: Int) = StaggeredGridLayoutManager(itemCount, LinearLayoutManager.VERTICAL)
fun RecyclerView.setLinearLayoutManager(context: Context) {
    this.layoutManager = linearLayoutManager(context)
}

fun RecyclerView.setReverseLayoutManager(context: Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
}

fun RecyclerView.setStaggeredGridLayoutManager(gridCount: Int) {
    this.layoutManager = staggeredGridLayoutManager(gridCount)
}

fun RecyclerView.setHorizontalLayoutManager(context: Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}

fun Context.setLinearLayoutManager(vararg recyclerViews: RecyclerView) {
    for (rv in recyclerViews) rv.setLinearLayoutManager(this)
}

fun Context.setHorizontalLayoutManager(vararg recyclerViews: RecyclerView) {
    for (rv in recyclerViews) rv.setHorizontalLayoutManager(this)
}