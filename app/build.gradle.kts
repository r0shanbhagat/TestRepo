plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

repositories {
    //maven(url= "https://raw.githubusercontent.com/iProov/android/master/maven/")
}

android {
    namespace = "com.roshan.actuantcamera"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.roshan.actuantcamera"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.acuant:acuantcommon:11.6.0")
    implementation("com.acuant:acuantcamera:11.6.0")
    implementation("com.acuant:acuantimagepreparation:11.6.0")
    implementation("com.acuant:acuantdocumentprocessing:11.6.0")
    implementation("com.acuant:acuantechipreader:11.6.0")
    implementation("com.acuant:acuantipliveness:11.6.0")
    implementation("com.acuant:acuantfacematch:11.6.0")
    implementation("com.acuant:acuantfacecapture:11.6.0")
    implementation("com.acuant:acuantpassiveliveness:11.6.0")
}