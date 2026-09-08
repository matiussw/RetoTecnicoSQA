# RetoTecnicoSQA

Reto técnico de aseguramiento de calidad de software (SQA). El repositorio contiene un proyecto de automatización de pruebas end-to-end para el sitio de comercio electrónico [sanangel.com.co](https://sanangel.com.co/), construido en el módulo **`Sanangel-Test`**.

## ¿Qué se prueba?

El proyecto automatiza el flujo de **agregar productos al carrito de compras**. El único escenario definido (`src/test/resources/features/agregar_productos.feature`) hace lo siguiente:

1. Ingresa al portal web `https://sanangel.com.co/`.
2. Agrega 2 productos distintos al carrito con cantidades diferentes: **Manarola** (5 unidades) y **Riviera** (2 unidades).
3. Verifica que los productos agregados aparezcan reflejados en el carrito de compras.

```gherkin
Feature: Agregar Producto al carrito de compras

  Scenario: Agregar 2 productos al carro de compras
    Given Estoy Dentro del Portal Web "https://sanangel.com.co/"
    When  Seleciono Productos de Mi Agrado y Agrego 2 Cantidades de un producto y 5 Cantidades de otro
    Then Puedo ver los  Productos Agregados "Riviera" Y "Manarola" Con Su respectiva cantidad
```

## Stack tecnológico

- **Java 11**
- **Gradle 8.2** (via `gradlew` wrapper)
- **Serenity BDD 4.0.1** con el patrón **Screenplay** (actores, tareas, preguntas, interacciones)
- **Cucumber** (`serenity-cucumber`) para BDD con especificaciones en Gherkin, escritas en español
- **JUnit 4** como runner de pruebas
- **Selenium WebDriver** (`RemoteWebDriver`) apuntando a un **Selenium Grid** en `http://localhost:4844`
- **AssertJ** para aserciones
- **SLF4J / Logback** para logging
- Plugin de **SonarQube** para análisis estático de código
- Reportes generados con **serenity-single-page-report**

## Estructura del proyecto

```
Sanangel-Test/
├── build.gradle                # Configuración de Gradle y dependencias
├── settings.gradle
├── gradlew / gradlew.bat       # Wrapper de Gradle
└── src/
    ├── main/java/com/co/sqasa/
    │   ├── interactions/        # Interacciones reutilizables (ej. Wait)
    │   ├── questions/           # Preguntas del patrón Screenplay (ej. ValidateCartProducts)
    │   ├── tasks/                # Tareas de negocio (ej. AddManarolaToCart, AddRivieraToCart)
    │   └── userinterfaces/       # Page objects / Targets (HomePage, HeaderPage, CartPage, DescriptionProductPage)
    └── test/
        ├── java/com/co/sqasa/
        │   ├── runners/          # Runner de Cucumber + Serenity (AddProductsRun)
        │   ├── stepdefinitions/  # Definiciones de los pasos Gherkin
        │   └── stepdefinitions/hooks/  # Hooks de ciclo de vida (setup/teardown del WebDriver)
        └── resources/features/   # Especificaciones Gherkin (.feature)
```

## Cómo ejecutar las pruebas

### Prerrequisitos

- Java 11 (JDK)
- Un **Selenium Grid** (Hub + nodo Chrome) accesible en `http://localhost:4844`, ya que el hook `Hook.java` crea el `RemoteWebDriver` apuntando a esa URL. Puede levantarse, por ejemplo, con Docker:

```bash
docker run -d -p 4844:4444 -p 7900:7900 --shm-size=2g selenium/standalone-chrome
```

  (ajustando el puerto expuesto a `4844` según lo esperado por el proyecto).

### Ejecución

Desde la carpeta `Sanangel-Test`:

```bash
cd Sanangel-Test
./gradlew clean test
```

En Windows:

```bash
cd Sanangel-Test
gradlew.bat clean test
```

### Reportes

Al finalizar la ejecución, Serenity BDD genera un reporte HTML de una sola página en:

```
Sanangel-Test/target/site/serenity/index.html
```

Ábrelo en el navegador para ver el detalle de los pasos ejecutados, capturas de pantalla y el resultado del escenario.

## Notas

- El escenario y los pasos están redactados en español, siguiendo la convención BDD del equipo.
- El WebDriver se conecta a un Grid remoto (no usa un driver local embebido), por lo que es indispensable tener el Grid disponible antes de ejecutar las pruebas.
