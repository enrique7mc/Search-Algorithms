package searchalgorithms;

import datastrctures.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *  Representa una búsqueda de forma abstracta
 */
public abstract class AbstractSearch {

    protected Node start;                 // Nodo inicial
    protected Node goal;                  // Nodo final
    protected Node result;                // Nodo resultado
    protected List<Node> closed           // Almacena los nodos visitados
            = new ArrayList<Node>();

    /**
     *  Realiza la búsqueda genérica
     */
    public void search() {
        Node n = null;			// Almacena el estado siguiente
        agendaAdd(start);		// Añade el nodo inicial a la agenda
        while (!agendaIsEmpty()) {
            do{
                n = this.agendaNextState();     // Obtiene el estado siguiente
            }while(closed.contains(n));         // Omite los nodos ya visitados
            if (n.equals(goal)) {
                this.result = n;		// Revisa si el nodo es el resultado
                return;                 // en dicho caso termina
            } else {
                for (Node child : n.expand()) {         // Expande el nodo
                    if(!closed.contains(child) && !child.equals(n))
                        this.agendaAdd(child);		// Añade los hijos a la agenda
                }
                closed.add(n);          		// Marca el nodo como visitado
            }
        }
    }
    

    /**
     * Obtiene el resultado de la búsqueda
     * @return el nodo resultante
     */
    public Node getResult() {
        return result;
    }

    /**
     * Asigna el nodo al que se quiere llegar
     * @param goal el nodo meta
     */
    public void setGoal(Node goal) {
        this.goal = goal;
    }
    
    /**
     * Obtiene el nodo meta
     * @return el nodo meta
     */
    public Node getGoal() {
        return goal;
    }
    

    /**
     * Define el nodo donde se comienza
     * @param start el nodo incial
     */
    public void setStart(Node start) {
        this.start = start;
    }
    
    /**
     * Obtiene el nodo inicial
     * @return el nodo inicial
     */
    public Node getStart(){
        return start;
    }

    /**
     * Avanza al siguiente estado de la agenda
     * @return el nodo del siguiente estado
     */
    public abstract Node agendaNextState();

    /**
     * Añade un nodo a la agenda
     * @param node el nodo a añadir
     */
    public abstract void agendaAdd(Node node);

    /**
     * Remueve un nodo de la agenda
     * @param node el nodo a remover
     */
    public abstract void agendaRemove(Node node);

    /**
     * Revisa si la agenda no contiene elementos
     * @return true si la agenda está vacía
     */
    public abstract boolean agendaIsEmpty();
}
