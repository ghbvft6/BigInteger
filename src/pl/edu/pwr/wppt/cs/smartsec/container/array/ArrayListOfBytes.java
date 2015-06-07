package pl.edu.pwr.wppt.cs.smartsec.container.array;

import java.util.Iterator;

import pl.edu.pwr.wppt.cs.smartsec.container.array.AbstractArrayList.Itr;
import pl.edu.pwr.wppt.cs.smartsec.memory.Endian;

public class ArrayListOfBytes extends AbstractArrayList {

	private byte[] array;

	public ArrayListOfBytes(byte[] array) {
		this.array = array;
	}

	public ArrayListOfBytes(byte[] array, Endian endian) {
		super(endian);
		this.array = array;
	}

	public ArrayListOfBytes() {
		this.array = new byte[0];
	}

	public ArrayListOfBytes(Endian endian) {
		super(endian);
		this.array = new byte[0];
	}

	public short size() {
		return (short) array.length;
	}

	public Object get(short index) {
		return new Byte(array[index]);
	}

	// Java 1.4 doesn't allow for overriding return type
	public byte getByte(short index) {
		return array[index];
	}

	public byte set(short index, byte element) {
		byte elementOld = array[index];
		array[index] = element;
		return elementOld;
	}

	public boolean add(byte element) {
		byte[] array = new byte[size() + 1];
		System.arraycopy(array, 0, this.array, 0, size()); // FIXME this might
															// not work on Java
															// Card
		array[indexOutOfBounds] = element;
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

	// FIXME // Java 1.4 doesn't allow for overriding return type
	public byte getArrayBytes() {
		throw new UnsupportedOperationException();
	}

	// TODO move to AbstractArrayList
	public boolean equals(ArrayListOfBytes array) {
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

	// Java 1.4 doesn't allow for overriding return type
	public class Itr extends AbstractArrayList.Itr {
		public byte nextByte() {
			byte nextReference = ArrayListOfBytes.this.getByte(indexNext);
			indexNext = indexCalculator.nextIndex(indexNext);
			return nextReference;
		}
	}

	public Object set(short index, Object element) {
		Object elementOld = new Byte(array[index]);
		array[index] = ((Byte) element).byteValue(); // no autoboxing
		return elementOld;
	}

	public boolean add(Object element) {
		byte[] array = new byte[size() + 1];
		System.arraycopy(array, 0, this.array, 0, size()); // FIXME this might
															// not work on Java
															// Card
		array[indexOutOfBounds] = ((Byte) element).byteValue(); // no autoboxing
		indexOutOfBounds = indexCalculator.nextIndex(indexOutOfBounds);
		return true;
	}

	// TODO broken quickfix for iteration over bytes
	public Itr iteratorOverBytes() {
		return new Itr();
	}
}
