// 1 class has all
class ListInter {

	// like global var
	static Node h1;
	static Node h2; 
 
	// static class in class 
    static class Node { 
		// val
        int val;
		// next 
        Node next; 
 
		// constructor 
        Node(int v) {
			// we don't call this, use straight 
            val = v;
			// we don't call this, use straight
            next = null; 
        } 
    } 

	Node getThatNode() {
		// static h1, count
		// no need this 
        int c1 = countNodeNum(h1); 
		// static h2, count
        int c2 = countNodeNum(h2);
		// diff 
        int diff; 
 
		// c1 list longer than c2 
        if (c1 > c2) {
			// get diff
            diff = c1 - c2; 
            return getJoinedNode(diff, h1, h2); 
        } else {
			// c2 longer than c1 
            diff = c2 - c1; 
            return getJoinedNode(diff, h2, h1); 
        } 
    } 

	Node getJoinedNode(int diff, Node h1, Node h2) {
		// consume
		int i;	
		// point
		Node curr1 = h1;
		// point
		Node curr2 = h2;		

		// consume all diff
		for (i = 0; i < diff; i++) {
			// to the end of list, in case 
            if (curr1 == null) { 
                return null; 
            } 
            curr1 = curr1.next; 
        } 	

		while(curr1 != null && curr2 != null) {
			if (curr1.val == curr2.val) { 
                return curr1; 
            } 
            curr1 = curr1.next; 
            curr2 = curr2.next; 
		}
	
		return null;	
	}

	int countNodeNum(Node node) {
		// point
		Node curr;
		int num = 0;		

		curr = node;
		while(curr != null) {
			// hava class
			curr = curr.next;
			num++;
		}

		return num;
	}	

	// main
	public static void main(String[] args) { 
		// itself
		ListInter list = new ListInter();

        list.h1 = new Node(3); 
        list.h1.next = new Node(6); 
        list.h1.next.next = new Node(15); 
        list.h1.next.next.next = new Node(15); 
        list.h1.next.next.next.next = new Node(30); 
  
        list.h2 = new Node(10); 
        list.h2.next = new Node(15); 
        list.h2.next.next = new Node(30); 
  
        System.out.println("The node of intersection is " + list.getThatNode().val); 
  
		
	}
}
