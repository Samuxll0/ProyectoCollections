package TallerCollections;
import java.util.LinkedList;

//Ejercicio 2: Turnos de Laboratorio.

public class TurnosLaboratorio {
    private LinkedList<String> cola = new LinkedList<>();

    public void agregarTurno(String estudiante, boolean preferencial) {
        if (preferencial) {
            cola.addFirst(estudiante);
        } else {
            cola.addLast(estudiante);
        }
    }

    public String atender() {
        return cola.poll();
    }

    public void mostrarCola() {
        System.out.println("Cola actuales: " + cola);
    }

    public static void main(String[] args) {
        TurnosLaboratorio lab = new TurnosLaboratorio();

        lab.agregarTurno("Ana", false);       // turno normal
        lab.agregarTurno("Luis", true);       // turno preferencial
        lab.agregarTurno("Marta", false);     // turno normal
        lab.agregarTurno("Pedro", true);      // turno preferencial

        lab.mostrarCola();

        System.out.println("Atendido: " + lab.atender());
        lab.mostrarCola();

        System.out.println("Atendido: " + lab.atender());
        lab.mostrarCola();
    }


}
