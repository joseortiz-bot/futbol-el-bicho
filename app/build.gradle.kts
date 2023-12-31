plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("androidx.navigation.safeargs.kotlin")
    id ("com.google.gms.google-services")
}


android {
    namespace = "com.mvvm.bichomvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mvvm.bichomvvm"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding {
        enable = true
    }

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    // Navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")

    //CardView
    implementation ("androidx.cardview:cardview:1.0.0")

    // RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.3.2")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-beta01")

    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-android-compiler:2.48")

    // Markwon
    implementation ("io.noties.markwon:core:4.4.0")

    // Security
    implementation ("androidx.security:security-crypto:1.1.0-alpha06")

    // Firestore
    implementation (platform("com.google.firebase:firebase-bom:26.7.0"))
    implementation ("com.google.firebase:firebase-firestore:24.9.1")
    implementation ("com.google.firebase:firebase-auth:22.2.0")
    implementation ("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-storage-ktx:20.3.0")

    //Coroutines - Firebase
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.1")
}
kapt {
    correctErrorTypes = true
}