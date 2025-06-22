class Solution {
    public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int freshCount = 0;
    Queue<int[]> queue = new LinkedList<>();
    // Count fresh oranges and enqueue rotten ones
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) freshCount++;
            else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
        }
    }

    if (freshCount == 0) return 0;

    int time = 0;
    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // up, right, down, left

    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean anyRot = false; // To check if any fresh orange rotted this minute

        for (int i = 0; i < size; i++) {
            int[] rotten = queue.poll();
            int r = rotten[0], c = rotten[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshCount--;
                    anyRot = true;
                }
            }
        }

        if (anyRot) time++; // Only increment time if any orange got rotten
    }
    return (freshCount == 0) ? time : -1;
}
}
