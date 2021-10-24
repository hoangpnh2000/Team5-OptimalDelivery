import java.util.*;

public class WeightedGraph {

    static class Edge {
        int src, dest;
        double distance;

        //Constructor
        public Edge(int src, int dest, double distance) {
            this.src = src;
            this.dest = dest;
            this.distance = distance;
        }
    }

    static class Graph {
        int vertices;
        //Initialize adj list for all vertices
        LinkedList<Edge> [] adjacencylist;
        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int dest, double distance) {
            Edge edge = new Edge(source, dest, distance);
            adjacencylist[source].addFirst(edge);
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    String temp = "Source vertex " + i;
                    while (temp.length() < 25){
                        temp+=" ";
                    }
                    temp += "Destination vertex " + list.get(j).dest;
                    while (temp.length() < 55){
                        temp+=" ";
                    }
                    temp += "Distance " + list.get(j).distance;
                    System.out.println(temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 230;
        Graph graph = new Graph(vertices);
        graph.addEdge(23, 200, 4);
        graph.addEdge(200, 23, 7);
        graph.printGraph();
    }
}