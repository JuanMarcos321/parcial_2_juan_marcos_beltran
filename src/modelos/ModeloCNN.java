package modelos;

import datos.Dataset;

/**
 * Modelo CNN. Hiperparámetro: número de filtros.
 */
public class ModeloCNN extends Modelo {

    private int numFiltros;

    public ModeloCNN(String nombre, int maxEpocas, int numFiltros) {
        super(nombre, maxEpocas);
        this.numFiltros = numFiltros;
    }

    /**
     * TODO estudiante:
     * Simula el entrenamiento registrando hasta maxEpocas valores decrecientes
     * de loss. Retorna el mejor (menor) loss alcanzado.
     * Puedes usar un loss inicial proporcional a numFiltros y decrementarlo
     * en cada época.
     */
    @Override
    public double entrenar(Dataset dataset) {
        int loss = Math.max(1, numFiltros * 10); //crea el loss inicial
        int epocas = getLossPorEpoca().length; //pregunta la capacidad maxima del historial
        for (int i = 0; i < epocas; i++) { //se repite "epocas" veces
            registrarEpoca(loss); // guarda el loss actual
            loss = Math.max(1, (int) (loss * 0.8)); // multiplica por 0.8
        }
        return mejorLoss();
    }

    public int getNumFiltros() { return numFiltros; }
}