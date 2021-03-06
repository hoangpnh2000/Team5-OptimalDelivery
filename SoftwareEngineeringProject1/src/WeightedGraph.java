import java.util.*;


public class WeightedGraph implements Comparable<WeightedGraph> {

    NodeWeighted source;
    NodeWeighted destination;
    double weight;

    WeightedGraph(NodeWeighted s, NodeWeighted d, double w) {
        // Note that we are choosing to use the (exact) same objects in the Edge class
        // and in the GraphShow and GraphWeighted classes on purpose - this MIGHT NOT
        // be something you want to do in your own code, but for sake of readability
        // we've decided to go with this option
        source = s;
        destination = d;
        weight = w;
    }

    public String toString() {
        return String.format("(%s -> %s, %f)", source.name, destination.name, weight);
    }

    // We need this method if we want to use PriorityQueues instead of LinkedLists
// to store our edges, the benefits are discussed later, we'll be using LinkedLists
// to make things as simple as possible
    public int compareTo(WeightedGraph otherEdge) {

        // We can't simply use return (int)(this.weight - otherEdge.weight) because
        // this sometimes gives false results
        if (this.weight > otherEdge.weight) {
            return 1;
        }
        else return -1;
    }
    public static class NodeWeighted {
        // The int n and String name are just arbitrary attributes
        // we've chosen for our nodes these attributes can of course
        // be whatever you need
        String name;
        private boolean visited;
        LinkedList<WeightedGraph> edges;

        NodeWeighted(String name) {
            this.name = name;
            visited = false;
            edges = new LinkedList<>();
        }

        boolean isVisited() {
            return visited;
        }

        void visit() {
            visited = true;
        }

        void unvisit() {
            visited = false;
        }
    }
    public static class GraphWeighted {
        private Set<NodeWeighted> nodes;

        GraphWeighted() {
            nodes = new HashSet<>();
        }

        // Doesn't need to be called for any node that has an edge to another node
// since addEdge makes sure that both nodes are in the nodes Set
        public void addNode(NodeWeighted... n) {
            // We're using a var arg method so, we don't have to call
            // addNode repeatedly
            nodes.addAll(Arrays.asList(n));
        }
        public void addEdge(NodeWeighted source, NodeWeighted destination, double weight) {
            // Since we're using a Set, it will only add the nodes
            // if they don't already exist in our graph
            nodes.add(source);
            nodes.add(destination);

            // We're using addEdgeHelper to make sure we don't have duplicate edges
            addEdgeHelper(source, destination, weight);

            if (source != destination) {
                addEdgeHelper(destination, source, weight);
            }
        }

