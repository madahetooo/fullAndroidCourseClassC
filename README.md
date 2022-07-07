# fullAndroidCourseClassC
This project is for training purposes in Android with Kotlin Course.
![Screen Shot 2022-07-07 at 7 31 22 PM](https://user-images.githubusercontent.com/28203059/177842125-9d608e03-ff6e-4854-bfd9-323548cee6b0.png)
![Screen Shot 2022-07-07 at 7 31 18 PM](https://user-images.githubusercontent.com/28203059/177842192-cd7010a1-9bce-451d-800b-fe3b0881b161.png)
![Screen Shot 2022-07-07 at 7 31 11 PM](https://user-images.githubusercontent.com/28203059/177842200-16d4a343-e5a1-417b-947c-8a15ee97ea47.png)
![Screen Shot 2022-07-07 at 7 31 01 PM](https://user-images.githubusercontent.com/28203059/177842205-718ce30b-988f-43ed-a0b8-db9948911e68.png)
![Screen Shot 2022-07-07 at 7 30 39 PM](https://user-images.githubusercontent.com/28203059/177842209-9c1fc2c9-9751-4f29-99c1-d7314b115793.png)
![Screen Shot 2022-07-07 at 7 30 28 PM](https://user-images.githubusercontent.com/28203059/177842213-3e834662-4c8e-4a40-bcd7-82cd5547a976.png)
![Screen Shot 2022-07-07 at 7 30 24 PM](https://user-images.githubusercontent.com/28203059/177842222-ebccbbf1-4359-48d5-b0a6-34e6ff82f6bc.png)
![Screen Shot 2022-07-07 at 7 29 21 PM](https://user-images.githubusercontent.com/28203059/177842225-159fa728-39de-4f3d-ae89-2c8d3a93792f.png)
![Screen Shot 2022-07-07 at 7 29 10 PM](https://user-images.githubusercontent.com/28203059/177842230-06a0234a-4742-452a-84d3-0f60a3072825.png)
![Screen Shot 2022-07-07 at 7 29 05 PM](https://user-images.githubusercontent.com/28203059/177842232-d7f45bd2-5376-4199-82dc-07eaeeef63dc.png)
![Screen Shot 2022-07-07 at 7 29 01 PM](https://user-images.githubusercontent.com/28203059/177842234-289493a6-8a37-4b3f-b12c-d2b1201d4486.png)
![Screen Shot 2022-07-07 at 7 28 52 PM](https://user-images.githubusercontent.com/28203059/177842236-896dbe1c-4173-4055-893e-7a882492af82.png)
![Screen Shot 2022-07-07 at 7 28 46 PM](https://user-images.githubusercontent.com/28203059/177842239-83ad47c2-df7c-495a-9e2e-e10205c3ff14.png)
===================================================
`dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.4.32"
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0' //Material Design
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3' // ConstraintLayout

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
