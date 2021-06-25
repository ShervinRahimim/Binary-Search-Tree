package BinarySearchTree;

public class BinarySearchTree {
	
	class Node{
		
		int key;
		String name;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name){
			
			this.key = key;
			this.name = name;
		
		}
		
		public String toString() {
			
			return key + " has a key " + name;
		}
   

	}
	
	Node root1;
	Node root2;
	
	public void addNodeIteratively(int key, String name) {
		
		Node newNode1 = new Node(key,name);
		
		if(root1 == null) {
			
			root1 = newNode1;
		}
		else {
			
			Node focusNode = root1;
			Node parent;
			
			while(true) {
				
				parent = focusNode;
				
				if(key < focusNode.key) {
					
					focusNode = focusNode.leftChild;
					
					if(focusNode == null) {
						
						parent.leftChild = newNode1;
						return;
					}
				}
				else {
					
					focusNode = focusNode.rightChild;
					
					if(focusNode == null) {
						
						parent.rightChild = newNode1;
						return;
					}
				}
			}
		}
	}
	
	static boolean iterativeSearch(Node root1, int key) {
		
		while(root1 != null) {
			
			if(key > root1.key) {
				
				root1 = root1.rightChild;
			}
			else if(key < root1.key) {
				
				root1 = root1.leftChild;
			}
			else {
				
				return true;
			}
		}
		
		return false;
	}
	
	static boolean recursiveSearch(Node root2, int key) {
		
		if(root2 == null) {
			
			return false;
		}
		else if(root2.key == key) {
			
			return true;
		}
		
		if(key < root2.key) {
			
			return recursiveSearch(root2.leftChild, key);
		}
		
		return recursiveSearch(root2.rightChild, key);
	}
	
	void insert(int key, String name) {
		
		root2 = addNodeRecursively(root2, key, name);
	}
	
	public Node addNodeRecursively(Node root2, int key, String name) {
		
		if(root2 == null) {
			
			root2 = new Node(key,name);
			return root2;
		}
		
		if(key < root2.key) {
			
			root2.leftChild = addNodeRecursively(root2.leftChild, key, name);
		}
		
		else if(key > root2.key) {
			
			root2.rightChild = addNodeRecursively(root2.rightChild, key, name);
		}
		
		return root2;
		
	}
	
	void inOrder() {
		
		inOrderRecursive(root2);
	}
	
	void inOrderRecursive(Node root2) {
		
		
		if(root2 == null) {
			
			return;
		}
		
		inOrderRecursive(root2.leftChild);
		System.out.println(root2);
		inOrderRecursive(root2.rightChild);
	}
	
	public void inOrderTraversal(Node focusNode) {
		
		if(focusNode != null) {
			
			inOrderTraversal(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
	public static void main(String args[]) {
		
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.addNodeIteratively(25,"Manager");
		tree1.addNodeIteratively(10, "Lawyer");
		tree1.addNodeIteratively(35, "Superman");
		tree1.addNodeIteratively(7, "Engineer");
		tree1.addNodeIteratively(15, "Scientist");
		tree1.addNodeIteratively(23, "Artist");
		tree1.addNodeIteratively(12, "Waiter");
		tree1.addNodeIteratively(1, "Batman");
		tree1.addNodeIteratively(9, "Teacher");
		tree1.addNodeIteratively(70, "President");
		tree1.addNodeIteratively(30, "Professor");
		tree1.addNodeIteratively(27, "Puppy");
		tree1.addNodeIteratively(33, "Nurse");
		tree1.addNodeIteratively(42, "Walker");
		tree1.addNodeIteratively(100, "Rapper");
		
		BinarySearchTree tree2 = new BinarySearchTree();
	
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 25, "Manager");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 10, "Lawyer");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 35, "Superman");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 7, "Engineer");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 15, "Scientist");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 23, "Artist");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 12, "Waiter");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 1, "Batman");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 9, "Teacher");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 70, "President");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 30, "Professor");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 27, "Puppy");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 33, "Nurse");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 42, "Walker");
	    tree2.root2 = tree2.addNodeRecursively(tree2.root2, 100, "Rapper");
	    
	    
	    System.out.println("Binary Search Tree Iteratively");
		System.out.println("------------------------------");
		tree1.inOrderTraversal(tree1.root1);
		long startTime1 = System.nanoTime(); 
		System.out.println(iterativeSearch(tree1.root1, 100));
		long estimatedTime1 = System.nanoTime() - startTime1;
		System.out.println("Iterative Search took: " + estimatedTime1 + " nanoseconds");
		System.out.println(iterativeSearch(tree1.root1, 89));
		System.out.println("\nBinary Search Tree Recursively");
		System.out.println("------------------------------");
		tree2.inOrder();
		long startTime2 = System.nanoTime();
		System.out.println(recursiveSearch(tree2.root2,100));
		long estimatedTime2 = System.nanoTime() - startTime2;
		System.out.println("Recursive Search took: " + estimatedTime2 + " nanoseconds");
	    System.out.println(recursiveSearch(tree2.root2, 89));
		
		
	}
	
}
