package cn.linter.offer;

/**
 * linCQ
 */
public class FindInPartiallySortedMatrix {

    // 面试题3：二维数组中的查找
    // 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
    // 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
    // 整数，判断数组中是否含有该整数。
    public static void main(String... args) {

        int[][] matix = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8}
        };

        System.out.println(find1(matix, 9));

    }

    public static boolean find1(int[][] matrix, int target) {
        boolean found = false;

        if (matrix != null) {
            int rows = matrix.length;           //行数
            int cols = matrix[0].length;        //列数

            int row = 0;
            int col = cols - 1;
            // (row,col)  矩阵右上角元素

            while (row < rows && col > 0) {
                if (matrix[row][col] == target) {
                    found = true;
                    break;
                } else if (matrix[row][col] > target) {
                    --col;
                } else {
                    ++row;
                }
            }
        }

        return found;
    }
}
