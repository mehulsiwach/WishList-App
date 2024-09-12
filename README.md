# Wishlist App

## Overview

This is a simple Android application that allows users to create, update, and delete notes. The app is built with a clean and modern UI, and stores notes locally using Room Database.

## Features

- **Add Notes**: Users can add new notes with a title and description.
- **Update Notes**: Existing notes can be edited and updated.
- **Delete Notes**: Notes can be deleted from the list if no longer needed.
- **Persistent Storage**: Notes are stored locally in the app using Room Database.
- **User-friendly UI**: The app interface is designed to be simple and easy to use, built with Jetpack Compose for a smooth user experience.

## Tech Stack

- **Kotlin**: The app is built using Kotlin as the primary programming language.
- **Jetpack Compose**: The UI is implemented using Jetpack Compose for a declarative UI design.
- **Room Database**: Used for local data persistence, allowing users to store and retrieve notes.
- **MVVM Architecture**: The project follows the Model-View-ViewModel (MVVM) architecture to ensure clean separation of concerns and maintainable code.

## Prerequisites

1. **Android Studio**: Download and install the latest version of Android Studio.
2. **Internet Connection**: Not required for the basic app features, but needed for any updates or cloud-syncing features (if implemented).

## Installation and Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/notes-app.git
    ```

2. Open the project in Android Studio.

3. Build and run the project on your emulator or Android device.

## How to Use

1. **Add a New Note**:
    - Click on the **Add Note** button.
    - Enter the title and description of the note.
    - Save the note to add it to your list.

2. **Update a Note**:
    - Tap on an existing note to view or edit it.
    - Update the title or description and save your changes.

3. **Delete a Note**:
    - Long-press on a note in the list to delete it.
    - Confirm the deletion, and the note will be removed from the list.
