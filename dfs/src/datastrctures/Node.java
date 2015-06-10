package datastrctures;

import java.util.List;

/**
 * Clase abstracta que representa un nodo
 * @author proteco
 */
public abstract class Node {

    protected Node prev;                // Se refiere al nodo anterior (padre)

    /**
     * Obtiene el Id
     * @return Id
     */
    public abstract String getId();

    /**
     * Expande el nodo
     * @return List de nodos expadidos
     */
    public abstract List<? extends Node> expand();

    /**
     * Obtiene el nodo anterior
     * @return nodo anterior
     */
    public Node prev() {
        return prev;
    }

    /**
     * Revisa si el nodo tiene un anterior
     * @return true si el nodo tiene un anterior
     */
    public boolean hasPrev() {
        return prev != null;
    }

    /**
     * Asigna un nodo anterior a este nodo
     * @param prev el nodo a asignar
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Calcula el costo asociado al recorrido del nodo
     * actual al último en jerarquía
     * @return el costo total del recorrido
     */
    public abstract int computeCost();
}
