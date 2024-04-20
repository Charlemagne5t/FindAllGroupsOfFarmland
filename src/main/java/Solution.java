import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> res = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] coords = new int[4];
                    coords[0] = i;
                    coords[1] = j;
                    coords[2] = i;
                    coords[3] = j;
                    for (int k = i; k < m; k++) {
                        if (land[k][j] == 0) {
                            break;
                        }
                        for (int l = j; l < n; l++) {
                            if (land[k][l] == 1) {
                                land[k][l] = 0;
                                coords[2] = k;
                                coords[3] = l;
                            } else break;
                        }

                    }
                    res.add(coords);
                }
            }
        }
        int size = res.size();
        if (size == 0) {
            return new int[][]{};
        } else {
            int[][] arr = new int[size][4];
            for (int i = 0; i < size; i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }
}