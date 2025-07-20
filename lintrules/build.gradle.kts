plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.android.lint)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.lint.api)
    compileOnly(libs.android.lint.checks)
    compileOnly(libs.kotlin.stdlib)

    testImplementation(libs.android.lint.tests)
    testImplementation(libs.android.lint.lint)
    testImplementation(libs.junit)
//    testImplementation(libs.androidx.appcompat)
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Lint-Registry-v2" to "biz.davidpearson.android.customlintrules.CustomIssueRegistry"
            )
        )
    }
}

//task javadoc(type: Javadoc) {
//    source = android.sourceSets.main.java.srcDirs
//    classpath += project.files(android.getBootClasspath().join(File.pathSeparator))
//}
//
//task sourcesJar(type: Jar, dependsOn: classes) {
//    classifier = 'sources'
//    from sourceSets.main.allSource
//}
//
//task javadocJar(type: Jar, dependsOn: javadoc) {
//    classifier = 'javadoc'
//    from javadoc.destinationDir
//}
