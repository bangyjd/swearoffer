import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * <p>
 * 方法：回溯法、适合用递归抵达下一个节点
 * <p>
 * 思路：首先定义到任意一格，从这一格开始沿着上下左右分别找到给定字符串的下一字符，如果满足要求就
 * 一直向下找，如果不满足要求，就返回上一节点，如果都不满足就说明该矩阵没有符合要求的字符串
 */
public class StringPathInMatrix_12 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //定义边界条件，只要这其中有一个条件为真就为假，即找不到相关的字符串
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //创建一个bool类型的数组来定位该位置是否已经走过了，因为题目说不能走已经走过的路
        Boolean[] visited = new Boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        //定义一个到达的长度的位置记录变量
        int pathLength = 0;
        //遍历数组，找到一开始的字符
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        visited = null;
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, Boolean[] visited) {
        //如果找到的长度的字符串与字符数组的长度相等就说明已经在这个矩阵中找到了该字符串
        if (pathLength == str.length) {
            return true;
        }
        //定义一个标志，表示是否存在该字符的路径
        boolean hasPath = false;
        //如果if中的条件都为真，说明已经找到对应的字符串，就把路径的长度加1，并把这一位置标记为已经达到过了，即true。
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;

            //此时就找下一深度的字符，分别从上下左右的四个方向寻找，由于是相同的操作的我们采用递归的方法
            //如果能从这四个方位中找到这个字符就将说明存在该路径的字符，就将hsaPath赋值为true。
            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);

            //如果一旦找不到下一路径的对应字符，将路径pathLength定位到上一节点重新开始找，并把已经到达的位置
            //的标记重设为false
            if (!hasPath){
                pathLength--;
                visited[row * cols + col] = false;
            }

        }
        return hasPath;
    }
}
