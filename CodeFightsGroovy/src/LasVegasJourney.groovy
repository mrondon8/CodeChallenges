/*Al is known as one of the most talented hackers in the world. He can easily break into any system in just a blink of an eye. He's currently in Las Vegas, celebrating his partner's birthday. He'd like to gift her a diamond ring, but he's about 5 million dollars short. Luckily, he sees an opportunity in the casino games.
 There's a wagering game called Golden Spheres, where a winner is randomly chosen by a computer algorithm, and the grand prize is 5 million dollars. Here are the rules:
 To participate in the draw, each person is able to buy one ticket, which contains a range of numbers.
 The algorithm generates an indexed sequence of random integers, arr. The range of numbers on each ticket represents a range of indices from this sequence.
 On the day of the draw, another integer number is randomly generated, which is called the standard. The winner is the ticketholder whose range of indices has a maximum value in arr that's closest to standard.
 If there's a tie for closest, the winning ticket is the one with the smallest range of indices.
 If there's still a tie, the winner is the one with the smallest index.
 Players can choose which range of numbers they'd like, but they won't know the standard until the draw on the following day, after ticket sales are closed. That is, unless they're a master hacker like Al, who was able to figure out what the standard will be, in advance.
 Given the numbers arr, the choices of indices ranges, and the standard, your task is to find which range Al should pick in order to win!*/
/**
 * A basic node class that holds the range within this node
 * a left and right node and the value at this node
 * @author Miguel
 *
 */
 class Node{
	Node left
	Node right
	int startRange
	int endRange
	int value
}

/**
 * A treelike structure that that is composed of nodes of ranges
 * @author Miguel
 *
 */
@groovy.transform.CompileStatic
class RangeTree{
	//Root node
	Node root
	//Array/List representation of the tree
	List array
	/**
	 * Constructor
	 * @param array we want to perform range searches in
	 */
    RangeTree(List array){
		this.root = new Node()
        this.array = array
        createTree(0, array.size() - 1, root)
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
		node.startRange = start
		node.endRange = end
		if(start == end){
			node.value = this.array[start]
		}else{
			int mid = start + (end - start >> 1)
            node.left = new Node()
			node.right = new Node()
			node.value = Math.max(createTree(start, mid, node.left), createTree(mid+1, end, node.right))
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
			return node.value
		}
		else if(node.startRange > end || node.endRange < start){
			return -1
		}
		else{
			return Math.max(searchRange(node.left, start, end), searchRange(node.right, start, end))
		}
	}
}

def lasVegasJourney(List array, List ranges, int standard){
    def start = System.currentTimeMillis()
	def tree = new RangeTree(array)
	int minValue = 1e6
	int minIndex = 0
	int i = 0
    for(List range : ranges){	
		int temp = Math.abs(tree.searchRange(tree.root, range[0], range[1]) - standard) + range[1] - range[0]
		if( temp < minValue ){
			minValue = temp
			minIndex = i
		}
		i++
	}
    def end = System.currentTimeMillis()
    println end - start
	minIndex
}

//println lasVegasJourney([7, 1, 9, 5], [[0, 2], [2, 3], [0, 1], [3, 3], [1, 3], [0, 0]], 6)
//println lasVegasJourney([6, 4, 1],[[2,2],  [0,1],  [0,1]], 8)
//println lasVegasJourney([80, 18, 33, 13, 53], [[3,4], [3,4], [0,3], [0,4], [1,2], [0,4], [0,1], [2,4]], 7)

