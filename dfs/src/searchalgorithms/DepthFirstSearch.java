package searchalgorithms;

import datastrctures.Node;
import java.util.Stack;

/**
 * Clase que realiza una búsqueda DFS
 */
public class DepthFirstSearch extends AbstractSearch {

    // La agenda se modela como una pila
    protected Stack<Node> agenda;

    public DepthFirstSearch() {
        agenda = new Stack<Node>();
    }

    /**
     *  Realiza la búsqueda mostrando los estados y la agenda
     */
    public void searchView() {
        Node n = null;
        agendaAdd(start);
        System.out.println(agenda);
        while (!agendaIsEmpty()) {
            do{
                n = this.agendaNextState();
                System.out.print("\nNext State\n " + n + "   ");
            }while(closed.contains(n));
            if (n.equals(goal)) {
                this.result = n;
                return;
            } else {
                for (Node child : n.expand()) {
                    System.out.print("i");
                    if(!closed.contains(child) && !child.equals(n))
                        this.agendaAdd(child);
                }
                System.out.println("\nagenda " +agenda);
                closed.add(n);
            }
        }
    }

    /**
     * Obtiene el siguiente estado realizando un pop()
     * @return el siguiente estado
     */
    @Override
    public Node agendaNextState() {
        return agenda.pop();
    }

    /**
     * Añade un nodo a la agenda realizando un push
     * @param node el nodo a insertar
     */
    @Override
    public void agendaAdd(Node node) {
        agenda.push(node);
    }

    /**
     * Remueve un nodo de la agenda
     * @param node el nodo a remover
     */
    @Override
    public void agendaRemove(Node node) {
        while(agenda.contains(node))
            agenda.remove(node);
    }

    /**
     * Revisa si la agenda no tiene elementos
     * @return true si la agenda está vacía
     */
    @Override
    public boolean agendaIsEmpty() {
       return agenda.isEmpty();
    }



}
