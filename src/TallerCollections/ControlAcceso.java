package TallerCollections;
import java.util.HashSet;

//Ejercicio 6: Control de Acceso con Huellas.

public class ControlAcceso {
    private HashSet<String> huellas = new HashSet<>();

    public boolean registrarHuella(String id) {
        boolean agregado = huellas.add(id);
        if (agregado) {
            System.out.println("Huella registrada: " + id);
        } else {
            System.out.println("Huella duplicada, no se registro: " + id);
        }
        return agregado;
    }

    public void mostrarHuellas() {
        System.out.println("Huellas registradas: " + huellas);
        System.out.println("Total: " + huellas.size());
    }

     public static void main(String[] args) {
        ControlAcceso acceso = new ControlAcceso();

        acceso.registrarHuella("H001");
        acceso.registrarHuella("H002");
        acceso.registrarHuella("H001"); // duplicada
        acceso.registrarHuella("H003");
        acceso.registrarHuella("H002"); // duplicada

        acceso.mostrarHuellas();
    }
}
