package cl.hcslearning.gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AppAvanzado {
    public static void main(String[] args) {
        JsonObject jsonObject = JsonParser.parseString(jsonText).getAsJsonObject();

        jsonObject.addProperty("costoEnvio", 5_000);

        jsonObject.getAsJsonObject("direccion").addProperty("codigoPostal", "9110111");

        String jsonFinal = jsonObject.toString();
        System.out.println(jsonFinal);
    }

    private static String jsonText = """
            {
              "id": "ecc87bf5-6c5f-4ae6-973c-7ff30051becf",
              "fecha": "2025-09-04T01:08:50.16436",
              "cliente": {
                "nombre": "Ignacio",
                "apellido": "Contreras",
                "rut": "17.385.015-8"
              },
              "direccion": {
                "calle": "Apoquindo",
                "numero": "9469",
                "comuna": "Providencia",
                "ciudad": "Región Metropolitana"
              },
              "items": [
                {
                  "producto": "Smartphone de Alta Gama",
                  "cantidad": 1,
                  "precioUnitario": 757141
                },
                {
                  "producto": "Consola de Videojuegos PS5/Xbox",
                  "cantidad": 2,
                  "precioUnitario": 635646
                }
              ],
              "montoTotal": 2028433,
              "comisionMarketplace": 202843.3
            }
            """;
}
