plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.safeArgs)
}

android {
    namespace = "com.lugmana_andres.appdispo2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lugmana_andres.appdispo2"
        minSdk = 30
        targetSdk = 34
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.bundles.retrofit)
    implementation(libs.coil)
    implementation(libs.lottieLib)

    implementation(libs.swipeRefreshLayout)
    implementation(libs.coordinatorLayout)
    implementation(libs.roomRuntime)
    ksp(libs.roomCompiler)
    implementation(libs.biometric)
    implementation(libs.splashScreen)
    implementation(libs.dataStorePreferences)
    implementation(libs.navigationFragmentKtx)
    implementation(libs.navigationUiKtx)
    implementation(libs.fragmentKtx)
    implementation(libs.activityKtx)
    implementation(libs.viewModelKtx)
    implementation(libs.liveDataKtx)


}