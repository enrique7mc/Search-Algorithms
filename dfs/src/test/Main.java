package test;

import datastrctures.Graph;
import datastrctures.GraphNode;
import searchalgorithms.*;

public class Main {

    private Graph g;
//    private City[] cities = {
//        new City("Guadalajara"),
//        new City("Monterrey"),
//        new City("Acapulco"),
//        new City("Distrito Federal"),
//        new City("Tijuana"),
//        new City("Cancún"),
//        new City("Cd. Juárez")};
    
    private City[] cities = {
        new City("A"),      //0
        new City("B"),      //1
        new City("C"),      //2
        new City("D"),      //3
        new City("F"),      //4
        new City("M"),      //5
        new City("S"),      //6
        new City("Z"),      //7
        new City("R"),      //8
        new City("P"),      //9
        new City("T"),      //10
        new City("O"),      //11
        new City("L")};     //12


    public static void main(String[] args) {
        new Main().start();

    }

    public void start() {
        g = new Graph();
        for (City c : cities) {
            g.addNode(c);
        }
//        System.out.println(cities[0]);
//        City clone = (City)cities[0].clone();
//        System.out.println(clone);
//
//        clone.setName("lala");
//        System.out.println(cities[0]);
//        System.out.println(clone);



//        g.addEdge(cities[0], cities[10]);
//        g.addEdge(cities[10], cities[12]);
//        g.addEdge(cities[12], cities[5]);
//        g.addEdge(cities[5], cities[3]);
//        g.addEdge(cities[3], cities[8]);
//        g.addEdge(cities[8], cities[2]);
//        g.addEdge(cities[8], cities[9]);
//        g.addEdge(cities[8], cities[6]);
//        g.addEdge(cities[2], cities[9]);
//        g.addEdge(cities[9], cities[1]);
//        g.addEdge(cities[1], cities[4]);
//        g.addEdge(cities[4], cities[6]);
//        g.addEdge(cities[6], cities[11]);
//        g.addEdge(cities[11], cities[7]);
//        g.addEdge(cities[7], cities[0]);
//        g.addEdge(cities[0], cities[6]);
        
        g.addEdgeCost(cities[0], cities[10], 118);
        g.addEdgeCost(cities[10], cities[12], 111);
        g.addEdgeCost(cities[12], cities[5], 70);
        g.addEdgeCost(cities[5], cities[3], 75);
        g.addEdgeCost(cities[3], cities[8], 120);
        g.addEdgeCost(cities[8], cities[2], 146);
        g.addEdgeCost(cities[8], cities[9], 97);
        g.addEdgeCost(cities[8], cities[6], 90);
        g.addEdgeCost(cities[2], cities[9], 138);
        g.addEdgeCost(cities[9], cities[1], 101);
        g.addEdgeCost(cities[1], cities[4], 211);
        g.addEdgeCost(cities[4], cities[6], 99);
        g.addEdgeCost(cities[6], cities[11], 151);
        g.addEdgeCost(cities[11], cities[7], 71);
        g.addEdgeCost(cities[7], cities[0], 75);
        g.addEdgeCost(cities[0], cities[6], 140);

//        g.addEdge(cities[0], cities[4]);
//        g.addEdge(cities[0], cities[1]);
//        g.addEdge(cities[0], cities[2]);
//        g.addEdge(cities[1], cities[3]);
//        g.addEdge(cities[1], cities[4]);
//        g.addEdge(cities[2], cities[3]);
//        g.addEdge(cities[3], cities[5]);
//        g.addEdge(cities[6], cities[1]);

//        DepthFirstSearch dfs = new DepthFirstSearch();
//        dfs.setStart(cities[0]);
//        dfs.setGoal(cities[1]);
//        dfs.search();
//        System.out.println("Result DFS: " + dfs.getResult());
//
//        System.out.println("************************");
//
//        BreadthFirstSearch bfs = new BreadthFirstSearch();
//        bfs.setStart(cities[0]);
//        bfs.setGoal(cities[1]);
//        bfs.search();
//        System.out.println("Result BFS: " + bfs.getResult());
//
//        System.out.println("************************");
//
//        DepthLimitedSearch dls = new DepthLimitedSearch();
//        dls.setStart(cities[0]);
//        dls.setGoal(cities[1]);
//        dls.setDepth(5);
//        dls.search();
//        System.out.println("Result DLS: " + dls.getResult());
//
//        System.out.println("************************");
//
//        IterativeDeepening id = new IterativeDeepening();
//        id.setStart(cities[0]);
//        id.setGoal(cities[1]);
//        id.search();
//        System.out.println("Result ID: " + id.getResult());
//
//        System.out.println("************************");
//
//        BidirectionalSearch bs = new BidirectionalSearch();
//        bs.setStart(cities[0]);
//        bs.setGoal(cities[1]);
//        bs.search();
//        System.out.println("Result BS: " + bs.getResult());
//
//        System.out.println("************************");

        UniformCostSearch ucs = new UniformCostSearch();
        ucs.setStart(cities[0]);
        ucs.setGoal(cities[1]);
        ucs.searchView();
        System.out.println("Result USC: " + ucs.getResult()
                + "Cost: " + ((GraphNode)ucs.getResult()).computeCost());

//        DijkstraAlgorithm da = new DijkstraAlgorithm();
//        da.setStart(cities[0]);
//        da.setGoal(cities[1]);
//        da.search();
//        System.out.println("Result DA: " + da.getResult());
       
    }
}
