# Lista Auto Ordenada — Android

Una versión para Android en Kotlin de la aplicación JavaFX **Lista Auto Ordenada**. Categoriza y ordena automáticamente una lista de compras consultando cada producto en una base de datos Room local.

---

## Funcionamiento

1. El usuario introduce los nombres de los productos (uno por línea) en un área de texto.
2. La aplicación busca cada producto en la base de datos local SQLite/Room mediante coincidencia aproximada (exacta → empieza por → límite de palabra → subcadena → distancia de Levenshtein).
3. Los artículos se agrupan por categoría y se muestran con encabezados como `==== Frutería ====`.
4. Se pueden eliminar artículos individuales de la lista ordenada.
5. La lista ordenada se puede guardar con un nombre y consultar posteriormente en la pantalla **Listas guardadas**.

---

## Abrir en Android Studio

1. Abre **Android Studio** (se recomienda la versión Hedgehog o posterior).
2. Selecciona **Archivo → Abrir** y elige la raíz de esta rama (`version-android`).
3. Espera a que finalice la sincronización de Gradle (descargará las dependencias automáticamente).
4. Conecta un dispositivo o inicia un emulador (API 24 o superior).
   
---

## Ejecución de la aplicación
- **Emulador**: Haz clic en el botón verde **Ejecutar** o pulsa `Shift+F10`.
- **Dispositivo físico**: Habilita la depuración USB, conecta el dispositivo y ejecuta la aplicación.
- **Línea de comandos**: Ejecuta `./gradlew :app:installDebug` desde la raíz de esta rama.

---

## Arquitectura

| Capas | Tecnología |
|---|---|
| Interfaz de usuario | Jetpack Compose + Material 3 |
| Navegación | Navigation Compose |
| Gestión de estado | ViewModel + StateFlow |
| Asíncrono | Corrutinas de Kotlin |
| Base de datos | Room (generación de código KSP) |
| Compilación | Kotlin DSL Gradle + Catálogo de versiones |

### Estructura del paquete

``` com.proyectofinal.android
├── MainActivity.kt
├── data/
│ ├── db/
│ │ ├── AppDatabase.kt # Base de datos de la sala + función de devolución de llamada de semilla
│ │ ├── dao/ # CategoriaDao, ProductoDao, ListaDao
│ │ └── entity/ # Categoria, Producto, Lista, ListaItem
│ └── repository/ # ProductoRepository, ListaRepository
├── viewmodel/ # MainViewModel, ListaViewModel
└── ui/
    ├── navigation/NavGraph.kt
    ├── pantallas/ # PantallaPrincipal, ListasGuardadas
    └── tema/ # Color, Tema, Tipo
```

---

## Estrategia de base de datos

En el primer inicio, la función `onCreate` de Room inicializa la base de datos con:
- **21 categorías** (Frutería, Carnicería, Lácteos, …)
- **~250 productos** distribuidos entre esas categorías

No se incluye ningún archivo de base de datos externo; todo se genera durante la instalación mediante `AppDatabase.SeedCallback`.

---

## Notas de migración de la versión JavaFX

| Funcionalidad | JavaFX original | Versión para Android |
|---|---|---|
| Base de datos | JDBC sin formato + archivo SQLite | Room con KSP |
| Marco de interfaz de usuario | JavaFX FXML | Jetpack Compose |
| Arquitectura | Capa de controlador + capa de servicio | MVVM (ViewModel + StateFlow) |
| Coincidencia aproximada | Java `DBService` | `ProductoRepository.obtenerCategoria()` |
| Guardar lista | Escribir en archivo `.txt` | Persistir en las tablas `lista`/`lista_item` de Room |
| Funcionalidad de correo electrónico | Presente | **Eliminada** (no aplicable en Android) |
| Cuentas de usuario | Presente | **Eliminada** (simplificada: usuario único) |

---

## Requisitos

- Android Studio Hedgehog (2023.1.1) o posterior
- JDK 11 o superior
- Dispositivo o emulador Android con API 24 (Android 7.0) o superior
