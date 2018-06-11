package cn.linter.offer;

/**
 * 面试题10：二进制中的1的个数
 * 请实现一个函数，速输入一个整数，输出该数二进制表示中1的个数。例如： 9 1001， 有两位二进制数
 * Created by linCQ on 2018/5/29.
 */
public class NumberOf1InBinary {


    public static void main(String... args) {

//        System.out.println(numberOf1Demo1(0x80000000));
        System.out.println(numberOf1Demo2(0x80000000));
        System.out.println(numberOf1Demo3(0x80000000));


    }

    /**
     * 思路：先判断整数 二进制最后一位是否是1 是1就++ ，接着把整数右移动一位。
     * 右移动之后，原先第二位的数已经变到最右。
     * 最后一位 依此与 1做与运算& 直到整数为0
     * <p>
     * 缺点 ：负数会造成死循环。  例如：0x800000000 ==  - 2<<31.
     */
    public static int numberOf1Demo1(int n) {
        int count = 0;

        while (n != 0) {
            //每次判断 n的二进制数表示 最后一位是否为 1是就count++
            if ((n & 1) != 0) {
                count++;
            }

            //每次判断完都将n右移一位。因为我们已经判断过。
            n = n >> 1; // 右移动一位
        }


        return count;
    }

    /**
     * 对第一种方式 进行改进。  不对n做右移操作，每次对flag起始值为1 做左移操作。
     * 优点： 解决了负数的死循环问题
     * 缺点： int值 32位  ，需要做32次计算。
     */
    public static int numberOf1Demo2(int n) {
        int count = 0;
        int flag = 1;

        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }


    /**
     * 思路：将一个整数减去1 再与原来的数进行 与运算   目的就是消去 原来数中的最右边的1  使其变为0
     * 最优方式： n中有几个1 就做循环几次。
     */
    public static int numberOf1Demo3(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            //n:
            //0100  ==> 4
            //0011  ===> 4-1=3
            //0000  ===> 0
            n = n & (n - 1);
        }

        return count;

    }
}
