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

    implementation(libs.appcompat.v161)
    implementation(libs.material.v1110)

    // ROOM
    implementation(libs.room.runtime)
    implementation(libs.play.services.basement)
    implementation(libs.security.crypto)
    annotationProcessor(libs.room.compiler)

    // ViewModel & LiveData
    implementation(libs.lifecycle.viewmodel)

    // Navigation
    implementation(libs.navigation.fragment.v277)
    implementation(libs.navigation.ui.v277)

    // Preferences
    implementation(libs.preference)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.v115)
    androidTestImplementation(libs.espresso.core.v351)
}
