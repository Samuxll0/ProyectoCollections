package TallerCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Ejercicio 9: Inventario por Codigo.

class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre () {
        return nombre;
    }

    public double getPrecio () {
        return precio;
    }

    public int getStock () {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() { 
        return nombre + " | $" + precio + " | Stock: " + stock;
   }
}

public class Inventario {
    private HashMap<String, Producto> inventario = new HashMap<>();

    public void agregarProducto(String codigo, Producto producto) {
        inventario.put(codigo, producto);
        System.out.println("Producto agragado: " + producto);
    }

    public void actualizarStock(String codigo, int nuevoStock) {
        Producto p = inventario.get(codigo);
        if (p != null) {
            p.setStock(nuevoStock);
            System.out.println("Stock actualizado: " + p);
        } else {
            System.out.println("Producto con codigo" + codigo + "no encontrado.");
        }
    }

    public void consultarPrecio(String codigo) {
        Producto p = inventario.get(codigo);
        if (p != null) {
            System.out.println("Precio de " + p.getNombre() + ": $" + p.getPrecio());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public List<Producto> listarFaltantes() {
        List <Producto> faltantes = new ArrayList <>();
        for (Producto p : inventario.values()) {
            if (p.getStock() == 0) {
                faltantes.add(p);
            }
        }
        return faltantes;
    }

    public static void main(String[] args) {
        Inventario inv = new Inventario();

        inv.agregarProducto("A1", new Producto("Clavos", 5000, 100));
        inv.agregarProducto("B2", new Producto("Martillo", 25000.0, 0));
        inv.agregarProducto("C3", new Producto("Destornillador", 15000, 30));

        inv.consultarPrecio("B2");

        inv.actualizarStock("A1", 80);

        System.out.println("Productos faltantes: " + inv.listarFaltantes());
    }
}
