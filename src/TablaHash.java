import java.util.ArrayList;
import java.util.LinkedList;

class TablaHash {
    private ArrayList<LinkedList<Premio>> tabla;
    private int tamaño;

    public TablaHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            tabla.add(new LinkedList<>());
        }
    }

    private int calcularHash(int numero, int serie) {
        return (numero + serie) % tamaño;
    }

    public void insertar(Premio premio) {
        int posicion = calcularHash(premio.numero, premio.serie);
        tabla.get(posicion).add(premio);
    }

    public Premio buscar(int numero, int serie) {
        int posicion = calcularHash(numero, serie);
        LinkedList<Premio> lista = tabla.get(posicion);

        for (Premio premio : lista) {
            if (premio.numero == numero && premio.serie == serie) {
                return premio;
            }
        }
        return null;
    }

    public String mostrarTabla() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < tamaño; i++) {
            resultado.append("Posición ").append(i).append(": ");
            if (tabla.get(i).isEmpty()) {
                resultado.append("Vacía\n");
            } else {
                for (Premio premio : tabla.get(i)) {
                    resultado.append(premio).append(" -> ");
                }
                resultado.append("null\n");
            }
        }
        return resultado.toString();
    }
}