package excercise;

public class Matrix {
    int[][] arr;
    private int[][] data;

    public Matrix(int[] array, int index, int row, int column) {
        arr = new int[row][column];
        // row
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = array[index++];
            }
        }
    }

    public Matrix(int[][] arr) {
        this.arr = arr;

    }

    public static Matrix sum(Matrix mA, Matrix mB) {
        int[][] retarr = new int[mA.arr.length][mA.arr[0].length];
        for (int i = 0; i < retarr.length; i++) {
            for (int j = 0; j < retarr[0].length; j++) {
                retarr[i][j] = mA.arr[i][j] + mB.arr[i][j];
            }
        }
        return new Matrix(retarr);
    }

    public static Matrix multiple(Matrix mA, Matrix mB) {
        int[][] retarr = new int[mA.arr.length][mA.arr[0].length];
        for (int i = 0; i < retarr.length; i++) {
            for (int j = 0; j < retarr[0].length; j++) {
                retarr[i][j] = mA.arr[i][j] * mB.arr[i][j];
            }
        }
        return new Matrix(retarr);
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
