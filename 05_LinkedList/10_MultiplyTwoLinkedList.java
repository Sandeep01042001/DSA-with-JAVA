import java.util.*;   /*  https://course.acciojob.com/idle?question=63357edf-db57-4f72-bf2f-9dfa416884d7  */
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
        Node head=null;
        Node phead=null;
        int n=sc.nextInt();
        while(n-->0){
            int n1=sc.nextInt();
            if(head==null)
                head=new Node(n1);
            else
                addHead(head,n1);
        }
        int m=sc.nextInt();
        while(m-->0){
            int n1=sc.nextInt();
            if(phead==null)
                phead=new Node(n1);
            else{
                addHead(phead,n1);
            }
        }
		Solution g=new Solution();
        System.out.println(g.multiplyLists(head,phead));
	}
   
    public static void addHead(Node node,int a) {
          if (node == null)
            return;
		if(node.next==null)
			node.next=new Node(a);
		else
			addHead(node.next,a);
	}
}

class Solution{
   public static final int MOD = 1000000007;
   public long multiplyLists(Node l1,Node l2){
         long num1 = convertListToNumber(l1);
       long num2 = convertListToNumber(l2);
       return (num1 * num2) % MOD;
   }
    public long convertListToNumber(Node node) {
       long num = 0;
       while (node != null) {
           num = (num * 10 + node.data) % MOD;
           node = node.next;
       }
       return num;
   }
}
