package Ejercicio;

public class GestorDeLista<T> {
    private Nodo<T> head;

    public GestorDeLista() {
        this.head = null;
    }

    public Nodo <T> getHead(){
        return head;
    }

    // Insertar un nodo al final
    public void insertarAlFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (head == null) {
            head = nuevo;
            return;
        }
        Nodo<T> actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
        actual.setNext(nuevo);
    }

    // Buscar un elemento
    public boolean buscarElemento(T valor) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    // Contar los nodos
    public int contarNodos() {
        int contador = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.getNext();
        }
        return contador;
    }

    // Invertir la lista
    public void invertirLista() {
        Nodo<T> anterior = null;
        Nodo<T> actual = head;
        while (actual != null) {
            Nodo<T> siguiente = actual.getNext();
            actual.setNext(anterior);
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    // Comparar con otra lista
    public boolean sonIguales(GestorDeLista<T> otraLista) {
        Nodo<T> actual1 = this.head;
        Nodo<T> actual2 = otraLista.getHead();

        while (actual1 != null && actual2 != null) {
            if (!actual1.getDato().equals(actual2.getDato())) {
                return false;
            }
            actual1 = actual1.getNext();
            actual2 = actual2.getNext();
        }
        return actual1 == null && actual2 == null;
    }

    // Concatenar con otra lista
    public void concatenarListas(GestorDeLista<T> otraLista) {
        if (this.head == null) {
            this.head = otraLista.getHead();
            return;
        }
        Nodo<T> actual = this.head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
        actual.setNext(otraLista.getHead());
    }

    // Imprimir la lista
    public void imprimirLista() {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }
}
