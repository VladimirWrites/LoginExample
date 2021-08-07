object Versions {
    const val kotlin = "1.4.10"
    const val kotlin_coroutines = "1.3.9"

    const val android_x_legacy_v4 = "1.0.0"
    const val android_x_v7 = "1.2.0"
    const val android_x_core_ktx = "1.3.2"
    const val android_x_lifecycle = "2.2.0"
    const val android_x_constraint_layout = "2.0.2"
    const val material_design = "1.2.1"
    const val android_x_work_manager = "2.4.0"
    const val android_x_databinding_compiler = "4.1.0"

    const val firebase_core = "17.5.1"
    const val firebase_bom = "28.3.0"

    const val play_services_auth = "19.2.0"

    const val koin = "2.1.6"

    const val junit = "4.13.1"
    const val mockito = "3.5.15"
    const val mockito_kotlin = "2.2.0"
    const val truth = "1.1"
    const val robolectric = "4.4"
    const val arch_core_testing = "2.1.0"
    const val fragment_test = "1.2.5"
    const val espresso_core = "3.3.0"
    const val test_core_ktx = "1.3.0"

    const val gradle_android = "7.0.0"
    const val google_services = "4.3.8"

    const val min_sdk = 21
    const val target_sdk = 30
    const val compile_sdk = 30
    const val build_tools = "30.0.3"

    const val version_code = 1
    const val version_name = "1.0.0"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
    const val kotlin_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutines}"

    const val support = "androidx.legacy:legacy-support-v4:${Versions.android_x_legacy_v4}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.android_x_v7}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.android_x_core_ktx}"
    const val material_design = "com.google.android.material:material:${Versions.material_design}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.android_x_constraint_layout}"
    const val databinding_compiler = "androidx.databinding:databinding-compiler:${Versions.android_x_databinding_compiler}"
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.android_x_lifecycle}"

    const val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase_core}"
    const val firebase_bom = "com.google.firebase:firebase-bom:${Versions.firebase_bom}"
    const val firebase_auth = "com.google.firebase:firebase-auth"

    const val playServicesAuth = "com.google.android.gms:play-services-auth:${Versions.play_services_auth}"


    const val junit = "junit:junit:${Versions.junit}"
    const val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val mockito_kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val arch_core_testing = "androidx.arch.core:core-testing:${Versions.arch_core_testing}"
    const val fragment_test = "androidx.fragment:fragment-testing:${Versions.fragment_test}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso_core}"
    const val test_core_ktx = "androidx.test:core-ktx:${Versions.test_core_ktx}"
    const val work_manager_test = "androidx.work:work-testing:${Versions.android_x_work_manager}"

    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_android}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val google_services_plugin = "com.google.gms:google-services:${Versions.google_services}"
}

object Modules {
    const val loginUi = ":login:ui"
    const val loginDomain = ":login:domain"
    const val loginData = ":login:data"
}