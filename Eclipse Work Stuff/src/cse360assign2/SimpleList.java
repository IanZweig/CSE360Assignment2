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
	private int listLength = 10;
	
//The constructor SimpleList() initializes the list as an empty integer array
//of length 10, and sets the number of elements in the list to 0.
	
	public SimpleList() {
		list = new int[listLength];
		count = 0;
	}
	
//The add(int) method takes an integer input, places it in the first position
//in the list, and shifts all values up a spot. If the list is full
//(count == listLength), the list will be expanded to accommodate.
	
	public void add(int newElement) {
		
		if(count != 0) {
			
			if(count == listLength) {
				changeSize(listLength + (listLength / 2));
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
			
			if(count < (3 * listLength) / 4 && count > 0) {
				changeSize(count);
			}
		}
	}
	
//The append(int) method takes an integer input, expands the list if it is full,
//and then adds the input at the end of the list. 
	
	public void append(int newElement) {
		
		if(count == listLength) {
			changeSize(listLength + (listLength / 2));
		}
		
		list[count] = newElement;
		count++;
	}
	
//The count() method will return an integer specifying how many elements are
//in the list. Note that this does not match up with array positions, as it 
//starts at 1. This output will have a value from 0 to 10 inclusive.
	
	public int count() {
		return count;
	}
	
//The size() method will return an integer specifying how many elements CAN
//be in the list at the moment. Note that the size does NOT indicate how many
//elements are in the list, just how many CAN be.
	
	public int size() {
		return listLength;
	}
	
//The first() method will return the first element from the list UNLESS there
//are no elements, in which case it will return -1.
	
	public int first() {
		
		int output = -1;
		
		if(count != 0) {
			output = list[0];
		}
		
		return output;
	}
	
//The last() method will return the last element from the list UNLESS there
//are no elements, in which case it will return -1.	
	
	public int last() {
		
		int output = -1;
		
		if(count != 0) {
			output = list[count - 1];
		}
		
		return output;
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
	
//The private method changeSize(int) takes an integer input, and creates 
//a new list with size specified as by the input. It then copies over all
//data, then assigns list to the new list.
	
	private void changeSize(int newSize) {
		
		int[] newList = new int[newSize];
		
		for(int index = 0; index < count; index++) {
			newList[index] = list[index];
		}
		
		listLength = newSize;
		list = newList;
	}
}