package com.revature.models;

import java.util.Arrays;

public class PopularBookArray {
	PopularBook[] array  = new PopularBook[5];
	
public PopularBookArray() {
		super();
	}


public PopularBook[] getArray() {
	return array;
}


public void setArray(PopularBook[] array) {
	this.array = array;
}


public void addElement(PopularBook book) {
	for (int i=0; i < this.array.length; i++) {
		if (this.array[i]==null) {
			this.array[i] = book;
			break;
		}
	}
}
	
public boolean isEmpty() {
	for (int i=0; i < this.array.length; i++) {
		if (this.array[i]==null) {
			return true;
		}
	}
	return false;
}


@Override
public String toString() {
	return "PopularBookArray [array=" + Arrays.toString(array) + "]";
}



}
