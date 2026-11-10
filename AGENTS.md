# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Evaluación de la importancia de las pruebas de performance en proyectos de software**.

| | |
|---|---|
| Tema | Importancia de las pruebas de performance Fundamentos de pruebas de performance |
| Nivel | advanced-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / JMeter 5.6 |
| Patron arquitectonico | suite de pruebas de performance con escenarios de carga, estrés y volumen |
| Tiempo estimado | 2 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- org.apache.jmeter:ApacheJMeter_core 5.6.3
- org.apache.jmeter:ApacheJMeter_http 5.6.3
- org.apache.jmeter:ApacheJMeter_junit 5.6.3
- org.apache.jmeter:jorphan 5.6.3
- org.apache.maven.plugins:maven-surefire-plugin 3.2.5

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de tipos de pruebas no funcionales**: Lista de tipos de pruebas no funcionales con descripciones y su importancia en el proyecto.
- **Fase 2 — Evaluación de la importancia de las pruebas no funcionales**: Informe que evalúa la importancia de las pruebas no funcionales en el proyecto, incluyendo un análisis de caso y ejemplos prácticos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (2)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `RunCucumberTest.java` — `org.junit.runner`
      El import org.junit.runner.RunWith pertenece a org.junit.runner, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `XSteps.java` — `io.cucumber.java`
      El import io.cucumber.java.es.Cuando pertenece a io.cucumber.java, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).

### Presentes (9)

- `pom.xml`
- `RunCucumberTest.java`
- `XSteps.java`
- `README.md`
- `src/test/jmeter/prestamos_performance_test.jmx`
- `src/test/resources/data/usuarios_simulados.csv`
- `src/test/resources/config/jmeter.properties`
- `src/test/jmeter/prestamos_baseline_test.jmx`
- `src/test/jmeter/prestamos_failure_tolerance_test.jmx`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/test/jmeter`
- `src/test/resources/data`
- `src/test/resources/config`
- `reports`

## Verificacion

```bash
mvn clean test-compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **suite de pruebas de performance con escenarios de carga, estrés y volumen**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Tecnología Pruebas de Performance, Advanced L2
- Brecha que el reto ataca: Reconoce la importancia de llevar a cabo pruebas no funcionales, como las pruebas de carga, rendimiento, volumen, estrés, estabilidad, linea base, tolerancia a fallas y robustez, dentro de los proyectos, Reconoce la importancia de llevar a cabo pruebas no funcionales, como las pruebas de carga, rendimiento, volumen, estrés, estabilidad, linea base, tolerancia a fallas y robustez, dentro de los proyectos

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
