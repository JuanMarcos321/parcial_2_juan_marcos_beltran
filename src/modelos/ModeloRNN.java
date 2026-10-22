package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }


    @Override
    public double entrenar(Dataset dataset) {
        int loss = 50 + numCapas * 10;  //crea el loss inicial
        int epocas = getLossPorEpoca().length; //pregunta la capacidad maxima del historial
        for (int i = 0; i < epocas; i++) { //se repite "epocas" veces
            registrarEpoca(loss); // guarda el loss actual
            loss = Math.max(1, loss - 5); // resta 5
        }
        return mejorLoss();
    }

    public int getNumCapas() { return numCapas; }
}
