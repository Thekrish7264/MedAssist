# Implementation Plan - Fix HomeScreen Preview Render Issue

The `HomeScreen` composable currently instantiates `UserViewModel` and `ScheduleViewModel` using `hiltViewModel()`. When rendered in a Compose Preview, these ViewModels cannot be instantiated because they have dependencies that `ViewModelProvider` doesn't know how to resolve, leading to a `NoSuchMethodException`.

To fix this, I will refactor `HomeScreen` to separate its stateful logic from its stateless UI content.

## User Review Required

> [!NOTE]
> I am refactoring `HomeScreen` to separate state and UI. This is a standard practice in Jetpack Compose to improve testability and support Previews.

## Proposed Changes

### UI Components

#### [MODIFY] [HomeScreen.kt](file:///D:/downlods/adnroid project 20-07-2026/medassist/app/src/main/java/com/example/medassist/ui/screens/HomeScreen.kt)

- Extract the UI logic of `HomeScreen` into a new stateless composable `HomeScreenContent`.
- `HomeScreen` will remain as the entry point, collecting state from ViewModels and passing it to `HomeScreenContent`.
- Update `HomeScreenPreview` and `HomeScreenDarkPreview` to use `HomeScreenContent` with mock data.

## Verification Plan

### Automated Tests
- I will run `analyze_file` on `HomeScreen.kt` to ensure no syntax errors.
- I will attempt to render the `HomeScreenPreview` using `render_compose_preview` to verify the fix.

### Manual Verification
- The user can verify that the Preview now renders correctly in Android Studio.
