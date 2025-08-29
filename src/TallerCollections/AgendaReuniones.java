package TallerCollections;
import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.TreeSet;

//Ejercicio 8: Agenda de reuniones ordenada.

class Reunion implements Comparable<Reunion> {
    private LocalDateTime fechaHora;
    private String asunto;

    public Reunion(LocalDateTime fechaHora, String asunto) {
        this.fechaHora = fechaHora;
        this.asunto = asunto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public int compareTo(Reunion o) {
        return this.fechaHora.compareTo(o.fechaHora);
    }

    @Override
    public String toString() {
        return asunto + " (" + fechaHora + ")";
    }
}

public class AgendaReuniones {
    private TreeSet<Reunion> reuniones = new TreeSet<>();

    public void agendar(Reunion r) {
        reuniones.add(r);
    }

    public void mostrarReuniones() {
        System.out.println("Reuniones: " + reuniones);
    }

    public Reunion primeraReunion() {
        return reuniones.first();
    }

    public Reunion ultimaReunion() {
        return reuniones.last();
    }

    public NavigableSet<Reunion> reunionesEntre(LocalDateTime desde, LocalDateTime hasta) {
        return reuniones.subSet(new Reunion(desde, "Inicio"), true, new Reunion(hasta, "Fin"), true);
    }

    public static void main(String[] args) {
        AgendaReuniones agenda = new AgendaReuniones();

        agenda.agendar(new Reunion(LocalDateTime.now().plusDays(1), "Planificación sprint"));
        agenda.agendar(new Reunion(LocalDateTime.now().plusDays(5), "Revisión de proyecto"));
        agenda.agendar(new Reunion(LocalDateTime.now().plusHours(2), "Reunión urgente"));
        agenda.agendar(new Reunion(LocalDateTime.now().plusDays(10), "Presentación al cliente"));

        agenda.mostrarReuniones();

        System.out.println("Primera reunión: " + agenda.primeraReunion());
        System.out.println("Última reunión: " + agenda.ultimaReunion());

        System.out.println("Reuniones entre hoy y 7 días: " +
            agenda.reunionesEntre(LocalDateTime.now(), LocalDateTime.now().plusDays(7)));
    }
}
