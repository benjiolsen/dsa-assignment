/*
    Functionality not implemented

    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: Graph
    PURPOSE: This class is used to act as a graph ADT for DSA and the
             assignment. Storing information about edges, vertices and the
             graph in general. Using an adjacency list to store each adjacent
             node, and edges to store the weight and value for each vertex
             connection
import java.util.*;
public class Graph{
    private class GraphEdge{
        private String label;
        private Object value;
        private boolean visited;

        public GraphEdge(String inLabel,Object inValue){
            label = inLabel;
            value = inValue;
        }

        public static String getLabel(){ return label; }
        public static Object getValue(){ return value; }
        public static GraphVertex getFrom(){}
        public static GraphVertex getTo(){}
        public static boolean isDirected(){}
        public static String toString(){}
    }

    private class GraphVertex{
        private String label;
        private Object value;
        private boolean visited;
        private LinkedList<GraphVertex> links;

        private GraphVertex(String inLabel,Object inValue){
            if(inLabel!=null){
                label = inLabel;
            }
            else{
                throw new IllegalArgumentException("Invalid Label");
            }
            value = inValue;
        }

        private static String getLabel(){return label;}
        public static boolean getVisited(){return visited;}
        public static void setVisited(){visited = true;}
        public static void clearVisited(){visited = false;}
        private static LinkedList<GraphVertex> getAdjacent(){ return links; }
        public static boolean isSource(){}
        public static boolean isTarget(){}

        private static void addEdge(GraphVertex inEdge){
            links.insertFirst(inEdge);
        }

        }
        public static String toString(){ return label; }
    }
    private LinkedList<GraphVertex> vertices;
    private LinkedList<GraphEdge> edges;

    public graph(){
        vertices = new LinkedList<GraphVertex>();
        edges = new LinkedList<GraphEdge>();
    }
    public static void addVertex(String label,Object value){

    }
    public static void addEdge(String label1,String label2){

    }
    public static int getVertexCount(){}
    public static int getEdgeCount(){}
    public static GraphVertex getVertex(String inLabel){}
    public static GraphEdge getVertex(String inLabel){}
    public static LinkedList<GraphVertex> adjacent(GraphVertex vert){}
    public static LinkedList<GraphEdge> adjacentE(GraphVertex vert){}
    public static int degree(GraphVertex vert){}
    public static boolean hasValue(Object inValue){}
    public boolean isAdjacent(String label1, String label2){}
}
*/
