/*
 *
 *  Copyright(c) 2018 VerstSiu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.ijoic.configbus

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build

/**
 * Config bus.
 *
 * @author verstsiu on 2018/8/18.
 * @version 1.0
 */
object ConfigBus {
  /**
   * Module items.
   */
  internal var moduleItems: List<ConfigModule>? = null

  /**
   * Wrap context with config settings.
   *
   * @param context context.
   */
  fun wrapContext(context: Context?): Context? {
    context ?: return null
    val oldConfig = context.resources.configuration ?: return context
    val items = this.moduleItems?.filter { it.isConfigChanged(context, oldConfig) }

    if (items == null || items.isEmpty()) {
      return context
    }
    return updateResources(context, { res, config ->
      items.forEach { it.applyConfigChangeOld(res, config) }
    }, { config ->
      items.forEach { it.applyConfigChangeNew(config) }
    })
  }

  private fun updateResources(context: Context, onConfigOld: (Resources, Configuration) -> Unit, onConfigNew: (Configuration) -> Unit): Context {
    val res = context.resources
    val config = Configuration(res.configuration)

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      onConfigNew(config)
      context.createConfigurationContext(config)
    } else {
      onConfigOld(res, config)
      context
    }
  }
}