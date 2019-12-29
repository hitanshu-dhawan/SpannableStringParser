![SpannableStringParser](images/logo.png)

[![CircleCI](https://circleci.com/gh/hitanshu-dhawan/SpannableStringParser.svg?style=svg)](https://circleci.com/gh/hitanshu-dhawan/SpannableStringParser)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/6ed7afcc6a144e4e814b4b91157ab472)](https://www.codacy.com/manual/hitanshu-dhawan/SpannableStringParser?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=hitanshu-dhawan/SpannableStringParser&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/hitanshu-dhawan/SpannableStringParser/branch/master/graph/badge.svg)](https://codecov.io/gh/hitanshu-dhawan/SpannableStringParser)

In Android, to style our text we use Spans.
<br>
Spans are markup objects that can be applied to parts of the text.

It requires us to deal with the indexes of the text that we want to style.

```kotlin
val string = SpannableString("Text with a foreground color span")
string.setSpan(ForegroundColorSpan(Color.RED), 12, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
```

But what if the text is dynamic and the styling of the text is also dynamic.
<br>
Now, dealing with indexes and styling becomes really difficult for us.

This is where <b>SpannableStringParser</b> helps us.
<br>
You can specify which text to style and how to style them inside the string itself, and use the `spannify()` extension function to style it.

```kotlin
val string = "Text with a { `foreground color` < color : #FF0000 /> } span".spannify()
```

This string can also come from a back-end server and if we wish to change the style of the text in future, the string can be easily changed from back-end and no front-end change will be required.

## Have a Look
Here are some examples...
```kotlin
"Hello { `SpannableStringParser` < color:#0000FF /> }"
```
![](images/have_a_look_1.png)
---
```kotlin
"Hello { `SpannableStringParser` < color:#0000FF ; text-decoration-line:underline /> }"
```
![](images/have_a_look_2.png)
___
```kotlin
"Hello { `SpannableStringParser` < color:#0000FF ; text-decoration-line:underline|line-through /> }"
```
![](images/have_a_look_3.png)

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
