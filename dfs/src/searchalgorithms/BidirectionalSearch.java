package searchalgorithms;

import datastrctures.Node;
import java.util.Stack;

/**
 *  Clase que realiza una búsqueda bidireccional
 *  utiliza dos agendas una para el estado inicial
 *  y otra para el estado final
 */
public class BidirectionalSearch extends AbstractSearch {

    private Stack<Node> agendaStart;    // Almacena la agenda del nodo inicial
    private Stack<Node> agendaGoal;     // Almacena la agenda del nodo final

    // Inicializa las agendas
    public BidirectionalSearch() {
        agendaStart = new Stack<Node>();
        agendaGoal = new Stack<Node>();
    }

    /**
     *  Realiza la búsqueda bidireccional basado en DFS
     */
    @Override
    public void search() {
        Node nodoInicial = null;
        Node nodoFinal = null;
        agendaGoalAdd(goal);        // añade a la agenda el nodo meta
        agendaAdd(start);           // añade a la agenda el nodo inicial

        // Mientras ninguna de las agendas esté vacía continua
        while (!agendaIsEmpty() && !agendaGoalIsEmpty()) {
            do {						// Este ciclo salta nodos ya visitados
                if (!agendaIsEmpty()) // y avanza al siguiente
                {
                    nodoInicial = this.agendaNextState();
                }
            } while (closed.contains(nodoInicial));

            if (nodoInicial.equals(goal)) {      // Revisa si es el nodo meta
                this.result = nodoInicial;		 // en tal caso termina 
                return;
            } else {
                // Si no es el nodo meta realiza lo siguiente
                if (agendaGoal.contains(nodoInicial)) {
                    // Itera sobre la agenda del nodo meta
                    for (Node node : agendaGoal) {
                        // Si la agenda del nodo meta
                        // contiene a nodoInicial (el actual)
                        // entonces termina
                        if (nodoInicial.equals(node)) {
                            System.out.println(nodoInicial
                                    + "---" + node);
                        }
                    }
                    return;
                } else {
                    // Si no, expande el nodoInicial (el actual)
                    for (Node child : nodoInicial.expand()) {
                        if (!closed.contains(child) && !child.equals(nodoInicial)) {
                            this.agendaAdd(child);  // añade los hijos a la agenda
                        }                        //closed.add(child);
                    }
                    closed.add(nodoInicial);    // marca el nodo actual como visitado
                }
            }

            // Realiza el mismo procedimiento pero para el nodo meta
            do {
                if (!agendaGoalIsEmpty()) {
                    nodoFinal = this.agendaGoalNextState();
                }
            } while (closed.contains(nodoFinal));

            if (nodoFinal.equals(start)) {
                this.result = nodoFinal;
                return;
            } else {
                if (agendaStart.contains(nodoFinal)) {
                    for (Node node : agendaStart) {
                        if (nodoFinal.equals(node)) {
                            System.out.println(nodoFinal
                                    + "---" + node);
                        }
                    }
                    return;
                } else {
                    for (Node child : nodoFinal.expand()) {
                        if(!closed.contains(child) && !child.equals(nodoFinal))
                        this.agendaGoalAdd(child);
                        //closed.add(child);
                    }
                    closed.add(nodoFinal);
                }
            }
        }

    }

    /**
     * Obtiene el siguiente estado realizando un pop()
     * @return el siguiente estado
     */
    @Override
    public Node agendaNextState() {
        return agendaStart.pop();
    }

    /**
     * Añade un nodo a la agenda realizando un push
     * @param node el nodo a insertar
     */
    @Override
    public void agendaAdd(Node node) {
        agendaStart.push(node);
    }

    /**
     * Remueve un nodo de la agenda
     * @param node el nodo a remover
     */
    @Override
    public void agendaRemove(Node node) {
        while (agendaStart.contains(node)) {
            agendaStart.remove(node);
        }
    }

    /**
     * Revisa si la agenda no tiene elementos
     * @return true si la agenda está vacía
     */
    @Override
    public boolean agendaIsEmpty() {
        return agendaStart.isEmpty();
    }

    /**
     * Obtiene el siguiente estado realizando un pop()
     * @return el siguiente estado
     */
    public Node agendaGoalNextState() {
        return agendaGoal.pop();
    }

    /**
     * Añade un nodo a la agenda realizando un push
     * @param node el nodo a insertar
     */
    public void agendaGoalAdd(Node node) {
        agendaGoal.push(node);
    }

    /**
     * Remueve un nodo de la agenda
     * @param node el nodo a remover
     */
    public void agendaGoalRemove(Node node) {
        while (agendaGoal.contains(node)) {
            agendaGoal.remove(node);
        }
    }

    /**
     * Revisa si la agenda no tiene elementos
     * @return true si la agenda está vacía
     */
    public boolean agendaGoalIsEmpty() {
        return agendaGoal.isEmpty();
    }
}
