# 🛒 Simulación de Cobro en Supermercado

## Descripción

Este proyecto es una simulación del proceso de cobro en las cajas registradoras de un supermercado, desarrollado como parte de un caso de estudio para la IUDigital de Antioquia. El objetivo es modelar y simular, utilizando concurrencia y programación orientada a objetos en Java, cómo varias cajeras atienden a múltiples clientes de manera eficiente.

## 📝 Contexto

El Departamento de Tecnología en Desarrollo de Software de la IUDigital de Antioquia fue contactado por un supermercado local para implementar una solución que simule el proceso de cobro en las cajas registradoras. El reto consiste en aplicar conceptos de concurrencia, hilos y modelado de clases para resolver un problema real del entorno.

## 🚀 Funcionalidades

- Creación de múltiples cajeras y clientes de manera simultánea.
- Simulación realista del proceso de cobro usando hilos (concurrencia).
- Registro del tiempo necesario para procesar cada compra y cada producto.
- Visualización del detalle de productos comprados, costo total y tiempo de procesamiento.
- Cálculo y visualización del tiempo total de cobro para todas las compras.

## 📦 Estructura del Proyecto

SupermercadoSimulacion/
├── src/
│ ├── modelo/
│ │ ├── Producto.java
│ │ ├── Cliente.java
│ │ └── Cajera.java
│ ├── simulacion/
│ │ └── Supermercado.java
│ └── util/
│ └── GeneradorDatos.java
├── test/
│ ├── ProductoTest.java
│ ├── ClienteTest.java
│ └── CajeraTest.java
├── docs/
│ ├── Caso_de_Estudio.pdf
│ └── explicacion.txt
├── video/
│ └── explicacion.mp4
├── lib/
│ └── (JARs de JUnit si no usas Maven/Gradle)
├── pom.xml / build.gradle
└── README.md

## ⚙️ Instalación y Ejecución

### 1. Prerrequisitos

- Java 11 o superior.

### 2. Clonar el repositorio

git clone https://github.com/tu-usuario/SupermercadoSimulacion.git
cd SupermercadoSimulacion

### 3. Compilar y ejecutar

**Con Maven:**
mvn compile
mvn exec:java -Dexec.mainClass="simulacion.Supermercado"

**Con Gradle:**
./gradlew build
./gradlew run
text

**Con VSCode o IDE:**  
Abre el proyecto, haz clic derecho sobre `Supermercado.java` y selecciona "Run".

## 🧑‍💻 Uso y Ejemplo

Al ejecutar la simulación, verás en la consola cómo cada cajera atiende a los clientes, procesando cada producto, mostrando los tiempos y totales.  
Ejemplo de salida:

Cajera Cajera-1 comienza a atender a Cliente-1
Cajera Cajera-1 procesó el producto: Leche | Precio: $4.5 | Tiempo: 1000ms
...
Cajera Cajera-1 terminó de atender a Cliente-1 | Total a pagar: $15.3 | Tiempo total: 3000ms
...
Tiempo total de cobro para todos los clientes: 9500 ms

## 👥 Autores y Créditos

- Desarrollado por: Lucas Rodriguez.
- Universidad: IUDigital de Antioquia
- Año: 2025