import modelos.*;
import estructuras.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaSecuencial inventario = new ListaSecuencial();
        ListaSimple prestamosActivos = new ListaSimple();
        Cola espera = new Cola();
        ListaDoble historial = new ListaDoble();
        Pila deshacer = new Pila();
        ListaCircular turnos = new ListaCircular();

        // Datos mínimos sugeridos obligatorios
        inventario.insertar(new Laptop("LAP001", "Dell", "i5", 80, "Disponible"));
        inventario.insertar(new Laptop("LAP002", "HP", "i7", 60, "Prestado"));
        inventario.insertar(new Laptop("LAP003", "Lenovo", "Ryzen 5", 20, "Disponible"));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE PRESTAMO DE LAPTOPS ---");
            System.out.println("1. Ver Inventario");
            System.out.println("2. Registrar Préstamo (Regla >= 25%)");
            System.out.println("3. Ver Préstamos Activos");
            System.out.println("4. Ver Cola de Espera");
            System.out.println("5. Ver Historial");
            System.out.println("6. Deshacer último préstamo");
            System.out.println("7. Administrar Turnos Contingencia");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
             switch (opcion) {
                case 1:
                    inventario.mostrar();
                    break;
                case 2:
                    System.out.print("Código de Laptop: ");
                    String cod = sc.nextLine();
                    Laptop lap = inventario.buscar(cod);
                    if (lap != null) {
                        if (lap.getEstado().equals("Prestado")) {
                            System.out.print("Laptop ocupada. Ingrese su nombre para ir a la cola: ");
                            String est = sc.nextLine();
                            espera.encolar(new Solicitud(est));
                            System.out.println("Enviado a cola de espera.");
                        } else if (lap.getBateria() < 25) { // Regla diferenciadora
                            System.out.println("ERROR: Batería menor al 25%. No se puede prestar.");
                        } else {
                          System.out.print("Nombre del Estudiante: ");
                            String est = sc.nextLine();
                            lap.setEstado("Prestado");
                            Prestamo p = new Prestamo(lap, est);
                            prestamosActivos.insertar(p);
                            deshacer.apilar(p);
                            historial.insertarAlFinal("Préstamo: " + cod + " a " + est);
                            System.out.println("Préstamo exitoso.");
                        }
                    } else { System.out.println("Laptop no encontrada."); }
                    break;
                case 3: prestamosActivos.recorrer(); break;
                case 4: espera.listar(); break;
                case 5: historial.recorrerAdelante(); break;
                case 6: 
                    Prestamo pError = (Prestamo) deshacer.desapilar();
                    if (pError != null) {
                        prestamosActivos.eliminar(pError.getLaptop().getCodigo());
                        pError.getLaptop().setEstado("Disponible");
                        historial.insertarAlFinal("Deshecho: " + pError.getLaptop().getCodigo());
                        System.out.println("Préstamo deshecho con éxito.");
                    } else { System.out.println("No hay acciones para deshacer."); }
                    break;
                case 7:
                    System.out.println("Agregando turno...");
                    turnos.insertar(new Solicitud("Estudiante Contingencia"));
                    turnos.mostrarRonda();
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}
