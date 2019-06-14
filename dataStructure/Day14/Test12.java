package day14;
/**
 * @Description: 以x为界输出链表（左边比x小右边比x大或等于）
 * @Author: zdd
 * @Date: 2019/6/11
 */

class Partition {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        ListNode minHead = null;
        ListNode minTail = null;
        ListNode maxHead = null;
        ListNode maxTail = null;
        while (pHead != null) {
            ListNode next = pHead.next;
            pHead.next = null;
            if (pHead.val < x){
                if (minHead==null){
                    minHead = pHead;
                    minTail = minHead;
                }else {
                    minTail.next = pHead;
                    minTail = pHead;
                }
            }else {
                if (maxHead==null){
                    maxHead = pHead;
                    maxTail = maxHead;
                }else {
                    maxTail.next = pHead;
                    maxTail = pHead;
                }
            }
            pHead = next;
        }
        if (minHead==null){
            return maxHead;
        }else {
            minTail.next = maxHead;
            return minHead;
        }
    }
}