package modelos;
public class Prestamo {
    private Laptop laptop;
    private String estudiante;
    public Prestamo(Laptop laptop, String estudiante) {
        this.laptop = laptop; this.estudiante = estudiante;
    }
    public Laptop getLaptop() { return laptop; }
    @Override public String toString() { return "Estudiante: " + estudiante + " | Equipo: " + laptop.getCodigo(); }
}