pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url= "https://jitpack.io" )
        maven(url = "https://maven.google.com")
        maven(url = "https://raw.githubusercontent.com/Acuant/AndroidSdkMaven/main/maven/")
        maven(url = "https://raw.githubusercontent.com/iProov/android/master/maven/")

    }
}

rootProject.name = "ActuantCamera"
include(":app")
 