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
	private boolean isSigned = false; // TODO unsupported
	private byte base = BigInteger.defaultBase; // TODO unsupported
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

//	public BigInteger(String number) throws Exception {
//		if (number.startsWith("-")) {
//			isSigned = true;
//			number = number.substring(1);
//		}
//		this.number = new ArrayListOfBytes();
//		byte[] bytes = number.getBytes();
//		// for(byte b : bytes){
//		// this.number.add(b-48);
//		// }
//		for (ArrayListOfBytes.Itr i = this.number.iteratorOverBytes(); i
//				.hasNext();) { // foreach doesn't work
//			byte b = i.nextByte();
//			this.number.add((byte) (b - 48));
//		}
//		base = 9;
//		toBase(BigInteger.defaultBase);
//		endian = Endian.BIG;
//		toEndian(BigInteger.defaultEndian);
//	}
	
	public byte[] getBytes(){
		return this.number.getBytes();
	}

	public BigInteger(byte number) {
		this.number = new ArrayListOfBytes();
		// this.number.add(number);
		this.number.add(number);
		try {
			toBase(BigInteger.defaultBase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BigInteger(byte[] number) {
		this.number = new ArrayListOfBytes(number);
		// this.number.add(number);
		//this.number.add(number);
		try {
			toBase(BigInteger.defaultBase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// TODO test TODO dry TODO performance
	public BigInteger plus(BigInteger bigInteger) {
		ArrayListOfBytes.Itr i = this.number.iteratorOverBytes();
		ArrayListOfBytes.Itr j = bigInteger.number.iteratorOverBytes();
		short index = 0;
		short element = 0;
		for (; i.hasNext() && j.hasNext();++index) {
			element += (short)(i.nextByte()+j.nextByte());
			//System.out.println(element + " "+i.hasNext());
			this.number.set(index, (byte)(element&0xFF));
			//System.out.println(element + " "+index+" "+(byte)(element&0xFF)+" "+bigInteger.number.getByte((short)0));
			//System.out.println("arr: "+this.number.equals(bigInteger.number));
			element >>>= 8;
		}
		
		if (i.hasNext()) for (; i.hasNext() ;++index) { // TODO remove this loop
			element += (short)(i.nextByte());
			this.number.set(index, (byte)(element&0xFF));
			element >>>= 8;
		}
		
		if (j.hasNext()) for (; j.hasNext() ;++index) {
			element += (short)(j.nextByte());
			this.number.set(index, (byte)(element&0xFF));
			element >>>= 8;
		}
		
		if (element!=0) this.number.set(index, (byte)(element&0xFF)); // TODO check if necessary
		element >>>= 4;
		if (element!=0) this.number.set(index, (byte)(element&0xFF));
		return this;
	}

	// TODO test TODO dry TODO performance
	public BigInteger minus(BigInteger bigInteger) {
		ArrayListOfBytes.Itr i = this.number.iteratorOverBytes();
		ArrayListOfBytes.Itr j = bigInteger.number.iteratorOverBytes();
		short index = 0;
		short element = 0;
		for (; i.hasNext() && j.hasNext();++index) {
			element += (short)(i.nextByte()-j.nextByte());
			if (element<0) {
				element += 256;
				this.number.set(index, (byte)(element&0xFF));
				element = -1;
			} else {
			    this.number.set(index, (byte)(element&0xFF));
				element >>>= 8;
			}
		}
		if (i.hasNext()) for (; i.hasNext() ;++index) { // TODO remove this loop
			element += (short)(i.nextByte());
			if (element<0) {
				element += 256;
				this.number.set(index, (byte)(element&0xFF));
				element = -1;
			} else {
			    this.number.set(index, (byte)(element&0xFF));
				element >>>= 8;
			}
		}
		if (bigInteger.number.getByte((short) (this.number.size()-1))==0){ // TODO
			this.number.resize((short) (this.number.size()-1));
		}
		if (j.hasNext() || element <0 ){
			this.number = new ArrayListOfBytes();
			this.number.set((short)0, (byte)(0));
			return this;
		}
		if (element!=0) this.number.set(index, (byte)(element&0xFF)); // TODO check if necessary
		element >>>= 8;
		if (element!=0) this.number.set(index, (byte)(element&0xFF));
		return this;
	}

	// TODO test TODO dry TODO performance^2
	public BigInteger times(BigInteger bigInteger) {
		BigInteger copy = new BigInteger();
		copy.is(this);
		BigInteger zero = new BigInteger((byte)0);
		BigInteger one = new BigInteger((byte)1);
		while(bigInteger.equals(zero)==false){
			bigInteger.minus(one);
			this.plus(copy);
		}
		return this;
	}

	// TODO test TODO dry TODO performance^2
	public BigInteger by(BigInteger bigInteger) {
		BigInteger result = new BigInteger((byte)0);
		BigInteger zero = new BigInteger((byte)0);
		BigInteger one = new BigInteger((byte)1);
		while(this.equals(zero)==false){
			this.minus(bigInteger);
			result.plus(one);
		}
		return result;
	}

	// TODO test TODO dry TODO performance
	public BigInteger mod(BigInteger bigInteger) {
		BigInteger result = new BigInteger((byte)0);
		BigInteger copy = new BigInteger();
		BigInteger zero = new BigInteger((byte)0);
		BigInteger one = new BigInteger((byte)1);
		while(this.equals(zero)==false){
			this.minus(bigInteger);
			copy.is(this);
			result.plus(one);
		}
		return copy;
	}

	// TODO test TODO dry TODO performance
	public BigInteger pow(BigInteger bigInteger) {
		BigInteger copy = new BigInteger();
		copy.is(this);
		BigInteger zero = new BigInteger((byte)0);
		BigInteger one = new BigInteger((byte)1);
		while(bigInteger.equals(zero)==false){
			bigInteger.minus(one);
			this.times(copy);
		}
		return this;
	}
	
	
	
	public BigInteger is(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.is(tmp);
    }

    public BigInteger plus(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.plus(tmp);
    }

    public BigInteger minus(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.minus(tmp);
    }

    public BigInteger times(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.times(tmp);
    }

    public BigInteger by(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.by(tmp);
    }

    public BigInteger mod(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.mod(tmp);
    }

    public BigInteger pow(byte num) {
        BigInteger tmp = new BigInteger(num);
        return this.pow(tmp);
    }
    
    
    
    public BigInteger is(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        return this.is(tmp);
    }

    public BigInteger plus(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        tmp.printBytes();
        return this.plus(tmp);
    }

    public BigInteger minus(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        return this.minus(tmp);
    }

    public BigInteger times(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        return this.times(tmp);
    }

    public BigInteger by(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        return this.by(tmp);
    }

    public BigInteger mod(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        return this.mod(tmp);
    }

    public BigInteger pow(byte[] num) {
        BigInteger tmp = new BigInteger(num);
        return this.pow(tmp);
    }
    
    
    public BigInteger printBytes(){
        ArrayListOfBytes.Itr i = this.number.iteratorOverBytes();
        for (; i.hasNext();) {
            System.out.print(i.nextByte());
        }
        System.out.println();
        return this;
    }
}
