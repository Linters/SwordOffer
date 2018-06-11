package cn.linter.offer;

/**
 * 面试题9-1：
 *      写一个函数 ， 输入n， 求斐波那契数列的第n项。
 *
 *      f(n)={
 *          0               (n=0)
 *          1               (n=1)
 *         f(n-1)+f(n-2)    (n>1)
 *      }
 *
 * Created by linCQ on 2018/5/9.
 */
public class Fibonacci {

    public static void main(String... args) {
        int n = 39;
        System.out.println(fibonacci(n));
//        System.out.println(fibonacci2(n));
    }

    /**
     * 递归法：
     * 缺点：每一次递归都重复计算   n值越大 所需要的时间也就越大 。
     *
     */
    public static long  fibonacci(int n) {
        if (n <=0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /**
     * 直接循环法：从下往上计算  先根据 f(0) , f(1) 算出f(2)
     * 时间复杂度：O(n)
     */
    public static long fibonacci2(int n) {
        if (n == 0)
            return 0;
        if (n==1)
            return 1;

        long f1 = 0, f2 = 1;
        long f = 0;

        for (int i = 2; i <= n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
