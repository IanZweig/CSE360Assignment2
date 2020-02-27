//Name: Ian Zweig
//Class ID: 357
//Assignment: 1
//Description: A simple integer list, with methods to add, remove, and search
//for elements. Also Included is a way to search for elements and get a count
//of how many elements are in the list.

package cse360assign2;

public class SimpleList {
	
	private int[] list;
	private int count;
	final int LIST_LENGTH = 10;
	
//The constructor SimpleList() initializes the list as an empty integer array
//of length 10, and sets the number of elements in the list to 0.
	
	public SimpleList() {
		list = new int[LIST_LENGTH];
		count = 0;
	}
	
//The add(int) method takes an integer input, places it in the first position
//in the list, and shifts all values up a spot. If the list is full
//(count == LIST_LENGTH), the last element will be removed.
	
	public void add(int newElement) {
		
		if(count != 0) {
			
			if(count == LIST_LENGTH) {
				count--;
			}
			
			for(int index = count - 1; index >= 0; index--) {
				list[index + 1] = list[index];
			}
		}
		
		list[0] = newElement;
		count++;
	}

//The remove(int) method takes an integer input, uses the search() method to
//find it in the list, and then removes it and shifts all elements above it
//downwards in the list to fill in the hole.
	
	public void remove(int elementToRemove) {
		
		int whereIsIt = search(elementToRemove);
		
		if(whereIsIt != -1) {
			
			while(whereIsIt < count - 1) {
				list[whereIsIt] = list[whereIsIt + 1];
				whereIsIt++;
			}
			
			list[count - 1] = 0;
			count--;
		}
	}
	
//The count() method will return an integer specifying how many elements are
//in the list. Note that this does not match up with array positions, as it 
//starts at 1. This output will have a value from 0 to 10 inclusive.
	
	public int count() {
		return count;
	}
	
//The toString method will return a string of all elements in the list
//separated by spaces. The last element will not have a space after it.
	
	public String toString() {
		
		String output = "";
		
		if(count > 0) {
			
			for(int index = 0; index < count - 1; index++) {
				output = output + list[index] + " ";
			}
			
			output += list[count - 1];
		}
		
		return output;
	}

//The search method finds the index of a specified element, and returns it.
//It will also return -1 if it cannot find the element.
	
	public int search(int elementToSearch) {
		
		int output = -1;
		
		for(int search = 0; search < count; search++) {
			
			if(list[search] == elementToSearch) {
				output = search;
				search = count;
			}
		}
		
		return output;
	}
}