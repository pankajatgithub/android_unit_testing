plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
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


    dependencies {

        // App dependencies
        implementation("androidx.core:core-ktx:1.7.0")
        implementation("androidx.appcompat:appcompat:1.5.1")
        implementation("com.google.android.material:material:1.6.1")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("com.google.code.gson:gson:2.8.6")

        // Unit tests
        testImplementation("junit:junit:4.12")

        // Instrumentation / UI tests
        androidTestImplementation("androidx.test:core:1.5.0-rc01")
        androidTestImplementation("androidx.test:core-ktx:1.5.0-rc01")
        androidTestImplementation("androidx.test.ext:junit:1.1.4-rc01")
        androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4-rc01")
        androidTestImplementation("androidx.test:runner:1.5.0-rc01")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0-rc01")
        androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.0-rc01")
    }
    testImplementation(kotlin("test"))

}

