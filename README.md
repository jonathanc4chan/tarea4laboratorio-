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


            package laboratoriotarea4;

class ListaEnlazada {
    Nodo cabeza;

    // Método para insertar al inicio de la lista para facilitar el proceso.
    public void insertar(char dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        mostrarBalance(); // Mostrar si está balanceado después de cada inserción
    }

    // Método para eliminar un nodo específico.
    public boolean eliminar(char dato) {
        if (cabeza == null) return false;
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            mostrarBalance(); // Mostrar si está balanceado después de cada eliminación
            return true;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == dato) {
                actual.siguiente = actual.siguiente.siguiente;
                mostrarBalance(); // Mostrar si está balanceado después de cada eliminación
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para verificar si los paréntesis están balanceados.
    public boolean parentesisBalanceados() {
        int balance = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == '(') {
                balance++;
            } else if (actual.dato == ')') {
                balance--;
            }
            if (balance < 0) {
                return false; // Más ')' que '('
            }
            actual = actual.siguiente;
        }
        return balance == 0; // True si está balanceado
    }

    // Método para mostrar la lista y si está balanceada.
    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("Contenido de la lista: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para mostrar el estado de balance de paréntesis.
    private void mostrarBalance() {
        if (parentesisBalanceados()) {
            System.out.println("Los paréntesis están balanceados.");
        } else {
            System.out.println("Los paréntesis no están balanceados.");
        }
    }
}
        }
    }
}
