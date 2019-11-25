/**
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * <p>
 * 思路：把原数字减1后，与原数字作与运算，就是把原数字的最右一位的1变为0，做了多少此运算，就是有多少个1
 */

public class NumberOf1InBinary_15 {

    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
