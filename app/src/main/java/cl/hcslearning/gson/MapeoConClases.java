package cl.hcslearning.gson;

import com.google.gson.Gson;

/**
 * Ejemplo de uso de Gson con clases Java (mapeo).
 * Serializa un objeto Producto a JSON y luego lo deserializa de nuevo a un objeto.
 */
public class MapeoConClases {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Crear un objeto Producto y convertirlo a JSON
        Producto producto = new Producto("Lápiz", 2000, 20);
        String jsonString = gson.toJson(producto);
        System.out.println("Objeto Producto serializado a JSON:");
        System.out.println(jsonString);

        imprimirSeparador();

        // Cadena JSON que será convertida a objeto Producto
        jsonString = """
                {
                  "nombre": "Fundas de Asientos",
                  "precio": 69000,
                  "stock": 5
                }
                """;

        // Convertir JSON a objeto Producto
        producto = gson.fromJson(jsonString, Producto.class);
        System.out.println("JSON deserializado a objeto Producto:");
        System.out.println(producto);
    }

    private static void imprimirSeparador() {
        System.out.println("-".repeat(50));
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
