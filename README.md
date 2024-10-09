
# Login App

A simple **Login App** developed using **Android Studio** in **Kotlin** with **Jetpack Compose** UI, **ViewModel**, **Firebase Authentication** (email/password), and **Jetpack Navigation** for seamless app navigation.

## Table of Contents
- [Features](#features)
- [Screenshots](#screenshots)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)

## Features
- **Firebase Authentication**: Login and sign-up using email and password.
- **Jetpack Compose**: Modern UI toolkit for building the app's UI.
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
- **Navigation Component**: Navigate between login and home screens smoothly.
- **Clean Architecture**: Follow the MVVM (Model-View-ViewModel) pattern.

## Screenshots

![login](https://github.com/user-attachments/assets/e91af221-e7ae-449c-8070-7df7284cf670)![create account](https://github.com/user-attachments/assets/f943bed1-863f-4bb4-993a-90398a88d479)![home](https://github.com/user-attachments/assets/622a7535-85b9-4f26-933a-c2805058723b)
![firebase](https://github.com/user-attachments/assets/63804074-981c-4093-9e1a-d948a9655f91)

## Prerequisites

- **Android Studio** version Bumblebee (or later).
- A **Firebase project** with **Firebase Authentication** enabled.
- Basic knowledge of Kotlin and Jetpack Compose.

### Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com/).
2. Create or use an existing project.
3. Enable **Email/Password Authentication** under the Authentication tab.
4. Download the `google-services.json` file and place it in the `app/` directory.

## Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/login-app.git
```

2. Open the project in **Android Studio**.
3. Add the `google-services.json` file to the `app/` folder.
4. Sync the project with Gradle files.
5. Run the app on your emulator or physical device.

## Usage

### Login Screen
- Users can log in by entering their **email** and **password**.
- Firebase handles authentication via the Firebase Authentication SDK.

### Home Screen
- After successful login, users are redirected to the home screen.
- A simple greeting or action can be presented to logged-in users.

## Project Structure

```
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/simon/ui
│   │   │   │   ├── pages
│   │   │   │   │   ├── Login.kt
│   │   │   │   │   ├── Home.kt
│   │   │   │   ├── viewmodel
│   │   │   │   │   └── AuthViewModel.kt
│   │   │   ├── res
│   │   │   │   └── layout
│   │   ├── AndroidManifest.xml
│  
```

### Key Components

- **Login.kt**: Compose UI for the login screen where users input credentials.
- **signup.kt**: Compose UI for the login screen where users input credentials.
- **Home.kt**: Compose UI for the home screen.
- **AuthViewModel.kt**: ViewModel class for handling login logic and updating the UI.
- **AppNavigation.kt**: Navigation configuration for moving between screens.

## Technologies Used

- **Kotlin**: Primary programming language.
- **Jetpack Compose**: Used for declarative UI.
- **ViewModel**: Manages the UI-related data.
- **Firebase Authentication**: Provides secure user authentication.
- **Coroutines**: Handles background tasks like login requests.
- **Jetpack Navigation**: Manages navigation between screens.

### Dependencies

Add the following dependencies in `app/build.gradle`:

```gradle
dependencies {
    implementation "androidx.compose.ui:ui:1.4.0"
    implementation "androidx.compose.material:material:1.4.0"
    implementation "androidx.compose.ui:ui-tooling-preview:1.4.0"
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0"
    implementation "androidx.navigation:navigation-compose:2.5.0"
    implementation platform('com.google.firebase:firebase-bom:32.1.0')
    implementation 'com.google.firebase:firebase-auth-ktx'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'
}






