package datastrctures;

import java.util.HashMap;

/**
 *  Clase que representa un grafo mediante un HashMap
 *  cada GraphNode se mapea a una HashMap de GraphNodes
 *  cuyos valores son los costos asociados a cada param
 *  de nodos
 *  
 */
public class Graph extends HashMap<GraphNode, HashMap<GraphNode, Integer>> {

    /**
     * Añade un nodo al HashMap, inicializa la variavle de instancia
     * graph del GraphNode que recibe.
     * @param graphNode GraphNode a añadir
     */
    public void addNode(GraphNode graphNode) {
        graphNode.setGraph(this);
        this.put(graphNode, new HashMap<GraphNode, Integer>());
    }

    /**
     * Une dos GraphNodes, añadiendo cada uno al HashMap
     * del otro, esto es en ambas direcciones, con un
	 * costo asociado de cero
     * @param gn1 GraphNode 1
     * @param gn2 GraphNode 2
     */
    public void addEdge(GraphNode gn1, GraphNode gn2) {
        if (containsKey(gn1) && containsKey(gn2)) {
            this.get(gn1).put(gn2, 0);
            this.get(gn2).put(gn1, 0);
        }
    }

    /**
     * Uno dos GraphNodes, solo en una dirección
     * gn2 se añade a la lista de gn1 con un costo
	 * asociado de cero
     * @param gn1 GraphNode 1
     * @param gn2 GraphNode 2
     */
    public void addArc(GraphNode gn1, GraphNode gn2) {
        if (containsKey(gn1) && containsKey(gn2)) {
            this.get(gn1).put(gn2, 0);
        }
    }

    /**
     * Une dos GraphNodes, añadiendo cada uno a la List
     * del otro, esto es en ambas direcciones
     * @param gn1 GraphNode 1
     * @param gn2 GraphNode 2
	 * @param cost el costo asociado a los nodos
     */
    public void addEdgeCost(GraphNode gn1, GraphNode gn2, Integer cost) {
        if (containsKey(gn1) && containsKey(gn2)) {
            this.get(gn1).put(gn2, cost);
            this.get(gn2).put(gn1, cost);
        }
    }

    /**
     * Uno dos GraphNodes, solo en una dirección
     * gn2 se añade a la lista de gn1
     * @param gn1 GraphNode 1
     * @param gn2 GraphNode 2
	 * @param cost el costo asociado a los nodos
     */
    public void addArcCost(GraphNode gn1, GraphNode gn2, Integer cost) {
        if (containsKey(gn1) && containsKey(gn2)) {
            this.get(gn1).put(gn2, cost);
        }
    }
    
}
