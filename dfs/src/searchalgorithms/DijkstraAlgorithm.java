package searchalgorithms;

import datastrctures.Graph;
import datastrctures.GraphNode;
import datastrctures.Node;
import java.util.HashMap;


/**
 * Clase que realiza una búsqueda utilizando
 * el algoritmo de Dijkstra
 */
public class DijkstraAlgorithm extends UniformCostSearch {

    //Costo inicial asignado a los nodos
    private static final int INF = 1000;

    public DijkstraAlgorithm() {
//        Comparator<Node> comp = new GraphNodeComparator();
//        agenda = new PriorityQueue<Node>(INIT_CAP, comp);
    }

    @Override
    public void search() {
        Node n = null;
        Graph graph = ((GraphNode) start).getGraph(); // Grafo a recorrer
        HashMap<Node, Integer> distances 
                = new HashMap<Node, Integer>(graph.size());
        for (Node node : graph.keySet()) {
            if(node.equals(start))
                distances.put(node, 0);
            else
                distances.put(node, INF);
        }
        agendaAdd(start);
        //System.out.println(agenda);
        while(closed.size() < distances.size()){
            do{
                n = this.agendaNextState();
            }while(closed.contains(n));
            for (Node child : n.expand()) {
                    // si el nodo expanido no ha sido visitado lo añade a la agenda
                    if (!closed.contains(child)) {
                        int newDistance = child.computeCost();
                        this.agendaAdd(child);
                        if(distances.get(child) > newDistance){
                            distances.put(child, newDistance);
                        }
                    }
                }
                closed.add(n);   	// marca el nodo actual como visitado
        }        
        
        System.out.println("Distancia más corta de " + start + " a " + goal
                + " es " + distances.get(goal));
    }

}
