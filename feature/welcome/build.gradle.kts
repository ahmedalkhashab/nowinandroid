plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "com.google.samples.apps.demo.feature.welcome"
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.store)
    implementation(projects.feature.lineHub)
    implementation(projects.feature.more)

    implementation(libs.androidx.appcompat)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.notifications)

    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.robolectric)
    testImplementation(projects.core.testing)
    testDemoImplementation(projects.core.screenshotTesting)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
    androidTestImplementation(projects.core.testing)
}