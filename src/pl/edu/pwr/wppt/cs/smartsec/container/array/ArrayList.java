package pl.edu.pwr.wppt.cs.smartsec.container.array;

import java.util.Iterator;

import pl.edu.pwr.wppt.cs.smartsec.container.array.AbstractArrayList.Itr;
import pl.edu.pwr.wppt.cs.smartsec.memory.Endian;

public class ArrayList extends AbstractArrayList {

	private Object[] array;

	public ArrayList(Object[] array) {
		this.array = array;
	}

	public ArrayList(Object[] array, Endian endian) {
		super(endian);
		this.array = array;
	}

	public ArrayList() {
		this.array = new Object[0];
	}

	public ArrayList(Endian endian) {
		super(endian);
		this.array = new Object[0];
	}

	public short size() {
		return (short) array.length;
	}

	public Object get(short index) {
		return array[index];
	}

	public Object set(short index, Object element) {
		Object elementOld = array[index];
		array[index] = element;
		return elementOld;
	}

	public boolean add(Object element) {
		Object[] array = new Object[size() + 1];
		System.arraycopy(array, 0, this.array, 0, size()); // FIXME this might
															// not work on Java
															// Card
		indexOutOfBounds = indexCalculator.nextIndex(indexOutOfBounds);
		return true;
	}

	// FIXME
	public void reverse() {
		throw new UnsupportedOperationException();
	}
	
	// FIXME
	public Object getArray() {
		throw new UnsupportedOperationException();
	}


	public boolean equals(ArrayList array) {
		if (this.size() != array.size()) { // deliberately ignoring ||
											// this.indexCalculator!=array.indexCalculator
			return false;
		}
		for (Iterator i = this.iterator(), j = array.iterator(); i.hasNext();) { // foreach
																					// doesn't
																					// work
			Object elementA = i.next();
			Object elementB = j.next();
			if (elementA.equals(elementB) == false)
				return false;
		}
		return true;
	}

}
