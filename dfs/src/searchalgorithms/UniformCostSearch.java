package searchalgorithms;

import datastrctures.GraphNode;
import datastrctures.Node;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Clase que realiza una búsqueda basada en el costo
 */
public class UniformCostSearch extends BreadthFirstSearch {

    // Define la capacidad inicial de la cola
    protected static final int INIT_CAP = 20;

    /**
     * Inicializa una instancia de UniformCostSearch
     * La agenda la maneja como una cola de prioridad
     * Hace uso de un Comparator para priorizar la cola
     */
    public UniformCostSearch() {
        Comparator<Node> comp = new GraphNodeComparator();
        agenda = new PriorityQueue<Node>(INIT_CAP, comp);
    }

    /**
     *  Realiza la búsqueda mostrando los estados y la agenda
     */
    @Override
    public void searchView() {
        Queue q;			// Utilizada para mostrar el estado de la cola
        Node n = null;		// se refiere al nodo actual
        agendaAdd(start);    			// añade el nodo inicial a la agenda
        System.out.println(agenda);
        while (!agendaIsEmpty()) {		// mientras la agenda no esté vacía
            do {						// salta los nodos visitados
                n = this.agendaNextState();
                System.out.println("\nNext State " + n + "   ");
            } while (closed.contains(n));
            // Si el nodo actual es igual al nodo meta termina el método
            if (n.equals(goal)) {
                this.result = n;
                return;
            } else {
                // en caso contrario se expande el nodo
                for (Node child : n.expand()) {
                    // si el nodo expanido no ha sido visitado lo añade a la agenda
                    if (!closed.contains(child) && !child.equals(n)) {
                        this.agendaAdd(child);
                    }
                }
                closed.add(n);   	// marca el nodo actual como visitado

                // Crea una PriorityQueue a partir de la agenda
                // Esto es sólo para mostrarla en pantalla
                q = new PriorityQueue(agenda);
                while (q.size() > 0) {
                    System.out.print(q.peek() + "->" + ((GraphNode)q.peek()).computeCost() + "   ");
                    q.poll();
                }
                System.out.println("");
            }
        }
    }

    // Clase que implementa la interfaz comparator
    // para la priorización de la cola
    static class GraphNodeComparator implements Comparator<Node> {

        // Este método comparará los costos asociados
        // al recorrido completo del nodo-> GraphNode.computeCost()
        // Así ordenará la cola con los costos más bajos al principio
        public int compare(Node o1, Node o2) {
            if (o1 instanceof GraphNode && o2 instanceof GraphNode
                    && o1 != null && o2 != null) {
//                GraphNode gn1 = (GraphNode) o1;
//                GraphNode gn2 = (GraphNode) o2;
                Integer cost1 = o1.computeCost();
                Integer cost2 = o2.computeCost();
                return cost1.compareTo(cost2);
            }
            return 0;
        }
    }
}
