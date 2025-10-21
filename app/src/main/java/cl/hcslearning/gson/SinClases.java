package cl.hcslearning.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class SinClases {

    public static void main(String[] args) {
        // JSON de prueba: lista de ventas con cliente y monto
        final String JSON_DOC = "[{\"ventaId\": 100, \"cliente\": \"Juan\", \"monto\": 100000}, {\"ventaId\": 101, \"cliente\": \"Raúl\", \"monto\": 80000}]";

        // Parsear string JSON a JsonArray
        JsonElement jsonElement = JsonParser.parseString(JSON_DOC);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        // Imprimir ventas iniciales
        imprimirVentas(jsonArray);

        imprimirSeparador("#");

        // Modificar cliente del primer registro (porque llave cliente ya existe)
        jsonArray.get(0).getAsJsonObject().addProperty("cliente", "Juan Pérez");

        // Agregar nueva propiedad al segundo registro
        jsonArray.get(1).getAsJsonObject().addProperty("costoEnvio", 3990);

        // Mostrar JSON final con formato
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // o sin formato
        //Gson gson = new Gson();
        System.out.println("JSON final modificado:");
        System.out.println(gson.toJson(jsonArray));
    }

    // Método para imprimir las ventas
    private static void imprimirVentas(JsonArray ventas) {
        for (JsonElement elementoVenta : ventas) {
            JsonObject venta = elementoVenta.getAsJsonObject();
            String cliente = venta.get("cliente").getAsString();
            int monto = venta.get("monto").getAsInt();
            System.out.println("Cliente: " + cliente);
            System.out.println("Monto: $" + monto);
            imprimirSeparador("-");
        }
    }

    // Método utilitario para imprimir separadores
    private static void imprimirSeparador(String s) {
        System.out.println(s.repeat(10));
    }
}
