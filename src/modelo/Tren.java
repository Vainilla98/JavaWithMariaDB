package modelo;

public class Tren {
    private int cod;
    private String nombre;
    private String tipo;
    private Linea linea;
    private int codCochera;

    public Tren(int cod, String nombre, String tipo, Linea linea, int codCochera) {
        this.cod = cod;
        this.nombre = nombre;
        this.tipo = tipo;
        this.linea = linea;
        this.codCochera = codCochera;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public int getCodCochera() {
        return codCochera;
    }

    public void setCodCochera(int codCochera) {
        this.codCochera = codCochera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tren tren = (Tren) o;

        return cod == tren.cod;
    }
}
