package modelos;

import datos.Dataset;

/**
 * Modelo de regresión. Hiperparámetro: grado del polinomio.
 */
public class ModeloRegresion extends Modelo {

    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int loss = 40 + grado * 5; //crea el loss inicial
        int epocas = getLossPorEpoca().length; //pregunta la capacidad maxima del historial
        for (int i = 0; i < epocas; i++) {  //se repite "epocas" veces
            registrarEpoca(loss); // guarda el loss actual
            loss = Math.max(1, loss / 2); // divide el loss entre 2
        }
        return mejorLoss();
    }

    public int getGrado() { return grado; }
}