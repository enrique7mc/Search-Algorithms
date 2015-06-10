package test;

import datastrctures.GraphNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una ciudad, extiende GraphNode
 */
public class City extends GraphNode {

    private String cityName;

    /**
     * Constructor de la clase City
     * inicializa el nombre
     * @param cityName
     */
    public City(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Obtiene el nombre asignado a esta ciudad
     * @return el nombre de la ciudad
     */
    public String getName() {
        return cityName;
    }

    /**
     * Asigna el nombre a la ciudad
     * @param name
     */
    public void setName(String name) {
        this.cityName = name;
    }

    /**
     * Compara esta instancia con otro objeto
     * basado en cityName
     * @param obj el objeto con el que se compara
     * @return true si esta instancia y obj son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if ((this.cityName == null) ? (other.cityName != null) : !this.cityName.equals(other.cityName)) {
            return false;
        }
        return true;
    }

    /**
     * Regresa el hashcode de esta instancia
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.cityName != null ? this.cityName.hashCode() : 0);
        return hash;
    }

    /**
     * Crea un nuevo objeto City a partir de cityName
     * y le asigna el mismo grafo que posee esta instancia
     * @return GraphNode idéntico a esta instancia
     */
    @Override
    public GraphNode clone() {
        GraphNode clone = new City(cityName);
        clone.setGraph(this.getGraph());
        //clone.setCost(this.getCost());
        return clone;
    }

    @Override
    public String getId() {
        return cityName;
    }

    public List<GraphNode> expand() {
        List<GraphNode> children = new ArrayList<GraphNode>();
        // Itera las keys del HashMap asociado a este GraphNode
        for (GraphNode gn : graph.get(this).keySet()) {
            GraphNode child = gn.clone();    // Obtiene un clon de este elemento
            child.setPrev(this);             // Este GraphNode se coloca como padre
            children.add(child);             // Añade el hijo a la lista
        }
        return children;
    }
}
