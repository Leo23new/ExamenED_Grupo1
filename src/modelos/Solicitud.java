package modelos;
public class Solicitud {
    private String estudiante;
    public Solicitud(String estudiante) { this.estudiante = estudiante; }
    @Override public String toString() { return "Solicitud de: " + estudiante; }
}