import java.util.Scanner;
import java.io.*;

public class Sorting {
	static int index = 0;
	static String[] array;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		File loadFile = new File("words.txt"); 

		File saveFile = new File("words.txt");
		// information is saved when
		// it's been sorted

		// time the following for bubblesort, selection sort and insertion sort:
		// 10,000 items, 20,000 items, 30,000 items, 40,000 items and 50,000
		// items

		Scanner myscanner = new Scanner(System.in);
		System.out.println("How many items would you like to sort?");
		int nElems = myscanner.nextInt();
		array = new String[nElems];
		FileIo myFileIO = new FileIo();
		array = myFileIO.getContents(loadFile, nElems); // loads the file

		// insertionsort(); // calls the sorting method
		insertionsort();
		long elapsed = System.currentTimeMillis() - start;
		try {
			myFileIO.setContents(saveFile, array); // saves the sorted info
		} catch (Exception e) {
		}
		System.out.println(elapsed);
	}

	public static void bubblesort() {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareToIgnoreCase(array[j]) > 0) {
					swap(i, j);
				}

				else if (array[i].compareToIgnoreCase(array[j]) > 0) {
					if (array[i].charAt(1) > array[j].charAt(1)) {
						swap(i, j);
					}
				}
			}
		}
	}

	public static void swap(int num1, int num2) {
		String temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}

	public static void selectionsort() {
		int min;
		for (int outer = 0; outer < array.length; outer++) {
			min = outer;
			for (int i = outer + 1; i < array.length; i++) {
				if (array[i].compareToIgnoreCase(array[min]) < 0) {
					min = i;
				}

				else if (array[i].compareToIgnoreCase(array[min]) < 0) {
					if (array[i].charAt(1) < array[min].charAt(1))
						min = i;
				}
			}
			swap(outer, min);
		}
	}

	public static void insertionsort() {
		int inner;
		for (int outer = 1; outer < array.length; outer++) {
			// outer is the next element to be sorted

			String temp = array[outer]; // back it up
			inner = outer;// inner used to track shifts
			while (inner > 0
					&& array[inner - 1].compareToIgnoreCase(temp) > 0
					|| array[inner - 1].compareToIgnoreCase(temp) == 0) {

				array[inner] = array[inner - 1];// swap
				inner--;
				if (inner == 0)
					break;

			} // shift them all right until one is smaller
			array[inner] = temp;
		}
	}

}
