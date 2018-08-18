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

/**
 * Config module.
 *
 * @author verstsiu on 2018/8/18.
 * @version 1.0
 */
interface ConfigModule {
  /**
   * Returns config changed status.
   *
   * @param context context.
   * @param config config.
   */
  fun isConfigChanged(context: Context, config: Configuration): Boolean

  /**
   * Apply config change.
   *
   * @param config config.
   */
  fun applyConfigChange(config: Configuration)

  /**
   * Apply config change(old, API < 17).
   *
   * @param res resources.
   * @param config config.
   */
  fun applyConfigChangeOld(res: Resources, config: Configuration) {
    applyConfigChange(config)
  }

  /**
   * Apply config change(new, API >= 17, replace context).
   *
   * @param config config.
   */
  fun applyConfigChangeNew(config: Configuration) {
    applyConfigChange(config)
  }
}