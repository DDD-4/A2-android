plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Config.CompileSDK)

    defaultConfig {
        applicationId = "kr.ddd.a2"
        minSdkVersion(Config.MinSDK)
        targetSdkVersion(Config.TargetSDK)
        versionCode = Config.VersionCode
        versionName = Config.VersionName

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }

    buildFeatures.dataBinding = true

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
        getByName("test").java.srcDir("src/test/kotlin")
    }


    buildFeatures.dataBinding = true
}

dependencies {
    implementation(project(path = ":data"))
    implementation(project(path = ":domain"))

    // Kotlin
    implementation(Libs.Kotlin)

    // ConstraintLayout
    implementation(Libs.ConstraintLayout)
    implementation(Libs.Material)

    // Lifecycle
    implementation(Libs.LifecycleRuntime)
    implementation(Libs.LifecycleExt)
    implementation(Libs.LifecycleViewModel)
    implementation(Libs.LifecycleLiveData)

    // DI
    implementation(Libs.HiltViewModel)
    implementation(Libs.HiltWork)
    implementation(Libs.Dagger)
    kapt(Libs.HiltCompiler)
    kapt(Libs.DaggerCompiler)

    // Glide
    implementation(Libs.Glide)

    // Navigation
    implementation(Libs.NavigationFragment)
    implementation(Libs.NavigationUI)

    // Reactive
    implementation(Libs.RxAndroid)
    implementation(Libs.RxJava)
    implementation(Libs.RxKotlin)

    // Test
    testImplementation(Libs.JUnit)
    androidTestImplementation(Libs.JUnitExt)
    androidTestImplementation(Libs.Espresso)
    testImplementation(Libs.Mockito)
    testImplementation(Libs.MockitoKotlin)
    testImplementation(Libs.KotlinTest)
    testImplementation(Libs.KotlinTestJUnit)
    testImplementation(Libs.NavigationTest)
}
