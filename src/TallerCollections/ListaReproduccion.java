package TallerCollections;
import java.util.LinkedList;
import java.util.ListIterator;

//Ejercicio 18: Lista de reproduccion editable. 

class Cancion {
    private String titulo;

    public Cancion(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }
}

public class ListaReproduccion {
    private LinkedList<Cancion> lista = new LinkedList<>();
    private ListIterator<Cancion> cursor = lista.listIterator();

    public void agregarCancion(Cancion c) {
        lista.add(c);
        cursor = lista.listIterator(); 
        System.out.println("Agregada: " + c);
    }

    public Cancion siguiente() {
        if (cursor.hasNext()) {
            Cancion c = cursor.next();
            System.out.println("Reproduciendo: " + c);
            return c;
        } else {
            System.out.println("No hay más canciones adelante.");
            return null;
        }
    }

    public Cancion anterior() {
        if (cursor.hasPrevious()) {
            Cancion c = cursor.previous();
            System.out.println("Reproduciendo: " + c);
            return c;
        } else {
            System.out.println("No hay más canciones atrás.");
            return null;
        }
    }

    public void moverCancion(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= lista.size() || toIndex < 0 || toIndex >= lista.size()) {
            System.out.println("Índices fuera de rango.");
            return;
        }
        Cancion c = lista.remove(fromIndex);
        lista.add(toIndex, c);
        cursor = lista.listIterator(); 
        System.out.println("Movida: " + c + " a la posición " + toIndex);
    }

    public void mostrarLista() {
        System.out.println("Lista: " + lista);
    }

    public static void main(String[] args) {
        ListaReproduccion playlist = new ListaReproduccion();

        playlist.agregarCancion(new Cancion("Song A"));
        playlist.agregarCancion(new Cancion("Song B"));
        playlist.agregarCancion(new Cancion("Song C"));
        playlist.agregarCancion(new Cancion("Song D"));

        playlist.mostrarLista();

        playlist.siguiente();
        playlist.siguiente();
        playlist.anterior();

        playlist.moverCancion(3, 1); 
        playlist.mostrarLista();
    }
}

