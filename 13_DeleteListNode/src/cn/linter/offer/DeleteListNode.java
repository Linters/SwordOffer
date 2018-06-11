package cn.linter.offer;

/**
 * Created by linCQ on 2018/5/10.
 */
public class DeleteListNode {


    /**
     * 面试题13：在O(1)时间删除链表的结点
     * <p>
     * 抛给面试官的问题：要删除的结点确定在链表中。需要O(n)的时间才可以判断链表中是否包含某一个结点。
     * O(1)时间限制，不得不把确保结点在链表中的责任交给deleteNode函数的调用者去完成。
     */
    public static void main(String... args) {

        // 1->2->3->4
        ListNode listhead = createList();

        ListNode toBeDeteleNode = searchNode(listhead, 1);

//        deleteListNode(listhead, toBeDeteleNode);

        test2();
//
//        System.out.println("需要删除的结点：" + toBeDeteleNode);
//        System.out.println("删除之后的链表情况： " + listhead);
//        printList(listhead);

    }

    /**
     * 测试用例1：从只有一个元素的链表 也就是只有头结点的链表中删除一个结点
     * list : 1
     * delete Node：1
     */
    public static void test1() {
        ListNode listNodeHead = new ListNode(1, null);
        System.out.print("输出链表:");

        deleteListNode(listNodeHead, listNodeHead);
        printList(listNodeHead);
    }

    /**
     * 测试用例2：删除非头非尾的结点
     * list: 1->2->3
     * delete:  2
     */
    public static void test2() {
        //构建链表 1，2，3
        ListNode listNodeHead = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        listNodeHead.next = node2;
        node2.next = node3;
        printList(listNodeHead);

        //查找需要删除的结点 value:2
        ListNode toBeDeleteNode = searchNode(listNodeHead, 2);

        System.out.println("ToBeDeleteNode:" + toBeDeleteNode);

        //删除
        deleteListNode(listNodeHead, toBeDeleteNode);

        //删除之后
        printList(listNodeHead);
    }

    /**
     * 测试用例3:删除尾结点
     * list: 1->2->3->4
     * delete:  3
     */
    public static void test3() {

        //构建链表 1，2，3
        ListNode listNodeHead = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        listNodeHead.next = node2;
        node2.next = node3;
        printList(listNodeHead);

        //查找需要删除的结点
        ListNode toBeDeleteNode = searchNode(listNodeHead, 2);
        System.out.println("ToBeDeleteNode:" + toBeDeleteNode);

        //删除
        deleteListNode(listNodeHead, toBeDeleteNode);

        //删除之后
        printList(listNodeHead);

    }

    public static void printList(ListNode listHead) {
        if (listHead == null) {
            return;
        }

        ListNode p = listHead;
        while (p != null) {
            System.out.print(p.value);

            p = p.next;
            if (p != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    /**
     * 构建一个链表   1->2->3->4
     */
    private static ListNode createList() {
        ListNode head = new ListNode(1, null);

        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, null);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        return head;
    }

    /**
     * 查找指定值的结点 并返回该结点
     */
    public static ListNode searchNode(ListNode listHeadNode, int value) {
        if (listHeadNode == null) {
            return null;
        }

        ListNode p = listHeadNode;
        while (p != null && p.value != value) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        return p;
    }

    /**
     * 删除结点 o(1)时间内删除 链表中的某一个结点。
     *
     * @param listHead       链表头指针
     * @param toBeDeleteNode 将要删除的结点
     */
    public static void deleteListNode(ListNode listHead, ListNode toBeDeleteNode) {
        //无表头 要删除的元素为NULL 直接返回 不做任何操作。
        if (listHead == null || toBeDeleteNode == null) {
            return;
        }

        if (toBeDeleteNode.next != null) {      //要删除的不是尾结点
            //将要删除结点的下一个结点的所有值 拷贝到要删除的结点上， 删除 要删除结点的下一个结点。
            ListNode p = toBeDeleteNode.next;
            toBeDeleteNode.value = p.value;
            toBeDeleteNode.next = p.next;

            p.next = null;
            p = null;

        } else if (listHead == toBeDeleteNode) {
            toBeDeleteNode = null;
            listHead = null;
        } else {
            //要删除的是尾结点。
            ListNode p = listHead;

            //循环找到要删除结点的前驱结点
            while (p != toBeDeleteNode) {
                p = p.next;
            }
            p.next = null;
            toBeDeleteNode = null;
        }
    }

    /**
     * 结点类
     */
    static class ListNode {
        int value;      //数据域
        ListNode next;  //指针域

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        //对象字符串表示法
        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
