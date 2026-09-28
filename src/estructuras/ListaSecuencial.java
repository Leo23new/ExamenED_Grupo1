package estructuras;
import modelos.Laptop;

public class ListaSecuencial {
    private Laptop[] inventario;
    private int cantidad;

    public ListaSecuencial() {
        inventario = new Laptop[100];
        cantidad = 0;
    }

    public void insertar(Laptop lap) {
        if (cantidad < 100) { inventario[cantidad++] = lap; }
    }

    public Laptop buscar(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (inventario[i].getCodigo().equals(codigo)) return inventario[i];
        }
        return null;
    }

    public void mostrar() {
        for (int i = 0; i < cantidad; i++) { System.out.println(inventario[i].toString()); }
    }
}