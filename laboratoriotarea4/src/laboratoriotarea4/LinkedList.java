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