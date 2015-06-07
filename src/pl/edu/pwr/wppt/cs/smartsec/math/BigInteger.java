package pl.edu.pwr.wppt.cs.smartsec.math;

import java.util.Iterator;

import pl.edu.pwr.wppt.cs.smartsec.container.array.ArrayList;
import pl.edu.pwr.wppt.cs.smartsec.container.array.ArrayListOfBytes;
import pl.edu.pwr.wppt.cs.smartsec.memory.Endian;

// FIXME implement String so that Java Card compiler won't fail
// TODO implements comparable

public class BigInteger {
	public static byte defaultBase = (byte) 0xFF;
	public static Endian defaultEndian = Endian.LITTLE;

	private ArrayListOfBytes number;
	private boolean isSigned = false;
	private byte base = BigInteger.defaultBase;
	private Endian endian = BigInteger.defaultEndian; // TODO move to
														// AbstractArrayList as
														// a method

	public BigInteger() {
		number = new ArrayListOfBytes();
		number.add((byte) 0);
	}

	public BigInteger(BigInteger bigInteger) {
		number = bigInteger.number;
		isSigned = bigInteger.isSigned;
		base = bigInteger.base;
		endian = bigInteger.endian;
	}

	public BigInteger(String number) throws Exception {
		if (number.startsWith("-")) {
			isSigned = true;
			number = number.substring(1);
		}
		this.number = new ArrayListOfBytes();
		byte[] bytes = number.getBytes();
		// for(byte b : bytes){
		// this.number.add(b-48);
		// }
		for (ArrayListOfBytes.Itr i = this.number.iteratorOverBytes(); i
				.hasNext();) { // foreach doesn't work
			byte b = i.nextByte();
			this.number.add((byte) (b - 48));
		}
		base = 9;
		toBase(BigInteger.defaultBase);
		endian = Endian.BIG;
		toEndian(BigInteger.defaultEndian);
	}

	public BigInteger(byte number) throws Exception {
		this.number = new ArrayListOfBytes();
		// this.number.add(number);
		this.number.add(number);
		toBase(BigInteger.defaultBase);
	}

	public BigInteger copy() {
		BigInteger bigInteger = new BigInteger(this);
		bigInteger.number = new ArrayListOfBytes();
		// for(Object element : this.number){
		// bigInteger.number.add(element);
		// }
		for (ArrayListOfBytes.Itr i = this.number.iteratorOverBytes(); i
				.hasNext();) { // foreach doesn't work
			byte element = i.nextByte();
			bigInteger.number.add(element);
		}
		return bigInteger;
	}

	public void toBase(byte toBase) throws Exception {
		toBase--;
		// FIXME
		this.base = toBase;
		throw new UnsupportedOperationException();
	}

	public void toEndian(Endian endian) {
		if (this.endian != endian) {
			number.reverse();
		}
	}

	// FIXME handle signed numbers
	public void printNumber() {
		throw new UnsupportedOperationException();
	}

	public boolean equals(BigInteger bigInteger) {
		if (this.isSigned == bigInteger.isSigned
				&& this.base == bigInteger.base
				&& this.number.equals(bigInteger.number))
			return true;
		return false;
	}

	// TODO DRY - copied from public BigInteger(BigInteger bigInteger)
	public BigInteger is(BigInteger bigInteger) {
		BigInteger tmp = bigInteger.copy();
		number = tmp.number;
		isSigned = tmp.isSigned;
		base = tmp.base;
		endian = tmp.endian;
		return this;
	}

	// FIXME
	public BigInteger plus(BigInteger bigInteger) {
		throw new UnsupportedOperationException();
	}

	// FIXME
	public BigInteger minus(BigInteger bigInteger) {
		throw new UnsupportedOperationException();
	}

	// FIXME
	public BigInteger times(BigInteger bigInteger) {
		throw new UnsupportedOperationException();
	}

	// FIXME
	public BigInteger by(BigInteger bigInteger) {
		throw new UnsupportedOperationException();
	}

	// FIXME
	public BigInteger mod(BigInteger bigInteger) {
		throw new UnsupportedOperationException();
	}

	// FIXME
	public BigInteger pow(BigInteger bigInteger) {
		throw new UnsupportedOperationException();
	}
}
