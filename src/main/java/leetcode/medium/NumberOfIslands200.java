package leetcode.medium;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/08/16:45
 * @Description: 岛屿问题
 * <p>
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 */

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */

/**
 * 解答
 * 题解：首先需要明确的就是岛屿有可能是一个陆地，也有可能是多个陆地组成的，
 * 也就是说陆地的上下左右（或者的关系）连接陆地那就是组成一块岛屿。
 * 然后使用DFS进行解题
 * DFS是针对数或者图提出来的一种算法，可以借助这种算法实现在表格（把二维数组想象成一个横竖坐标的表格）里面的遍历。
 * DFS需要考虑到两点：1、访问相邻节点。2、判断边界条件，也可以说是不需要遍历的节点。
 * 对表格建立直角坐标系，设某一个陆地的坐标为（x,y），针对第一点：与它相邻的上下左右四个坐标分别为（x+1,y）、（x-1,y）、（x,y-1）、（x,y+1）；
 * 针对第二点：其实就是grid[x][y]出现数组下标越界的节点
 * 解决了上面这两个问题，还有一点需要注意，因为没有对遍历过的节点做任何的处理，也就是重复遍历的问题，
 * 这个问题可以对遍历过的1（陆地）进行标记，标记为2，以后遇到2直接过去，不做count++操作
 *
 *
 */
public class NumberOfIslands200 {

    public static void main(String[] args) {
        char[][] gird = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int s = 11;
        System.out.println(sumIslandsTest(gird, s));
    }

    public static int sumIslandsTest(char[][] grid, int s) {
        int count = 0;
        int sumIs = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    sumIs++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        //System.out.println("--"+sumIs);
        return sumIs == s ? count : 0;
    }

    static void dfs(char[][] grid, int x, int y) {
        // 判断边界条件
        if (inGird(grid, x, y)) {
            return;
        }
        // 如果不是陆地立即返回，下一轮遍历的时候遍历过的已经标记为2
        if (grid[x][y] != '1') {
            return;
        }
        // 下一轮遍历的时候遍历过的标记为2
        grid[x][y] = '2';
        // 遍历上下左右四个相邻节点
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }

    // 判断坐标（x,y）是否在表格中
    static boolean inGird(char[][] grid, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
