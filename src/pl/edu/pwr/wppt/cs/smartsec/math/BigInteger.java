package pl.edu.pwr.wppt.cs.smartsec.math;

import java.util.Iterator;

import pl.edu.pwr.wppt.cs.smartsec.container.array.ArrayList;
import pl.edu.pwr.wppt.cs.smartsec.memory.Endian;

// FIXME implement String so that Java Card compiler won't fail
// TODO implements comparable

public class BigInteger {
	public static byte defaultBase = (byte) 0xFF;
	public static Endian defaultEndian = Endian.LITTLE;

	private ArrayList number; // TODO implement ArrayListOfBytes or Shorts -
								// right now it's working through autoboxing //
								// tho autoboxing doesn't work on JDK 1.4
	private boolean isSigned = false;
	private byte base = BigInteger.defaultBase;
	private Endian endian = BigInteger.defaultEndian;

	public BigInteger() {
		number = new ArrayList();
		// number.add(0);
		number.add(new Byte((byte) 0)); // autoboxing doesn't work
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
		this.number = new ArrayList();
		byte[] bytes = number.getBytes();
		// for(byte b : bytes){
		// this.number.add(b-48);
		// }
		for (Iterator i = this.number.iterator(); i.hasNext();) { // autoboxing
																	// and
																	// foreach
																	// doesn't
																	// work
			byte b = ((Byte) i.next()).byteValue();
			this.number.add(new Byte((byte) (b - 48)));
		}
		base = 9;
		toBase(BigInteger.defaultBase);
		endian = Endian.BIG;
		toEndian(BigInteger.defaultEndian);
	}

	public BigInteger(byte number) throws Exception {
		this.number = new ArrayList();
		// this.number.add(number);
		this.number.add(new Byte(number)); // autobixing doesn't work
		toBase(BigInteger.defaultBase);
	}

	public BigInteger copy() {
		BigInteger bigInteger = new BigInteger(this);
		bigInteger.number = new ArrayList();
		// for(Object element : this.number){
		// bigInteger.number.add(element);
		// }
		for (Iterator i = this.number.iterator(); i.hasNext();) { // autoboxing
																	// and
																	// foreach
																	// doesn't
																	// work
			byte element = ((Byte) i.next()).byteValue();
			bigInteger.number.add(new Byte(element));
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
