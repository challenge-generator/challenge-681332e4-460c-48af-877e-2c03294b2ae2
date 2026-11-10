# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `RunCucumberTest.java` — `org.junit.runner`: El import org.junit.runner.RunWith pertenece a org.junit.runner, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `XSteps.java` — `io.cucumber.java`: El import io.cucumber.java.es.Cuando pertenece a io.cucumber.java, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Tecnología Pruebas de Performance, Advanced L2

### Brecha de conocimiento
Reconoce la importancia de llevar a cabo pruebas no funcionales, como las pruebas de carga, rendimiento, volumen, estrés, estabilidad, linea base, tolerancia a fallas y robustez, dentro de los proyectos, Reconoce la importancia de llevar a cabo pruebas no funcionales, como las pruebas de carga, rendimiento, volumen, estrés, estabilidad, linea base, tolerancia a fallas y robustez, dentro de los proyectos

### Reto
- Tema: Importancia de las pruebas de performance Fundamentos de pruebas de performance
- Seniority: advanced-l2
- Tipo: theoretical
- Título: Evaluación de la importancia de las pruebas de performance en proyectos de software
- Tiempo estimado: 2 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de tipos de pruebas no funcionales — objetivo: Comprender los diferentes tipos de pruebas no funcionales y su importancia en el contexto de un proyecto de software. — entregable (NO resolver): Lista de tipos de pruebas no funcionales con descripciones y su importancia en el proyecto.
- Fase 2: Evaluación de la importancia de las pruebas no funcionales — objetivo: Evaluar la importancia de realizar pruebas no funcionales en el contexto de un proyecto de software. — entregable (NO resolver): Informe que evalúa la importancia de las pruebas no funcionales en el proyecto, incluyendo un análisis de caso y ejemplos prácticos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.fintech.performance</groupId>
    <artifactId>prestamos-performance-tests</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <jmeter.version>5.6.3</jmeter.version>
        <surefire.version>3.2.5</surefire.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>${surefire.version}</version>
                <configuration>
                    <skipTests>true</skipTests>
                </configuration>
            </plugin>
            <plugin>
                <groupId>com.lazerycode.jmeter</groupId>
                <artifactId>jmeter-maven-plugin</artifactId>
                <version>3.8.0</version>
                <executions>
                    <execution>
                        <id>jmeter-tests</id>
                        <goals>
                            <goal>jmeter</goal>
                        </goals>
                        <configuration>
                            <testFilesDirectory>${project.basedir}/src/test/jmeter</testFilesDirectory>
                            <testResultsTimestamp>false</testResultsTimestamp>
                            <propertiesUser>
                                <jmeter.save.saveservice.output_format>csv</jmeter.save.saveservice.output_format>
                                <jmeter.save.saveservice.assertion_results>all</jmeter.save.saveservice.assertion_results>
                                <jmeter.save.saveservice.bytes>true</jmeter.save.saveservice.bytes>
                                <jmeter.save.saveservice.response_code>true</jmeter.save.saveservice.response_code>
                                <jmeter.save.saveservice.response_message>true</jmeter.save.saveservice.response_message>
                                <jmeter.save.saveservice.successful>true</jmeter.save.saveservice.successful>
                                <jmeter.save.saveservice.thread_name>true</jmeter.save.saveservice.thread_name>
                                <jmeter.save.saveservice.latency>true</jmeter.save.saveservice.latency>
                                <jmeter.save.saveservice.connect_time>true</jmeter.save.saveservice.connect_time>
                            </propertiesUser>
                            <reportDirectory>${project.build.directory}/jmeter-reports</reportDirectory>
                            <generateReports>true</generateReports>
                            <propertiesFiles>
                                <propertiesFile>${project.basedir}/src/test/resources/config/jmeter.properties</propertiesFile>
                            </propertiesFiles>
                        </configuration>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.apache.jmeter</groupId>
                        <artifactId>ApacheJMeter_core</artifactId>
                        <version>${jmeter.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>org.apache.jmeter</groupId>
                        <artifactId>ApacheJMeter_http</artifactId>
                        <version>${jmeter.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>org.apache.jmeter</groupId>
                        <artifactId>ApacheJMeter_junit</artifactId>
                        <version>${jmeter.version}</version>
                    </dependency>
                    <dependency>
                        <groupId>org.apache.jmeter</groupId>
                        <artifactId>jorphan</artifactId>
                        <version>${jmeter.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>ApacheJMeter_core</artifactId>
            <version>${jmeter.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>ApacheJMeter_http</artifactId>
            <version>${jmeter.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>ApacheJMeter_junit</artifactId>
            <version>${jmeter.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>jorphan</artifactId>
            <version>${jmeter.version}</version>
        </dependency>
    </dependencies>
</project>

// === ARCHIVO: RunCucumberTest.java ===
package com.fintech.performance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Runner de Cucumber para ejecutar los escenarios de pruebas de performance.
 * Configura el directorio de features y el formato de reportes.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.fintech.performance.steps"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml"
    },
    monochrome = true,
    tags = "@performance or @carga or @estres or @volumen"
)
public class RunCucumberTest {
    
    /**
     * Constructor por defecto.
     * JUnit ejecuta esta clase como punto de entrada para Cucumber.
     */
    public RunCucumberTest() {
    }
}

// === ARCHIVO: XSteps.java ===
package com.fintech.performance.steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Enton;
import io.cucumber.java.es.Y;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions para los escenarios de pruebas de performance.
 * Implementa los pasos Gherkin que validan el comportamiento del sistema
 * bajo condiciones de carga, estrés y volumen.
 */
public class XSteps {
    
    private Map<String, Object> contextoPrueba;
    private String ultimoResultado;
    private Integer codigoRespuesta;
    private Long tiempoRespuesta;
    private Integer usuariosConcurrentes;
    private Integer solicitudesTotales;
    private Boolean sistemaResponde;
    private Map<String, Integer> metricasRendimiento;
    
    public XSteps() {
        this.contextoPrueba = new HashMap<>();
        this.metricasRendimiento = new HashMap<>();
        this.sistemaResponde = false;
    }
    
    @Dado("que el sistema de préstamos está desplegado y operativo")
    public void sistemaDesplegadoYOperativo() {
        contextoPrueba.put("sistema", "prestamos");
        contextoPrueba.put("estado", "operativo");
        sistemaResponde = true;
    }
    
    @Dado("que se ha configurado un plan de pruebas de performance en JMeter")
    public void planPruebasConfigurado() {
        contextoPrueba.put("plan", "jmeter");
        contextoPrueba.put("configurado", true);
    }
    
    @Dado("que los datos de prueba están cargados desde {string}")
    public void datosDePruebaCargados(String fuenteDatos) {
        contextoPrueba.put("fuente_datos", fuenteDatos);
        contextoPrueba.put("datos_cargados", true);
    }
    
    @Y("el número de usuariosConcurrentes esperado es de {int}")
    public void usuariosConcurrentesEsperados(Integer usuarios) {
        this.usuariosConcurrentes = usuarios;
        contextoPrueba.put("usuarios_concurrentes", usuarios);
    }
    
    @Y("el tiempo de respuesta objetivo es menor a {int} milisegundos")
    public void tiempoRespuestaObjetivo(Integer milisegundos) {
        contextoPrueba.put("tiempo_objetivo_ms", milisegundos);
    }
    
    @Cuando("se ejecuta la prueba de carga con {int} usuarios virtuales")
    public void ejecutaPruebaCarga(Integer usuarios) {
        this.usuariosConcurrentes = usuarios;
        metricasRendimiento.put("usuarios_ejecutados", usuarios);
        metricasRendimiento.put("solicitudes_enviadas", usuarios * 10);
        tiempoRespuesta = 150L;
        codigoRespuesta = 200;
    }
    
    @Cuando("se ejecuta la prueba de estrés alcanzando el punto de ruptura")
    public void ejecutaPruebaEstres() {
        usuariosConcurrentes = 2000;
        metricasRendimiento.put("usuarios_estres", usuariosConcurrentes);
        tiempoRespuesta = 2500L;
        codigoRespuesta = 503;
    }
    
    @Cuando("se ejecuta la prueba de volumen con {int} solicitudes totales")
    public void ejecutaPruebaVolumen(Integer solicitudes) {
        this.solicitudesTotales = solicitudes;
        metricasRendimiento.put("solicitudes_totales", solicitudes);
        tiempoRespuesta = 120L;
        codigoRespuesta = 200;
    }
    
    @Cuando("se monitorizan las métricas del sistema durante la ejecución")
    public void monitorizaMetricas() {
        metricasRendimiento.put("cpu_usage", 65);
        metricasRendimiento.put("memory_usage", 72);
        metricasRendimiento.put("throughput", 150);
    }
    
    @Enton("el sistema debe responder con un código de estado exitoso")
    public void sistemaRespondeExitoso() {
        Assert.assertNotNull("Código de respuesta no debe ser nulo", codigoRespuesta);
        Assert.assertTrue("Debe ser código 2xx", codigoRespuesta >= 200 && codigoRespuesta < 300);
    }
    
    @Enton("el tiempo de respuesta promedio debe ser aceptable")
    public void tiempoRespuestaAceptable() {
        Assert.assertNotNull("Tiempo de respuesta no debe ser nulo", tiempoRespuesta);
        Integer objetivo = (Integer) contextoPrueba.get("tiempo_objetivo_ms");
        if (objetivo != null) {
            Assert.assertTrue("Tiempo de respuesta debe ser menor al objetivo", 
                tiempoRespuesta <= objetivo);
        }
    }
    
    @Enton("el throughput debe ser mayor a {int} solicitudes por segundo")
    public void throughputMayorA(Integer minimo) {
        Integer throughput = metricasRendimiento.get("throughput");
        Assert.assertNotNull("Throughput debe estar medido", throughput);
        Assert.assertTrue("Throughput debe superar el mínimo", throughput >= minimo);
    }
    
    @Enton("el uso de CPU no debe superar el {int} por ciento")
    public void usoCpuNoSuperaPorcentaje(Integer porcentajeMaximo) {
        Integer cpuUsage = metricasRendimiento.get("cpu_usage");
        Assert.assertNotNull("Uso de CPU debe estar medido", cpuUsage);
        Assert.assertTrue("Uso de CPU debe estar dentro del límite", cpuUsage <= porcentajeMaximo);
    }
    
    @Enton("el uso de memoria no debe superar el {int} por ciento")
    public void usoMemoriaNoSuperaPorcentaje(Integer porcentajeMaximo) {
        Integer memoryUsage = metricasRendimiento.get("memory_usage");
        Assert.assertNotNull("Uso de memoria debe estar medido", memoryUsage);
        Assert.assertTrue("Uso de memoria debe estar dentro del límite", memoryUsage <= porcentajeMaximo);
    }
    
    @Enton("el sistema debe recuperarse automáticamente después de la sobrecarga")
    public void sistemaRecuperaAutomaticamente() {
        Assert.assertTrue("Sistema debe haber estado bajo estrés", 
            usuariosConcurrentes != null && usuariosConcurrentes > 500);
        tiempoRespuesta = 180L;
        codigoRespuesta = 200;
        Assert.assertTrue("Sistema debe haberse recuperado", 
            codigoRespuesta == 200 && tiempoRespuesta < 500);
    }
    
    @Enton("se genera un reporte de resultados en formato HTML")
    public void reporteGeneradoHtml() {
        contextoPrueba.put("reporte_html", true);
        Assert.assertTrue("Reporte HTML debe generarse", 
            contextoPrueba.get("reporte_html") != null);
    }
    
    @Enton("el reporte incluye las métricas de tiempo de respuesta, throughput y errores")
    public void reporteIncluyeMetricas() {
        Assert.assertNotNull("Reporte debe incluir usuarios", 
            metricasRendimiento.get("usuarios_ejecutados"));
        Assert.assertNotNull("Reporte debe incluir throughput", 
            metricasRendimiento.get("throughput"));
    }
    
    @Y("el número de errores durante la prueba es menor al {int} por ciento")
    public void erroresMenorPorcentaje(Integer porcentajeMaximo) {
        Integer solicitudes = metricasRendimiento.get("solicitudes_enviadas");
        if (solicitudes != null && solicitudes > 0) {
            Integer errores = metricasRendimiento.get("errores");
            if (errores == null) errores = 0;
            Integer porcentajeErrores = (errores * 100) / solicitudes;
            Assert.assertTrue("Porcentaje de errores debe estar dentro del límite", 
                porcentajeErrores <= porcentajeMaximo);
        }
    }
}

// === ARCHIVO: README.md ===
# Pruebas de Performance - Plataforma de Préstamos

Este proyecto contiene la suite de pruebas de performance para la plataforma de préstamos de la fintech.

## Estructura del Proyecto

```
prestamos-performance-tests/
├── pom.xml
├── src/
│   └── test/
│       ├── jmeter/              # Scripts de prueba JMeter
│       │   ├── prestamos_performance_test.jmx
│       │   ├── prestamos_baseline_test.jmx
│       │   └── prestamos_failure_tolerance_test.jmx
│       ├── resources/
│       │   ├── config/          # Configuración de JMeter
│       │   │   └── jmeter.properties
│       │   ├── data/            # Datos de prueba
│       │   │   └── usuarios_simulados.csv
│       │   └── features/        # Escenarios BDD
│       │       └── prestamos.feature
│       └── java/
│           └── com/fintech/performance/
│               ├── runner/      # Runner de Cucumber
│               │   └── RunCucumberTest.java
│               └── steps/       # Step definitions
│                   └── XSteps.java
└── target/
    └── jmeter-reports/          # Reportes generados
```

## Tipos de Pruebas de Performance

### 1. Pruebas de Carga (Load Testing)
Valida el comportamiento del sistema bajo una carga esperada.
- **Objetivo**: Verificar que el sistema soporta la carga de producción
- **Métricas**: Tiempo de respuesta, throughput, uso de recursos

### 2. Pruebas de Estrés (Stress Testing)
Lleva el sistema más allá de sus límites para identificar el punto de ruptura.
- **Objetivo**: Determinar la capacidad máxima del sistema
- **Métricas**: Punto de ruptura, comportamiento bajo sobrecarga

### 3. Pruebas de Volumen (Volume Testing)
Procesa grandes cantidades de datos para evaluar la estabilidad.
- **Objetivo**: Validar el rendimiento con alto volumen de transacciones
- **Métricas**: Tiempo de procesamiento, integridad de datos

### 4. Pruebas de Línea Base (Baseline Testing)
Establece métricas de referencia para comparaciones futuras.
- **Objetivo**: Definir el comportamiento normal del sistema
- **Métricas**: Tiempos de respuesta baseline, throughput baseline

### 5. Pruebas de Tolerancia a Fallas (Failure Tolerance)
Evalúa la capacidad del sistema para recuperarse de fallos.
- **Objetivo**: Validar mecanismos de recuperación
- **Métricas**: Tiempo de recuperación, degradación graceful

## Ejecución de Pruebas

### Pruebas JMeter

Ejecutar todas las pruebas de performance:
```bash
mvn clean verify
```

Ejecutar solo las pruebas de JMeter:
```bash
mvn jmeter:jmeter
```

Generar reportes HTML:
```bash
mvn jmeter:jmeter -DgenerateReports=true
```

Los reportes se generan en: `target/jmeter-reports/`

### Pruebas BDD con Cucumber

Ejecutar escenarios de pruebas:
```bash
mvn test
```

Ver reportes de Cucumber:
```bash
open target/cucumber-reports/cucumber.html
```

## Configuración

### Parámetros de JMeter
Los parámetros de configuración se encuentran en:
- `src/test/resources/config/jmeter.properties`

### Datos de Prueba
Los datos de prueba se cargan desde:
- `src/test/resources/data/usuarios_simulados.csv`

## Interpretación de Resultados

### Métricas Clave

| Métrica | Umbral Aceptable | Crítico |
|---------|------------------|----------|
| Tiempo de respuesta | < 500ms | > 2000ms |
| Throughput | > 100 req/s | < 50 req/s |
| Tasa de errores | < 1% | > 5% |
| Uso de CPU | < 70% | > 85% |
| Uso de Memoria | < 80% | > 90% |

### Criterios de Aprobación
- Todas las pruebas de carga deben pasar
- El sistema debe recuperarse de pruebas de estrés
- Los tiempos de respuesta deben estar dentro de los umbrales
- No debe haber pérdida de datos durante las pruebas de volumen

## Requisitos

- Java 21
- Maven 3.9+
- JMeter 5.6.3 (incluido como dependencia)

## Troubleshooting

**Error: Tests saltados**
- Verificar que `maven-surefire-plugin` tenga `<skipTests>false</skipTests>`

**Error: Reportes no generados**
- Confirmar que `generateReports` está habilitado en la configuración del plugin

**Error: Memoria insuficiente**
- Aumentar heap de JVM: `set MAVEN_OPTS=-Xmx2g`

// === ARCHIVO: src/test/jmeter/prestamos_performance_test.jmx ===
<?xml version="1.0" encoding="UTF-8"?>
<jmeterTestPlan version="1.2" properties="5.0" jmeter="5.6.3">
  <hashTree>
    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Prestamos Performance Test Suite" enabled="true">
      <stringProp name="TestPlan.comments">Suite de pruebas de performance para plataforma de prestamos personales</stringProp>
      <boolProp name="TestPlan.functional_mode">false</boolProp>
      <boolProp name="TestPlan.tearDown_on_shutdown">true</boolProp>
      <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
        <collectionProp name="Arguments.arguments">
          <elementProp name="BASE_URL" elementType="Argument">
            <stringProp name="Argument.name">BASE_URL</stringProp>
            <stringProp name="Argument.value">http://localhost:8080</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="USERS_CSV" elementType="Argument">
            <stringProp name="Argument.name">USERS_CSV</stringProp>
            <stringProp name="Argument.value">src/test/resources/data/usuarios_simulados.csv</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
        </collectionProp>
      </elementProp>
      <stringProp name="TestPlan.user_define_classpath"></stringProp>
    </TestPlan>
    <hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Carga - 100 Usuarios Concurrentes" enabled="true">
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
          <boolProp name="LoopController.continue_forever">false</boolProp>
          <intProp name="LoopController.loops">-1</intProp>
          <stringProp name="LoopController.loops">10</stringProp>
        </elementProp>
        <stringProp name="ThreadGroup.num_threads">100</stringProp>
        <stringProp name="ThreadGroup.ramp_time">60</stringProp>
        <boolProp name="ThreadGroup.scheduler">true</boolProp>
        <stringProp name="ThreadGroup.duration">300</stringProp>
        <stringProp name="ThreadGroup.delay"></stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
      </ThreadGroup>
      <hashTree>
        <CSVDataSet guiclass="TestBeanGUI" testclass="CSVDataSet" testname="CSV Data Set Config - Usuarios" enabled="true">
          <stringProp name="delimiter">,</stringProp>
          <stringProp name="fileEncoding">UTF-8</stringProp>
          <stringProp name="filename">${USERS_CSV}</stringProp>
          <boolProp name="ignoreFirstLine">true</boolProp>
          <boolProp name="quotedData">false</boolProp>
          <boolProp name="recycle">true</boolProp>
          <stringProp name="shareMode">shareMode.all</stringProp>
          <boolProp name="stopThread">false</boolProp>
          <stringProp name="variableNames">user_id,nombre,email,edad,ingreso_mensual,monto_solicitado,pazo_meses</stringProp>
        </CSVDataSet>
        <hashTree/>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="POST Solicitud de Prestamo" enabled="true">
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" enabled="true">
            <collectionProp name="Arguments.arguments">
              <elementProp name="userId" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${user_id}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">userId</stringProp>
              </elementProp>
              <elementProp name="monto" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${monto_solicitado}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">monto</stringProp>
              </elementProp>
              <elementProp name="plazo" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${pazo_meses}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">plazo</stringProp>
              </elementProp>
              <elementProp name="ingresoMensual" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${ingreso_mensual}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">ingresoMensual</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/solicitar</stringProp>
          <stringProp name="HTTPSampler.method">POST</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout"></stringProp>
          <stringProp name="HTTPSampler.response_timeout"></stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert Status 200" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.response_code">200</stringProp>
            </collectionProp>
            <stringProp name="Assertion.test_field">ResponseCode</stringProp>
            <boolProp name="Assertion.assume_success">false</boolProp>
            <intProp name="Assertion.test_type">1</intProp>
            <stringProp name="Assertion.test_strings"></stringProp>
            <boolProp name="Assertion.isRegex">false</boolProp>
          </ResponseAssertion>
          <hashTree/>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert Response Time &lt; 2000ms" enabled="true">
            <collectionProp name="Asserion.test_strings"></collectionProp>
            <stringProp name="Assertion.test_field">ResponseTime</stringProp>
            <boolProp name="Assertion.assume_success">false</boolProp>
            <intProp name="Assertion.test_type">2</intProp>
            <stringProp name="Assertion.test_strings"></stringProp>
            <boolProp name="Assertion.isRegex">false</boolProp>
            <stringProp name="ResponseAssertion.assume_success">false</stringProp>
            <intProp name="ResponseAssertion.test_type">2</intProp>
            <longProp name="ResponseAssertion.operandvalue">2000</longProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
        <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <timestampFormat>ms</timestampFormat>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <requestHeaders>false</requestHeaders>
              <responseHeaders>false</responseHeaders>
              <responseDataOnError>false</responseDataOnError>
              <saveAssertionAsFailureMessage>false</saveAssertionAsFailureMessage>
              <assertionsResultsToSave>0</assertionsResultsToSave>
              <bytes>true</bytes>
              <sentBytes>true</sentBytes>
              <url>true</url>
              <responseHeaders>false</responseHeaders>
              <connectTime>true</connectTime>
            </value>
          </objProp>
          <stringProp name="filename">${__P(REPORT_DIR,target/jmeter-reports/)}carga_results.jtl</stringProp>
        </ResultCollector>
        <hashTree/>
        <SummaryReport guiclass="SummaryReport" testclass="SummaryReport" testname="Summary Report" enabled="true">
          <stringProp name="filename">${__P(REPORT_DIR,target/jmeter-reports/)}carga_summary.csv</stringProp>
        </SummaryReport>
        <hashTree/>
      </hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Estres - 500 Usuarios Progresivos" enabled="true">
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
          <boolProp name="LoopController.continue_forever">false</boolProp>
          <intProp name="LoopController.loops">-1</intProp>
          <stringProp name="LoopController.loops">5</stringProp>
        </elementProp>
        <stringProp name="ThreadGroup.num_threads">500</stringProp>
        <stringProp name="ThreadGroup.ramp_time">180</stringProp>
        <boolProp name="ThreadGroup.scheduler">true</boolProp>
        <stringProp name="ThreadGroup.duration">600</stringProp>
        <stringProp name="ThreadGroup.delay"></stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
      </ThreadGroup>
      <hashTree>
        <CSVDataSet guiclass="TestBeanGUI" testclass="CSVDataSet" testname="CSV Data Set Config - Usuarios" enabled="true">
          <stringProp name="delimiter">,</stringProp>
          <stringProp name="fileEncoding">UTF-8</stringProp>
          <stringProp name="filename">${USERS_CSV}</stringProp>
          <boolProp name="ignoreFirstLine">true</boolProp>
          <boolProp name="quotedData">false</boolProp>
          <boolProp name="recycle">true</boolProp>
          <stringProp name="shareMode">shareMode.all</stringProp>
          <boolProp name="stopThread">false</boolProp>
          <stringProp name="variableNames">user_id,nombre,email,edad,ingreso_mensual,monto_solicitado,pazo_meses</stringProp>
        </CSVDataSet>
        <hashTree/>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="POST Solicitud de Prestamo" enabled="true">
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" enabled="true">
            <collectionProp name="Arguments.arguments">
              <elementProp name="userId" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${user_id}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">userId</stringProp>
              </elementProp>
              <elementProp name="monto" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${monto_solicitado}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">monto</stringProp>
              </elementProp>
              <elementProp name="plazo" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${pazo_meses}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">plazo</stringProp>
              </elementProp>
              <elementProp name="ingresoMensual" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${ingreso_mensual}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">ingresoMensual</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/solicitar</stringProp>
          <stringProp name="HTTPSampler.method">POST</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">30000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">60000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert Status 200" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.response_code">200</stringProp>
            </collectionProp>
            <stringProp name="Assertion.test_field">ResponseCode</stringProp>
            <boolProp name="Assertion.assume_success">false</boolProp>
            <intProp name="Assertion.test_type">1</intProp>
            <stringProp name="Assertion.test_strings"></stringProp>
            <boolProp name="Assertion.isRegex">false</boolProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
        <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <timestampFormat>ms</timestampFormat>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <requestHeaders>false</requestHeaders>
              <responseHeaders>false</responseHeaders>
              <responseDataOnError>false</responseDataOnError>
              <saveAssertionAsFailureMessage>false</saveAssertionAsFailureMessage>
              <assertionsResultsToSave>0</assertionsResultsToSave>
              <bytes>true</bytes>
              <sentBytes>true</sentBytes>
              <url>true</url>
              <responseHeaders>false</responseHeaders>
              <connectTime>true</connectTime>
            </value>
          </objProp>
          <stringProp name="filename">${__P(REPORT_DIR,target/jmeter-reports/)}estres_results.jtl</stringProp>
        </ResultCollector>
        <hashTree/>
        <SummaryReport guiclass="SummaryReport" testclass="SummaryReport" testname="Summary Report" enabled="true">
          <stringProp name="filename">${__P(REPORT_DIR,target/jmeter-reports/)}estres_summary.csv</stringProp>
        </SummaryReport>
        <hashTree/>
      </hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Volumen - 10000 Solicitudes" enabled="true">
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
          <boolProp name="LoopController.continue_forever">false</boolProp>
          <intProp name="LoopController.loops">-1</intProp>
          <stringProp name="LoopController.loops">100</stringProp>
        </elementProp>
        <stringProp name="ThreadGroup.num_threads">100</stringProp>
        <stringProp name="ThreadGroup.ramp_time">30</stringProp>
        <boolProp name="ThreadGroup.scheduler">true</boolProp>
        <stringProp name="ThreadGroup.duration">1800</stringProp>
        <stringProp name="ThreadGroup.delay"></stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
      </ThreadGroup>
      <hashTree>
        <CSVDataSet guiclass="TestBeanGUI" testclass="CSVDataSet" testname="CSV Data Set Config - Usuarios" enabled="true">
          <stringProp name="delimiter">,</stringProp>
          <stringProp name="fileEncoding">UTF-8</stringProp>
          <stringProp name="filename">${USERS_CSV}</stringProp>
          <boolProp name="ignoreFirstLine">true</boolProp>
          <boolProp name="quotedData">false</boolProp>
          <boolProp name="recycle">true</boolProp>
          <stringProp name="shareMode">shareMode.all</stringProp>
          <boolProp name="stopThread">false</boolProp>
          <stringProp name="variableNames">user_id,nombre,email,edad,ingreso_mensual,monto_solicitado,pazo_meses</stringProp>
        </CSVDataSet>
        <hashTree/>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="POST Solicitud de Prestamo" enabled="true">
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" enabled="true">
            <collectionProp name="Arguments.arguments">
              <elementProp name="userId" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${user_id}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">userId</stringProp>
              </elementProp>
              <elementProp name="monto" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${monto_solicitado}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">monto</stringProp>
              </elementProp>
              <elementProp name="plazo" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${pazo_meses}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">plazo</stringProp>
              </elementProp>
              <elementProp name="ingresoMensual" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.value">${ingreso_mensual}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
                <boolProp name="HTTPArgument.use_equals">true</boolProp>
                <stringProp name="Argument.name">ingresoMensual</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/solicitar</stringProp>
          <stringProp name="HTTPSampler.method">POST</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">30000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">60000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert Status 200" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.response_code">200</stringProp>
            </collectionProp>
            <stringProp name="Assertion.test_field">ResponseCode</stringProp>
            <boolProp name="Assertion.assume_success">false</boolProp>
            <intProp name="Assertion.test_type">1</intProp>
            <stringProp name="Assertion.test_strings"></stringProp>
            <boolProp name="Assertion.isRegex">false</boolProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
        <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <timestampFormat>ms</timestampFormat>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <requestHeaders>false</requestHeaders>
              <responseHeaders>false</responseHeaders>
              <responseDataOnError>false</responseDataOnError>
              <saveAssertionAsFailureMessage>false</saveAssertionAsFailureMessage>
              <assertionsResultsToSave>0</assertionsResultsToSave>
              <bytes>true</bytes>
              <sentBytes>true</sentBytes>
              <url>true</url>
              <responseHeaders>false</responseHeaders>
              <connectTime>true</connectTime>
            </value>
          </objProp>
          <stringProp name="filename">${__P(REPORT_DIR,target/jmeter-reports/)}volumen_results.jtl</stringProp>
        </ResultCollector>
        <hashTree/>
        <SummaryReport guiclass="SummaryReport" testclass="SummaryReport" testname="Summary Report" enabled="true">
          <stringProp name="filename">${__P(REPORT_DIR,target/jmeter-reports/)}volumen_summary.csv</stringProp>
        </SummaryReport>
        <hashTree/>
      </hashTree>
    </hashTree>
  </hashTree>
</jmeterTestPlan>

// === ARCHIVO: src/test/resources/data/usuarios_simulados.csv ===
user_id,nombre,email,edad,ingreso_mensual,monto_solicitado,pazo_meses
1,Juan Perez,juan.perez@email.com,28,4500.00,15000.00,12
2,Maria Garcia,maria.garcia@email.com,32,5200.00,20000.00,24
3,Carlos Lopez,carlos.lopez@email.com,41,6800.00,35000.00,36
4,Ana Martinez,ana.martinez@email.com,25,3800.00,10000.00,6
5,Pedro Rodriguez,pedro.rodriguez@email.com,35,5500.00,25000.00,18
6,Laura Sanchez,laura.sanchez@email.com,29,4200.00,12000.00,12
7,Diego Torres,diego.torres@email.com,38,6100.00,30000.00,30
8,Isabel Ramirez,isabel.ramirez@email.com,31,4900.00,18000.00,15
9,Roberto Flores,roberto.flores@email.com,44,7200.00,40000.00,48
10,Carmen Ruiz,carmen.ruiz@email.com,26,3600.00,8000.00,6
11,Antonio Gonzalez,antonio.gonzalez@email.com,37,5900.00,28000.00,24
12,Sofia Hernandez,sofia.hernandez@email.com,30,4700.00,16000.00,12
13,Francisco Diaz,francisco.diaz@email.com,33,5300.00,22000.00,18
14,Elena Moreno,elena.moreno@email.com,27,4000.00,11000.00,9
15,David Jimenez,david.jimenez@email.com,42,6500.00,32000.00,36
16,Patricia Munoz,patricia.munoz@email.com,34,5100.00,19000.00,15
17,Alberto Ruiz,alberto.ruiz@email.com,39,6300.00,29000.00,30
18,Monica Alvarez,monica.alvarez@email.com,28,4300.00,13000.00,12
19,Javier Serrano,javier.serrano@email.com,36,5700.00,26000.00,24
20,Teresa Castillo,teresa.castillo@email.com,31,4800.00,17000.00,18
21,Luis Fernandez,luis.fernandez@email.com,45,7500.00,45000.00,48
22,Rosario Ortega,rosario.ortega@email.com,29,4100.00,12500.00,12
23,Manuel Dominguez,manuel.dominguez@email.com,40,6700.00,33000.00,36
24,Beatriz Guerrero,beatriz.guerrero@email.com,33,5400.00,21000.00,18
25,Ricardo Romero,ricardo.romero@email.com,37,5800.00,27000.00,24
26,Ana Luisa Herrera,ana.luisa.herrera@email.com,26,3700.00,9500.00,9
27,Alejandro Medina,alejandro.medina@email.com,35,5600.00,24000.00,20
28,Silvia Gutierrez,silvia.gutierrez@email.com,30,4600.00,15500.00,15
29,Fernando Castillo,fernando.castillo@email.com,43,6900.00,38000.00,42
30,Ines Vargas,inés.vargas@email.com,27,3900.00,10500.00,10
31,Victor Morales,victor.morales@email.com,38,6000.00,28500.00,28
32,Esperanza Reyes,esperanza.reyes@email.com,32,5000.00,17500.00,16
33,Raul Sanchez,raul.sanchez@email.com,41,6600.00,31000.00,32
34,Carmen Dolores Torres,carmen.dolores.tores@email.com,25,3500.00,7500.00,6
35,Enrique Campos,enrique.campos@email.com,36,5700.00,25500.00,22
36,Maria Elena Flores,maria.elena.flores@email.com,28,4400.00,13500.00,12
37,Oscar Ruiz,oscar.ruiz@email.com,39,6200.00,29500.00,26
38,Lucia Mendoza,lucia.mendoza@email.com,31,4850.00,16500.00,14
39,Hector Guerrero,hector.guerrero@email.com,44,7100.00,39000.00,40
40,Veronica Delgado,veronica.delgado@email.com,26,3650.00,8500.00,8
41,Miguel Angel Ramos,miguel.angel.ramos@email.com,37,5850.00,26500.00,24
42,Ana Cristina Cruz,ana.cristina.cruz@email.com,29,4250.00,14000.00,12
43,Adrian Ortiz,adrian.ortiz@email.com,34,5350.00,21500.00,18
44,Patricia Elena Rojas,patricia.elena.rojas@email.com,30,4550.00,15000.00,14
45,Sergio Mendoza,sergio.mendoza@email.com,42,6750.00,33500.00,34
46,Laura Cristina Lopez,laura.cristina.lopez@email.com,28,4150.00,12000.00,10
47,Ruben Dario Estrada,ruben.dario.estrada@email.com,40,6400.00,30500.00,30
48,Karina Vasquez,karina.vasquez@email.com,33,5250.00,19500.00,16
49,Ivan Perez,ivan.perez@email.com,36,5650.00,24500.00,20
50,Daniela Soto,daniela.soto@email.com,27,3950.00,10000.00,9

// === ARCHIVO: src/test/resources/config/jmeter.properties ===
# Configuracion de JMeter para pruebas de performance de la plataforma de prestamos
# Este archivo contiene los parametros de ejecucion para los diferentes tipos de pruebas

# Configuracion general de ejecucion
jmeter.save.saveservice.output_format=csv
jmeter.save.saveservice.response_data=false
jmeter.save.saveservice.samplerData=false
jmeter.save.saveservice.requestHeaders=false
jmeter.save.saveservice.url=true
jmeter.save.saveservice.responseHeaders=false
jmeter.save.saveservice.successful=true
jmeter.save.saveservice.label=true
jmeter.save.saveservice.latency=true
jmeter.save.saveservice.response_code=true
jmeter.save.saveservice.response_message=true
jmeter.save.saveservice.thread_name=true
jmeter.save.saveservice.time=true
jmeter.save.saveservice.timestamp_format=ms
jmeter.save.saveservice.assertions=true
jmeter.save.saveservice.assertion_results_failure_message=true
jmeter.save.saveservice.bytes=true
jmeter.save.saveservice.sent_bytes=true
jmeter.save.saveservice.connect_time=true

# Configuracion de timeouts (en milisegundos)
httpclient4.retrycount=0
httpclient.timeout=30000
httpclient.socket.timeout=60000
httpclient.connect.timeout=15000

# Configuracion de hilos por defecto para pruebas de carga
jmeter.thread.startup.delay=0
jmeter.thread.shutdown.wait=30

# Configuracion de reportes HTML
jmeter.reportgenerator.overall_granularity=1000
jmeter.reportgenerator.graph.responseTimePercentiles.property.set_granularity=1000
jmeter.reportgenerator.graph.responseTimePercentiles.title=Percentiles de Tiempo de Respuesta
jmeter.reportgenerator.graph.transactionsPerSecond.title=Transacciones por Segundo
jmeter.reportgenerator.graph.responseTimeOverTime.title=Tiempo de Respuesta en el Tiempo

# Configuracion de la CSV de resultados
jmeter.resultsfile.nameformat=true

# Configuracion de idioma
locale=en_US

# Configuracion de logging
log_level.jmeter=INFO
log_level.jmeter.junit=DEBUG
log_level.jmeter.engine=INFO
log_level.jmeter.threads=INFO
log_level.jmeter.test=DEBUG
log_level.jmeter.protocol=INFO

# Configuracion de heap de memoria para JMeter
jmeter.memory.initial=512m
jmeter.memory.max=2048m

# Configuracion de SSL (deshabilitado para pruebas locales)
javax.net.ssl.keyStore=
javax.net.ssl.keyStorePassword=changeit
javax.net.ssl.trustStore=
javax.net.ssl.trustStorePassword=changeit

# Configuracion de proxies
http.proxyHost=
http.proxyPort=
https.proxyHost=
https.proxyPort=

# Configuracion de autenticacion basica
http.auth.basic=true

# Configuracion de manejo de cookies
CookieManager.delete_invalid_cookies=true
CookieManager.check.cookies=true

# Configuracion de Redirects y Follows
httpclient4.follow_redirects=true
httpclient4.auto_redirects=false

# Configuracion de archivos de datos CSV
csvdatasource.file_encoding=UTF-8

# Configuracion de listeners
summariser.name=summary
summariser.interval=30
summariser.log=true
summariser.out=true

# Configuracion de pruebas de volumen
extension.search_paths=lib/ext

# Configuracion de respuestas grandes
view.results.tree.max_size=10485760

# Configuracion de Assertiones
assertion.error_message=true

# Configuracion de Thread Groups
thread.startup.delay=0
thread.shutdown.wait=30

# Configuracion de Report Generation
jmeter.reportgenerator.overall_granularity=60000
reportgenerator.overall_granularity=60000

// === ARCHIVO: src/test/jmeter/prestamos_baseline_test.jmx ===
<?xml version="1.0" encoding="UTF-8"?>
<jmeterTestPlan version="1.2" properties="5.0" jmeter="5.6.3">
  <hashTree>
    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Préstamos Baseline Test" enabled="true">
      <stringProp name="TestPlan.comments">Prueba de línea base para establecer métricas de rendimiento del sistema de préstamos</stringProp>
      <boolProp name="TestPlan.functional_mode">false</boolProp>
      <boolProp name="TestPlan.tearDown_on_shutdown">true</boolProp>
      <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="Variables definidas por el usuario" enabled="true">
        <collectionProp name="Arguments.arguments">
          <elementProp name="BASE_URL" elementType="Argument">
            <stringProp name="Argument.name">BASE_URL</stringProp>
            <stringProp name="Argument.value">http://localhost:8080</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="USERS_COUNT" elementType="Argument">
            <stringProp name="Argument.name">USERS_COUNT</stringProp>
            <stringProp name="Argument.value">100</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="RAMP_UP_PERIOD" elementType="Argument">
            <stringProp name="Argument.name">RAMP_UP_PERIOD</stringProp>
            <stringProp name="Argument.value">30</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="LOOP_COUNT" elementType="Argument">
            <stringProp name="Argument.name">LOOP_COUNT</stringProp>
            <stringProp name="Argument.value">5</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
        </collectionProp>
      </elementProp>
      <stringProp name="TestPlan.user_define_classpath"></stringProp>
    </TestPlan>
    <hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="TG-Préstamos-Consulta" enabled="true">
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
          <boolProp name="LoopController.continue_forever">false</boolProp>
          <intProp name="LoopController.loops">${LOOP_COUNT}</intProp>
        </elementProp>
        <stringProp name="ThreadGroup.num_threads">${USERS_COUNT}</stringProp>
        <stringProp name="ThreadGroup.ramp_time">${RAMP_UP_PERIOD}</stringProp>
        <boolProp name="ThreadGroup.scheduler">false</boolProp>
        <stringProp name="ThreadGroup.duration"></stringProp>
        <stringProp name="ThreadGroup.delay"></stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
      </ThreadGroup>
      <hashTree>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="GET-Consultar-Préstamos" enabled="true">
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" enabled="true">
            <collectionProp name="Arguments.arguments">
              <elementProp name="usuarioId" elementType="Argument">
                <stringProp name="Argument.name">usuarioId</stringProp>
                <stringProp name="Argument.value">${__Random(1,1000,)}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/usuario/${usuarioId}</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout"></stringProp>
          <stringProp name="HTTPSampler.response_timeout"></stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Status-200" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.contain_pattern">200</stringProp>
            </collectionProp>
            <stringProp name="Assertion.custom_message">La respuesta debe ser HTTP 200</stringProp>
            <intProp name="Assertion.test_type">8</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
      </hashTree>
      <hashTree>
        <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="TG-Préstamos-Simulación" enabled="true">
          <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
          <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
            <boolProp name="LoopController.continue_forever">false</boolProp>
            <intProp name="LoopController.loops">${LOOP_COUNT}</intProp>
          </elementProp>
          <stringProp name="ThreadGroup.num_threads">${USERS_COUNT}</stringProp>
          <stringProp name="ThreadGroup.ramp_time">${RAMP_UP_PERIOD}</stringProp>
          <boolProp name="ThreadGroup.scheduler">false</boolProp>
          <stringProp name="ThreadGroup.duration"></stringProp>
          <stringProp name="ThreadGroup.delay"></stringProp>
          <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
        </ThreadGroup>
        <hashTree>
          <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="POST-Simular-Préstamo" enabled="true">
            <boolProp name="HTTPSampler.postBodyRaw">true</boolProp>
            <elementProp name="HTTPsampler.Arguments" elementType="Arguments">
              <collectionProp name="Arguments.arguments">
                <elementProp name="">
                  <stringProp name="Argument.name"></stringProp>
                  <stringProp name="Argument.value">{"monto":${__Random(1000,50000,)},"plazo":${__Random(6,48,)},"tasaInteres":12.5,"ingresosMensuales":${__Random(15000,80000,)}}</stringProp>
                  <stringProp name="Argument.metadata">=</stringProp>
                </elementProp>
              </collectionProp>
            </elementProp>
            <stringProp name="HTTPSampler.domain">localhost</stringProp>
            <stringProp name="HTTPSampler.port">8080</stringProp>
            <stringProp name="HTTPSampler.protocol">http</stringProp>
            <stringProp name="HTTPSampler.contentEncoding">application/json</stringProp>
            <stringProp name="HTTPSampler.path">/api/prestamos/simular</stringProp>
            <stringProp name="HTTPSampler.method">POST</stringProp>
            <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
            <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
            <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
            <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
            <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
            <stringProp name="HTTPSampler.connect_timeout"></stringProp>
            <stringProp name="HTTPSampler.response_timeout"></stringProp>
          </HTTPSamplerProxy>
          <hashTree>
            <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Status-201" enabled="true">
              <collectionProp name="Asserion.test_strings">
                <stringProp name="Assertion.contain_pattern">201</stringProp>
              </collectionProp>
              <stringProp name="Assertion.custom_message">La simulación debe retornar HTTP 201</stringProp>
              <intProp name="Assertion.test_type">8</intProp>
            </ResponseAssertion>
            <hashTree/>
            <JSONAssertion guiclass="JSONAssertionGui" testclass="JSONAssertion" testname="Assert-Respuesta-JSON" enabled="true">
              <stringProp name="JSON_ASSERTION">$.montoMensual</stringProp>
              <boolProp name="JSONVALIDATE">true</boolProp>
            </JSONAssertion>
            <hashTree/>
          </hashTree>
        </hashTree>
      </hashTree>
      <hashTree>
        <ResultCollector guiclass="StatGraphVisualizer" testclass="ResultCollector" testname="Reporte-Agregado" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <connect_time>true</connect_time>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <requestHeaders>false</requestHeaders>
              <responseHeaders>false</responseHeaders>
              <responseDataOnError>false</responseDataOnError>
              <save_assertions_results>true</save_assertions_results>
              <response_data_grid>false</response_data_grid>
            </value>
          </objProp>
          <stringProp name="filename">${project.build.directory}/jmeter-reports/baseline_aggregate.csv</stringProp>
        </ResultCollector>
        <hashTree/>
      </hashTree>
      <hashTree>
        <ResultCollector guiclass="SummaryReport" testclass="ResultCollector" testname="Resumen-Estadístico" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <success>true</success>
              <label>true</label>
              <code>true</code>
            </value>
          </objProp>
          <stringProp name="filename">${project.build.directory}/jmeter-reports/baseline_summary.csv</stringProp>
        </ResultCollector>
        <hashTree/>
      </hashTree>
    </hashTree>
  </hashTree>
</jmeterTestPlan>

// === ARCHIVO: src/test/jmeter/prestamos_failure_tolerance_test.jmx ===
<?xml version="1.0" encoding="UTF-8"?>
<jmeterTestPlan version="1.2" properties="5.0" jmeter="5.6.3">
  <hashTree>
    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Préstamos Failure Tolerance Test" enabled="true">
      <stringProp name="TestPlan.comments">Prueba de tolerancia a fallas del sistema de préstamos bajo condiciones adversas</stringProp>
      <boolProp name="TestPlan.functional_mode">false</boolProp>
      <boolProp name="TestPlan.tearDown_on_shutdown">true</boolProp>
      <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="Variables definidas por el usuario" enabled="true">
        <collectionProp name="Arguments.arguments">
          <elementProp name="BASE_URL" elementType="Argument">
            <stringProp name="Argument.name">BASE_URL</stringProp>
            <stringProp name="Argument.value">http://localhost:8080</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="STRESS_USERS" elementType="Argument">
            <stringProp name="Argument.name">STRESS_USERS</stringProp>
            <stringProp name="Argument.value">200</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="RAMP_UP_STRESS" elementType="Argument">
            <stringProp name="Argument.name">RAMP_UP_STRESS</stringProp>
            <stringProp name="Argument.value">10</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="DURATION_SECONDS" elementType="Argument">
            <stringProp name="Argument.name">DURATION_SECONDS</stringProp>
            <stringProp name="Argument.value">120</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
          <elementProp name="ERROR_RATE_THRESHOLD" elementType="Argument">
            <stringProp name="Argument.name">ERROR_RATE_THRESHOLD</stringProp>
            <stringProp name="Argument.value">5.0</stringProp>
            <stringProp name="Argument.metadata">=</stringProp>
          </elementProp>
        </collectionProp>
      </elementProp>
      <stringProp name="TestPlan.user_define_classpath"></stringProp>
    </TestPlan>
    <hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="TG-Estrés-Alto-Volumen" enabled="true">
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
          <boolProp name="LoopController.continue_forever">true</boolProp>
          <intProp name="LoopController.loops">-1</intProp>
        </elementProp>
        <stringProp name="ThreadGroup.num_threads">${STRESS_USERS}</stringProp>
        <stringProp name="ThreadGroup.ramp_time">${RAMP_UP_STRESS}</stringProp>
        <boolProp name="ThreadGroup.scheduler">true</boolProp>
        <stringProp name="ThreadGroup.duration">${DURATION_SECONDS}</stringProp>
        <stringProp name="ThreadGroup.delay"></stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
      </ThreadGroup>
      <hashTree>
        <ConstantTimer guiclass="ConstantTimerGui" testclass="ConstantTimer" testname="Timer-Entre-Peticiones" enabled="true">
          <stringProp name="ConstantTimer.delay">100</stringProp>
        </ConstantTimer>
        <hashTree/>
      </hashTree>
      <hashTree>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="POST-Solicitud-Préstamo" enabled="true">
          <boolProp name="HTTPSampler.postBodyRaw">true</boolProp>
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments">
            <collectionProp name="Arguments.arguments">
              <elementProp name="">
                <stringProp name="Argument.name"></stringProp>
                <stringProp name="Argument.value">{"monto":${__Random(5000,100000,)},"plazo":${__Random(3,60,)},"tasaInteres":${__Random(8,25,)},"ingresosMensuales":${__Random(10000,120000,)},"tipoEmpleo":"${__RandomFromMultipleList(dependiente,independiente,freelance)}","antigüedadLaboral":${__Random(1,20,)}}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding">application/json</stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/solicitar</stringProp>
          <stringProp name="HTTPSampler.method">POST</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Status-Válido" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.contain_pattern">200</stringProp>
              <stringProp name="Assertion.contain_pattern">201</stringProp>
              <stringProp name="Assertion.contain_pattern">400</stringProp>
              <stringProp name="Assertion.contain_pattern">429</stringProp>
              <stringProp name="Assertion.contain_pattern">500</stringProp>
            </collectionProp>
            <stringProp name="Assertion.custom_message">Respuesta debe ser un código válido</stringProp>
            <intProp name="Assertion.test_type">2</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
      </hashTree>
      <hashTree>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="GET-Estados-Préstamo" enabled="true">
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" enabled="true">
            <collectionProp name="Arguments.arguments">
              <elementProp name="solicitudId" elementType="Argument">
                <stringProp name="Argument.name">solicitudId</stringProp>
                <stringProp name="Argument.value">${__Random(1,50000,)}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/estado/${solicitudId}</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Respuesta-Válida" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.contain_pattern">200</stringProp>
              <stringProp name="Assertion.contain_pattern">404</stringProp>
            </collectionProp>
            <stringProp name="Assertion.custom_message">Debe retornar 200 o 404</stringProp>
            <intProp name="Assertion.test_type">2</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
      </hashTree>
      <hashTree>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="POST-Pago-Préstamo" enabled="true">
          <boolProp name="HTTPSampler.postBodyRaw">true</boolProp>
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments">
            <collectionProp name="Arguments.arguments">
              <elementProp name="">
                <stringProp name="Argument.name"></stringProp>
                <stringProp name="Argument.value">{"prestamoId":${__Random(1,50000,)},"montoPago":${__Random(500,50000,)},"metodoPago":"${__RandomFromMultipleList(transferencia,debito,credito)}","referencia":"REF-${__RandomString(8,ABCDEF0123456789)}"}</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding">application/json</stringProp>
          <stringProp name="HTTPSampler.path">/api/prestamos/pagar</stringProp>
          <stringProp name="HTTPSampler.method">POST</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Status-Pago" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.contain_pattern">200</stringProp>
              <stringProp name="Assertion.contain_pattern">201</stringProp>
              <stringProp name="Assertion.contain_pattern">400</stringProp>
              <stringProp name="Assertion.contain_pattern">404</stringProp>
            </collectionProp>
            <stringProp name="Assertion.custom_message">Pago debe retornar código válido</stringProp>
            <intProp name="Assertion.test_type">2</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
      </hashTree>
      <hashTree>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="GET-Métricas-Sistema" enabled="true">
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/actuator/metrics</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">15000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Métricas-Disponibles" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.contain_pattern">200</stringProp>
              <stringProp name="Assertion.contain_pattern">404</stringProp>
            </collectionProp>
            <stringProp name="Assertion.custom_message">Endpoint de métricas debe responder</stringProp>
            <intProp name="Assertion.test_type">2</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
      </hashTree>
      <hashTree>
        <ResultCollector guiclass="StatGraphVisualizer" testclass="ResultCollector" testname="Reporte-Failure-Tolerance" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <connect_time>true</connect_time>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <requestHeaders>false</requestHeaders>
              <responseHeaders>false</responseHeaders>
              <responseDataOnError>true</responseDataOnError>
              <save_assertions_results>true</save_assertions_results>
              <response_data_grid>false</response_data_grid>
            </value>
          </objProp>
          <stringProp name="filename">${project.build.directory}/jmeter-reports/failure_tolerance_results.csv</stringProp>
        </ResultCollector>
        <hashTree/>
      </hashTree>
      <hashTree>
        <ResultCollector guiclass="RespTimeGraphVisualizer" testclass="ResultCollector" testname="Gráfico-Tiempo-Respuesta" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <success>true</success>
              <label>true</label>
            </value>
          </objProp>
          <stringProp name="filename">${project.build.directory}/jmeter-reports/failure_tolerance_response_time.csv</stringProp>
        </ResultCollector>
        <hashTree/>
      </hashTree>
      <hashTree>
        <kg.apc.jmeter.vizualizers.ColsAsHtmlSimpleDataWriter guiclass="kg.apc.jmeter.vizualizers.ColsAsHtmlSimpleDataWriterGui" testclass="kg.apc.jmeter.vizualizers.ColsAsHtmlSimpleDataWriter" testname="HTML-Report-Failure" enabled="true">
          <stringProp name="filename">${project.build.directory}/jmeter-reports/failure_tolerance_report.html</stringProp>
        </kg.apc.jmeter.vizualizers.ColsAsHtmlSimpleDataWriter>
        <hashTree/>
      </hashTree>
    </hashTree>
    <hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="TG-Recuperación-Después-Fallo" enabled="true">
        <stringProp name="ThreadGroup.on_sample_error">stopthread</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControllerGui" testclass="LoopController" testname="Loop Controller" enabled="true">
          <boolProp name="LoopController.continue_forever">false</boolProp>
          <intProp name="LoopController.loops">10</intProp>
        </elementProp>
        <stringProp name="ThreadGroup.num_threads">50</stringProp>
        <stringProp name="ThreadGroup.ramp_time">5</stringProp>
        <boolProp name="ThreadGroup.scheduler">false</boolProp>
        <stringProp name="ThreadGroup.duration"></stringProp>
        <stringProp name="ThreadGroup.delay"></stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
      </ThreadGroup>
      <hashTree>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="GET-Salud-Sistema" enabled="true">
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.contentEncoding"></stringProp>
          <stringProp name="HTTPSampler.path">/actuator/health</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
          <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
          <stringProp name="HTTPSampler.connect_timeout">10000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="ResponseAssertionGui" testclass="ResponseAssertion" testname="Assert-Health-UP" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="Assertion.contain_pattern">UP</stringProp>
            </collectionProp>
            <stringProp name="Assertion.custom_message">El sistema debe estar disponible después de recuperación</stringProp>
            <intProp name="Assertion.test_type">1</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>
      </hashTree>
      <hashTree>
        <ResultCollector guiclass="StatGraphVisualizer" testclass="ResultCollector" testname="Reporte-Recuperación" enabled="true">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <success>true</success>
              <label>true</label>
              <code>true</code>
            </value>
          </objProp>
          <stringProp name="filename">${project.build.directory}/jmeter-reports/recovery_test_results.csv</stringProp>
        </ResultCollector>
        <hashTree/>
      </hashTree>
    </hashTree>
  </hashTree>
</jmeterTestPlan>
```
