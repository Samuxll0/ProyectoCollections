package TallerCollections;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

//Ejercicio 4: Soporte técnico por severidad.

class Ticket {
    private String descripcion;
    private String severidad;
    private LocalDateTime fechaCreacion;

    public Ticket(String descripcion, String severidad, LocalDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.severidad = severidad.toUpperCase();
        this.fechaCreacion = fechaCreacion;
    }

    public int getPrioridad() {
        return switch (severidad) {
            case "CRITICA" -> 4;
            case "ALTA" -> 3;
            case "MEDIA" -> 2;  
            case "BAJA" -> 1;
            default -> 0;
        };
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return "[" + severidad + "] " + descripcion + " ( " + fechaCreacion + ")";   
    }
}

public class SoporteTecnico {
    private PriorityQueue<Ticket> cola = new PriorityQueue<>(
        (t1, t2) -> {
            int prioridad = Integer.compare(t2.getPrioridad(), t1.getPrioridad());
            if (prioridad != 0) return prioridad;
            return t1.getFechaCreacion().compareTo(t2.getFechaCreacion());
        }
    );

    public void agregarTicket(Ticket t) {
        cola.add(t);
    }

    public Ticket atenderTicket() {
        return cola.poll();
    }

    public void mostrarCola() {
        System.out.println("\n Cola de soporte: " + cola);
    }

    public static void main(String[] args) {
        SoporteTecnico soporte = new SoporteTecnico();

        soporte.agregarTicket(new Ticket("Servidor caído", "CRITICA", LocalDateTime.now().minusHours(3)));
        soporte.agregarTicket(new Ticket("Error en login", "ALTA", LocalDateTime.now().minusHours(2)));
        soporte.agregarTicket(new Ticket("Consulta de usuario", "BAJA", LocalDateTime.now().minusHours(1)));
        soporte.agregarTicket(new Ticket("Error en base de datos", "CRITICA", LocalDateTime.now().minusHours(5)));

        soporte.mostrarCola();

        System.out.println("Atendido: " + soporte.atenderTicket());
        System.out.println("Atendido: " + soporte.atenderTicket());

        soporte.mostrarCola();
    }
}
