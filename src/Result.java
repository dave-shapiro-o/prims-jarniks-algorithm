
import java.util.*;


class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>> edges, int start) {

        int totalWeight = 0;
        int edgeCount = 0;

        boolean[] includedNodes = new boolean[n+1];
        Arrays.fill(includedNodes, false);
        includedNodes[start] = true;

        while (edgeCount < n - 1){
            int minEdge = Integer.MAX_VALUE;
            int minEdgeIndex = 0;

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
            if (includedNodes[selectedEdge.get(0)]) { includedNodes[selectedEdge.get(1)] = true; }
            else { includedNodes[selectedEdge.get(0)] = true; }
            totalWeight += minEdge;
            ++edgeCount;
            edges.remove(selectedEdge);
            }
        return totalWeight;
    }
}