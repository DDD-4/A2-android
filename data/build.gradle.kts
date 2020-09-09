plugins {
    id("kotlin")
}

sourceSets {
    getByName("main").java.srcDir("src/main/kotlin")
    getByName("test").java.srcDir("src/test/kotlin")
}


dependencies {
    implementation(project(path = ":domain"))

    // Kotlin
    implementation(Libs.Kotlin)

    // Reactive
    implementation(Libs.RxAndroid)
    implementation(Libs.RxJava)
    implementation(Libs.RxKotlin)

    // Test
    testImplementation(Libs.JUnit)
}
