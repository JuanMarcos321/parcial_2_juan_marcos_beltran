package plataforma;

import java.util.ArrayList;
import java.util.List;

/**
 * Plataforma que AGREGA experimentos.
 */
public class Plataforma {

    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    /** Agrega un experimento ya existente (agregación). */
    public void agregarExperimento(Experimento experimento) {
        if (experimento != null) {
            experimentos.add(experimento);
        }
    }

    /**
     * Reporte: una línea por experimento con su id y el mejor loss de su modelo.
     */
    public List<String> reporteMejorLoss() {
        List<String> reporte = new ArrayList<>();
        for (Experimento e : experimentos) {
            if (e.getModelo() == null) {
                reporte.add(e.getId() + " - sin modelo");
            } else if (e.getModelo().mejorLoss() == Integer.MAX_VALUE) {
                reporte.add(e.getId() + " - sin entrenar");
            } else {
                reporte.add(e.getId() + " - mejor loss: " + e.getModelo().mejorLoss());
            }
        }
        return reporte;
    }

    public String getNombre() { return nombre; }
    public ArrayList<Experimento> getExperimentos() { return experimentos; }
}