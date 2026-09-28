package nodos;

public class NodoDoble {
    public Object dato;
    public NodoDoble siguiente, anterior;

    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = this.anterior = null;
    }
}
