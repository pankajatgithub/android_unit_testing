
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

        sourceSets {
            getByName("test") {
                java.srcDir("src/sharedTest/kotlin")
            }
            getByName("androidTest") {
                java.srcDir("src/sharedTest/kotlin")
            }
        }




    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }


    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs += listOf(
            "-Xjvm-default=all",
            "-opt-in=kotlin.RequiresOptIn"
        )
    }


}

dependencies {

    // -------------------------
    // Core Android
    // -------------------------
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // -------------------------
    // Gson
    // -------------------------
    implementation("com.google.code.gson:gson:2.13.2")

    // -------------------------
    // Lifecycle (MVVM)
    // -------------------------
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")

    // -------------------------
    // Coroutines (ONE version only)
    // -------------------------
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // -------------------------
    // Retrofit
    // -------------------------
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    // MockWebServer for local unit tests
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")

    // Optional: MockWebServer for instrumentation tests
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")

    // -------------------------
    // Glide
    // -------------------------
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // -------------------------
    // Room (compile only)
    // -------------------------
    val room_version = "2.6.1"
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

    // -------------------------
    // UNIT TESTS (JVM ONLY)
    // -------------------------
    testImplementation("junit:junit:4.13.2")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

    // Mockito (JVM only)
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("app.cash.turbine:turbine:1.2.1") // Use the latest version

    // Turbine for Flow testing in androidTest
    androidTestImplementation("app.cash.turbine:turbine:1.0.0")

    // Instrumentation / UI tests
    androidTestImplementation("androidx.test:core:1.5.0-rc01")
    androidTestImplementation("androidx.test:core-ktx:1.5.0-rc01")
    androidTestImplementation("androidx.test.ext:junit:1.1.4-rc01")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4-rc01")
    androidTestImplementation("androidx.test:runner:1.5.0-rc01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0-rc01")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.0-rc01")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")



}
