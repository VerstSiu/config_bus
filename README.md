
# Config Bus

Android config bus library project. Help to manage app custom context config.

## Usage

* Declare config module:

    ```kotlin
    class FontSizeConfigModule: ConfigModule {
      private val defaultFontScale = 1.0F

      ovrride fun isConfigChanged(context: Context, config: Configuration): Boolean {
        return config.fontScale != defaultFontScale
      }

      override fun applyConfigChange(config: Configuration) {
        config.fontScale = defaultFontScale
      }
    }
    ```

* Add config settings to `Application`:

    ```kotlin
    class MyApplication: Application {
      init {
        ConfigBus.config()
          .addModule(LanConfigModule())
          .addModule(FontScaleConfigModule())
          .apply()
      }

      override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(ConfigBus.wrapContext(base))
      }

      override fun onConfigurationChanged(newConfig: Configuration?) {
        ConfigBus.wrapContext(this)
        super.onConfigurationChanged(newConfig)
      }

      override fun onCreate() {
        super.onCreate()
        ConfigBus.wrapContext(this)
      }
    }
    ```

* Add config settings to `Activity`:

    ```kotlin
    class MyActivity: Activity() {
      override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ConfigBus.wrapContext(newBase))
      }
    }
    ```

## License

```

   Copyright(c) 2017 VerstSiu

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```