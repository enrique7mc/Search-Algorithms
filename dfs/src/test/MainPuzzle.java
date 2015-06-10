package test;

import datastrctures.Graph;
import datastrctures.GraphNode;
import searchalgorithms.BreadthFirstSearch;
import searchalgorithms.DepthFirstSearch;
import searchalgorithms.DepthLimitedSearch;
import searchalgorithms.IterativeDeepening;
import searchalgorithms.UniformCostSearch;

/**
 *
 * @author proteco
 */
public class MainPuzzle {

    private Graph g;
    private Puzzle p = new Puzzle();

    public static void main(String[] args) {
        new MainPuzzle().start();
    }

    public void start() {
        g = new Graph();

//        Puzzle clone = (Puzzle)p.clone();
//        System.out.println(clone.equals(p));
//        System.out.println(p.equals(clone));

//        p.randomState();
//        System.out.println("p\n" + p);
        g.addNode(p);


//        p.expand();
//
//        System.out.println("______________");
//        for (GraphNode gn : g.get(p).keySet()) {
//            System.out.println("nodo\n" + gn + " cost" + gn.computeCost());
//        }

        p.zeroUp();
        p.zeroUp();
        p.zeroLeft();
        p.zeroLeft();

        //System.out.println(p);
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.setStart(p);
        dfs.setGoal(new Puzzle());
        dfs.search();
        System.out.println("Result DFS: " + dfs.getResult());

        System.out.println("************************");
//
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.setStart(p);
        bfs.setGoal(new Puzzle());
        bfs.search();
        System.out.println("Result BFS: " + bfs.getResult());

        System.out.println("************************");

        IterativeDeepening id = new IterativeDeepening();
        id.setStart(p);
        id.setGoal(new Puzzle());
        id.search();
        System.out.println("Result ID: " + id.getResult());

        System.out.println("************************");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setStart(p);
        dls.setGoal(new Puzzle());
        dls.setDepth(1000);
        dls.search();
        System.out.println("Result DLS: " + dls.getResult());

        UniformCostSearch ucs = new UniformCostSearch();
        ucs.setStart(p);
        ucs.setGoal(new Puzzle());
        ucs.search();
        System.out.println("Result USC: " + ucs.getResult()
                + "Cost: " + ((GraphNode) ucs.getResult()).computeCost());


    }
}
