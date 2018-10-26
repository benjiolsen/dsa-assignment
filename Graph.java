import java.util.*;
public class Graph{
    private class GraphEdge{
        private String label;
        private double value;
        private boolean visited;

        public GraphEdge(String inLabel,double inValue){
            label = inLabel;
            value = inValue;
        }

        public String getLabel(){ return label; }
        public double getValue(){ return value; }
        public void getFrom(){}
        public void getTo(){}

    }

    private class GraphVertex{
        private String label;
        private boolean visited;
        private
        private DSALinkedList<GraphVertex> links;

        private GraphVertex(String inLabel){
            if(inLabel!=null){
                label = inLabel;
            }
            else{
                throw new IllegalArgumentException("Unable to create vertex");
            }
        }

        private String getLabel(){ return label; }

        public boolean getVisited(){ return visited; }

        private DSALinkedList<GraphVertex> getAdjacent(){ return links; }

        public String toString(){ return label; }

        private void addEdge(GraphVertex inEdge)
        {

        }

        public void setVisited()
        {

        }

        public void clearVisited()
        {

        }


    }
    private DSALinkedList<GraphVertex> vertices;

}
