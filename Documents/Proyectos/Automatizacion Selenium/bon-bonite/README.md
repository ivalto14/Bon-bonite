# Automatización Web Bon-Bonite

## Descripción

Proyecto de automatización web desarrollado utilizando el patrón Screenplay con Serenity BDD, Selenium WebDriver y Cucumber.

El objetivo principal es automatizar los flujos críticos de compra de la tienda en línea Bon-Bonite:

* Ingreso a la cuenta de usuario.
* Selección de productos.
* Adición de productos al carrito.
* Validación de productos agregados.
* Navegación al Checkout.
* Validación de resumen de compra.
* Flujo de autenticación desde Checkout.

---

## Tecnologías Utilizadas

* Java 17
* Selenium WebDriver
* Serenity BDD
* Screenplay Pattern
* Cucumber
* JUnit 5
* Gradle

---

## Estructura del Proyecto

```text
src
├── main
└── test
    ├── java
    │   └── ├── interactions
    │       ├── questions
    │       ├── runners
    │       ├── stepdefinitions
    │       ├── tasks
    │       └── userinterface
    │
    └── resources
        ├── features
        └── serenity.conf
```

---

## Patrón de Automatización

Se implementa el patrón Screenplay para garantizar:

* Alta mantenibilidad.
* Reutilización de código.
* Separación de responsabilidades.
* Escalabilidad del framework.

### Componentes

#### User Interface

Contiene los elementos de la interfaz identificados mediante objetos Target.

Ejemplos:

* ProductPurchase

#### Tasks

Representan acciones de negocio ejecutadas por el actor.

Ejemplos:

* EnterAccount
* FillPaymentForm
* PurchaseProduct
* SignInWithEmail

#### Interactions

Acciones reutilizables sobre la interfaz.

Ejemplos:

* ClickSafe
* SwitchToDefaultContent
* SwitchToIframe

#### Questions

Validaciones realizadas por el actor.

Ejemplos:

* CurrentPageUrl
* PaymentFormValidated
* ProductIsInCart
* ProductIsInCheckout
* UserIsAuthenticated

#### Step Definitions

Orquestan la ejecución de los escenarios definidos en Gherkin.

---

## Escenarios Automatizados

### Escenario 1

Agregar productos al carrito exitosamente.

Validaciones:

* El producto es agregado correctamente.
* El contador del carrito es mayor que cero.

### Escenario 2

Acceder al Checkout.

Validaciones:

* El usuario es redireccionado al flujo de compra.

### Escenario 3

Validar resumen de compra.

Validaciones:

* El producto seleccionado aparece en el resumen de la orden.

### Escenario 4

Completar formulario de pago.

Validaciones:

* Los campos obligatorios son reconocidos por el sistema.

### Escenario 5

Autenticación desde Checkout.

Validaciones:

* El usuario puede iniciar el flujo de autenticación mediante correo electrónico.

---

## Ejecución del Proyecto

### Ejecutar todas las pruebas

```bash
gradlew clean test
```

### Ejecutar un Runner específico

```bash
gradlew test --tests "runners.PurchaseRunner"
```

### Generar Reportes Serenity

```bash
gradlew aggregate
```

---

## Reportes

Los reportes se generan automáticamente en:

```text
target/site/serenity
```

o

```text
build/reports/serenity
```

Dependiendo de la configuración del proyecto.

---

## Consideraciones

* Se utilizan esperas explícitas para mejorar la estabilidad de las pruebas.
* Los elementos dinámicos son gestionados mediante localizadores robustos.
* El framework fue diseñado siguiendo buenas prácticas de automatización y principios de mantenibilidad.

---

## Autor

Ivan Dario Lopez Riveros

QA Automation Engineer

## Cobertura Funcional

| Funcionalidad | Estado |
|--------------|---------|
| Acceso a cuenta | ✅ |
| Selección de producto | ✅ |
| Selección de color | ✅ |
| Selección de talla | ✅ |
| Incremento de cantidad | ✅ |
| Adición al carrito | ✅ |
| Checkout | ✅ |
| Resumen de compra | ✅ |
| Login desde Checkout | ✅ |
| Validaciones Screenplay | ✅ |