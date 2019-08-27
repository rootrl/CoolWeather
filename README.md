# CoolWeather
Android application source code.  《第一行代码》In action

# Development note

- AS 3.2: replace 'compile' to 'implementation' in build.gradle
- failed to resolve dependencies like org.litepal

add maven url to allprojects item:

``` bash
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```