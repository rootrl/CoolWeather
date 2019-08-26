# CoolWeather
Android application source code.  《第一行代码》In action

# Development note

- in build.gradle: 'compile' replaced with 'implementation'
- failed to resolve org.litepal

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