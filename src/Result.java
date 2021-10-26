
import java.util.*;


class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n -> the number of nodes
     *  2. 2D_INTEGER_ARRAY edges -> as List of Lists, where each list has 3 integers:
     *                               index 0 and 1 : nodes that the edge connects
     *                               index 2 : the weight of the edge
     *  3. INTEGER start -> the starting node
     */
    public static int prims(int n, List<List<Integer>> edges, int start) {

        int totalWeight = 0;
        int edgeCount = 0;

        // Nodes added to the MST by setting == true in "includedNodes" array.
        boolean[] includedNodes = new boolean[n+1];
        Arrays.fill(includedNodes, false);
        includedNodes[start] = true;

        while (edgeCount < n - 1){
            int minEdge = Integer.MAX_VALUE;
            int minEdgeIndex = 0;

            // For each of the edges remaining in the list,
            // if one of its nodes are in the MST and the other is not,
            // and if it is the cheapest edge thus far, mark it as such.
            for (int i = 0; i < edges.size(); ++i){
                List<Integer> current = edges.get(i);
                    if ((includedNodes[current.get(0)] && !includedNodes[current.get(1)])
                            || (includedNodes[current.get(1)]) && !includedNodes[current.get(0)]){
                        if (current.get(2) < minEdge){
                            minEdge = current.get(2);
                            minEdgeIndex = i;
                        }
                    }
                }

            List<Integer> selectedEdge = edges.get(minEdgeIndex);
            // Add the new node to the MST, add its weight to the total,
            // increment the edge count and remove the edge from the list of candidates ("edges").
            if (includedNodes[selectedEdge.get(0)]) { includedNodes[selectedEdge.get(1)] = true; }
            else { includedNodes[selectedEdge.get(0)] = true; }
            totalWeight += minEdge;
            ++edgeCount;
            edges.remove(selectedEdge);
            }
        return totalWeight;
    }
}