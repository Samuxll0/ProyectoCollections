package TallerCollections;
import java.time.LocalDate;
import java.util.*;

//Ejercicio 11. Agenda académica por fechas.

class Actividad {
    private String descripcion;

    public Actividad(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

public class AgendaAcademica {
    private TreeMap<LocalDate, List<Actividad>> agenda = new TreeMap<>();

    
    public void agregarActividad(LocalDate fecha, Actividad actividad) {
        agenda.computeIfAbsent(fecha, f -> new ArrayList<>()).add(actividad);
        System.out.println("Actividad agregada: " + actividad + " en " + fecha);
    }

    
    public Map.Entry<LocalDate, List<Actividad>> actividadProxima() {
        return agenda.ceilingEntry(LocalDate.now());
    }

    
    public SortedMap<LocalDate, List<Actividad>> reporte(LocalDate desde, LocalDate hasta) {
        return agenda.subMap(desde, true, hasta, true);
    }

    
    public void mostrarAgenda() {
        System.out.println("Agenda completa:");
        for (var entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    
    public static void main(String[] args) {
        AgendaAcademica agenda = new AgendaAcademica();

        agenda.agregarActividad(LocalDate.now().plusDays(1), new Actividad("Examen de Matemáticas"));
        agenda.agregarActividad(LocalDate.now().plusDays(3), new Actividad("Entrega de proyecto"));
        agenda.agregarActividad(LocalDate.now().plusWeeks(1), new Actividad("Exposición en clase"));
        agenda.agregarActividad(LocalDate.now().plusDays(2), new Actividad("Taller de programación"));

        agenda.mostrarAgenda();

        System.out.println("\n Actividad más próxima: " + agenda.actividadProxima());

        System.out.println("\n Reporte de la semana:");
        System.out.println(agenda.reporte(LocalDate.now(), LocalDate.now().plusDays(7)));
    }
}

