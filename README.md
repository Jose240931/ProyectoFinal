# Lista Auto Ordenada — Android

An Android Kotlin port of the **Lista Auto Ordenada** JavaFX application. It automatically categorises and sorts a shopping list by looking up each product in a local Room database.

---

## What it does

1. The user types product names (one per line) into a text area.
2. The app looks each product up in the local SQLite/Room database using fuzzy matching (exact → starts-with → word-boundary → substring → Levenshtein distance).
3. Items are grouped by category and displayed with headers like `==== Fruteria ====`.
4. Individual items can be removed from the sorted list.
5. The sorted list can be saved with a name and reviewed later in the **Listas guardadas** screen.

---

## Opening in Android Studio

1. Open **Android Studio** (Hedgehog or newer recommended).
2. Choose **File → Open** and select the `android-app/` folder.
3. Let Gradle sync finish (it will download dependencies automatically).
4. Connect a device or start an emulator (API 24+).

---

## Running the app

- **Emulator**: Click the green **Run** button or press `Shift+F10`.
- **Physical device**: Enable USB debugging, connect the device, then run.
- **Command line**: `./gradlew :app:installDebug` from within `android-app/`.

---

## Architecture

| Layer | Technology |
|---|---|
| UI | Jetpack Compose + Material 3 |
| Navigation | Navigation Compose |
| State management | ViewModel + StateFlow |
| Async | Kotlin Coroutines |
| Database | Room (KSP code generation) |
| Build | Kotlin DSL Gradle + Version Catalog |

### Package structure

```
com.proyectofinal.android
├── MainActivity.kt
├── data/
│   ├── db/
│   │   ├── AppDatabase.kt          # Room database + seed callback
│   │   ├── dao/                    # CategoriaDao, ProductoDao, ListaDao
│   │   └── entity/                 # Categoria, Producto, Lista, ListaItem
│   └── repository/                 # ProductoRepository, ListaRepository
├── viewmodel/                      # MainViewModel, ListaViewModel
└── ui/
    ├── navigation/NavGraph.kt
    ├── screens/                    # MainScreen, ListasGuardadasScreen
    └── theme/                      # Color, Theme, Type
```

---

## Database strategy

On first launch, Room's `onCreate` callback seeds the database with:
- **21 categories** (Fruteria, Carniceria, Lacteos, …)
- **~250 products** distributed across those categories

No external database file is shipped — everything is generated at install time via `AppDatabase.SeedCallback`.

---

## Migration notes from the JavaFX version

| Feature | JavaFX original | Android port |
|---|---|---|
| Database | Raw JDBC + SQLite file | Room with KSP |
| UI framework | JavaFX FXML | Jetpack Compose |
| Architecture | Controller + Service layer | MVVM (ViewModel + StateFlow) |
| Fuzzy matching | Java `DBService` | `ProductoRepository.obtenerCategoria()` |
| Save list | Write to `.txt` file | Persist to Room `lista`/`lista_item` tables |
| Email functionality | Present | **Removed** (not applicable on Android) |
| User accounts | Present | **Removed** (simplified — single-user) |

---

## Requirements

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 11+
- Android device / emulator running API 24 (Android 7.0) or higher
