class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int [] {0, 0, 0});

        boolean [] visited = new boolean [n];
        int cost = 0;
        int edges = 0;
        
        while (!pq.isEmpty() || edges < n - 1) {
            int [] current = pq.remove();
            if (visited[current[1]])
                continue;
            visited[current[1]] = true;
            cost += current[2];
            edges += 1;
            for (int j = 0; j< n; j++) {
                if (!visited[j])
                    pq.add(new int [] {current[1], j, Math.abs(points[current[1]][0] - points[j][0]) + Math.abs(points[current[1]][1] - points[j][1])});
            }
        }
        return cost;
    }
}