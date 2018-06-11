package cn.linter.offer;

/**
 * 面试题：9-2
 *      一只青蛙一次可以跳1级台阶 ，也可以跳2级台阶 。求该青蛙跳上一个n级别台阶有几种条法。
 * Created by linCQ on 2018/5/9.
 */
public class Fibonacci_2 {


    public static void main(String... args) {


    }

    /**
     * 思路 ：
     * 一级阶梯的时候 只有一种走法 跳一步   n=1  跳法：1
     * 2级阶梯的时候 两种走法 1。一次跳1步和一级跳两步 2.先跳两步，再跳一步。   n=2  跳法：2
     * 以此类推   n=3之后   跳法：f（n-1）+f（n-2）   3
     */
    private static int JumpFloor(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return JumpFloor(n - 1) + JumpFloor(n - 2);
    }


}
