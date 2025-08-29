package TallerCollections;

import java.util.Scanner;

public class MainTaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== TALLER COLLECTIONS JAVA =====");
            System.out.println("1. Catálogo de libros");
            System.out.println("2. Turnos de laboratorio");
            System.out.println("3. Deshacer edición de imágenes");
            System.out.println("4. Soporte técnico");
            System.out.println("5. Navegación adelante/atrás");
            System.out.println("6. Control de acceso por huella");
            System.out.println("7. Favoritos en plataforma de cursos");
            System.out.println("8. Agenda de reuniones ordenada");
            System.out.println("9. Inventario por código");
            System.out.println("10. Factura en orden de escaneo");
            System.out.println("11. Agenda académica por fecha");
            System.out.println("12. Conteo concurrente simple");
            System.out.println("13. Caché LRU mini");
            System.out.println("14. Depuración de correos");
            System.out.println("15. Ranking de deportistas");
            System.out.println("16. Planificador de impresiones");
            System.out.println("17. Procesamiento por lotes");
            System.out.println("18. Lista de reproducción editable");
            System.out.println("19. Índice invertido simple");
            System.out.println("20. Tarifas por tramos");
            System.out.println("0. Salir");
            System.out.print("Seleccione un ejercicio: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> CatalogoLibros.main(new String[]{});
                case 2 -> TurnosLaboratorio.main(new String[]{});
                case 3 -> DeshacerEdicion.main(new String[]{});
                case 4 -> SoporteTecnico.main(new String[]{});
                case 5 -> Navegacion.main(new String[]{});
                case 6 -> ControlAcceso.main(new String[]{});
                case 7 -> FavoritosCursos.main(new String[]{});
                case 8 -> AgendaReuniones.main(new String[]{});
                case 9 -> Inventario.main(new String[]{});
                case 10 -> Factura.main(new String[]{});
                case 11 -> AgendaAcademica.main(new String[]{});
                case 12 -> ConteoConcurrente.main(new String[]{});
                case 13 -> CacheLRU.main(new String[]{});
                case 14 -> DepuracionCorreos.main(new String[]{});
                case 15 -> RankingDeportistas.main(new String[]{});
                case 16 -> PlanificadorImpresiones.main(new String[]{});
                case 17 -> ProcesamientoLotes.main(new String[]{});
                case 18 -> ListaReproduccion.main(new String[]{});
                case 19 -> IndiceInvertido.main(new String[]{});
                case 20 -> TarifasPeaje.main(new String[]{});
                case 0 -> System.out.println("Saliendo del taller...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

