package Actividad;

public class Nodo <T>{
    private T dato;
    private Nodo<T> next;

    public Nodo(T dato){
        this.dato=dato;
        this.next=null;
    }


}
