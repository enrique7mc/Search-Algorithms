package test;

import datastrctures.Graph;
import datastrctures.GraphNode;
import datastrctures.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa un puzzle de tamaño n
 * extiende de GraphNode
 */
public class Puzzle extends GraphNode {

    private int[][] tiles;
    private int SIZE;  // tamaño del puzzle
    private int x; //posición x del 0
    private int y; //posición y del 0

    public Puzzle() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        tiles = a;
        x = 2;
        y = 2;
        this.SIZE = 3;
    }

    public Puzzle(int SIZE) {
        this.SIZE = SIZE;
        tiles = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j] = (i * SIZE) + j;
            }
        }
    }

    public Puzzle(Puzzle p) {
        this.tiles = new int[p.SIZE][p.SIZE];
        for (int i = 0; i < tiles.length; i++) {
            System.arraycopy(p.tiles[i], 0, this.tiles[i], 0, tiles.length);
        }
        this.x = p.x;
        this.y = p.y;
        this.SIZE = p.SIZE;
    }

    public boolean zeroLeft() {
        if (y == 0) {
            return false;
        } else {
            int temp = tiles[x][y];
            tiles[x][y] = tiles[x][y - 1];
            tiles[x][y - 1] = temp;
            y = y - 1;
            return true;
        }
    }

    public boolean zeroRight() {
        if (y == SIZE - 1) {
            return false;
        } else {
            int temp = tiles[x][y];
            tiles[x][y] = tiles[x][y + 1];
            tiles[x][y + 1] = temp;
            y = y + 1;
            return true;
        }
    }

    public boolean zeroUp() {
        if (x == 0) {
            return false;
        } else {
            int temp = tiles[x][y];
            tiles[x][y] = tiles[x - 1][y];
            tiles[x - 1][y] = temp;
            x = x - 1;
            return true;
        }
    }

    public boolean zeroDown() {
        if (x == SIZE - 1) {
            return false;
        } else {
            int temp = tiles[x][y];
            tiles[x][y] = tiles[x + 1][y];
            tiles[x + 1][y] = temp;
            x = x + 1;
            return true;
        }
    }

    public void randomState() {
        byte c;
        byte i = 0;
        Random random = new Random();
        while (i < 50) {
            c = (byte) random.nextInt(4);
            switch (c) {
                case 0:
                    if (zeroLeft()) {
                        i++;
                    }
                    break;
                case 1:
                    if (zeroRight()) {
                        i++;
                    }
                    break;
                case 2:
                    if (zeroUp()) {
                        i++;
                    }
                    break;
                case 3:
                    if (zeroDown()) {
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
    }

//    private void insertIntoGraph(){
//        Graph g = this.getGraph();
//        GraphNode childLeft = this.clone();
//        GraphNode childRight = this.clone();
//        GraphNode childUp = this.clone();
//        GraphNode childDown = this.clone();
//
//        ((Puzzle) childLeft).zeroLeft();
//        ((Puzzle) childRight).zeroRight();
//        ((Puzzle) childUp).zeroUp();
//        ((Puzzle) childDown).zeroDown();
//
//        childLeft.setPrev(this);
//        childRight.setPrev(this);
//        childUp.setPrev(this);
//        childDown.setPrev(this);
//
//        g.addNode(childLeft);
//        g.addNode(childRight);
//        g.addNode(childUp);
//        g.addNode(childDown);
//
//        if(!childLeft.equals(this))
//            g.addEdgeCost(this, childLeft, 1);
//        if(!childRight.equals(this))
//            g.addEdgeCost(this, childRight, 1);
//        if(!childUp.equals(this))
//            g.addEdgeCost(this, childUp, 1);
//        if(!childDown.equals(this))
//            g.addEdgeCost(this, childDown, 1);
//    }

    @Override
    public List<GraphNode> expand() {
        List<GraphNode> children = new ArrayList<GraphNode>();
        Graph g = this.getGraph();
        //insertIntoGraph();

        GraphNode childLeft = this.clone();
        GraphNode childRight = this.clone();
        GraphNode childUp = this.clone();
        GraphNode childDown = this.clone();

//        childLeft.setPrev(this);
//        childRight.setPrev(this);
//        childUp.setPrev(this);
//        childDown.setPrev(this);
//
//        if (((Puzzle) childLeft).zeroLeft()) {
//            childLeft.setPrev(this);
//            g.addNode(childLeft);
//            g.addEdgeCost(this, childLeft, 1);
//            children.add(childLeft.clone());
//        }
//
//        if (((Puzzle) childLeft).zeroRight()) {
//            childRight.setPrev(this);
//            g.addNode(childRight);
//            g.addEdgeCost(this, childRight, 1);
//            children.add(childRight.clone());
//        }
//
//        if(((Puzzle) childUp).zeroUp()){
//            childUp.setPrev(this);
//            g.addNode(childUp);
//            g.addEdgeCost(this, childUp, 1);
//            children.add(childUp.clone());
//        }
//
//        if(((Puzzle) childDown).zeroDown()){
//            childDown.setPrev(this);
//            g.addNode(childDown);
//            g.addEdgeCost(this, childDown, 1);
//            children.add(childDown.clone());
//        }



        ((Puzzle) childLeft).zeroLeft();
        ((Puzzle) childRight).zeroRight();
        ((Puzzle) childUp).zeroUp();
        ((Puzzle) childDown).zeroDown();

        g.addNode(childLeft);
        g.addNode(childRight);
        g.addNode(childUp);
        g.addNode(childDown);

        childLeft.setPrev(this);
        childRight.setPrev(this);
        childUp.setPrev(this);
        childDown.setPrev(this);

        g.addEdgeCost(this, childLeft, 1);
        g.addEdgeCost(this, childRight, 1);
        g.addEdgeCost(this, childUp, 1);
        g.addEdgeCost(this, childDown, 1);

//        for (GraphNode gn : graph.get(this).keySet()) {
//            GraphNode child = gn.clone();    // Obtiene un clon de este elemento
//            child.setPrev(this);             // Este GraphNode se coloca como padre
//            children.add(child);             // Añade el hijo a la lista
//        }

//        GraphNode cloneLeft = childLeft.clone();
//        GraphNode cloneRight = childRight.clone();
//        GraphNode cloneUp = childUp.clone();
//        GraphNode cloneDown = childDown.clone();
//
//
//        cloneLeft.setPrev(this);
//        cloneRight.setPrev(this);
//        cloneUp.setPrev(this);
//        cloneDown.setPrev(this);

//        children.add(cloneLeft);
//        children.add(cloneRight);
//        children.add(cloneUp);
//        children.add(cloneDown);

//        childLeft.setPrev(this);
//        childRight.setPrev(this);
//        childUp.setPrev(this);
//        childDown.setPrev(this);

        children.add(childLeft.clone());
        children.add(childRight.clone());
        children.add(childUp.clone());
        children.add(childDown.clone());

        return children;
    }

    public GraphNode clone() {
        GraphNode clone = new Puzzle(this);
        clone.setGraph(this.getGraph());
        //((Node)clone).setPrev(((Node)this).prev());
        return clone;
    }

    public String getId() {
        return this.toString();
    }

    public int[][] getTiles() {
        return tiles;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puzzle other = (Puzzle) obj;
        if (!Arrays.deepEquals(this.tiles, other.tiles)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.deepHashCode(this.tiles);
        return hash;
    }

    @Override
    public String toString() {
        String str = "\n";
        for (int[] is : tiles) {
            for (int i : is) {
                str += String.format("%2d", i) + " ";
            }
            str += "\n";
        }
        return str;
    }
}
