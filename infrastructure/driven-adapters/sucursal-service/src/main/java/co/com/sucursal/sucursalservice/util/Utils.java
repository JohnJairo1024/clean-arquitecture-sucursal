package co.com.sucursal.sucursalservice.util;


import feign.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

public final class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * @param fecha
     * @return
     */
    public static String convertirDateToString(Date fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
        String reportDate = formatter.format(fecha);
        return reportDate;
    }

    /**
     * @param fecha
     * @return
     */
    public static Date agregarDosHorasAFecha(Calendar fecha) {
        fecha = Calendar.getInstance();
        fecha.add(Calendar.MINUTE, 120);
        Date date = fecha.getTime();
        return date;
    }

    /**
     * @param resp
     * @param headerName
     * @return
     */
    public static String getHeaderValue(Response resp, String headerName) {
        Map<String, Collection<String>> headers = resp.headers();
        Collection<String> values = headers.get(headerName);
        String value = null;
        if (values != null && values.isEmpty() == false) {
            String[] array = new String[values.size()];
            values.toArray(array);
            value = array[0];
        }
        return value;
    }

    /**
     * @param message
     * @return
     */
    @SuppressWarnings("java:S3776")
    public static List<String> getValueString(String message) {
        List<Character> stack = new ArrayList<>();
        List<String> jsons = new ArrayList<>();
        String temp = "";
        for (char eachChar : message.toCharArray()) {
            if (stack.isEmpty() && eachChar == '{') {
                stack.add(eachChar);
                temp += eachChar;
            } else if (!stack.isEmpty()) {
                temp += eachChar;
                if (stack.get(stack.size() - 1).equals('{') && eachChar == '}') {
                    stack.remove(stack.size() - 1);
                    if (stack.isEmpty()) {
                        jsons.add(temp);
                        temp = "";
                    }
                } else if (eachChar == '{' || eachChar == '}')
                    stack.add(eachChar);
            } else if (temp.length() > 0 && stack.isEmpty()) {
                jsons.add(temp);
                temp = "";
            }
        }
        return jsons;
    }

    /**
     * @param json
     * @return
     */
    public static String convertJson(String json) {
        String messageReplace = json.replaceAll("\\\\", "");
        JSONObject jsonObject = new JSONObject(messageReplace);
        logger.debug("CONSULTA OBJECT JSON: {}", json);
        JSONArray jsonarr = jsonObject.getJSONArray("messages");
        logger.debug("CONSULTA OBJECT MESSAGE ARRAY: {}", jsonarr);
        String message = jsonarr.getJSONObject(0).getString("message");
        logger.debug("CONSULTA MESSAGE: {}", message);
        return message;
    }

}
