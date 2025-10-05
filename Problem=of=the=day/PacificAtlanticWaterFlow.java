/**
 * 🌊 Pacific Atlantic Water Flow
 *
 * Problem:
 * You are given an m x n matrix of heights representing a map of the island.
 * The Pacific Ocean touches the island’s left and top edges,
 * and the Atlantic Ocean touches the island’s right and bottom edges.
 *
 * Water can only flow from a cell to another cell that has a height less than
 * or equal to its current height (i.e., downhill or flat flow).
 *
 * Return all grid coordinates (r, c) from which water can flow to both oceans.
 *
 * Approach:
 * - Reverse the flow: start DFS from both oceans and mark cells reachable from each.
 * - A cell can reach both oceans if it’s visited by both DFS traversals.
 *
 * Time Complexity:  O(m × n)
 * Space Complexity: O(m × n)
 *
 * Example Input:
 * heights = [
 *   [1, 2, 2, 3, 5],
 *   [3, 2, 3, 4, 4],
 *   [2, 4, 5, 3, 1],
 *   [6, 7, 1, 4, 5],
 *   [5, 1, 1, 2, 4]
 * ]
 *
 * Output:
 * [[0,4], [1,3], [1,4], [2,2], [3,0], [3,1], [4,0]]
 *
 * Author: [Your Name]
 * GitHub: [your-github-username]
 */

import java.util.*;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // Grids to track reachable cells
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 🌊 Pacific Ocean (top and left borders)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
        }

        // 🌊 Atlantic Ocean (bottom and right borders)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);
        }

        // ✅ Intersection: cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    /**
     * Depth-First Search (DFS)
     * Marks cells reachable from the ocean starting point.
     */
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Stop if out of bounds, already visited, or current cell is lower
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return;

        // Mark cell as reachable
        visited[r][c] = true;

        // Explore 4 directions
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }

    // 🔍 Test the solution
    public static void main(String[] args) {
        PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();

        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solver.pacificAtlantic(heights);
        System.out.println("Cells that can flow to both oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
