Custom Lint Rules
=================

A small library of lint rules that can be applied to an Android project.

Lint
----

The following lint rules are provided:

* **PrintStackTrace** (Error) - Detects the use of printStackTrace method calls.

        Example.java:17: Do not use printStackTrace [PrintStackTrace]
            } catch (Exception e) {
                e.printStackTrace();
               ~~~~~~~~~~~~~~~                                                    
            }

To disable a lint rule, in your modules's `build.gradle`, add a `disable` statement for the rule.  

```groovy
    lintOptions {
        ...
        disable 'PrintStackTrace'
        ...
    }
```

Download
--------

```groovy
compile 'biz.davidpearson.android:custom-lint-rules:0.1.0'
```

Credits
-------
* The `.aar` production is based on the LinkedIn Engineering blog post [Writing Custom Lint Checks with Gradle](https://engineering.linkedin.com/android/writing-custom-lint-checks-gradle)
* The lint rule code and tests are inspired by the lint rules in Jake Wharton's [Timber](https://github.com/JakeWharton/timber)  project.

License
-------

    Copyright 2017 David Pearson

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
