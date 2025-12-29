package VideoZuo38;

public class MyPract_LeetCode_25 {
	class ListNode{
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int val){this.val=val;}
		ListNode(int val,ListNode next){this.val=val;this.next=next;}
	}
	//k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        for(int i=0;i<k;i++){
            if(cur==null) return head;
            cur=cur.next;
        }
        ListNode pre=reverseKGroup(cur,k);
        cur=head;
        ListNode temp=null;
        for(int i=0;i<k;i++){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
