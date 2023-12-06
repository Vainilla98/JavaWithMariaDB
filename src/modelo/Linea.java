package modelo;

public class Linea {
    private int codLinea;
    private String nombre;

    public Linea(int codLinea, String nombre) {
        this.codLinea = codLinea;
        this.nombre = nombre;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
