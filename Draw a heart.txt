

public class  Draw a heart{
    public static void main(String[] args) {
        draw3R(5);
    }


    private static void draw3R(int n) {
        boolean[][] arr = new boolean[3 * n - 1][4 * n - 1];
        draw3(arr, 0, 0, n, true);
        draw3(arr, 0, 2 * n - 1 + 1, n, true);
        draw3(arr, n, 0, 2 * n - 1, false);
        print(arr);
    }


    private static void print(boolean[][] arr) {
        for (int i = 0; i < arr.length; i += 1) {
            for (int j = 0; j < arr[i].length; j += 1) {
                System.out.print(arr[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

    {
        for (int j = y + i + 1; j <= y + 2 * n - 1 - i; j++) {
            arr[i+x][j] = true;
        }
    }
    private static void draw3(boolean[][] arr, int x, int y, int n, boolean order) {
        for (int i = 0; i < n; i++) {
            if (order) {
                for (int j = y + (n - i - 1); j <= y + (2 * n - 1) - (n - i); j++) {
                    arr[i][j] = true;
                }
            } else {
                for (int j = y + i + 1; j <= y + 2 * n - 1 - i; j++) {
                    arr[i+x][j] = true;
                }
            }
        }
    }

}

