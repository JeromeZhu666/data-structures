package xin.jerome.datastructures.leetcode;

import xin.jerome.datastructures.leetcode.common.ListNode;

/**
 * 移除链表元素:
 * <br>删除链表中等于给定值 val 的所有节点。
 * <br>示例:
 * <br>输入: 1->2->6->3->4->5->6, val = 6
 * <br>输出: 1->2->3->4->5
 *
 * @author Jerome Zhu
 * @since 2019.06.04 15:15
 */
public class LeetCode0203 {

    /**
     * 删除链表中值等于 val 的所有节点
     *      解决思路假设一个虚拟头结点，用虚拟头结点去遍历。
     *
     * @param head 待检查链表
     * @param val  给的的值
     * @return 处理后的链表
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode resultNode = preNode;

        // 没有处理删除节点  从链表中断开     2 ms	42.9 MB
//        while (preNode.next != null) {
//            if (preNode.next.val == val) {
//                preNode.next = preNode.next.next;
//            } else {
//                preNode = preNode.next;
//            }
//        }
        // 优化了已删除节点  从链表中断开     2 ms	38.4 MB
        while (preNode.next != null) {
            ListNode delNode = preNode.next;
            if (delNode.val == val) {
                preNode.next = delNode.next;
                delNode.next = null;
            } else {
                preNode = delNode;
            }
        }
        return resultNode.next;
    }

    /**
     * 删除链表中值等于 val 的所有节点
     *      解决思路  没有虚拟头结点，先处理头结点然后再去遍历。
     *
     * @param head 待检查链表
     * @param val  给的的值
     * @return 处理后的链表
     */
    public ListNode removeElements1(ListNode head, int val) { // 2 ms	42.4 MB
        ListNode delNode;
        while (head != null && head.val == val) {
            delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        if (head == null)
            return null;
        ListNode preNode = head;
        while (preNode.next != null) {
            delNode = preNode.next;
            if(delNode.val == val) {
                preNode.next = delNode.next;
                delNode.next = null;
            } else {
                preNode = delNode;
            }
        }

        return head;
    }

}
