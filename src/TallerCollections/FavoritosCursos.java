package TallerCollections;
import java.util.LinkedHashSet;

//Ejercicio 7: Favoritos en plataforma de Cursos.

class Curso {
    private String nombre;

    public Curso (String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Curso)) return false;
        Curso c = (Curso) obj;
        return this.nombre.equalsIgnoreCase(c.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }
}

public class FavoritosCursos {
    private LinkedHashSet<Curso> favoritos = new LinkedHashSet<>();

    public void marcarFavorito(Curso c) {
        if (favoritos.add(c)) {
            System.out.println("Curso agregado a favoritos: " + c);
        } else {
            System.out.println("Curso ya estaba en favoritos: " + c);
        }
    }

    public void eliminarFavorito(Curso c) {
        if (favoritos.remove(c)) {
            System.out.println("Curso eliminado: " + c);
        } else {
            System.out.println("Curso no estaba en favoritos: " + c);
        }
    }

    public void mostrarFavoritos() {
        System.out.println("Favoritos: " + favoritos);
    }

    public static void main(String[] args) {
        FavoritosCursos favs = new FavoritosCursos();

        favs.marcarFavorito(new Curso("Java"));
        favs.marcarFavorito(new Curso("Python"));
        favs.marcarFavorito(new Curso("C++"));
        favs.marcarFavorito(new Curso("Java")); // duplicado

        favs.mostrarFavoritos();

        favs.eliminarFavorito(new Curso("Python"));
        favs.marcarFavorito(new Curso("Go"));

        favs.mostrarFavoritos();
    }
    
}
