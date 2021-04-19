package co.com.sucursal.sucursalservice.client;

import co.com.sucursal.sucursalservice.util.Constantes;
import lombok.SneakyThrows;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CalcularDistancia {

    public static final double KILOMETRO = 1000;

    /**
     * @param origen
     * @param destino
     * @return
     */
    public static int obtenerDistancia(String origen, String destino) {
        ResponseEntity<String> response = getStringResponseEntity(origen, destino);
        JsonNode root = getJsonNode(response);
        return getRoot(root);
    }

    /**
     * @param origen
     * @param destino
     * @return
     */
    public static ResponseEntity<String> getStringResponseEntity(String origen, String destino) {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "AIzaSyBFRWejmKEEigEEzISmq0mOPgQKT6HNCpY";
        String resourceUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins=" + origen + "&destinations=" + destino + "&key=" + apiKey;
        return restTemplate.getForEntity(resourceUrl, String.class);
    }

    /**
     * @param response
     * @return
     */
    @SneakyThrows
    private static JsonNode getJsonNode(ResponseEntity<String> response) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.getBody());
    }

    /**
     * @param root
     * @return
     */
    private static int getRoot(JsonNode root) {
        List<Double> listaDistancia = new ArrayList<>();
        for (JsonNode jsonNode : root.path(Constantes.ROWS).get(0).path(Constantes.ELEMENTS)) {
            JsonNode valor = jsonNode.path(Constantes.DISTANCE).get(Constantes.VALUE);
            listaDistancia.add(valor.asDouble() / KILOMETRO);
        }
        StringBuilder strNum = new StringBuilder();
        return convertToInt(listaDistancia, strNum);
    }

    /**
     * @param doubles
     * @param strNum
     * @param numInt
     */
    private static void convertToDouble(List<Double> doubles, StringBuilder strNum, int[] numInt) {
        for (int i = 0; i < doubles.size(); i++) {
            numInt[i] = doubles.get(i).intValue();
        }
        strNum.append(Arrays.stream(numInt).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    /**
     * @param doubles
     * @param strNum
     * @return
     */
    private static int convertToInt(List<Double> doubles, StringBuilder strNum) {
        int[] numInt = new int[doubles.size()];
        convertToDouble(doubles, strNum, numInt);
        return Integer.parseInt(strNum.toString());
    }


}