        private void addEdgeHelper(NodeWeighted a, NodeWeighted b, double weight) {
            // Go through all the edges and see whether that edge has
            // already been added
            for (WeightedGraph edge : a.edges) {
                if (edge.source == a && edge.destination == b) {
                    // Update the value in case it's a different one now
                    edge.weight = weight;
                    return;
                }
            }
            // If it hasn't been added already (we haven't returned
            // from the for loop), add the edge
            a.edges.add(new WeightedGraph(a, b, weight));
        }
        public void printEdges() {
            for (NodeWeighted node : nodes) {
                LinkedList<WeightedGraph> edges = node.edges;

                if (edges.isEmpty()) {
                    //System.out.println("Node " + node.name + " has no edges.");
                    continue;
                }
                //System.out.print("Node " + node.name + " has edges to: ");

                for (WeightedGraph edge : edges) {
                    //System.out.print(edge.destination.name + "(" + edge.weight + ") ");
                }
                //System.out.println();
            }
        }
        public boolean hasEdge(NodeWeighted source, NodeWeighted destination) {
            LinkedList<WeightedGraph> edges = source.edges;
            for (WeightedGraph edge : edges) {
                // Again relying on the fact that all classes share the
                // exact same NodeWeighted object
                if (edge.destination == destination) {
                    return true;
                }
            }
            return false;
        }
        // Necessary call if we want to run the algorithm multiple times
        /*
        public void resetNodesVisited() {
            for (NodeWeighted node : nodes) {
                node.unvisit();
            }
        }*/
        public void DijkstraShortestPath(NodeWeighted start, NodeWeighted end) {
            // We keep track of which path gives us the shortest path for each node
            // by keeping track how we arrived at a particular node, we effectively
            // keep a "pointer" to the parent node of each node, and we follow that
            // path to the start
            HashMap<NodeWeighted, NodeWeighted> changedAt = new HashMap<>();
            changedAt.put(start, null);

            // Keeps track of the shortest path we've found so far for every node
            HashMap<NodeWeighted, Double> shortestPathMap = new HashMap<>();

            // Setting every node's shortest path weight to positive infinity to start
            // except the starting node, whose shortest path weight is 0
            for (NodeWeighted node : nodes){
                if (node == start)
                    shortestPathMap.put(start, 0.0);
                else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
            }

            // Now we go through all the nodes we can go to from the starting node
            // (this keeps the loop a bit simpler)
            for (WeightedGraph edge : start.edges) {
                shortestPathMap.put(edge.destination, edge.weight);
                changedAt.put(edge.destination, start);
            }

            start.visit();

            // This loop runs as long as there is an unvisited node that we can
            // reach from any of the nodes we could till then
            while (true) {
                NodeWeighted currentNode = closestReachableUnvisited(shortestPathMap);
                // If we haven't reached the end node yet, and there isn't another
                // reachable node the path between start and end doesn't exist
                // (they aren't connected)
                if (currentNode == null) {
                    //System.out.println("There isn't a path between " + start.name + " and " + end.name);
                    return;
                }

                // If the closest non-visited node is our destination, we want to print the path
                if (currentNode == end) {
                    //System.out.println("The path with the smallest weight between "
                    //        + start.name + " and " + end.name + " is:");

                    NodeWeighted child = end;

                    // It makes no sense to use StringBuilder, since
                    // repeatedly adding to the beginning of the string
                    // defeats the purpose of using StringBuilder
                    String path = end.name;
                    while (true) {
                        NodeWeighted parent = changedAt.get(child);
                        if (parent == null) {
                            break;
                        }

                        // Since our changedAt map keeps track of child -> parent relations
                        // in order to print the path we need to add the parent before the child, and
                        // it's descendants
                        path = parent.name + " " + path;
                        child = parent;
                    }
                    //System.out.println(path);
                    //System.out.println("The path costs: " + shortestPathMap.get(end));
                    return;
                }
                currentNode.visit();

                // Now we go through all the unvisited nodes our current node has an edge to
                // and check whether its shortest path value is better when going through our
                // current node than whatever we had before
                for (WeightedGraph edge : currentNode.edges) {
                    if (edge.destination.isVisited())
                        continue;

                    if (shortestPathMap.get(currentNode)
                            + edge.weight
                            < shortestPathMap.get(edge.destination)) {
                        shortestPathMap.put(edge.destination,
                                shortestPathMap.get(currentNode) + edge.weight);
                        changedAt.put(edge.destination, currentNode);
                    }
                }
            }
        }
        private NodeWeighted closestReachableUnvisited(HashMap<NodeWeighted, Double> shortestPathMap) {

            double shortestDistance = Double.POSITIVE_INFINITY;
            NodeWeighted closestReachableNode = null;
            for (NodeWeighted node : nodes) {
                if (node.isVisited())
                    continue;

                double currentDistance = shortestPathMap.get(node);
                if (currentDistance == Double.POSITIVE_INFINITY)
                    continue;

                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                    closestReachableNode = node;
                }
            }
            return closestReachableNode;
        }

    }
    private static double Distance (int x1,int x2,int y1,int y2){
        double dist = 0;
        return dist = Math.sqrt(Math.pow((x2-x1), 2)+(Math.pow((y2-y1),2)));
    }


    public static void main(String[] args) {
        GraphWeighted graphWeighted = new GraphWeighted();
        String name = "";
        for (int i = 0; i < Map.listDelivery.size(); i++){
            name += i;
            NodeWeighted temp = new NodeWeighted(name);
        }
        NodeWeighted zero = new NodeWeighted("0");
        NodeWeighted one = new NodeWeighted("1");
        NodeWeighted two = new NodeWeighted("2");
        NodeWeighted three = new NodeWeighted("3");
        NodeWeighted four = new NodeWeighted("4");
        NodeWeighted five = new NodeWeighted("5");
        NodeWeighted six = new NodeWeighted("6");

        // Our addEdge method automatically adds Nodes as well.
        // The addNode method is only there for unconnected Nodes,
        // if we wish to add any
        graphWeighted.addEdge(zero, one, 8);
        graphWeighted.addEdge(zero, two, 11);
        graphWeighted.addEdge(one, three, 3);
        graphWeighted.addEdge(one, four, 8);
        graphWeighted.addEdge(one, two, 7);
        graphWeighted.addEdge(two, four, 9);
        graphWeighted.addEdge(three, four, 5);
        graphWeighted.addEdge(three, five, 2);
        graphWeighted.addEdge(four, six, 6);
        graphWeighted.addEdge(five, four, 1);
        graphWeighted.addEdge(five, six, 8);

        graphWeighted.DijkstraShortestPath(zero, six);

    }
}