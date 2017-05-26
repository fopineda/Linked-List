package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
	  
//	  pinedasTests();
//	  testsForLIST();
    test1();
//    test2();
  }
  

  public static void test1(){
    LinkedListImpl L= new LinkedListImpl();
    System.out.println(L.isEmpty());
    printList(L);
    L.clear();
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.root.toString());
    L.insert(new Node(3.3),0);
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.root.next.toString());
    L.insert(new Node(3.4),0);
    L.insert(new Node(3.5),0);
    L.insert(new Node(3.67),1);
    L.insert(new Node(3.357),0);
    L.insert(new Node(3.333),4);
    System.out.println(L.size());
    printList(L);
    L.remove(3);
    System.out.println(L.size());
    printList(L);
    L.clear();
    L.insert(new Node(3.4),0);
    L.insert(new Node(3.5),0);
    L.insert(new Node(3.67),1);
    L.insert(new Node(3.357),0);
    L.insert(new Node(3.333),3);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }
  
  
  public static void test2(){
    LinkedListImpl L= new LinkedListImpl();
    L.insert(new Node(3.4),0);
    L.insert(new Node(3.5),1);
    L.insert(new Node(3.67),2);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }
  
  public static void pinedasTests(){
	  System.out.println("---------- Next and Prev Testing -----------------");
	  LinkedListImpl L= new LinkedListImpl();
	  printList(L);
	  
	  L.insert(new Node(3.3),0);
//	  printList(L);
	  L.insert(new Node(3.4),1);
	  L.insert(new Node(3.5),2);
//	  printList(L);
	  L.insert(new Node(2.9),1);
//	  printList(L);
	  L.insert(new Node(3.9), 0);
//	  printList(L);
	  L.insert(new Node(4.0), 4);
//	  printList(L);
	  L.insert(new Node(4.1), 1);
	  L.insert(new Node(4.2), 2);
	  L.insert(new Node(4.3), 3);
//	  printList(L);
	  L.insert(new Node(20.0), 6);
	  L.insert(new Node(55.3), -100);  // should return false and not put anything in the Linked List because index < 0
	  L.insert(new Node(50.0), 11); // should return false and not put anything in the Linked List 
	  L.insert(new Node(50.0), 50); // should return false and not put anything in the Linked List
	  printList(L);
	  
	  // allows you to check a node's prev and next (basically allowing you to see what the specified node is connected to).
	  int indexer = 2;
	  System.out.println(L.get(indexer));
	  System.out.println("Next: "+L.get(indexer).next);
	  System.out.println("Prev: "+L.get(indexer).prev);
	  
	  
	  System.out.println("\n------------- Clear Tests------------------");
	  System.out.println("IsEmpty before clear(): " + L.isEmpty());
	  L.clear();
	  printList(L);
	  System.out.println("IsEmpty after clear(): " + L.isEmpty());
	  
	  
	  System.out.println("\n--------- Remove Tests ------------------");
	  LinkedListImpl R = new LinkedListImpl();
	  R.insert(new Node(10), 0);
	  R.insert(new Node(20), 1);
	  R.insert(new Node(30), 2);
	  R.insert(new Node(40), 3);
	  R.insert(new Node(50), 4);
	  R.insert(new Node(60), 5);
	  printList(R);
	 /*
	  * Be careful with the println() statements below
	  * they will crash if indexForRemove is last index of 
	  * the List (because it'll be getting something that has been removed), 
	  * or bigger than size of list. 
	  */
	  int indexForRemove = 2;
	  R.remove(indexForRemove);
	  printList(R);
//	  System.out.println(R.get(indexForRemove)); // null if indexForRemove > size ---- or < 0
//	  System.out.println("Prev: "+R.get(indexForRemove).getPrev());  // Error if indexForRemove > size or getting a node that is not there.
//	  System.out.println("prev.next: " + R.get(indexForRemove).getPrev().getNext());  // Error if indexForRemove > size or getting a node that is not there.
  }
  
  
  public static void testsForLIST(){
	  sizeTests();
	  insertTests();
	  removeTests();
	  clearTests();
	  everythingTests();
  }
  
  public static void everythingTests(){
	  System.out.println("--------- Everything Tests --------------");
	  LinkedListImpl list1 = new LinkedListImpl();
	  list1.insert(new Node(3), 0);
	  list1.insert(new Node(2.0), 1);
	  list1.insert(new Node(1.0), 2);
	  list1.remove(0);
	  list1.clear();
	  list1.insert(new Node(3), 0);
	  list1.insert(new Node(2), 1);
	  list1.insert(new Node(1), 0);
	  list1.remove(2);
	  System.out.println(list1.size());
	  
	  LinkedListImpl list2 = new LinkedListImpl();
	  list2.insert(new Node(3), 0);
	  list2.insert(new Node(2.0), 1);
	  list2.insert(new Node(1.0), 2);
	  list2.remove(0);
	  list2.clear();
	  list2.insert(new Node(3), 0);
	  list2.insert(new Node(2), 1);
	  list2.insert(new Node(1), 0);
	  list2.remove(2);
	  printList(list2);
  }
  
  public static void sizeTests(){
	  System.out.println("--------- Size Tests ----------------");
	  
	  LinkedListImpl S = new LinkedListImpl();
	  System.out.println(S.size());
	  
	  S.insert(new Node(45.0), 0);
	  System.out.println(S.size());
	  S.clear();
	  
	  S.insert(new Node(3), 0);
	  S.insert(new Node(2.0), 1);
	  S.insert(new Node(1.2), 2);
	  S.remove(0);
	  System.out.println(S.size());
	  S.clear();
	  
	  S.insert(new Node(3), 0);
	  S.insert(new Node(2.0), 1);
	  S.clear();
	  System.out.println(S.size());
  }
  
  public static void insertTests(){
	  System.out.println("--------- Insert Tests --------------");
	  LinkedListImpl I = new LinkedListImpl();
	  I.insert(new Node(3), 0);
	  I.insert(new Node(5), 1);
	  I.insert(new Node(6), 2);
	  I.insert(new Node(4), 1);
	  printList(I);
	  I.clear();
	  
	  I.insert(new Node(3), 0);
	  I.insert(new Node(5), 0);
	  I.insert(new Node(6), 0);
	  I.insert(new Node(4), 3);
	  printList(I);
	  I.clear();
	  
	  I.insert(new Node(3), 0);
	  I.insert(new Node(5), 1);
	  I.insert(new Node(6), 2);
	  I.insert(new Node(4), 3);
	  printList(I);
	  I.clear();
	  
	  boolean didItWork = I.insert(new Node(3), 1);
	  printList(I);
	  System.out.println("Is Empty: " + I.isEmpty());
	  System.out.println(didItWork);
  }
  
  public static void removeTests(){
	  // Probably require you to uncomment the removes that you want.
	  System.out.println("--------- Remove Tests --------------");
	  LinkedListImpl R2 = new LinkedListImpl();
	  R2.insert(new Node(3), 0);
	  R2.insert(new Node(5), 1);
	  R2.insert(new Node(6), 2);
	  R2.insert(new Node(4), 1);
	  printList(R2);
	  R2.remove(2);
//	  R2.remove(3);
//	  R2.remove(0);
//	  R2.remove(3);    // ???
	  printList(R2);
  }
  
  public static void clearTests(){
	  System.out.println("--------- Clear Tests --------------");
	  LinkedListImpl C = new LinkedListImpl();
	  
	  C.insert(new Node(3), 0);
	  C.clear();
	  C.insert(new Node(5), 0);
	  C.insert(new Node(6), 1);
	  C.insert(new Node(4), 0);
	  printList(C);
	  C.clear();
	  
	  System.out.println(C.isEmpty());
	  C.clear();
	  C.insert(new Node(3), 0);
	  C.insert(new Node(5), 0);
	  C.insert(new Node(6), 1);
	  C.clear();
	  C.insert(new Node(4), 0);
	  printList(C);	  
  }
  
  public static void printList(LinkedListImpl L){ //note that this is a good example of how to iterate through your linked list
    Node curr=L.root;
    for(int i=-1; i<L.size(); i++) { //-1 b/c the 0th node in list is the one after root. Root is just the entry point!
      System.out.print(curr.data+" --> ");
      curr=curr.next;
    }
    System.out.println();
  }
}