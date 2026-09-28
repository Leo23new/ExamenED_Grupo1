package modelos;
public class Laptop {
    private String codigo, marca, procesador, estado;
    private int bateria;

    public Laptop(String codigo, String marca, String procesador, int bateria, String estado) {
        this.codigo = codigo; this.marca = marca; this.procesador = procesador;
        this.bateria = bateria; this.estado = estado;
    }
    public String getCodigo() { return codigo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getBateria() { return bateria; }
    @Override public String toString() {
        return codigo + " - " + marca + " - " + procesador + " - Bat: " + bateria + "% - " + estado;
    }
}