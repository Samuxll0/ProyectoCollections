package TallerCollections;
import java.util.LinkedHashMap;
import java.util.Map;

//Ejercicio 10: Factura en orden de escaneo.

class Detalle { 
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Detalle(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public void incrementarCantidad(int extra) {
        this.cantidad += extra;
    }

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return nombre + " x" + cantidad + " @ $" + precioUnitario + " = $" + getSubtotal();
    }
}

public class Factura {
    private LinkedHashMap<String, Detalle> factura = new LinkedHashMap<>();
    private static final double IVA = 0.19;

    public void escanearProducto(String codigo, String nombre, double precio) {
        factura.merge(codigo,
            new Detalle(nombre, 1, precio),
            (existente, nuevo) -> {
                existente.incrementarCantidad(1);
                return existente;
            }
        );
    }

    public void imprimirFactura() {
        double subtotal = 0;

        System.out.println("Factura: ");
        for (Map.Entry<String, Detalle> entry : factura.entrySet()) {
            System.out.println(entry.getValue());
            subtotal += entry.getValue().getSubtotal();;
        } 

        double iva = subtotal * IVA;
        double total = subtotal + iva;

        System.out.println("--------------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (19%): $" + iva);
        System.out.println("Total: $" + total);
    }

    public static void main(String[] args) {
        Factura factura = new Factura();

        factura.escanearProducto("P01", "Pan", 2000.0);
        factura.escanearProducto("P02", "Leche", 3500.0);
        factura.escanearProducto("P01", "Pan", 2000.0); // se repite
        factura.escanearProducto("P03", "Huevos", 6000.0);
        factura.escanearProducto("P02", "Leche", 3500.0); // se repite

        factura.imprimirFactura();
    }
}
