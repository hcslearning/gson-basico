package cl.hcslearning.gson;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        String json = null;
        Producto producto = null;

        Gson gson = new Gson();
        producto = new Producto("Lápiz", 2_000, 20);
        json = gson.toJson(producto);
        System.out.println(json);

        // #####################################################################
        json = """
                {
                  "nombre":"Fundas de Asientos",
                  "precio":69000,
                  "stock":5
                }
                """;
        producto = gson.fromJson(json, Producto.class);
        System.out.println(producto);
    }
}

class Producto {
    private String nombre;
    private int precio;
    private int stock;

    public Producto() {
    }

    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