println lasVegasJourney(
		[
			2,
			15,
			64,
			5,
			62,
			37,
			34,
			74,
			13,
			4,
			1,
			93,
			3,
			44,
			24,
			22,
			84,
			79,
			42,
			88,
			51,
			63,
			15,
			58,
			52,
			38,
			1,
			81,
			42,
			90,
			93,
			83,
			58,
			30,
			29,
			19,
			83,
			43,
			68,
			2,
			29,
			38,
			57,
			61,
			55,
			22,
			17,
			92,
			38,
			6,
			25,
			18,
			18,
			90,
			38,
			42,
			66,
			14,
			79,
			83,
			98,
			59,
			50,
			62,
			97,
			97,
			23,
			56,
			85,
			11,
			63,
			31,
			5,
			90,
			85,
			74,
			53,
			74,
			48,
			43,
			85,
			61,
			14,
			92,
			24,
			32,
			52,
			27,
			63,
			44,
			77,
			95,
			10,
			42,
			63,
			78,
			9,
			87,
			93,
			60,
			74,
			40,
			11,
			77,
			58,
			4,
			56,
			32,
			43,
			30,
			54,
			16,
			76,
			97,
			44,
			78,
			9,
			92,
			27,
			16,
			58,
			80,
			31,
			69,
			58,
			21,
			25,
			97,
			59,
			23,
			68,
			11,
			21,
			59,
			7,
			10,
			14,
			61,
			78,
			1,
			62,
			45,
			57,
			84,
			12,
			16,
			81,
			83,
			63,
			40,
			22,
			85,
			49,
			38,
			52,
			53,
			14,
			7,
			23,
			86,
			52,
			72,
			44,
			53,
			68,
			58,
			66,
			14,
			5,
			9,
			13,
			13,
			70,
			43,
			1,
			9,
			27,
			41,
			56,
			6,
			41,
			39,
			16,
			14,
			31,
			7,
			44,
			61,
			43,
			23,
			15,
			9,
			27,
			52,
			18,
			48,
			14,
			40,
			67,
			64,
			78,
			84,
			90,
			79,
			21,
			42,
			54,
			76,
			28,
			47,
			41,
			93,
			70,
			97,
			67,
			65,
			68,
			32,
			5,
			68,
			84,
			17,
			67,
			87,
			70,
			32,
			53,
			82,
			81,
			30,
			16,
			27,
			18,
			69,
			51,
			34,
			19,
			66,
			29,
			13,
			73,
			52,
			82,
			43,
			66,
			42,
			58,
			65,
			96,
			56,
			55,
			67,
			50,
			58,
			91,
			46,
			9,
			53,
			67,
			54,
			33,
			93,
			16,
			86,
			76,
			99,
			90,
			69,
			55,
			11,
			1,
			54,
			67,
			2,
			36,
			35,
			34,
			28,
			39,
			91,
			30,
			77,
			84,
			13,
			54,
			26,
			18,
			35,
			14,
			3,
			16,
			88,
			62,
			29,
			22,
			54,
			87,
			45,
			49,
			89,
			17,
			77,
			51,
			41,
			32,
			61,
			49,
			31,
			51,
			3,
			29,
			29,
			16,
			36,
			96,
			96,
			66,
			39,
			41,
			65,
			46,
			17,
			1,
			10,
			66,
			9,
			16,
			95,
			98,
			34,
			64,
			91,
			93,
			31,
			52,
			25,
			50,
			46,
			76,
			33,
			66,
			15,
			94,
			15,
			92,
			85,
			46,
			40,
			26,
			82,
			62,
			52,
			92,
			58,
			14,
			21,
			32,
			84,
			92,
			33,
			88,
			80,
			77,
			3,
			87,
			89,
			22,
			77,
			15,
			64,
			43,
			75,
			28,
			96,
			71,
			79,
			73,
			50,
			37,
			49,
			54,
			81,
			13,
			88,
			55,
			88,
			19,
			6,
			29,
			12,
			74,
			72,
			5,
			19,
			97,
			8,
			36,
			57,
			5,
			46,
			47,
			3,
			82,
			47,
			38,
			2,
			56,
			62,
			1,
			47,
			53,
			6,
			23,
			16,
			1,
			46,
			84,
			15,
			0,
			56,
			25,
			58,
			82,
			70,
			27,
			87,
			36,
			4,
			16,
			28,
			48,
			9,
			22,
			11,
			75,
			32,
			76,
			50,
			66,
			23,
			92,
			53,
			41,
			72,
			57,
			23,
			93,
			67,
			92,
			60,
			10,
			86,
			0,
			98,
			55,
			28,
			19,
			11,
			53,
			49,
			30,
			27,
			46,
			12,
			69,
			7,
			39,
			24,
			1,
			37,
			64,
			22,
			45,
			28,
			41,
			29,
			9,
			78,
			54,
			18,
			1,
			76,
			53,
			17,
			50,
			32,
			3,
			59,
			26,
			2,
			1,
			70,
			58,
			83,
			91,
			48,
			9,
			66,
			31,
			56,
			68,
			50,
			3,
			64,
			96,
			53,
			56,
			36,
			76,
			16,
			50,
			31,
			45,
			63,
			71,
			90,
			26,
			38,
			43,
			65,
			5,
			52,
			13,
			97,
			27,
			89,
			85,
			21,
			39,
			37,
			29,
			82,
			73,
			41,
			82,
			17,
			95,
			68,
			23,
			96,
			90,
			62,
			85,
			65,
			9,
			52,
			37,
			48,
			4,
			77,
			20,
			11,
			10,
			14,
			64,
			24,
			44,
			17,
			99,
			56,
			51,
			70,
			6,
			74,
			1,
			25,
			46,
			78,
			11,
			94,
			56,
			96,
			16,
			11,
			15,
			33,
			23,
			19,
			16,
			70,
			14,
			35,
			98,
			81,
			67,
			74,
			31,
			8,
			46,
			56,
			43,
			41,
			2,
			52,
			25,
			34,
			39,
			86,
			19,
			45,
			32,
			74,
			13,
			17,
			87,
			66,
			83,
			62,
			79,
			5,
			5,
			78,
			55,
			86,
			68,
			99,
			68,
			1,
			22,
			94,
			70,
			88,
			21,
			59,
			20,
			59,
			36,
			78,
			18,
			56,
			52,
			88,
			53,
			44,
			65,
			23,
			94,
			85,
			99,
			32,
			69,
			18,
			40,
			47,
			31,
			42,
			87,
			78,
			60,
			55,
			50,
			10,
			0,
			45,
			0,
			50,
			38,
			54,
			74,
			20,
			13,
			70,
			87,
			28,
			28,
			29,
			46,
			47,
			51,
			48,
			6,
			96,
			66,
			3,
			39,
			27,
			80,
			94,
			29,
			20,
			53,
			55,
			35,
			26,
			6,
			51,
			44,
			92,
			26,
			6,
			83,
			70,
			38,
			73,
			9,
			55,
			69,
			60,
			17,
			85,
			25,
			13,
			13,
			17,
			46,
			93,
			10,
			3,
			34,
			6
		],
		[
			[25, 708],
			[101, 123],
			[348, 660],
			[216, 528],
			[154, 619],
			[224, 319],
			[56, 442],
			[301, 692],
			[4, 512],
			[82, 421],
			[398, 551],
			[137, 703],
			[267, 629],
			[91, 570],
			[403, 599],
			[25, 608],
			[294, 495],
			[248, 576],
			[4, 458],
			[40, 347],
			[82, 524],
			[431, 528],
			[40, 582],
			[315, 421],
			[126, 632],
			[379, 423],
			[539, 547],
			[33, 62],
			[294, 622],
			[28, 64],
			[266, 513],
			[510, 561],
			[140, 411],
			[42, 448],
			[168, 375],
			[197, 320],
			[399, 562],
			[369, 618],
			[344, 637],
			[174, 431],
			[313, 474],
			[133, 466],
			[244, 410],
			[161, 243],
			[309, 311],
			[120, 581],
			[255, 689],
			[177, 305],
			[322, 459],
			[27, 174],
			[398, 580],
			[122, 487],
			[126, 541],
			[257, 363],
			[552, 663],
			[64, 591],
			[254, 586],
			[17, 538],
			[285, 625],
			[47, 353],
			[339, 565],
			[177, 384],
			[62, 587],
			[4, 578],
			[116, 343],
			[183, 277],
			[344, 677],
			[348, 605],
			[104, 238],
			[37, 538],
			[269, 666],
			[193, 227],
			[86, 683],
			[536, 695],
			[455, 561],
			[75, 539],
			[310, 446],
			[107, 168],
			[279, 448],
			[249, 341],
			[161, 360],
			[101, 391],
			[38, 80],
			[20, 602],
			[128, 533],
			[312, 359],
			[14, 44],
			[182, 263],
			[114, 402],
			[69, 409],
			[44, 585],
			[44, 643],
			[467, 701],
			[19, 695],
			[470, 700],
			[596, 675],
			[391, 458],
			[148, 312],
			[53, 280],
			[36, 450],
			[672, 682],
			[22, 597],
			[293, 412],
			[469, 568],
			[94, 499],
			[57, 446],
			[335, 513],
			[344, 644],
			[150, 570],
			[383, 695],
			[111, 707],
			[287, 538],
			[261, 452],
			[28, 283],
			[329, 357],
			[108, 433],
			[179, 388],
			[34, 699],
			[636, 663],
			[141, 280],
			[35, 693],
			[143, 477],
			[501, 626],
			[252, 469],
			[177, 251],
			[226, 394],
			[160, 440],
			[21, 180],
			[94, 694],
			[575, 602],
			[376, 512],
			[58, 464],
			[218, 371],
			[238, 392],
			[328, 571],
			[271, 296],
			[422, 523],
			[288, 636],
			[113, 310],
			[211, 305],
			[192, 511],
			[267, 408],
			[519, 563],
			[144, 353],
			[279, 405],
			[111, 301],
			[496, 507],
			[306, 408],
			[91, 266],
			[57, 354],
			[218, 529],
			[142, 261],
			[65, 545],
			[117, 588],
			[450, 629],
			[362, 380],
			[165, 454],
			[80, 238],
			[4, 492],
			[78, 456],
			[485, 703],
			[344, 644],
			[348, 367],
			[227, 596],
			[252, 264],
			[36, 270],
			[58, 638],
			[118, 638],
			[256, 480],
			[674, 708],
			[529, 602],
			[223, 389],
			[308, 330],
			[262, 541],
			[138, 521],
			[485, 707],
			[532, 668],
			[7, 424],
			[373, 575],
			[206, 482],
			[189, 530],
			[13, 74],
			[632, 658],
			[14, 534],
			[415, 512],
			[386, 394],
			[371, 592],
			[86, 642],
			[244, 704],
			[101, 665],
			[396, 505],
			[297, 482],
			[23, 438],
			[303, 357],
			[92, 285],
			[252, 632],
			[218, 378],
			[227, 377],
			[187, 523],
			[286, 525],
			[32, 268],
			[560, 607],
			[136, 233],
			[181, 531],
			[407, 596],
			[400, 574],
			[198, 647],
			[227, 573],
			[217, 292],
			[225, 263],
			[69, 336],
			[100, 589],
			[113, 320],
			[490, 705],
			[371, 375],
			[396, 546],
			[408, 604],
			[515, 572],
			[175, 265],
			[81, 146],
			[446, 692],
			[36, 46],
			[200, 469],
			[107, 234],
			[103, 140],
			[429, 605],
			[212, 608],
			[528, 550],
			[83, 220],
			[209, 470],
			[126, 276],
			[162, 698],
			[488, 506],
			[527, 546],
			[369, 390],
			[311, 703],
			[173, 265],
			[66, 137],
			[316, 485],
			[57, 575],
			[61, 388],
			[338, 440],
			[168, 450],
			[255, 342],
			[173, 428],
			[272, 359],
			[389, 641],
			[126, 521],
			[109, 260],
			[45, 194],
			[211, 502],
			[103, 201],
			[215, 281],
			[657, 705],
			[157, 414],
			[288, 594],
			[152, 484],
			[128, 579],
			[23, 437],
			[147, 302],
			[58, 532],
			[153, 454]
		],
		50
		)



