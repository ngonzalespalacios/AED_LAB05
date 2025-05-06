package Actividad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        List<Tarea> tareasCompletadas = new ArrayList<>();

        // 1. Agregar tareas
        gestor.agregarTarea(new Tarea("Estudiar para el examen", 1));
        gestor.agregarTarea(new Tarea("Hacer la compra", 2));
        gestor.agregarTarea(new Tarea("Limpiar la casa", 3));
        gestor.agregarTarea(new Tarea("Lavar ropagi", 2));

        // 2. Eliminar una tarea
        Tarea tareaAEliminar = new Tarea("Hacer la compra", 2);
        if (gestor.eliminarTarea(tareaAEliminar)) {
            System.out.println("Tarea eliminada: " + tareaAEliminar);
        } else {
            System.out.println("No se encontró la tarea: " + tareaAEliminar);
        }

        // 3. Imprimir tareas actuales
        System.out.println("\nTareas actuales:");
        gestor.imprimirTareas();

        // 4. Verificar si existe una tarea
        Tarea buscar = new Tarea("Limpiar la casa", 3);
        System.out.println("\n¿Contiene 'Limpiar la casa'? " + gestor.contieneTarea(buscar));

        // 5. Invertir la lista
        gestor.invertirTareas();
        System.out.println("\nTareas invertidas:");
        gestor.imprimirTareas();

        // 6. Obtener tarea de mayor prioridad
        Tarea masPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("\nTarea de mayor prioridad: " + masPrioritaria);

        // 7. Transferir una tarea a completadas
        Tarea tareaCompleta = new Tarea("Estudiar para el examen", 1);
        if (gestor.eliminarTarea(tareaCompleta)) {
            tareasCompletadas.add(tareaCompleta);
            System.out.println("\nTarea completada y transferida: " + tareaCompleta);
        }

        // 8. Mostrar ambas listas
        System.out.println("\nTareas pendientes:");
        gestor.imprimirTareas();

        System.out.println("\nTareas completadas:");
        for (Tarea t : tareasCompletadas) {
            System.out.println(t);
        }
    }
}
