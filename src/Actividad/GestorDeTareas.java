package Actividad;

public class GestorDeTareas<T> {
    private Nodo<T> cabeza;

    public GestorDeTareas() {
        cabeza = null;
    }

    public void agregarTarea(T tarea) {
        Nodo<T> nuevo = new Nodo<>(tarea);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (cabeza == null) return false;

        if (cabeza.getDato().equals(tarea)) {
            cabeza = cabeza.getNext();
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual.getNext() != null && !actual.getNext().getDato().equals(tarea)) {
            actual = actual.getNext();
        }

        if (actual.getNext() != null) {
            actual.setNext(actual.getNext().getNext());
            return true;
        }

        return false;
    }

    public boolean contieneTarea(T tarea) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(tarea)) return true;
            actual = actual.getNext();
        }
        return false;
    }

    public void imprimirTareas() {
        Nodo<T> actual = cabeza;
        if (actual == null) {
            System.out.println("No hay tareas.");
            return;
        }
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getNext();
        }
    }

    public int contarTareas() {
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getNext();
        }
        return contador;
    }

    public T obtenerTareaMasPrioritaria() {
        if (cabeza == null) return null;

        if (!(cabeza.getDato() instanceof Tarea)) {
            throw new UnsupportedOperationException("El tipo T no es Tarea");
        }

        Nodo<T> actual = cabeza;
        Tarea mayor = (Tarea) actual.getDato();
        actual = actual.getNext();

        while (actual != null) {
            Tarea t = (Tarea) actual.getDato();
            if (t.getPrioridad() < mayor.getPrioridad()) { // menor número = mayor prioridad
                mayor = t;
            }
            actual = actual.getNext();
        }

        return (T) mayor;
    }

    public void invertirTareas() {
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> next = null;
        while (actual != null) {
            next = actual.getNext();
            actual.setNext(anterior);
            anterior = actual;
            actual = next;
        }
        cabeza = anterior;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
