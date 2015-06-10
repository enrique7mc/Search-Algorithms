package searchalgorithms;

import datastrctures.Node;

public class DepthLimitedSearch extends DepthFirstSearch {

    protected int depth;        // Nivel de profundidad para la búsqueda

    public DepthLimitedSearch(int depth) {
        this.depth = depth;
    }

    public DepthLimitedSearch() {
    }

    /**
     *  Realiza la búsqueda con límite de profundidad
     */
    @Override
    public void search() {
        Node n = null;
        agendaAdd(start);
        while (!agendaIsEmpty() && depth >= 0) {
            do {
                n = this.agendaNextState();
            } while (closed.contains(n));
            if (n.equals(goal)) {
                this.result = n;
                return;
            } else {
                for (Node child : n.expand()) {
                    if (!closed.contains(child) && !child.equals(n)) {
                        this.agendaAdd(child);
                    }
                }
                closed.add(n);
                depth--;
            }
        }
    }

    /**
     * Asigna la profundidad a la búsqueda
     * @param depth la profundidad en niveles
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
}
