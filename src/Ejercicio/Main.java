package Ejercicio;
public class Main {
    public static void main(String[] args) {
        GestorDeLista<Integer> lista1 = new GestorDeLista<>();
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(2);
        lista1.insertarAlFinal(3);

        System.out.println("Lista 1:");
        lista1.imprimirLista();

        System.out.println("¿Contiene el 2?: " + lista1.buscarElemento(2));
        System.out.println("Número de nodos: " + lista1.contarNodos());

        lista1.invertirLista();
        System.out.println("Lista invertida:");
        lista1.imprimirLista();

        GestorDeLista<Integer> lista2 = new GestorDeLista<>();
        lista2.insertarAlFinal(3);
        lista2.insertarAlFinal(2);
        lista2.insertarAlFinal(1);

        System.out.println("¿Lista1 es igual a Lista2?: " + lista1.sonIguales(lista2));

        lista1.concatenarListas(lista2);
        System.out.println("Lista1 después de concatenar con Lista2:");
        lista1.imprimirLista();
    }
}
