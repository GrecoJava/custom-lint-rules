plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.gradle.maven.publish.plugin)
}
android {
    namespace = "biz.davidpearson.android.customlintrules"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    lint {
        checkDependencies = true
    }
}


dependencies {
    // implementation(fileTree(dir: 'libs', include: ['*.jar']))

//    androidTestImplementation('androidx.test.espresso:espresso-core:3.1.0', {
//        exclude group: 'com.android.support', module: 'support-annotations'
//    })
//    implementation('androidx.appcompat:appcompat:1.1.0')
//    implementation('androidx.constraintlayout:constraintlayout:1.1.3')
//    testImplementation("junit:junit:${_dep_junit}")

    // lintPublish(project(path: ':lintrules', configuration: 'lintChecks'))
    // implementation(project(":lintrules"))
    lintPublish(project(":lintrules"))
    // lintChecks(project(path: ':lintrules'))
}

//task copyLintJar(type: Copy) {
//    from(configurations.lintChecks) {
//        rename {
//            String filename -> 'lint.jar'
//        }
//    }
//    into 'build/intermediates/lint/'
//}

//task copyLintReleaseAar(type: Copy) {
//    doFirst {
//        println 'starting copyLintReleaseAar'
//    }
//    from("${buildDir}/outputs/aar/lintlib-release.aar")
//    into '../lintdemolibrelease/'
//    doLast {
//        println 'finishing copyLintReleaseAar'
//    }
//}
//
//project.afterEvaluate {
//    def compileLintTask = project.tasks.find { it.name == 'compileLint' }
//    compileLintTask.dependsOn(copyLintJar)
//    copyLintReleaseAar.mustRunAfter(assembleRelease)
//}

// apply plugin: 'com.jfrog.bintray'
//apply plugin: 'com.github.dcendents.android-maven'

// apply plugin: 'maven-publish'

//artifacts {
//    archives javadocJar
//    archives sourcesJar
//}

//bintray {
//    user = bintray_user
//    key = bintray_apikey
//    publications = ['MyPublication']
//    override = 'true'
//    pkg {
//        repo = 'maven'
//        name = 'custom-lint-rules'
//        licenses = ['Apache-2.0']
//        websiteUrl = 'https://github.com/GrecoJava/custom-lint-rules'
//        issueTrackerUrl = 'https://github.com/GrecoJava/custom-lint-rules/issues'
//        vcsUrl = 'https://github.com/GrecoJava/custom-lint-rules.git'
//        labels = ['android', 'lint']
//        githubRepo = 'GrecoJava/custom-lint-rules'
//        githubReleaseNotesFile = 'README.md'
//        version {
//            name = libraryVersion
//            desc = 'Updated to current Lint API'
//            released = new Date()
//        }
//    }
//}

// Create the pom configuration:
//def pomConfig = {
//    licenses {
//        license {
//            name POM_LICENCE_NAME
//            url POM_LICENCE_URL
//            distribution POM_LICENCE_DIST
//        }
//    }
//    developers {
//        developer {
//            id POM_DEVELOPER_ID
//            name POM_DEVELOPER_NAME
//            email POM_DEVELOPER_EMAIL
//            url POM_DEVELOPER_URL
//        }
//    }
//
//    scm {
//        url POM_SCM_URL
//    }
//}

// Create the publication with the pom configuration:
//publishing {
//    publications {
//        MyPublication(MavenPublication) {
//            artifact("${buildDir}/outputs/aar/lintlib-release.aar")
//            artifact("../lintrules/build/libs/lintrules-javadoc.jar") {
//                classifier 'javadoc'
//                extension 'jar'
//            }
//            artifact("../lintrules/build/libs/lintrules-sources.jar") {
//                classifier 'sources'
//                extension 'jar'
//            }
//
//            groupId GROUP
//            artifactId POM_ARTIFACT_ID
//            version libraryVersion
//            pom.packaging = POM_PACKAGING
//            pom.withXml {
//                def root = asNode()
//                root.appendNode('description', POM_DESCRIPTION)
//                root.appendNode('name', POM_NAME)
//                root.appendNode('url', POM_URL)
//                root.children().last() + pomConfig
//
//                def dependenciesNode = root.appendNode('dependencies')
//
//                configurations.compile.allDependencies.each {
//                    if (it.group != null && it.name != null) {
//                        def dependencyNode = dependenciesNode.appendNode('dependency')
//                        dependencyNode.appendNode('groupId', it.group)
//                        dependencyNode.appendNode('artifactId', it.name)
//                        dependencyNode.appendNode('version', it.version)
//                    }
//                }
//            }
//        }
//    }
//}

