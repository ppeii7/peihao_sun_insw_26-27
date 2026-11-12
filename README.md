# Proyecto Java Maven - Proyecto Ingeniería del Software

Este proyecto es una plantilla base para comenzar a trabajar con aplicaciones Java utilizando Maven. Asegúrate de seguir las instrucciones para configurar tu entorno correctamente y entender cómo contribuir al proyecto.

## Tabla de Contenidos

- [Introducción](#introducción)
- [Requisitos](#requisitos)
- [Configuración del Entorno](#configuración-del-entorno)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Compilación y Ejecución](#compilación-y-ejecución)
- [Soluciones Implementadas e Innovaciones Técnicas](#soluciones-implementadas-e-innovaciones-técnicas)
- [Contribución](#contribución)
- [Licencia](#licencia)

---

## Introducción

Este es un proyecto base para aprender sobre el uso de **Java** y **Maven**. El objetivo familiarizarse con las buenas prácticas de desarrollo y gestionar dependencias utilizando Maven.

## Requisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente en tu sistema:

- **Java 11+** (JDK) - Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o [OpenJDK](https://openjdk.java.net/)
- **Maven** - Puedes instalar Maven siguiendo las instrucciones en su sitio oficial: [https://maven.apache.org/install.html](https://maven.apache.org/install.html)
- **IDE recomendada:** Visual Studio Code o cualquier editor de tu preferencia con soporte para Java.

## Configuración del Entorno

### 1. Instalar Java
Asegúrate de que tienes **Java 8** o una versión superior instalada. Puedes verificarlo con el siguiente comando:

```bash
java -version
```

### 2. Instalar Maven
Una vez que tengas Java instalado, puedes proceder con la instalación de Maven. Para verificar que Maven esté instalado correctamente, ejecuta el siguiente comando:

mvn -version

### 3. Configurar el IDE
Para trabajar con este proyecto, puedes usar cualquier IDE que soporte Java, como Visual Studio Code, IntelliJ IDEA, Eclipse, etc. Si estás usando Visual Studio Code, asegúrate de instalar las siguientes extensiones:

Java Extension Pack (de Microsoft)
Maven for Java

## Estructura del proyecto
```
peihaosun/
├── .github/
│   └── workflows/
│       └── ci.yml
├── .vscode/
│   └── settings.json
├── logs/
│   └── application.log
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── uem/
│   │   │           ├── control/
│   │   │           │   └── OrderController.java
│   │   │           ├── model/
│   │   │           │   ├── Article.java
│   │   │           │   ├── Calculator.java
│   │   │           │   ├── ExchangeRateService.java
│   │   │           │   ├── Order.java
│   │   │           │   └── Searcher.java
│   │   │           ├── view/
│   │   │           │   └── OrderView.java
│   │   │           └── Main.java
│   │   └── resources/
│   │       ├── logback.xml
│   │       ├── orders.json
│   │       └── pedido.png
│   └── test/
│       └── java/
│           ├── ArticleTest.java
│           ├── CalculatorTest.java
│           ├── OrderTest.java
│           └── SearcherTestCase.java
├── target/
│   ├── classes/
│   └── test-classes/
├── .gitignore
├── pom.xml
└── README.md
```

## Compilación y ejecución

Para compilar y ejecutar el proyecto, sigue estos pasos:

Abre una terminal en la raíz del proyecto.

Ejecuta el siguiente comando para compilar el proyecto:
```bash
mvn clean install
```
Para ejecutar la aplicación, usa el siguiente comando:
```bash
mvn exec:java
```

## Soluciones Implementadas e Innovaciones Técnicas

En esta sección se documenta el desarrollo y la arquitectura de las nuevas funcionalidades añadidas al sistema de gestión de pedidos.

### 1. Icono de la Aplicación y Gestión de Recursos (`OrderView`)
Para personalizar la ventana principal (`JFrame`) se integró un icono corporativo en formato `.png` asegurando la portabilidad del software.
* **Carga de Recursos en Maven:** Se utilizó `getClass().getResource("/pedido.png")` apuntando a la raíz del *classpath* (`src/main/resources`). Esto evita depender de rutas absolutas locales y garantiza que el recurso funcione al empaquetar el proyecto.
* **Asignación a la Ventana:** En lugar de incrustar la imagen en el flujo de componentes visuales, se extrajo el objeto gráfico desde el `ImageIcon` y se asignó directamente a la barra de título y barra de tareas mediante el método nativo `setIconImage(imageIcon.getImage())`.

### 2. Consumo de API y Expresiones Regulares (`ExchangeRateService`)
Se integró la consulta en vivo de la divisa EUR/USD para permitir la visualización de los pedidos en dólares estadounidenses.
* **Cliente HTTP Nativo:** Se emplearon las clases modernas `HttpClient`, `HttpRequest` y `HttpResponse` para realizar peticiones `GET` síncronas a la API pública de *Frankfurter* (`/v1/latest?base=EUR&symbols=USD`), verificando el código de estado HTTP `200` antes de procesar la respuesta.
* **Extracción con Regex (`Pattern` y `Matcher`):** Para evitar añadir dependencias externas de parseo JSON al `pom.xml`, se implementó una expresión regular (`"USD"\s*:\s*([0-9]+(?:\.[0-9]+)?)`) que localiza y captura con precisión el valor numérico decimal dentro de la respuesta JSON.
* **Tolerancia a Fallos:** Mediante un bloque `try-catch` y validaciones de estado, el servicio captura posibles caídas de red o respuestas malformadas y devuelve un valor seguro por defecto (`1.0`).

### 3. Sincronización Reactiva en Patrón MVC (`OrderController`)
Para permitir al usuario alternar entre Euros (`EUR (€)`) y Dólares (`USD ($)`) mediante un `JComboBox` sin penalizar el rendimiento:
* **Caché en Memoria:** La consulta a internet se realiza **únicamente al pulsar el botón "Search"**. El tipo de cambio obtenido se almacena en el atributo de clase `euroDolarChange` junto con el pedido recuperado (`orderEncontrada`).
* **Cambio Instantáneo:** Al interactuar con el menú desplegable, su *ActionListener* invoca el método local `actualizarPantalla()`, el cual reutiliza los datos almacenados en memoria para recalcular los importes en la vista de forma inmediata y sin latencias de red.


## Contribución

Si deseas contribuir a este proyecto, por favor sigue estos pasos:
- Haz un fork del repositorio.
- Crea una nueva rama (git checkout -b feature-nueva-funcionalidad).
- Realiza tus cambios y haz commit (git commit -am 'Agregué nueva funcionalidad').
- Empuja los cambios a tu fork (git push origin feature-nueva-funcionalidad).
- Crea un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo LICENSE para más detalles.