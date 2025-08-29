package TallerCollections;
import java.util.Stack;

//Ejercicio 3: Deshacer edición de imagenes.

class Operacion {
    private String nombre;

    public Operacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

public class DeshacerEdicion {
    private Stack<Operacion> historial = new Stack<>();

    public void aplicarOperacion(Operacion op) {
        historial.push(op);
        System.out.println("Aplicada: " + op);
    }

    public void deshacer() {
        if (!historial.isEmpty()) {
            Operacion op = historial.pop();
            System.out.println("Deshecha: " + op);
        } else {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("Historial actual: " + historial);
    }

    public static void main(String[] args) {
        DeshacerEdicion editor = new DeshacerEdicion();

        // Aplicar operaciones
        editor.aplicarOperacion(new Operacion("Rotar"));
        editor.aplicarOperacion(new Operacion("Recortar"));
        editor.aplicarOperacion(new Operacion("Brillo"));
        editor.aplicarOperacion(new Operacion("Contraste"));
        editor.aplicarOperacion(new Operacion("Saturación"));

        editor.mostrarHistorial();

        // Deshacer 3 veces
        editor.deshacer();
        editor.deshacer();
        editor.deshacer();

        editor.mostrarHistorial();
    }
}
