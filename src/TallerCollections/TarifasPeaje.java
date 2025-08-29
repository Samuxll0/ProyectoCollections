package TallerCollections;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.Map;

//Ejercicio 20: Tarifas por tramos. 

public class TarifasPeaje {
    private TreeMap<Integer, BigDecimal> tarifas = new TreeMap<>();

    public void agregarTramo(int limitePeso, BigDecimal tarifa) {
        tarifas.put(limitePeso, tarifa);
        System.out.println("Tramo agregado: <= " + limitePeso + "kg -> $" + tarifa);
    }

    public BigDecimal obtenerTarifa(int pesoVehiculo) {
        Map.Entry<Integer, BigDecimal> tramo = tarifas.floorEntry(pesoVehiculo);
        if (tramo != null) {
            return tramo.getValue();
        } else {
            return BigDecimal.ZERO; 
        }
    }

    public void mostrarTarifas() {
        System.out.println("\nTarifas definidas:");
        for (var entry : tarifas.entrySet()) {
            System.out.println("<= " + entry.getKey() + "kg -> $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        TarifasPeaje peaje = new TarifasPeaje();

        peaje.agregarTramo(1000, new BigDecimal("5000"));
        peaje.agregarTramo(2000, new BigDecimal("8000"));
        peaje.agregarTramo(3000, new BigDecimal("12000"));

        peaje.mostrarTarifas();

        int peso1 = 900;
        int peso2 = 1800;
        int peso3 = 2500;
        int peso4 = 4000;

        System.out.println("\nVehículo de " + peso1 + "kg -> Tarifa: $" + peaje.obtenerTarifa(peso1));
        System.out.println("Vehículo de " + peso2 + "kg -> Tarifa: $" + peaje.obtenerTarifa(peso2));
        System.out.println("Vehículo de " + peso3 + "kg -> Tarifa: $" + peaje.obtenerTarifa(peso3));
        System.out.println("Vehículo de " + peso4 + "kg -> Tarifa: $" + peaje.obtenerTarifa(peso4));
    }
}

