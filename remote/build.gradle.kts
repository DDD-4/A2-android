plugins {
    id("kotlin")
}

sourceSets {
    getByName("main").java.srcDir("src/main/kotlin")
    getByName("test").java.srcDir("src/test/kotlin")
}

dependencies {
    api(project(path = ":data"))

    // Kotlin
    implementation(Libs.Kotlin)

    // Reactive
    implementation(Libs.RxJava)
    implementation(Libs.RxKotlin)

    // Retrofit
    implementation(Libs.Retrofit)
    implementation(Libs.RetrofitLogger)
    implementation(Libs.GsonConverter)
    implementation(Libs.RxJavaAdapter)

    // Test
    testImplementation(Libs.JUnit)
}
