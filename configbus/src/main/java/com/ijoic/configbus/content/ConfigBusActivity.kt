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
package com.ijoic.configbus.content

import android.content.Context
import android.support.v4.app.FragmentActivity
import com.ijoic.configbus.ConfigBus

/**
 * Config bus activity.
 *
 * @author verstsiu on 2018/8/18.
 * @version 1.0
 */
open class ConfigBusActivity: FragmentActivity() {
  override fun attachBaseContext(newBase: Context?) {
    super.attachBaseContext(ConfigBus.wrapContext(newBase))
  }
}