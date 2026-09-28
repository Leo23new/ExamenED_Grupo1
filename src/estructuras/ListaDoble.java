package estructuras;

import nodos.NodoDoble;

public class ListaDoble {
    private NodoDoble cabeza, cola;

    public void insertarAlFinal(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void recorrerAdelante() {
        NodoDoble temp = cabeza;
        if (temp == null)
            System.out.println("Historial vacío.");
        while (temp != null) {
            System.out.println(temp.dato.toString());
            temp = temp.siguiente;
        }
    }
}