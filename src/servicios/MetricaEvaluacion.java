package servicios;

import modelos.Modelo;

/**
 * Servicio que calcula métricas de evaluación para un modelo.
 * Se usa como DEPENDENCIA desde Modelo.calcularMetrica(MetricaEvaluacion).
 */
public class MetricaEvaluacion {

    public double calcular(Modelo modelo, String nombreMetrica) {
        int mejor = modelo.mejorLoss();
        if (mejor == Integer.MAX_VALUE) {
            return 0;
        }
        return 100.0 / (1 + mejor);
    }
}