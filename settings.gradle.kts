pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
//    resolutionStrategy {
//        eachPlugin {
//            if (requested.id.id == "com.android.application") {
//                useModule("com.android.tools.build:gradle:${requested.version}")
//            }
//            if (requested.id.id == "com.google.gms.google-services") {
//                useModule("com.google.gms:google-services:${requested.version}")
//            }
//        }
//    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":lintlib")
include(":lintrules")
