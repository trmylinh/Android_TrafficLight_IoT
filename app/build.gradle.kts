plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.lighttraffic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lighttraffic"
        minSdk = 24
        targetSdk = 34
        versionCode = 3
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

    //scalable unit size
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    //fragment extension
    val fragment_version = "1.4.0"
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // OpenStreetMap
    implementation("org.osmdroid:osmdroid-android:6.1.14")

    //zxing-android-embedded (scanner qr code)
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("com.google.zxing:core:3.3.3")

}