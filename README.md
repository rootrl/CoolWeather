# CoolWeather
Android application source code.  《第一行代码》In action

# Development note

- AS 3.2: replace 'compile' to 'implementation' in build.gradle
- failed to resolve dependencies （for example: org.litepal）

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

-  Resource is not a Drawable (color or path)

copy source file both bo drawable and drawable-v24

# Screenshot

<img src="https://raw.githubusercontent.com/rootrl/CoolWeather/master/screenshot.jpg" width="300" height="500">
