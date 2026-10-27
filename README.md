# Bitki Rehberim (My Plant Guide)

An offline Android plant guide written in Java. The app presents care information for house, garden and field plants, seasonal care tips based on the current month, and a short reference of medicinal plants. The user interface and all content are in Turkish.

## Features

- **Splash screen** with simple view animations (rotate, slide-down, fade-in); tap anywhere to continue.
- **Three plant categories**: house plants (Ev Bitkileri), garden plants (Bahçe Bitkileri) and field crops (Tarla Bitkileri), each shown in a `RecyclerView` list with an image, common name and Latin name.
- **Search** inside a category, filtering by common or Latin name as you type.
- **Plant detail screen** covering watering frequency, light requirement, growing environment and regions, lifespan, fertilizing, pruning, repotting, general care, common diseases, prevention and propagation.
- **Seasonal suggestions**: works out the current season from the device date, then shows care tips and plants suited to that season.
- **Medicinal plants** (Şifalı Bitkiler): benefits, usage, preparation, dosage, side effects, interactions, precautions and storage for plants such as ginger, chamomile, linden, echinacea and sage.

All plant data is hard-coded in the activities and images are bundled as drawable resources. The app makes no network calls and uses no database.

## Tech stack

- Java 11, Android SDK (compileSdk / targetSdk 34, minSdk 24)
- Android Gradle Plugin 8.7.3 with Gradle version catalog (`gradle/libs.versions.toml`)
- AndroidX AppCompat, Material Components, ConstraintLayout, RecyclerView

## Project structure

```
bitki-rehberim/
├── app/
│   └── src/main/
│       ├── java/com/example/bitkirehberim/
│       │   ├── SplashActivity.java                # animated entry screen
│       │   ├── MainActivity.java                  # category / seasonal / medicinal menu
│       │   ├── CategoryActivity.java              # plant list per category + search
│       │   ├── PlantDetailActivity.java           # care details for one plant
│       │   ├── SeasonalActivity.java              # season detection, tips, plant list
│       │   ├── MedicinalPlantsActivity.java       # medicinal plant list
│       │   ├── MedicinalPlantDetailActivity.java
│       │   ├── Plant.java, PlantAdapter.java      # model + RecyclerView adapter
│       │   └── MedicinalPlant.java, MedicinalPlantAdapter.java
│       └── res/                                   # layouts, drawables (plant images), animations
├── docs/referans-gorseller/                       # reference photos of the plants
├── gradle/                                        # wrapper + version catalog
├── build.gradle, settings.gradle, gradle.properties
└── gradlew, gradlew.bat
```

## Getting started

1. Clone the repository and open the folder in Android Studio.
2. `local.properties` is not included in the repository, because it contains a machine-specific Android SDK path. Android Studio creates it automatically on first sync. If you build from the command line, create it yourself:
   ```
   sdk.dir=/path/to/your/Android/sdk
   ```
3. Let Gradle sync, then run the `app` configuration on an emulator or device (Android 7.0 / API 24 or newer).

Command-line build:

```bash
./gradlew assembleDebug        # Windows: gradlew.bat assembleDebug
```

## Notes

- `docs/referans-gorseller/` holds reference photos used while preparing the in-app plant images. The app does not load them.
- This is a student project built for learning Android development.

## Author

Ayşe Sümeyra Mert, Computer Engineering student
