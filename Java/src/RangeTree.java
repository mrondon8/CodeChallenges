/**
 * A basic node class that holds the range within this node
 * a left and right node and the value at this node
 * @author Miguel
 *
 */
 class Node{
	Node left;
	Node right;
	int startRange;
	int endRange;
	int value;
}

/**
 * A treelike structure that that is composed of nodes of ranges
 * @author Miguel
 *
 */
class RangeTree{
	//Root node
	Node root;
	//Array/List representation of the tree
	int[] array;
	/**
	 * Constructor
	 * @param array we want to perform range searches in
	 */
    RangeTree(int[] array){
		this.root = new Node();
        this.array = array;
        createTree(0, array.length - 1, root);
    }
    
	/**
	 * The method that creates the tree structure given the search array
	 * @param r is the array we plan to build the tree structure from
	 * @param start range
	 * @param end range
	 * @param node current node we work with
	 * @return node value
	 */
	int createTree(int start, int end, Node node){
		node.startRange = start;
		node.endRange = end;
		if(start == end){
			return node.value = this.array[start];
		}else{
			int mid = start + (end - start >> 1);
            node.left = new Node();
			node.right = new Node();
			return node.value = Math.max(createTree(start, mid, node.left), createTree(mid+1, end, node.right));
		}
	}

	/**
	 * Method to perform a search based on range
	 * @param node current node under inspection
	 * @param start represents the start of the range we are searching
	 * @param end represents the end of the range we are searching
	 * @return maximum value in the given range
	 */
	int searchRange(Node node, int start, int end){
		if(node.startRange >= start && node.endRange <= end){
			return node.value;
		}
		else if(node.startRange > end || node.endRange < start){
			return -1;
		}
		else{
			return Math.max(searchRange(node.left, start, end), searchRange(node.right, start, end));
		}
	}
	
	int lasVegasJourney(int[] array, int[][] ranges, int standard){
		RangeTree tree = new RangeTree(array);
		int minValue = 1_000_000;
		int minIndex = 0;
		int i = 0;
	    for(int[] range : ranges){	
			int temp = Math.abs(tree.searchRange(tree.root, range[0], range[1]) - standard) + range[1] - range[0];
			if( temp < minValue ){
				minValue = temp;
				minIndex = i;
			}
			i++;
		}
		return minIndex;
	}
}

