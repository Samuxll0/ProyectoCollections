package TallerCollections;
import java.util.*;

//Ejercicio 1: Catálogo de libros con filtros.


class Libro {
    String titulo;
    String autor;
    int año;
    String isbn;

    public Libro (String titulo, String autor, int año, String isbn) {
        
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return titulo + "(" + autor + ", " + año + ", ISBN:" + isbn + ")";
    }
}

public class CatalogoLibros {
    private List<Libro> catalogo = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public void eliminarPorISBN(String isbn) {
        catalogo.removeIf(l -> l.isbn.equals(isbn));
    }

    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogo) {
            if (l.autor.equalsIgnoreCase(autor)) {
                resultado.add(l);
            }
        }
        return resultado;
    } 

    public List<Libro> listarPorAñoAscendente() {
        List<Libro> copia = new ArrayList<>(catalogo);
        copia.sort(Comparator.comparingInt(l -> l.año));
        return copia;
    }

    public List<Libro> obtenerCincoMasRecientes() {
        List<Libro> copia = new ArrayList<>(catalogo);
        copia.sort((l1, l2) -> Integer.compare(l2.año, l1.año));
        return copia.subList(0, Math.min(5, copia.size()));
    }

    public static void main(String[] args) {
        CatalogoLibros catalogo = new CatalogoLibros();

        catalogo.agregarLibro(new Libro("Cien años de soledad", "García Márquez", 1967, "123"));
        catalogo.agregarLibro(new Libro("El amor en los tiempos del cólera", "García Márquez", 1985, "456"));
        catalogo.agregarLibro(new Libro("Don Quijote", "Cervantes", 1605, "789"));
        catalogo.agregarLibro(new Libro("La ciudad y los perros", "Vargas Llosa", 1963, "321"));
        catalogo.agregarLibro(new Libro("Rayuela", "Cortázar", 1963, "654"));
        catalogo.agregarLibro(new Libro("1984", "Orwell", 1949, "987"));

        System.out.println(" Buscar por autor García Márquez:");
        System.out.println(catalogo.buscarPorAutor("García Márquez"));

        System.out.println("\n Libros ordenados por año:");
        System.out.println(catalogo.listarPorAñoAscendente());

        System.out.println("\n Los 5 más recientes:");
        System.out.println(catalogo.obtenerCincoMasRecientes());

        catalogo.eliminarPorISBN("123");
        System.out.println("\n Después de eliminar ISBN 123:");
        System.out.println(catalogo.listarPorAñoAscendente());
    }
}
