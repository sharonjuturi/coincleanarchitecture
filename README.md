# Coins Clean Architecture

## Project Overview
Coins Clean Architecture is an Android application that fetches cryptocurrency data using Retrofit and displays it in a clean, modular UI built with Jetpack Compose.

## Tech Stack
- Kotlin
- Jetpack Compose
- Retrofit (for networking)
- OkHttp (HTTP Client)
- Hilt (Dependency Injection)
- Clean Architecture (Separation of concerns)

## Setup Instructions
1. Clone the repository:
    ```bash
    git clone https://github.com/sharonjuturi/coincleanarchitecture.git
    cd coincleanarchitecture
    ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.

## Running the App
- To run the app, use the standard Android Studio "Run" button or execute the following command:
    ```bash
    ./gradlew installDebug
    ```

## Architecture Overview
The app is built using Clean Architecture principles:
- **Presentation Layer**: ViewModels, Jetpack Compose UI
- **Domain Layer**: UseCases
- **Data Layer**: Network and Repository layer

## Screenshots


