class Solution {
    int[] parent;
    int[] rank;
    int count;

    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int dots = rows + 1;
        parent = new int[dots * dots];
        rank = new int[dots * dots];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = i;
        }

        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == rows || j == rows) {
                    int cells = i * dots + j;
                    union(0, cells);
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            char[] ch = grid[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '\\') {
                    int cell1 = i * dots + j;
                    int cell2 = (i + 1) * dots + (j + 1);
                    union(cell1, cell2);
                } else if (ch[j] == '/') {
                    int cell1 = ((i + 1) * dots) + j;
                    int cell2 = (i * dots) + (j + 1);
                    union(cell1, cell2);
                }
            }
        }
        return count;
    }

    public void union(int x, int y) {
        int parentA = find(x);
        int parentB = find(y);
        if (parentA == parentB) {
            count++;
        } else {
            if (rank[parentA] > rank[parentB]) {
                parent[parentA] = parentB;
            } else {
                parent[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    public int find(int n) {
        if (parent[n] == n) {
            return n;
        }

        int temp = find(parent[n]);
        parent[n] = temp;
        return temp;
    }
}