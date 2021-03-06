package InterviewGuildCode.List;


/**
 * 在单链表和双链表中删除倒数第K个节点
 *要求：链表长度为N，时间复杂度为O（N）,额外空间复杂度O（1）
 * 思路：
 * 1
 */
public class Problem_02_RemoveLastKthNode {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node removeLastKthNode(Node head,int lastKth){
        if(head ==null || lastKth <1){
            return head;
        }
        Node cur = head;
        while(cur!=null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth ==0){
            head = head.next;
        }
        if(lastKth<0){
            cur = head;
            while(++lastKth!=0){
                cur = cur.next;
            }
            cur.next =cur.next.next;
        }
        return head;
    }

    public static class BinaryNode{
        public int value;
        public BinaryNode last;
        public BinaryNode next;

        public BinaryNode(int value){
            this.value= value;
        }
    }

    public static BinaryNode removeLastKthNode(BinaryNode head,int lastKth){
        if(head==null||lastKth<1){
            return head;
        }
        BinaryNode cur =head;
        while(cur!=null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth==0);{
            head = head.next;
            head.last = null;
        }
        if(lastKth<0){
            cur = head;
            while(++lastKth!=0){
                cur= cur.next;
            }
            BinaryNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext!=null){
                newNext.last = cur;
            }
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(BinaryNode head) {
        System.out.print("Double Linked List: ");
        BinaryNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        head1 = removeLastKthNode(head1, 3);
        // head1 = removeLastKthNode(head1, 6);
        // head1 = removeLastKthNode(head1, 7);
        printLinkedList(head1);

        BinaryNode head2 = new BinaryNode(1);
        head2.next = new BinaryNode(2);
        head2.next.last = head2;
        head2.next.next = new BinaryNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new BinaryNode(4);
        head2.next.next.next.last = head2.next.next;
        head2.next.next.next.next = new BinaryNode(5);
        head2.next.next.next.next.last = head2.next.next.next;
        head2.next.next.next.next.next = new BinaryNode(6);
        head2.next.next.next.next.next.last = head2.next.next.next.next;
        printDoubleLinkedList(head2);
        head2 = removeLastKthNode(head2, 3);
        // head2 = removeLastKthNode(head2, 6);
        // head2 = removeLastKthNode(head2, 7);
        printDoubleLinkedList(head2);

    }

}
