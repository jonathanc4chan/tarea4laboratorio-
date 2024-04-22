codigo del programa 
import java.util.Scanner;

public class tarea4balanceo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        System.out.println("Programa para verificar paréntesis balanceados y manejar datos.");

        while (true) {
            System.out.println("\n1. Insertar carácter");
            System.out.println("2. Eliminar carácter");
            System.out.println("3. Verificar paréntesis balanceados");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un carácter para insertar: ");
                    char dato = scanner.nextLine().charAt(0);
                    lista.insertar(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el carácter a eliminar: ");
                    dato = scanner.nextLine().charAt(0);
                    if (lista.eliminar(dato)) {
                        System.out.println("Carácter eliminado.");
                    } else {
                        System.out.println("Carácter no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Paréntesis balanceados: " + lista.parentesisBalanceados());
                    break;
                case 4:
                    lista.mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
