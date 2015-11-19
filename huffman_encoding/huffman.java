package Huffman;

import java.util.PriorityQueue;

public class huffman {

	public static void main(String[] args) {
		FileIO reader = new FileIO(); // Uses the FileIo class
		String[] contents = reader.load("C://hello.txt"); // reads in a file in the C drive
		String sentence = new String(); 
		
		for(int i = 0; i < contents.length; i++){
			sentence += contents[i]; // sentence holds the all the characters in the file
		}

		String binaryString = ""; // this stores the string of binary code

		for (int i = 0; i < sentence.length(); i++) { // go through the sentence
			int decimalValue = (int) sentence.charAt(i); // convert to decimal
			String binaryValue = Integer.toBinaryString(decimalValue); // convert to binary
			
			for (int j = 7; j > binaryValue.length(); j--) {
				binaryString += "0"; // this loop adds in the leading zeros
			}
			
			binaryString += binaryValue + " "; // add to the string of binary
		}
		System.out.println(binaryString); // print out the binary

		int[] array = new int[256]; // an array to store all the frequencies

		for (int i = 0; i < sentence.length(); i++) { // go through the sentence
			array[(int) sentence.charAt(i)]++; // increment the appropriate frequencies

		}

		PriorityQueue<Tree> PQ = new PriorityQueue<Tree>(); // make a priority queue to hold the forest of trees

		for (int i = 0; i < array.length; i++) { // go through frequency array
			if (array[i] > 0) { // print out non-zero frequencies - cast to a char
				System.out.println("'" + (char) i + "' appeared " + array[i]
						+ ((array[i] == 1) ? " time" : " times"));

				
				Tree tree = new Tree(); // makes the Tree
				tree.frequency = array[i]; // gives the tree the frequency

				Node newNode = new Node(); // makes a Node
				newNode.letter = (char) i; // gives the node the letter

				tree.root = newNode; // adds this node to the tree

				PQ.add(tree); // adds the tree to the priority queue
			}
		}
		while (PQ.size() > 1) { // while there are two or more Trees left in the forest
			
			// Creates two trees and a tree for combining the two trees
			Tree treeA = new Tree();
			Tree treeB = new Tree();
			Tree combinedTree = new Tree();
			
			Node parent = new Node(); // Node used to store each letter and to 
										// ensure we don't get a null pointer

			treeA = PQ.poll(); // treeA is the lowest frequecy
			treeB = PQ.poll(); // treeB is the second lowest frequency

			parent.rightChild = treeB.root;
			parent.leftChild = treeA.root;
			
			combinedTree.frequency = treeA.frequency + treeB.frequency; // this gives the combinedTree the total
																		// frequency
			combinedTree.root = parent;

			PQ.add(combinedTree); // add the tree to the priority queue 
		}

		Tree HuffmanTree = PQ.poll(); // now there's only one tree left - get
										// its code

		int count = 0;
		for (int i = 0; i < sentence.length(); i++) { // go through frequency
														// array
			String x = HuffmanTree.getCode(sentence.charAt(i)); // gets the binary value of each letter 
																// in the sentence
			System.out.print(x + " ");
			count = count + x.length(); // keeps count of the bits we're using

		}

		System.out.println();
		System.out.println("Compression percentages is " + (double) count
				/ (binaryString.length() - sentence.length()) * 100 + '%'); // this prints out the compression rate of the Huffman process
	}
}
