plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android) // 'jetbrains'를 삭제했습니다.
    alias(libs.plugins.ksp)            // 추가
    alias(libs.plugins.hilt)           // 추가
}

android {
    namespace = "com.example.teanotes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.teanotes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)

    // 이 부분의 네이밍을 주의 깊게 보십시오.
    implementation(libs.androidx.lifecycle.runtime)    // libs.androidx.lifecycle.runtime.ktx 대신
    implementation(libs.androidx.lifecycle.viewmodel)  // libs.androidx.lifecycle.viewmodel 대신

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    debugImplementation(libs.androidx.ui.tooling)
}