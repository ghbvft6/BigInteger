package pl.edu.pwr.wppt.cs.smartsec.memory;

//import java.nio.ByteOrder;

//import sun.misc.Unsafe;

public class Endian {
	private Endian() {
	};

	public static final Endian BIG = new Endian();
	public static final Endian LITTLE = new Endian();
	public static final Endian NATIVE = Endian.LITTLE;//nativeEndian(); // Endian.LITTLE; //
														// FIXME

	/*private static Endian nativeEndian() {
		final Unsafe unsafe = Unsafe.getUnsafe();
		// long a = unsafe.allocateMemory(8);
		final short a = (short) unsafe.allocateMemory(2);
		try {
			// unsafe.putLong(a, 0x0099999999999911L);
			unsafe.putLong(a, 0x0011L);
			final byte b = unsafe.getByte(a);
			switch (b) {
			case 0x00:
				return Endian.BIG;
				// case 0x11:
				// NATIVE = Endian.LITTLE;
				// break;
				// default:
				// NATIVE = Endian.NATIVE;
				// throw new Error("Unknown byte order");
			default:
				return Endian.NATIVE;
			}
		} finally {
			unsafe.freeMemory(a);
		}

	}*/
}

// public enum Endian {
// BIG_ENDIAN,
// LITTLE_ENDIAN
// }
