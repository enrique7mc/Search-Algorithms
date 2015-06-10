package searchalgorithms;

import datastrctures.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que realiza una búsqueda utilizando
 * Breath First Search
 */
public class BreadthFirstSearch extends AbstractSearch {
    protected Queue<Node> agenda = new LinkedList<Node>();

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
                System.out.print("\nNext State " + n + "   ");
            }while(closed.contains(n));
            if (n.equals(goal)) {
                this.result = n;
                return;
            } else {
                for (Node child : n.expand()) {
                    if(!closed.contains(child) && !child.equals(n))
                        this.agendaAdd(child);
                }
                System.out.println("\nagenda " +agenda);
                closed.add(n);
            }
        }
    }

    @Override
    public Node agendaNextState() {
        return agenda.poll();
    }

    @Override
    public void agendaAdd(Node n) {
        agenda.offer(n);
    }

    @Override
    public void agendaRemove(Node n) {
        while(agenda.contains(n))
            agenda.remove(n);
    }

    @Override
    public boolean agendaIsEmpty() {
        return agenda.isEmpty();
    }
}
