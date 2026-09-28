package estructuras;
import nodos.NodoSimple;
import modelos.Prestamo;

public class ListaSimple {
    private NodoSimple cabeza;

    public void insertar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (cabeza == null) { cabeza = nuevo; } 
        else {
            NodoSimple temp = cabeza;
            while (temp.siguiente != null) temp = temp.siguiente;
            temp.siguiente = nuevo;
        }
    }

    public void recorrer() {
        NodoSimple temp = cabeza;
        while (temp != null) {
            System.out.println(temp.dato.toString());
            temp = temp.siguiente;
        }
    }

    public void eliminar(String codigoLaptop) {
        if (cabeza == null) return;
        if (((Prestamo)cabeza.dato).getLaptop().getCodigo().equals(codigoLaptop)) {
            cabeza = cabeza.siguiente; return;
        }
        NodoSimple actual = cabeza;
        while (actual.siguiente != null && !((Prestamo)actual.siguiente.dato).getLaptop().getCodigo().equals(codigoLaptop)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) { actual.siguiente = actual.siguiente.siguiente; }
    }
}