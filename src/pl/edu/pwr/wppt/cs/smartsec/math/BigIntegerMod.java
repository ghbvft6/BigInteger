package pl.edu.pwr.wppt.cs.smartsec.math;

public class BigIntegerMod extends BigInteger {

	public BigInteger modulus = null;

	public BigIntegerMod() {
	}

	public BigIntegerMod(BigInteger bigInteger) {
		super(bigInteger);
	}

	public BigIntegerMod(String number) throws Exception {
		super(number);
	}

	public BigIntegerMod(byte number) throws Exception {
		super(number);
	}

	public BigInteger is(BigInteger bigInteger) {
		return super.is(bigInteger).mod(modulus);
	}

	public BigInteger plus(BigInteger bigInteger) {
		return super.plus(bigInteger).mod(modulus);
	}

	public BigInteger minus(BigInteger bigInteger) {
		return super.minus(bigInteger).mod(modulus);
	}

	public BigInteger times(BigInteger bigInteger) {
		return super.times(bigInteger).mod(modulus);
	}

	public BigInteger by(BigInteger bigInteger) {
		return super.by(bigInteger).mod(modulus);
	}

	public BigInteger mod(BigInteger bigInteger) {
		return super.mod(bigInteger).mod(modulus);
	}

	// TODO through RSA
	public BigInteger pow(BigInteger bigInteger) {
		return super.pow(bigInteger).mod(modulus);
	}
}
