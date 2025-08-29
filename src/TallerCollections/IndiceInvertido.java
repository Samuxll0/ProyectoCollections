package TallerCollections;
import java.util.HashMap;
import java.util.TreeSet;

//Ejercicio 19: Indice invertido simple.

public class IndiceInvertido {
    private HashMap<String, TreeSet<Integer>> indice = new HashMap<>();

    public void agregar(String palabra, int pagina) {
        indice.computeIfAbsent(palabra.toLowerCase(), k -> new TreeSet<>()).add(pagina);
        System.out.println("Agregado: \"" + palabra + "\" en página " + pagina);
    }

    public TreeSet<Integer> consultar(String palabra) {
        return indice.getOrDefault(palabra.toLowerCase(), new TreeSet<>());
    }

    public void mostrarIndice() {
        System.out.println("\nÍndice invertido:");
        for (var entry : indice.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        IndiceInvertido indice = new IndiceInvertido();

        indice.agregar("Java", 5);
        indice.agregar("Colecciones", 2);
        indice.agregar("Java", 10);
        indice.agregar("HashMap", 7);
        indice.agregar("Java", 5); 
        indice.agregar("Colecciones", 12);

        indice.mostrarIndice();

        System.out.println("\nPáginas de 'Java': " + indice.consultar("Java"));
        System.out.println("Páginas de 'Python': " + indice.consultar("Python"));
    }
}
