# Evaluación de la importancia de las pruebas de performance en proyectos de software

El equipo de desarrollo de una fintech está en proceso de lanzar una nueva plataforma de préstamos personales. Es crucial asegurar que la plataforma pueda manejar un alto volumen de solicitudes simultáneas sin degradar el rendimiento. El objetivo es reconocer la importancia de llevar a cabo pruebas no funcionales, tales como pruebas de carga, rendimiento, volumen, estrés, estabilidad, línea base, tolerancia a fallas y robustez, dentro de los proyectos.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Importancia de las pruebas de performance Fundamentos de pruebas de performance |
| **Nivel** | advanced-l2 |
| **Tipo** | theoretical |
| **Tiempo estimado** | 2 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Identificación de tipos de pruebas no funcionales

**Objetivo:** Comprender los diferentes tipos de pruebas no funcionales y su importancia en el contexto de un proyecto de software.

**Tiempo estimado:** 30 minutos

**Instrucciones:**

- Enumera y describe brevemente las pruebas de carga, rendimiento, volumen, estrés, estabilidad, línea base, tolerancia a fallas y robustez.
- Explica la importancia de cada tipo de prueba en el contexto de la plataforma de préstamos personales.

**Entregable:** Lista de tipos de pruebas no funcionales con descripciones y su importancia en el proyecto.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo cada tipo de prueba puede afectar la experiencia del usuario y la estabilidad del sistema.
- Piensa en escenarios realistas donde cada tipo de prueba sería crucial.

</details>

### Fase 2: Evaluación de la importancia de las pruebas no funcionales

**Objetivo:** Evaluar la importancia de realizar pruebas no funcionales en el contexto de un proyecto de software.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Analiza un caso de estudio donde se omitieron las pruebas no funcionales y discute las consecuencias.
- Proporciona ejemplos de cómo las pruebas no funcionales pueden prevenir problemas en la plataforma de préstamos personales.

**Entregable:** Informe que evalúa la importancia de las pruebas no funcionales en el proyecto, incluyendo un análisis de caso y ejemplos prácticos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las posibles consecuencias de no realizar pruebas no funcionales en términos de rendimiento y satisfacción del usuario.
- Piensa en cómo las pruebas no funcionales pueden ayudar a identificar y solucionar problemas antes del lanzamiento.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las pruebas no funcionales y por qué son importantes en el contexto de un proyecto de software?
- **paraQueSirve**: ¿Cuál es el propósito de realizar pruebas no funcionales en un proyecto de software?
- **queDecisionesImplica**: ¿Qué decisiones críticas pueden surgir al realizar pruebas no funcionales en un proyecto de software?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir al no realizar pruebas no funcionales en un proyecto de software?

## Criterios de Evaluacion

- Identificación correcta de los diferentes tipos de pruebas no funcionales.
- Descripción precisa de la importancia de cada tipo de prueba en el contexto del proyecto.
- Análisis detallado de un caso de estudio donde se omitieron las pruebas no funcionales y sus consecuencias.
- Proporción de ejemplos prácticos de cómo las pruebas no funcionales pueden prevenir problemas en la plataforma de préstamos personales.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
