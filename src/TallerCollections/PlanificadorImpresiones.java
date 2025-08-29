package TallerCollections;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

//Ejercicio 16: Planificador de impresiones.

class Trabajo {
    private String nombre;
    private int tamano; 
    private LocalDateTime fecha;

    public Trabajo(String nombre, int tamano, LocalDateTime fecha) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.fecha = fecha;
    }

    public int getTamano() {
        return tamano;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return nombre + " (" + tamano + " páginas, " + fecha + ")";
    }
}

public class PlanificadorImpresiones {
    private PriorityQueue<Trabajo> cola = new PriorityQueue<>(
        (t1, t2) -> {
            int cmp = Integer.compare(t1.getTamano(), t2.getTamano()); 
            if (cmp == 0) {
                return t1.getFecha().compareTo(t2.getFecha()); 
            }
            return cmp;
        }
    );

    public void agregarTrabajo(Trabajo t) {
        cola.add(t);
        System.out.println("Trabajo agregado: " + t);
    }

    public Trabajo imprimirSiguiente() {
        return cola.poll();
    }

    public void mostrarCola() {
        System.out.println("\nCola de impresión: " + cola);
    }

    public static void main(String[] args) {
        PlanificadorImpresiones plan = new PlanificadorImpresiones();

        plan.agregarTrabajo(new Trabajo("Doc1", 10, LocalDateTime.now().minusMinutes(30)));
        plan.agregarTrabajo(new Trabajo("Doc2", 5, LocalDateTime.now().minusMinutes(20)));
        plan.agregarTrabajo(new Trabajo("Doc3", 5, LocalDateTime.now().minusMinutes(10)));
        plan.agregarTrabajo(new Trabajo("Doc4", 20, LocalDateTime.now()));

        plan.mostrarCola();

        System.out.println("Imprimiendo: " + plan.imprimirSiguiente());
        System.out.println("Imprimiendo: " + plan.imprimirSiguiente());

        plan.mostrarCola();
    }
}

