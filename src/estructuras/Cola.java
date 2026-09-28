package estructuras;
import nodos.NodoSimple;

public class Cola {
     private NodoSimple frente, fin;

    public void encolar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (frente == null) { frente = fin = nuevo; } 
        else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public void listar() {
        NodoSimple temp = frente;
        if (temp == null) System.out.println("La cola está vacía.");
        while (temp != null) {
            System.out.println(temp.dato.toString());
            temp = temp.siguiente;
        }
    }
}
