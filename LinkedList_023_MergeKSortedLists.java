import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 *  Merge k sorted linked lists and return it as one sorted list.
 *  Analyze and describe its complexity. 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedList_023_MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists==null||lists.isEmpty())
			return null;
		PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(
				lists.size(),new Comparator<ListNode>(){
					public int compare(ListNode l1,ListNode l2){
						if(l1.val<l2.val)	
							return -1;
						else if(l1.val>l2.val)	
							return 1;
						else 	
							return 0;
					}
				}
				);
		for(ListNode node:lists){
			if(node!=null){
				heap.add(node);
			}
		}
		ListNode head=null,cur=null;
		while(!heap.isEmpty()){
			if(head==null){
				head=heap.poll();
				cur=head;
			}else{
				cur.next=heap.poll();
				cur=cur.next;
			}
			if(cur.next!=null){
				heap.add(cur.next);
			}
		}
		return head;
    }
}
