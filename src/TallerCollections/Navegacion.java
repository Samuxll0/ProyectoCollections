package TallerCollections;
import java.util.ArrayDeque;

//Ejercicio 5: Navegación "adelante/atras".

public class Navegacion {
    private ArrayDeque<String> atras = new ArrayDeque<>();
    private ArrayDeque<String> adelante = new ArrayDeque<>();
    private String actual = null;

    public void visitar(String url) {
        if (actual != null) {
            atras.push(actual);
        }
        actual = url;
        adelante.clear();
        System.out.println("Visitando: " + url);
    }
    
    public void irAtras() {
        if (!atras.isEmpty()) {
            adelante.push(actual);
            actual = atras.pop();
            System.out.println("Atras -> " + actual);
        } else {
            System.out.println("No hay página atrás.");
        }
    }

    public void irAdelante() {
        if (!adelante.isEmpty()) {
            atras.push(actual);
            actual = adelante.pop();
            System.out.println("adelante -> " + actual);
        } else {
            System.out.println("No hay página adelante.");
        }
    }

    public void mostrarEstado() {
        System.out.println("Pagina actual: " + actual);
        System.out.println("Atras: " + atras);
        System.out.println("Adelante: " + adelante);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Navegacion nav = new Navegacion();

        nav.visitar("Google");
        nav.visitar("Facebook");
        nav.visitar("YouTube");
        nav.mostrarEstado();

        nav.irAtras();
        nav.mostrarEstado();

        nav.irAtras();
        nav.mostrarEstado();

        nav.irAdelante();
        nav.mostrarEstado();

        nav.visitar("Twitter"); // visitar limpia adelante
        nav.mostrarEstado();
    }
}
