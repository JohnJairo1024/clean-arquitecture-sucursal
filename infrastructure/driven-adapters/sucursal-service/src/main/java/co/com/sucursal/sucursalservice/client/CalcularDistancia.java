package co.com.sucursal.sucursalservice.client;

import co.com.sucursal.model.sucursal.SucursalCercana;
import co.com.sucursal.sucursalservice.entity.SucursalEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CalcularDistancia {

    /**
     * @param lat1
     * @param lon1
     * @param list
     * @return
     */
    public static SucursalCercana calcularDistancia(double lat1, double lon1, List<SucursalEntity> list) {
        Map<Integer, Double> distanceAll = new HashMap();
        SucursalCercana sucursalCercana = new SucursalCercana();
        getDistancia(lat1, lon1, list, distanceAll, sucursalCercana);
        return sucursalCercana;
    }

    /**
     * @param lat1
     * @param lon1
     * @param list
     * @param distanceAll
     * @param sucursalCercana
     */
    private static void getDistancia(double lat1, double lon1, List<SucursalEntity> list, Map<Integer, Double> distanceAll, SucursalCercana sucursalCercana) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "--" + list.get(i).getDireccion() + "--" + list.get(i).getLatitud()
                    + "--" + list.get(i).getLongitud());
            distanceAll.put(i, distancia(lat1, lon1, list.get(i).getLatitud(), list.get(i).getLongitud(), "K"));
        }
        Map<Integer, Double> sortedByCount = distanceAll.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        getSucursalCercana(list, sucursalCercana, sortedByCount);
    }

    /**
     * @param list
     * @param sucursalCercana
     * @param sortedByCount
     */
    private static void getSucursalCercana(List<SucursalEntity> list, SucursalCercana sucursalCercana, Map<Integer, Double> sortedByCount) {
        for (Map.Entry<Integer, Double> entry : sortedByCount.entrySet()) {
            sucursalCercana.setInfoSucursal("La sucursal mas cercana es :" + list.get(entry.getKey()).getDireccion());
            sucursalCercana.setDistancia(sortedByCount.get(entry.getKey()));
            break;
        }
    }

    /**
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @param unit
     * @return
     */
    private static double distancia(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

}
