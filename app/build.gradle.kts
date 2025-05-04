plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "minicla03.coinquylife"
    compileSdk = 35

    defaultConfig {
        applicationId = "minicla03.coinquylife"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.lifecycle.viewmodel.android)
    implementation(libs.ext.junit)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.espresso.intents)
    implementation(libs.fragment.testing)
    implementation(libs.room.common.jvm)
    implementation(libs.room.runtime.android)
    implementation(libs.preference)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
}