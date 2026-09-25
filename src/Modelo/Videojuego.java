package Modelo;

public class Videojuego {

    private String titulo;
    private String genero;
    private double precio;

    public Videojuego() {
    }

    public Videojuego(String titulo, String genero, double precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
    // Sobrecarga de métodos
    public double calcularPrecioFinal() {
        return precio;
    }

    public double calcularPrecioFinal(double descuento) {
        return precio - (precio * descuento / 100);
    }
}