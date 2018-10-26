import java.util.*;
public class Graph
{
    private class GraphVertex
    {
        private String label;
        private boolean visited;
        private DSALinkedList<GraphVertex> links;

        private GraphVertex(String inLabel)
        {
            if(inLabel!=null)
            {
                label = inLabel;
            }
            else
            {
                throw new IllegalArgumentException("Unable to create vertex");
            }
        }

        private String getLabel()
        {
            return label;
        }

        private DSALinkedList<GraphVertex> getAdjacent()
        {
            return links;
        }

        private void addEdge(GraphVertex inEdge)
        {

        }

        public void setVisited()
        {

        }

        public void clearVisited()
        {

        }

        public boolean getVisited()
        {
            return visited;
        }

        public String toString()
        {
            return label;
        }
    }
    private DSALinkedList<GraphVertex> vertices;

}
