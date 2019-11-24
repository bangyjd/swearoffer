/**
 * 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 思路：该题与在二位数组（矩阵）中找路径的方法的是一样的，我们采用回溯法可以解决
 */

public class RobotMove_13 {

    /**
     * @param threshold 上限值
     * @param rows      矩阵的行数
     * @param cols      矩阵的列数
     * @return 返回能够到达的格子数
     */
    public int movingCount(int threshold, int rows, int cols) {

        //判断特殊情况
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        //为了不重复记录格子定义一个记录每个格子的标记数组
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);

        visited = null; //将visited赋为空，方便垃圾回收
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

        int count = 0;//定义计数变量

        //定义check方法，只要满足相加的条件小于上限值就加1；
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }

        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row)+getDigitSum(col) <= threshold && !visited[row*cols+col]){
            return true;
        }

        return false;
    }

    private int getDigitSum(int number) {

        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

}
