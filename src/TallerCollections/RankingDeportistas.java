package TallerCollections;
import java.util.TreeSet;

//Ejercicio 15: Ranking de deportistas.

class Deportista {
    private String apellido;
    private int puntaje;

    public Deportista(String apellido, int puntaje) {
        this.apellido = apellido;
        this.puntaje = puntaje;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPuntaje() {
        return puntaje;
    }

    @Override
    public String toString() {
        return apellido + " (" + puntaje + ")";
    }
}

public class RankingDeportistas {
    private TreeSet<Deportista> ranking = new TreeSet<>(
        (d1, d2) -> {
            int cmp = Integer.compare(d2.getPuntaje(), d1.getPuntaje()); 
            if (cmp == 0) {
                return d1.getApellido().compareToIgnoreCase(d2.getApellido()); 
            }
            return cmp;
        }
    );

    public void agregarDeportista(Deportista d) {
        ranking.add(d);
        System.out.println("Agregado: " + d);
    }

    public void mostrarTop10() {
        System.out.println("\nTop 10 deportistas:");
        ranking.stream().limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        RankingDeportistas r = new RankingDeportistas();

        r.agregarDeportista(new Deportista("Zapata", 100));
        r.agregarDeportista(new Deportista("Alvarez", 100));
        r.agregarDeportista(new Deportista("Martinez", 90));
        r.agregarDeportista(new Deportista("Gomez", 95));
        r.agregarDeportista(new Deportista("Ramirez", 90));

        r.mostrarTop10();
    }
}
