class Solution {
    public int find(int[] parentVertices, int currentVertex) {
        if (currentVertex == parentVertices[currentVertex]) {
            return currentVertex;
        }

        int returnVertex = currentVertex;

        while (returnVertex != parentVertices[returnVertex]) {
            returnVertex = parentVertices[returnVertex];
        }

        return returnVertex;
    }

    public int union(int[] parentVertices, int[] ranks, int vertexOne, int vertexTwo) {
        vertexOne = find(parentVertices, vertexOne);
        vertexTwo = find(parentVertices, vertexTwo);

        if (vertexOne == vertexTwo) {
            return 0;
        }

        if (ranks[vertexOne] > ranks[vertexTwo]) {
            parentVertices[vertexOne] = vertexTwo;
            ranks[vertexTwo] += ranks[vertexOne];
        } else {
            parentVertices[vertexTwo] = vertexOne;
            ranks[vertexOne] += ranks[vertexTwo];
        }

        return 1;
    }

    public int countComponents(int n, int[][] edges) {
        int numComponents = n;
        int[] parentVertices = new int[n];
        int[] ranks = new int[n];
        int i = 0;

        for (i = 0; i < n; i++) {
            parentVertices[i] = i;
            ranks[i] = 1;
        }

        for (i = 0; i < edges.length; i++) {
            numComponents -= union(parentVertices, ranks, edges[i][0], edges[i][1]);
        }

        return numComponents;
    }
}