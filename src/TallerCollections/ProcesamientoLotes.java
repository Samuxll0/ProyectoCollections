package TallerCollections;
import java.util.ArrayDeque;

//Ejercicio 17: Procesamiento por lotes.

class Lote {
    private String nombre;

    public Lote(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

public class ProcesamientoLotes {
    private ArrayDeque<Lote> cola = new ArrayDeque<>();

    public void agregarNormal(Lote lote) {
        cola.addLast(lote);
        System.out.println("Lote agregado al final: " + lote);
    }

    public void agregarUrgente(Lote lote) {
        cola.addFirst(lote);
        System.out.println("Lote urgente agregado al inicio: " + lote);
    }

    public Lote procesar() {
        Lote lote = cola.pollFirst();
        System.out.println("Procesado: " + lote);
        return lote;
    }

    public void mostrarCola() {
        System.out.println("Cola actual: " + cola);
    }

    public static void main(String[] args) {
        ProcesamientoLotes sistema = new ProcesamientoLotes();

        sistema.agregarNormal(new Lote("Lote1"));
        sistema.agregarNormal(new Lote("Lote2"));
        sistema.agregarUrgente(new Lote("LoteUrgente1"));
        sistema.agregarNormal(new Lote("Lote3"));
        sistema.agregarUrgente(new Lote("LoteUrgente2"));

        sistema.mostrarCola();

        sistema.procesar();
        sistema.procesar();

        sistema.mostrarCola();
    }
}
