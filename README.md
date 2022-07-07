# fullAndroidCourseClassC
This project is for training purposes in Android with Kotlin Course.
<img width="200" heigth="400"  src="https://user-images.githubusercontent.com/28203059/177842125-9d608e03-ff6e-4854-bfd9-323548cee6b0.png">
<img width="200" heigth="400"  src="https://user-images.githubusercontent.com/28203059/177842192-cd7010a1-9bce-451d-800b-fe3b0881b161.png">
<img width="200" heigth="400"  src="https://user-images.githubusercontent.com/28203059/177842200-16d4a343-e5a1-417b-947c-8a15ee97ea47.png">
<img width="200" heigth="400"  src="https://user-images.githubusercontent.com/28203059/177842205-718ce30b-988f-43ed-a0b8-db9948911e68.png">
<img width="200" heigth="400"  src="https://user-images.githubusercontent.com/28203059/177842209-9c1fc2c9-9751-4f29-99c1-d7314b115793.png">
===================================================

`//Dependencies
dependencies {
    //Kotlin
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.4.32"
    
    //Libs
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    
    //KTX core
    implementation 'androidx.core:core-ktx:1.7.0'
    
    //AppCompact
    implementation 'androidx.appcompat:appcompat:1.4.1'
    
    //Material Design
    implementation 'com.google.android.material:material:1.5.0' 
    
    // ConstraintLayout
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // For control over item selection of both touch and mouse driven selection
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")

    //SDP
    implementation 'com.intuit.sdp:sdp-android:1.0.6'

    //Navigation UI
    implementation 'androidx.navigation:navigation-fragment-ktx:2.4.1'
    implementation 'androidx.navigation:navigation-ui-ktx:2.4.1'
    implementation 'com.google.android.gms:play-services-maps:18.0.2'

    //TESTING
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    testImplementation "com.google.truth:truth:1.1.3"
    androidTestImplementation "com.google.truth:truth:1.1.3"

    // Room and Architectural Components
    implementation "androidx.room:room-runtime:2.4.2"
    implementation "androidx.legacy:legacy-support-v4:1.0.0"
    implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0'
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
    implementation "androidx.room:room-ktx:2.4.2"
    kapt "androidx.room:room-compiler:2.4.2"

    //FIREBASE
    implementation platform('com.google.firebase:firebase-bom:29.1.0')//Firebase core
    implementation 'com.google.firebase:firebase-analytics-ktx'//Analytics
    implementation 'com.google.firebase:firebase-auth-ktx' // Authentication
    implementation 'com.google.android.gms:play-services-auth:20.1.0' //GOOGLE SIGN IN
    implementation 'com.google.firebase:firebase-firestore-ktx:24.0.2' // FireStore
    implementation 'com.google.firebase:firebase-storage-ktx:20.0.1' // Storage
    implementation 'com.google.firebase:firebase-messaging:23.0.2' //FCM, Firebase Cloud Messaging

    //Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.0'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.13.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.13.0'

    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:4.9.0"
    }`
