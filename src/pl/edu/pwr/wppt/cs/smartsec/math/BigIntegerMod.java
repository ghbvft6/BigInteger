package pl.edu.pwr.wppt.cs.smartsec.math;

import pl.edu.pwr.wppt.cs.smartsec.container.array.ArrayListOfBytes;

public class BigIntegerMod extends BigInteger {

	public BigInteger modulus = null;

	public BigIntegerMod() {
	}

	public BigIntegerMod(BigInteger bigInteger) {
		super(bigInteger);
	}

//	public BigIntegerMod(String number) throws Exception {
//		super(number);
//	}

	public BigIntegerMod(byte number) throws Exception {
		super(number);
	}	

    public BigIntegerMod(byte[] number) {
        super(number);
    }
    
    

    public BigIntegerMod is(BigInteger bigInteger) {
		super.is(bigInteger).mod(modulus);
		return this;
	}

	public BigInteger plus(BigInteger bigInteger) {
		super.plus(bigInteger).mod(modulus);
		return this;
	}

	public BigInteger minus(BigInteger bigInteger) {
		super.minus(bigInteger).mod(modulus);
		return this;
	}

	public BigInteger times(BigInteger bigInteger) {
		super.times(bigInteger).mod(modulus);
		return this;
	}

	public BigInteger by(BigInteger bigInteger) {
		super.by(bigInteger).mod(modulus);
		return this;
	}

	public BigInteger mod(BigInteger bigInteger) {
		super.mod(bigInteger).mod(modulus);
		return this;
	}

	// TODO through RSA
	public BigInteger pow(BigInteger bigInteger) {
		super.pow(bigInteger).mod(modulus);
		return this;
	}
	
	
	
    public BigIntegerMod is(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.is(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger plus(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.plus(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger minus(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.minus(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger times(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.times(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger by(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.by(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger mod(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.mod(bigInteger).mod(modulus);
        return this;
    }

    // TODO through RSA
    public BigInteger pow(byte num) {
        BigInteger bigInteger = new BigInteger(num);
        super.pow(bigInteger).mod(modulus);
        return this;
    }
    
    
    
    public BigIntegerMod is(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.is(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger plus(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.plus(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger minus(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.minus(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger times(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.times(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger by(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.by(bigInteger).mod(modulus);
        return this;
    }

    public BigInteger mod(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.mod(bigInteger).mod(modulus);
        return this;
    }

    // TODO through RSA
    public BigInteger pow(byte[] num) {
        BigInteger bigInteger = new BigInteger(num);
        super.pow(bigInteger).mod(modulus);
        return this;
    }
}
