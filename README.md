![SpannableStringParser](images/logo.png)

SpannableStringParser is a ...

## Have a Look(*)

## Download
Add JitPack repository to your root `build.gradle` file
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency to your app `build.gradle` file
```
dependencies {
    implementation 'com.github.hitanshu-dhawan:SpannableStringParser:1.0.x'
}
```

## Usage(*)
- text having a declaration
```
{ `text` < property : value /> }
```
- text having a declaration with multiple values
```
{ `text` < property : value | value /> }
```
- text having multiple declarations
```
{ `text` < property : value ; property : value /> }
```

## Supported Properties
#### `color`
> The `color` property specifies the color of text.

Examples: `color : #FF00FF` , `color : #00FF00FF`
<br><br>
#### `text-decoration-line`
> The `text-decoration-line` property sets the kind of text decoration to use (like underline, line-through).

Examples: `text-decoration-line : underline` , `text-decoration-line : line-through`
<br><br>
#### `font-size`
> The `font-size` property sets the size of a font.

Examples: `font-size : 12dp` , `font-size : 1.5em` , `font-size : 24px`
<br><br>
#### `font-style`
> The `font-style` property specifies the font style for a text.

Examples: `font-style : italic`
<br><br>
#### `font-weight`
> The `font-weight` property sets how thick or thin characters in text should be displayed.

Examples: `font-weight : bold`
<br><br>
#### `more-properties-coming-soon`
You can add your custom properties using the `spanner` method.
<br>
But! If you want any property to be added in SpannableStringParser, feel free to open issues/pull requests.
<br><br>

## Licence
```
Copyright (c) 2019 Hitanshu Dhawan

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
