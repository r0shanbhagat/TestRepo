// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}

buildscript {

    repositories {
        google()
        mavenCentral()

        //We still use at least 1 dependency from there
        //noinspection JcenterRepositoryObsolete,GrDeprecatedAPIUsage
        jcenter()

        //for local (before it is released). You don't need a line like this in your projects.
        maven(url = "../../AndroidSdkMaven/maven/' ")

        //for remote (after it is released). You do need a line like this in your projects.
        maven(url = "https://raw.githubusercontent.com/Acuant/AndroidSdkMaven/main/maven/")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        //classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}