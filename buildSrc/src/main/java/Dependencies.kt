object Versions {
    const val kotlin = "1.5.21"
    const val kotlin_coroutines = "1.5.1"

    const val android_x_fragment = "1.3.6"
    const val android_x_legacy_v4 = "1.0.0"
    const val android_x_v7 = "1.2.0"
    const val android_x_core_ktx = "1.3.2"
    const val android_x_lifecycle = "2.2.0"
    const val android_x_constraint_layout = "2.0.2"
    const val material_design = "1.2.1"
    const val android_x_work_manager = "2.4.0"
    const val android_x_databinding_compiler = "4.1.0"
    const val android_x_biometric = "1.1.0"

    const val gson = "2.8.7"

    const val firebase_core = "17.5.1"
    const val firebase_auth = "21.0.1"

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

    const val hilt = "2.38.1"

    const val min_sdk = 23
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
    const val kotlin_coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlin_coroutines}"

    const val fragment = "androidx.fragment:fragment-ktx:${Versions.android_x_fragment}"
    const val support = "androidx.legacy:legacy-support-v4:${Versions.android_x_legacy_v4}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.android_x_v7}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.android_x_core_ktx}"
    const val material_design = "com.google.android.material:material:${Versions.material_design}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.android_x_constraint_layout}"
    const val databinding_compiler = "androidx.databinding:databinding-compiler:${Versions.android_x_databinding_compiler}"
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.android_x_lifecycle}"
    const val biometric = "androidx.biometric:biometric:${Versions.android_x_biometric}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase_core}"
    const val firebase_auth = "com.google.firebase:firebase-auth-ktx:${Versions.firebase_auth}"

    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_test = "com.google.dagger:hilt-android-testing:${Versions.hilt}"

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
    const val hilt_android_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

object Modules {
    const val loginUi = ":login:ui"
    const val loginDomain = ":login:domain"
    const val loginData = ":login:data"
    const val homeUi = ":home:ui"
    const val baseUi = ":base:ui"
}