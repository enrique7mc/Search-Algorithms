package searchalgorithms;

/**
*  Clase que realiza una búsqueda con Iterative Deepening
*  extiende DepthLimitedSearch ya que utiliza este tipo depth
*  búsqueda cambiando la profundidad
*/
public class IterativeDeepening extends DepthLimitedSearch {

    private DepthLimitedSearch dls;
	// Número máximo de aumento de profundidad
    private static final int MAX_ITER = 1000;

    /**
     *  Realiza la búsqueda iterativamente mezclando
     *  DeepFirstSearch y BreadthFirstSearch
     */
    @Override
    public void search() {
        int count = 0;
        result = null;
		// Mientras no se encuentre resultado
		// vuelve a intentar con aumento de profundidad
        while(result == null && count < MAX_ITER){
			// Busca con DepthLimitedSearch
            dls = new DepthLimitedSearch(depth);
            dls.setStart(this.getStart());
            dls.setGoal(this.getGoal());
            dls.search();
            result = dls.getResult();
            depth++;
            count++;
        }
        System.out.println("Resultado encontrado en profundidad " + --depth);
    }
}
