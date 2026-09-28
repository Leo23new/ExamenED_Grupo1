package estructuras;
import nodos.NodoSimple;

public class ListaCircular {
    private NodoSimple inicio, ultimo;

    public void insertar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (inicio == null) {
            inicio = ultimo = nuevo;
            inicio.siguiente = inicio;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = inicio;
            ultimo = nuevo;
        }
    }

    public void mostrarRonda() {
        if (inicio == null) return;
        NodoSimple temp = inicio;
        do {
            System.out.print(temp.dato.toString() + " -> ");
            temp = temp.siguiente;
        } while (temp != inicio);
        System.out.println("(Vuelve al inicio)");
    }
}