// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.gradle.maven.publish.plugin) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
}
//buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath 'com.android.tools.build:gradle:8.11.1'
//
//
//        // classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4'
//
//        /**
//         * [GitHub](https://github.com/vanniktech/gradle-maven-publish-plugin)
//         */
//        classpath 'com.vanniktech:gradle-maven-publish-plugin:0.34.0'
//
//        // classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
//        // NOTE: Do not place your application dependencies here; they belong
//        // in the individual module build.gradle files
//    }
//}

//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//    }
//
//    ext {
//        _minSdkVersion = 14
//        _targetSdkVersion = 30
//        _compileSdkVersion = 30
//
//        _dep_lint_version = "27.1.0" // AGP version x.y.z -> x+23.y.z
//
//        _dep_android_support = '26.0.0'
//        _dep_android_support_constraintlayout = '1.0.2'
//        _dep_android_support_test_espresso = '2.2.2'
//        _dep_android_tools = '26.0.0'
//        _dep_junit = '4.12'
//        _dep_fest = '2.0M10'
//
//        bintrayRepo = 'maven'
//        bintrayName = 'custom-lint-rules'
//
//        publishedGroupId = GROUP
//        libraryName = 'lintlib'
//        artifact = POM_ARTIFACT_ID
//
//        libraryDescription = POM_DESCRIPTION
//
//        siteUrl = POM_URL
//        gitUrl = POM_SCM_CONNECTION
//
//        libraryVersion = VERSION_NAME
//
//        developerId = POM_DEVELOPER_ID
//        developerName = POM_DEVELOPER_NAME
//        developerEmail = POM_DEVELOPER_EMAIL
//
//        licenseName = POM_LICENCE_NAME
//        licenseUrl = POM_LICENCE_URL
//        allLicenses = ["Apache-2.0"]
//
//    }
//}

//tasks {
//    @Suppress("unused") val clean by registering(Delete::class) {
//        delete(layout.buildDirectory)
//    }
//}

