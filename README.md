# Android Application - Student Dashboard

## Overview
This Android application allows users to log in using their student credentials and view a dashboard of entities. Users can click on items in the dashboard to see detailed information about each entity.

## Prerequisites
Before you build and run the application, ensure you have the following installed:
- Android Studio (latest version recommended)
- Java JDK (version 11 or later)
- Gradle (usually included with Android Studio)

## Getting Started

### 1. Clone the Repository
Clone this repository to your local machine using the following command:
```bash
git clone https://github.com/yourusername/your-repository.git
```

###2. Open the Project
Launch Android Studio.
Click on "Open an existing Android Studio project."
Navigate to the directory where you cloned the repository and select it.

###3. Sync Gradle
Once the project is open, sync the Gradle files:

Click on File > Sync Project with Gradle Files.
Wait for the sync to complete.

###4. Configure API Base URL
If necessary, update the base URL in the ApiService.kt file according to your environment:
```bash
const val BASE_URL = "https://nit3213-api-h2b3-latest.onrender.com"
```

###5 5. Add Required Dependencies
5.1 Project-level build.gradle (usually project/build.gradle)
Ensure you have the Google Maven repository:
```bash
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
```

5.2 App-level build.gradle (usually app/build.gradle)
Add the following dependencies to your dependencies block:
```bash
dependencies {
    // Hilt for Dependency Injection
    implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-compiler:2.44"

    // Retrofit for networking
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    // Gson for JSON serialization/deserialization
    implementation 'com.google.code.gson:gson:2.9.0'

    // ViewModel and LiveData for lifecycle-aware data management
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.0"

    // Kotlin Coroutines for asynchronous programming
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
}
```

###6. Build the Application
To build the application:

Click on Build in the top menu.
Select Build Bundle(s) / APK(s) > Build APK(s).
Wait for the build process to complete.

###7. Run the Application
To run the application:

Connect an Android device or start an emulator.
Click on the Run icon (green play button) in the toolbar.
Choose your device or emulator from the list.
The application will be installed and launched automatically.

###8. Testing the Application
Login: Enter your first name as the username and your student ID in the format s12345678 as the password.
Click the Login button.
If the login is successful, you will be redirected to the dashboard displaying the list of entities.
Click on an item in the dashboard to view its details.

###Dependencies
This application uses the following libraries:

Hilt for dependency injection
Retrofit for networking
Gson for JSON serialization/deserialization
ViewModel and LiveData for managing UI-related data in a lifecycle-conscious way
Kotlin Coroutines for asynchronous programming
Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request with your changes.

###License
This project is licensed under the MIT License - see the LICENSE file for details.

###Contact
For any inquiries, feel free to reach out at:
``` 
Email: s4669738@live.vu.edu.au
```
