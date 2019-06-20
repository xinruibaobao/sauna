public class SinglyLinkedList {

	private Node headNode;

	public void  setHeadNode(Node node) {
		headNode = node;
	}

	public Node  getHeadNode(){
		return headNode;
	}

	public Node findByValue(int value) {
		Node node = headNode;
		while(node!=null && node.getValue()!=value) {
			node = node.getNextNode();
		}
		return node;
	}

	public Node findByIndex(int index) {
		Node node = headNode;
		int i=0;
		while(node!=null && i!=index) {
			node = node.getNextNode();
			i++;
		}
		
		return null;
	}

	public void insertToHead(Node node){
		if(headNode == null) {
			headNode = node;
                } else {
			Node miNode = headNode;
		        headNode = node;
			headNode.setNextNode(miNode);
		}
	}

	public void insertToTail(Node node) { 
		if(headNode == null){
			headNode = node;
		} else {
			Node p = headNode;
			while(p.getNextNode()!=null){
				p = p.getNextNode();
			}
			node.setNextNode(p.getNextNode());
			p.setNextNode(node);
		}
	}


	public void insertAfter(Node node,Node aferNode){
		if(node==null || aferNode==null) {
			return;
		}

		node.setNextNode(aferNode.getNextNode());
		aferNode.setNextNode(node);

	}


	public void insertBefore(Node node,Node beforeNode){
		if(node == null || beforeNode == null) {
			return;
		}

		Node p = headNode;

		if(beforeNode == headNode) {
			headNode = node;
			headNode.setNextNode(p);	
		} else {
			while(p!=null && p.getNextNode()!=node) {
                        	p = p.getNextNode();
                	}
			
			if(p== null) {
				return;
			}
	
			node.setNextNode(p.getNextNode());
                        p.setNextNode(node);
			
		}
	}
	
	public void deleteByNode(Node node){
		Node p = headNode;
		if(node == headNode) {
			headNode = headNode.getNextNode();
		} else {
			while(p!=null && p.getNextNode()!=node) {
				p = p.getNextNode();
			}
			
			if(p == null) {
				return;
			}

			p.setNextNode(p.getNextNode().getNextNode());
		}
	}


	public void deleteByValue(int value) {
		if(headNode==null) {
			return;
		}
		Node p = headNode;
		
		if(headNode.getValue()==value) {
			headNode = headNode.getNextNode();
		} else {
			while(p!=null &&  p.getNextNode()!=null && p.getNextNode().getValue()!=value) {
                        	p = p.getNextNode();
                	}
			
			if(p == null) {
				return;
			}

			p.setNextNode(p.getNextNode().getNextNode());
		}
	}

	public void printAll(){
		Node p = headNode;
		while(p!=null) {
			System.out.println(p.getValue());
			p=p.getNextNode();
		}
	}



	public boolean palindrome() {
		
		if(headNode==null) {
			return false;	
		}
		
		Node fastNode = headNode;
		Node lowNode = headNode;
		Node pre = null;

		//到中间节点，以及下一个节点
		while(fastNode!=null && fastNode.getNextNode()!=null) {
			fastNode = fastNode.getNextNode().getNextNode();
			pre = lowNode;
			lowNode =lowNode.getNextNode();
		}

		System.out.println("fast node:"+(fastNode==null?"null":fastNode.getValue()));
		System.out.println("pre node:" + (pre==null?"null":pre.getValue()));
		System.out.println("low node:" + (lowNode==null?"null":lowNode.getValue()));

		if(pre == null) {
			return true;
		}

		//反转节点
		inverse(pre);		


		boolean result = false;

		if(fastNode==null) {  //双数
         result = compareLinkList(pre,lowNode);
		} else {
         result = compareLinkList(pre,lowNode.getNextNode());
		}

		return result;
	  
	}

	private void inverse(Node node) {
				Node p = headNode;
				Node pre = null;
				while(p!=null) {
					 Node next=p.getNextNode();
					 p.setNextNode(pre);
					 pre = p;
					 p = next;
					 
					 if(pre==node){
					 	break;	
					}
					 
				}			
	}
	
	private boolean compareLinkList(Node a,Node b) {
				boolean result = true;
				while(a!=null && b!=null) {
					System.out.println("a 节点:"+a.getValue());
	        System.out.println("b 节点:"+b.getValue());
					
					if(a.getValue()!=b.getValue()) {
						result = false;
						break;
					}
					
					a = a.getNextNode();
					b = b.getNextNode();
				}
		
				if(a!=null|| b!=null){
					result = false;
				}
		
				return result;
	}


	public static class Node {

		private int value;

		private Node nextNode;

		public void setValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public Node  getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node node) {
			nextNode = node;
		}
	}
	
	public static void main(String args []) {
			SinglyLinkedList ss = new SinglyLinkedList();
			//Node headNode = new Node();
			//headNode.setValue(1);
			//Node node1 = new Node();
			//node1.setValue(2);
			//Node node2 = new Node();
      //node2.setValue(3);
		  //Node node3 = new Node();
			//node3.setValue(2);
			//Node node4 = new Node();
			//node4.setValue(1);
			
			//headNode.setNextNode(node1);
			//node1.setNextNode(node2);
			//node2.setNextNode(node3);
			//node3.setNextNode(node4);
			
			//ss.setHeadNode(headNode);
			ss.printAll();
			
		  System.out.println(ss.palindrome());
			
	}
	
	
}
