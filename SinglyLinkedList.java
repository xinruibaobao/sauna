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
			Node p = head;
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
                        	p = p.getNextNode()；
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
		Node p = headNode;
		
		if(headNode.getValue==value) {
			headNode = headNode.getNextNode();
		} else {
			while(p!=null && p.getNextNode().getValue()!=value) {
                        	p = p.getNextNode();
                	}
			
			if(p == null) {
				return;
			}

			p.setNextNode(p.getNextNode().getNextNode());
		}
	}

	public class Node {

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

		public Node setNextNode(Node node) {
			nextNode = node;
		}
	}
}
