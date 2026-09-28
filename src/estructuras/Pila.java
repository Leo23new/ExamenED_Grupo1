package estructuras;
import nodos.NodoSimple;

public class Pila {
    private NodoSimple tope;

    public void apilar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Object desapilar() {
        if (tope == null) return null;
        Object dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }
}