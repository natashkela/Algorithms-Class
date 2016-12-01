package nvacheishvili.hw2;

import edu.princeton.cs.algs4.*;

//import nvacheishvili.hw1.BinaryStringSearch;

/**
 * This data type offers Bag-like behavior with the added constraint that all elements
 * stored are guaranteed to be unique within the bag, based on the equals() method.
 *
 * In all of the performance specifications, N refers to the number of items in the 
 * UniqueBag.
 * 
 * Once you complete this implementation, you will need to provide empirical evidence 
 * to support the performance specifications of each method.
 * 
 * CHANGE LOG:
 * 1. Added logic that each Item must extend Comparable<Item>. This means that you can
 *    fully compare items with each other
 *    
 * 2. Added default constructor so you can create an empty bag more easily.
 * 
 * @param <Item>
 */
public class UniqueBag<Item extends Comparable<Item>> {

	Node first = null; //beginning of a bag
	int N; //number of elements in the bag
	/** You must use this Node class as part of a LinkedList to store the UniqueBag items. */
	class Node {
		private Item       item;
		private Node       next;
	}

	/** Default constructor to create an empty initial bag. */
	public UniqueBag() {
		first = null;
		N = 0 ; //number of elements in the bag
	}
	
	/**
	 * Initialize the bag to contain the unique elements found in the initial list.
	 * 
	 * Performance must be dependent of the number of items in initial, or ~ N.
	 */
	public UniqueBag(Item[] initial) {
		//UniqueBag<Item> bag = new UniqueBag<Item>();
		for (int i=0;i<initial.length;i++){
			this.add(initial[i]);
		}
	}
	
	/** 
	 * Return the number of items in the UniqueBag.
	 * 
	 * Performance must be independent of the number of items in the UniqueBag, or ~ 1.
	 */
	public int size() {
		return N;
	}

	/** 
	 * Determines equality with another UniqueBag objects.
	 * 
	 * Performance must be linearly dependent on the number of items in the UniqueBag, or ~ N.
	 */
	public boolean identical (UniqueBag<Item> other) {
		// Replace with your implementation
		int counter =0;
		Node current = first;
		Node bagCurrent = other.first;
		if(this.size()!=other.size()){
			return false;
		}
		else if(this==null||other==null){
			return false;
		}
		while (current!=null){
			if(current.item.equals(bagCurrent.item)){
				counter++;
			}
			current=current.next;
			bagCurrent=bagCurrent.next;
		}
		if (counter == other.size()){
			return true;
		}
		return false;
	}
	
	/** 
	 * Return an array that contains the items from the UniqueBag.
	 * 
	 * Performance must be linearly dependent on the number of items in the UniqueBag, or ~ N.
	 */
	public Item[] toArray() {
		Item[] array = (Item[]) new Comparable[N];
		int i=0;
		Node current = first; //IS THIS RIGHT WAY TO DO IT?
		while(current!=null){
		    array[i]=current.item;
			i++;
			current=current.next;
		}
		return array;
	}

	/** 
	 * Add an item to the UniqueBag; return false if already contained.
	 * 
	 * Performance can be linearly dependent on the number of items in the UniqueBag, or ~ N.
	 */
	public boolean add(Item it){
		if(first == null){
			first = new Node();
			first.item=it;
			first.next = null;
			N++;
			return true;
		}
		Node current = new Node();
		Node previous = null;
		current = first;
		while (current!=null){
			if(it.equals(current.item)){
				return false;
			}
			if(current.item.compareTo(it)>0){
				if(previous == null){
					Node temp = new Node();
					temp.item=it;
					temp.next=first;
					first = temp;
					N++;
					return true;
				}
				
				else {
					Node node = new Node();
					node.item=it; // set the new one to have the item it in it.
					node.next = current;
					previous.next = node;//set the next element after first to equal old first
					N++;
					return true;
				}
			}
			previous = current;
			current = current.next;
		}
		Node n = new Node();
		n.item = it;
		n.next=null;
		previous.next=n;
		N++;
		
		/*if(it.equals(current.item)){
			return false;
		}*/
		 // Because we added one more element and we need more space
		
		return true;
		
	}
	
	/** 
	* Remove an item to the UniqueBag; return false if not contained within, true on success.
	* 
	* Performance can be linearly dependent on the number of items in the UniqueBag, or ~ N.
	*/
	public boolean remove (Item it){
	// Replace with your implementation
	Node current = first;
	Node previous = null;
	while (current!=null){
		if(current.item.equals(it)){
			if (previous==null){
				first=current.next;
				N--;
				return true;
			}
			else {
				previous.next=current.next;
				N--;
				return true;
			}
		}
		previous=current;
		current=current.next;
	}
	return false;
	}


	/** 
	 * Determine whether the item is contained by the UniqueBag.
	 * 
	 * Performance must be linearly dependent on the number of items in the UniqueBag, or ~ N.
	 */
	public boolean contains(Item it) {
		// Replace with your implementation
		Node newNode = first;
	    while(newNode!=null){
	    	if(newNode.item.equals(it)){
	    		return true;
	    	}
	    	newNode=newNode.next;
	    }
	    return false;
	}

	/** 
	 * Return a UniqueBag which represents intersection with existing UniqueBag.
	 * 
	 * Performance must be linearly dependent on the number of items in both UniqueBag 
	 * objects, or in otherwords ~ M + N where M is the number of items in other and N
	 * is the number of items in this UniqueBag.
	 */
	public UniqueBag<Item> intersects(UniqueBag<Item> other) {
		UniqueBag<Item> intersects = new UniqueBag<Item>();
		Node current=first;
		Node bagCurrent = other.first;
		while(current!=null&&bagCurrent!=null){
				if(current.item.compareTo(bagCurrent.item)==0){
					intersects.add(current.item);
					current=current.next;
					bagCurrent=bagCurrent.next;
				}
				else if(current.item.compareTo(bagCurrent.item)<0){
					current=current.next;
				}
				else {
					bagCurrent=bagCurrent.next;
				}
			//bagCurrent=bagCurrent.next;
			//current=current.next;
		}
		// Replace with your implementation
		return intersects;
	}

	/** 
	 * Return a UniqueBag which represents union with existing UniqueBag.
	 * 
	 * Performance must be linearly dependent on the number of items in both UniqueBag 
	 * objects, or in otherwords ~ M + N where M is the number of items in other and N
	 * is the number of items in this UniqueBag.
	 */
	public UniqueBag<Item> union(UniqueBag<Item> other) {
		// Replace with your implementation
		UniqueBag<Item> bigBag = new UniqueBag<Item>(other.toArray());
		Node current = first;
		while(current!=null){
			bigBag.add(current.item);
			current = current.next;
		}
		return bigBag;
		 
	}
	
	public void printFunction(){
		Node current = this.first;
		while(current!=null){
			System.out.println(current.item);
			current=current.next;
		}
		System.out.println(N);
	}

	/*public static void main(String[] args) {
		UniqueBag<String> bag = new UniqueBag<String>();
		bag.add("babi");
		bag.add("nata");
		UniqueBag<String> newbag = new UniqueBag<String>();
		newbag.add("babi");
		newbag.add("nata");
	}*/
}
