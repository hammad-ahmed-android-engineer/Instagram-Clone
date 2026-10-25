# 📸 Instagram Clone - Jetpack Compose UI

A modern, pixel-perfect **Instagram Clone** built natively for Android using **Jetpack Compose** and **Material 3**. This project strictly focuses on high-fidelity **UI/UX design**, visual mockups, fluid animations, adaptive navigation, and custom design system implementation.

> [!IMPORTANT]
> **Pure UI Prototype - No Backend Functionality**:
> This app is strictly a **UI/UX design showcase**. It contains **NO working functionality** for features such as:
> - **No Auth/Login**: The login screen is a visual design template with no authentication backend or credential handling.
> - **No Create Post Functionality**: The create post screen is a mock UI layout with no actual photo uploading, publishing, or camera/gallery persistence.
> - **No Direct Messaging (DM)**: The messaging screen is a static design layout with mock conversations and notes; no real-time chatting or socket/API connections exist.
> - **No Real Data Operations**: All feeds, profiles, reels, and notifications run exclusively on static, local dummy data.

---

## ✨ Screens & UI Mockups

| Screen / Feature | UI Description *(Static / Non-Functional)* |
| :--- | :--- |
| **⚡ Splash Screen** | Animated launch screen with Instagram branding. |
| **🔐 Login & Auth (UI Only)** | Visual login interface with mock input fields, Facebook button, and signup CTA *(no real authentication logic)*. |
| **🏠 Home Feed** | Infinite feed mockup featuring interactive story circles, post headers, media view, action bar, double-tap like overlay, comment sheet, and suggested accounts carousel. |
| **🔍 Explore / Search** | Search bar interface with filter chips, grid item displays, and search result previews. |
| **➕ Create Post (UI Only)** | Static media creation layout with gallery picker mockup, caption input, location tagging, and settings toggles *(no actual post publishing/uploading)*. |
| **🎬 Reels Screen** | Full-screen short-video layout with overlay buttons (like, comment, share), audio tracking marquee, and creator metadata. |
| **👤 User Profile** | Profile layout featuring user stats (Posts, Followers, Following), bio links, story highlights section, and tabbed grids (Posts, Reels, Tagged). |
| **💬 Direct Messaging / DM (UI Only)** | Direct messages layout featuring Instagram "Notes" bubble row and static conversation list *(no real-time messaging)*. |
| **🔔 Notifications** | Activity feed layout presenting mock user notifications (likes, comment mentions, new followers). |

---

## 🎨 UI & Design System Highlights

- **Custom Instagram Design System**: Tailored colors (`Color.kt`), custom typography (`AppTypography.kt`), and exact dimensions (`AppDimensions.kt`).
- **Double-Tap Like Overlay**: Animated heart overlay popping up when double-tapping feed post media.
- **Comment Bottom Sheet**: Modal bottom sheet mockup for viewing and typing post comments.
- **Adaptive Navigation Scaffold**: Bottom navigation bar supporting smooth tab switching with backstack state restoration.
- **Shimmer Skeletons**: Custom loading skeletons (`PostCardSkeleton`, `ShimmerEffect`) for realistic content loading placeholders.
- **Scalable Dimensions (SDP/SSP)**: Responsive sizing adaptation across various Android screen densities and sizes.

---

## 🛠 Tech Stack & Architecture

- **Language**: 100% [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material 3 (Compose BOM `2026.09.00`)
- **Build System**: [Gradle 9.8.2](https://gradle.org/) with Android Gradle Plugin `9.4.1`
- **Navigation**: Type-Safe [Jetpack Navigation Compose](https://developer.android.com/guide/navigation/design) using `kotlinx.serialization`
- **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) (`2.60.1`) & KSP (`2.3.12`)
- **Image Loading**: [Coil Compose](https://coil-kt.github.io/coil/compose/) (`2.7.0`)
- **Scalable UI**: SDP & SSP Android libraries for responsive dimensions
- **Architecture Pattern**: Unidirectional Data Flow (UDF) with feature-based modular packaging:
  - `core/designsystem`: Reusable UI components, icons, theme, and scaffold
  - `data`: Dummy repositories, models, and mock data generators
  - `feature`: Individual UI screens and view models (Feed, Profile, Reels, Explore, Auth, Messaging, Notifications, Post)

---

## 📁 Project Structure

```text
com.example.instagramclone/
├── app/                  # Application class, MainActivity, NavHost & Adaptive Scaffold
├── core/
│   ├── common/           # Utility functions (DateTime, Number Formatting)
│   └── designsystem/     # Themes, typography, custom icons, buttons, top bars, cards
├── data/
│   ├── dummy/            # Mock dataset for stories, posts, users, comments
│   ├── model/            # Data models (User, Post, Story, Notification, Comment)
│   └── repository/       # Repository interfaces & mock implementations
├── di/                   # Hilt Dependency Injection modules
└── feature/              # Feature UI screens & composables
    ├── auth/             # Login & SignUp UI sections
    ├── explore/          # Search bar & grid feed
    ├── feed/             # Main home feed & story row
    ├── messaging/        # DM screen & Notes UI layout
    ├── notifications/    # Notifications list UI layout
    ├── post/             # Create post UI screen layout
    ├── profile/          # User profile & tabbed grids
    ├── reels/            # Reels video overlay UI
    └── splash/           # Splash screen
```

---

## 🚀 Getting Started

### Prerequisites
- **Android Studio**: Android Studio Ladybug / Meerkat or newer
- **Gradle**: `9.8.2`
- **JDK**: Java `25`
- **Min SDK**: `24` (Android 7.0)
- **Compile SDK / Target SDK**: `37`

### Building the App
1. Clone the repository:
   ```bash
   git clone https://github.com/YourUsername/InstagramClone.git
   ```
2. Open the project in **Android Studio**.
3. Allow Gradle to sync dependencies.
4. Select an Android Emulator or physical device.
5. Click **Run (`Shift + F10`)** to launch the app.

---

## 📄 License & Disclaimer

This project is created solely for **educational, learning, and portfolio demonstration purposes**. All design rights, trademarks, and brand assets belong to Meta Platforms, Inc. / Instagram.
