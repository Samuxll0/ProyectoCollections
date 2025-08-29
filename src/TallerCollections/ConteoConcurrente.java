package TallerCollections;
import java.util.Hashtable;

//Ejercicio 12: Conteo concurrente simple.

public class ConteoConcurrente {
    private Hashtable<String, Integer> accesos = new Hashtable<>();

    public void registrarAcceso(String usuario) {
        accesos.put(usuario, accesos.getOrDefault(usuario, 0) + 1);
        System.out.println("Acceso registrado: " + usuario);
    }

    public void mostrarAccesos() {
        System.out.println("Accesos: " + accesos);
    }

    public void top3Usuarios() {
        System.out.println("\nTop 3 usuarios con más accesos:");
        accesos.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(3)
            .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() + " accesos"));
    }

    public static void main(String[] args) {
        ConteoConcurrente registro = new ConteoConcurrente();

        registro.registrarAcceso("Ana");
        registro.registrarAcceso("Luis");
        registro.registrarAcceso("Ana");
        registro.registrarAcceso("Marta");
        registro.registrarAcceso("Luis");
        registro.registrarAcceso("Ana");
        registro.registrarAcceso("Pedro");
        registro.registrarAcceso("Luis");

        registro.mostrarAccesos();
        registro.top3Usuarios();
    }
}
