/**
 * 面试题14：剪绳子
 * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 *
 * 方法：动态规划 和 贪婪算法
 */

public class CuttingRope_14 {

    //动态规划

    /**
     * @param length 绳子的长度
     * @return 绳子被剪短后的最大乘积
     */
    public int maxProductAfterCutting_solution1(int length){

        if (length < 2){
            return 0;
        }

        if (length == 2){
            return 1;
        }

        if (length == 3){
            return 2;
        }

        //建立一维数组将每次剪断后还剩下的长度能得到的最大乘积。
        int[] products = new int[length+1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;

        for (int i = 4; i <= length; i++) {

            max = 0;
            //这次循环能保证该长度的绳子能计算各种情况下的乘积并取得最大值
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (max < product){
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        products = null;

        return max;
    }

    //贪婪算法
    public int maxProductAfterCutting_solution2(int length){
        if (length < 2){
            return 0;
        }

        if (length == 2){
            return 1;
        }

        if (length == 3){
            return 2;
        }

        //尽可能多的减去长度为3的绳子段
        int timeOf3 = length/3;

        //当绳子最后剩下长度为4的时候不能再减去3的长度，而需要减去2的长度
        //因为2*2>3*1
        if (length - 3*timeOf3 == 1){
            timeOf3 -= 1;
        }

        int timeOf2 = (length - 3*timeOf3)/2;

        return (int)(Math.pow(3,timeOf3)) * (int)(Math.pow(2,timeOf2));
    }

}
