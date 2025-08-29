package TallerCollections;
import java.util.HashSet;
import java.util.Iterator;

//Ejerecicio 14: Depuración de correos.

public class DepuracionCorreos {
    public static void main(String[] args) {
        
        HashSet<String> correos = new HashSet<>();
        correos.add("ana@gmail.com");
        correos.add("luis@empresa.com");
        correos.add("marta@spam.com");
        correos.add("pedro@hotmail.com");
        correos.add("soporte@spam.com");

        System.out.println("Correos iniciales: " + correos);
        System.out.println("Cantidad inicial: " + correos.size());

        String dominioVetado = "spam.com";

        Iterator<String> it = correos.iterator();
        while (it.hasNext()) {
            String correo = it.next();
            if (correo.endsWith("@" + dominioVetado)) {
                System.out.println("Eliminando: " + correo);
                it.remove(); 
            }
        }

        System.out.println("\n Correos depurados: " + correos);
        System.out.println("Cantidad final: " + correos.size());
    }
}

