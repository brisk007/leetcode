// 并查集

/*
class Solution {

    public void union(int[] arr, int i, int j) {
        int count_i = 0, count_j = 0;
        while (arr[i] != i) {
            i = arr[i];
            count_i += 1;
        }
        while (arr[j] != j) {
            j = arr[j];
            count_j += 1;
        }
        if (count_i > count_j) {
            arr[j] = i;
        }
        else
            arr[i] = j;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;


        int[] recorder = new int[grid.length * grid[0].length];
        Arrays.fill(recorder, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    continue;
                int index = i * n + j;
                recorder[index] = index;
                if (i > 0 && recorder[index - n] != -1)
                    union(recorder, index - n, index);
                if (j > 0 && recorder[index - 1] != -1)
                    union(recorder, index - 1, index);

            }

        }
        int result = 0;
        for (int i = 0; i < recorder.length; i++) {
            if (recorder[i] == i)
                result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'1', '1', '1', '1', '0',},
//                {'1', '1', '0', '1', '0',},
//                {'1', '1', '0', '0', '0',},
//                {'0', '0', '0', '0', '0'}
//        };

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        grid = new char[][]{{'1'}, {'1'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));

    }
   
}
*/


// dfs

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        M = grid.length;
        N = grid[0].length;
        int ans = 0;
        
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (grid[i][j] == '1'){
                    ans ++;
                    dfs(i, j, grid);
                } 
            }
        }
        return ans;
    }
    
    public void dfs(int x, int y, char[][] grid){
        if (x >= 0 && y >= 0 && x < M && y < N && grid[x][y] == '1'){
            grid[x][y] = '2';
            dfs(x - 1, y, grid);
            dfs(x + 1, y, grid);
            dfs(x, y - 1, grid);
            dfs(x, y + 1, grid);
        }
    }
}



