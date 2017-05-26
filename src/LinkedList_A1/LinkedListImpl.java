/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node root;   //this will be the entry point to your linked list (the head)
  int theSize = 0;
  Node lastNode;
  
  public LinkedListImpl(){  //this constructor is needed for testing purposes. Please don't modify!
    root = new Node(0);  //Note that the root's data is not a true part of your data set!
  }
  
  public Node getRoot(){  //leave this method as is, used by the grader to grab your linkedList easily.
    return root;
  }

	@Override
	public boolean insert(Node n, int index) {
		// just test for if the new node is connect to the next node and previous node
		boolean retVal;
		
		if ( (this.isEmpty() == true) ){   // Inserting and Linked List is empty
			if (index > size() || index < 0){	// if the Linked List is empty and trying to insert at a position that does not exist in the Linked List
				retVal = false;
			}
			else{					// If the Linked List is empty and trying to insert first element
				getRoot().next = n;
				n.prev = getRoot();
				theSize++;
				retVal = true;
			}
		}
		else if (index == 0){  // inserting at the beginning
			Node targetNode = this.get(index);
			getRoot().next = n;
			n.prev = getRoot();
			n.next = targetNode;
			targetNode.prev = n;
			theSize++;
			retVal = true;
		}
		else if (index == size()){  // inserting at the end
			Node beforeNode = this.get(index-1);
			beforeNode.next = n;
			n.prev = beforeNode;
			theSize++;
			retVal = true;
		}
		else if (index > theSize || index < 0){     // Return false if trying to insert at a position that does not exist in the Linked List
			retVal = false;
		}
		
		else{  // Inserting in middle of the linked list.
			Node targetNode = this.get(index);
//			Node beforeNode = this.get(index-1);
			Node beforeNode = targetNode.getPrev();
			beforeNode.next = n;
			n.prev = beforeNode;
			n.next = targetNode;
			targetNode.prev = n;
			theSize++;
			retVal = true;
		}
//		System.out.println(retVal); // DELETE LATER 
		return retVal;
	}
	
	@Override
	public boolean remove(int index) {
		// test if the targetNode is disconnect from the code and if the node taking its place is connect to that the targetNode was connected to.
		boolean retVal;
		if (index ==  (size()-1)){  // removing last element
			Node targetNode = this.get(index);
			Node beforeNode = targetNode.getPrev();
			targetNode.prev = null;
			beforeNode.next = null;
			theSize--;
			retVal = true;
		}
		
		else if (index >= size() || index < 0){
			retVal = false;
		}
		
		else {
			Node targetNode = this.get(index);
			Node beforeNode = targetNode.getPrev();
			Node afterNode = targetNode.getNext();
			beforeNode.next = afterNode;
			afterNode.prev = beforeNode;
			targetNode.prev = null;
			targetNode.next = null;
			targetNode = null;
			theSize--;
			retVal = true;
			
		}
//		System.out.println(retVal);   // DELETE LATER
		return retVal;
	}
	
	// [DONE]
	@Override
	public Node get(int index) {
		Node currentNode = getRoot().next;
		if (this.isEmpty() || index < 0 || index >= size()){
			currentNode = null;
		}
		else {
			for (int i = 0; i < index; i++){
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}
	
	// [Done]
	@Override
	public int size() {
		return theSize;
	}
	
	// [DONE]
	@Override
	public boolean isEmpty() {
		boolean retValue = false;
		if (size() == 0){
			retValue = true;
		}
		return retValue;
	}
	
	// [DONE]
	@Override
	public void clear() {
		if (this.isEmpty() == false){      // not empty
			Node firstNode = this.getRoot().next;
			firstNode.prev = null;
			this.getRoot().next = null;
			theSize = 0;
		}
		
	}
}
