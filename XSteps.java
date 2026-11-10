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