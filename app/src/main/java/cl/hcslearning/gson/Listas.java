package cl.hcslearning.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Listas {

    public static void main(String[] args) {
        final String JSON_DOC = "[{\"ventaId\": 100, \"cliente\": \"Juan\", \"monto\": 100000}, {\"ventaId\": 101, \"cliente\": \"Raúl\", \"monto\": 80000}]";

        JsonElement jsonElement = JsonParser.parseString(JSON_DOC);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        // Conseguir de manera individual por índice
        //String cliente = jsonArray.get(1).getAsJsonObject().getAsJsonPrimitive("cliente").getAsString();
        // Iterar sobre el arreglo
        for (JsonElement e : jsonArray) {
            JsonObject obj = e.getAsJsonObject();
            String cliente = obj.getAsJsonPrimitive("cliente").getAsString();
            int monto = obj.getAsJsonPrimitive("monto").getAsInt();
            System.out.println(cliente);
            System.out.println(monto);
            separador("-");
        }

        separador("#");

        // modifica si ya existe
        jsonArray.get(0).getAsJsonObject().addProperty("cliente", "Juan Pérez");
        // agrega si no existe
        jsonArray.get(1).getAsJsonObject().addProperty("costoEnvio", 3990);
        String jsonFinal = jsonArray.toString();
        System.out.println(jsonFinal);
    }

    private static void separador(String s) {
        System.out.println(s.repeat(10));
    }
}
