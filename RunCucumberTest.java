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