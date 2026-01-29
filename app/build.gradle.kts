plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")   // REQUIRED

}

android {
    namespace = "com.example.testcase"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.testcase"
        minSdk = 24
        targetSdk = 36
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

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // App dependencies
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.code.gson:gson:2.8.6")

    // Room
    val room_version = "2.6.1"

    // Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    kapt("androidx.room:room-compiler:$room_version")
    kaptAndroidTest("androidx.room:room-compiler:$room_version")

    androidTestImplementation("androidx.room:room-testing:$room_version")      // Kotlin extensions
             // KSP for annotation processing

    // Optional Room support libraries
    implementation("androidx.room:room-rxjava2:$room_version")
    implementation("androidx.room:room-rxjava3:$room_version")
    implementation("androidx.room:room-guava:$room_version")
    implementation("androidx.room:room-paging:$room_version")
    testImplementation("androidx.room:room-testing:$room_version")

    // Unit tests
    testImplementation("junit:junit:4.13.2")
    testImplementation(kotlin("test"))

    // Instrumentation / UI tests
    androidTestImplementation("androidx.test:core:1.5.0-rc01")
    androidTestImplementation("androidx.test:core-ktx:1.5.0-rc01")
    androidTestImplementation("androidx.test.ext:junit:1.1.4-rc01")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4-rc01")
    androidTestImplementation("androidx.test:runner:1.5.0-rc01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0-rc01")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.0-rc01")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")

    testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("org.mockito:mockito-inline:5.11.0")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")
    androidTestImplementation("org.mockito:mockito-android:5.11.0")

}
