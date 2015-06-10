package datastrctures;

import java.util.List;

/**
 *  Clase abstracta que representa un nodo en un grafo
 */
public abstract class GraphNode extends Node {

    protected Graph graph;     // grafo al que pertenece este GraphNode

    /**
     * Genera una lista de GraphNodes hijos a partir del HashMap
     * asociado a este GraphNode
     * @return
     */
//    public List<GraphNode> expand() {
//        List<GraphNode> children = new ArrayList<GraphNode>();
//		// Itera las keys del HashMap asociado a este GraphNode
//        for (GraphNode gn : graph.get(this).keySet()) {
//            GraphNode child = gn.clone();    // Obtiene un clon de este elemento
//            child.setPrev(this);             // Este GraphNode se coloca como padre
//            children.add(child);             // Añade el hijo a la lista
//        }
//        return children;
//    }
    public abstract List<GraphNode> expand();

    /**
     * Clona esta instancia
     * @return un clon de este GraphNode
     */
    @Override
    public abstract GraphNode clone();

    /**
     * Define el Graph asociado a este GraphNode
     * @param graph el Graph a asignar
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /**
     * Obtiene el Graph asocidado a este GraphNode
     * @return el Graph asociado
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Calcula el costo asociado al recorrido del nodo
     * actual al último en jerarquía
     * @return el costo total del recorrido
     */
    public int computeCost() {
        int suma = 0;
        GraphNode gn = this;
        // Recorre la rama que finaliza con este nodo
        // hasta la raíz
        while (gn.hasPrev()) {	// verifica que el nodo no sea raíz
            // Obtiene el Integer del HashMap asociado al nodo
            suma += gn.getGraph().get((GraphNode) gn).get((GraphNode) gn.prev());
            gn = (GraphNode) gn.prev();		// avanza en la jerarquía
        }
        return suma;
    }

    /**
     * Concatena el nodo actual con sus anteriores hasta la raíz
     * @return la representación del nodo
     */
    @Override
    public String toString() {
        String s = "{";
        Node ap = this;
        while (ap.hasPrev()) {
            s += ap.getId() + ", ";
            ap = ap.prev();
        }
        s += ap.getId() + "}";
        return s;
    }
}
