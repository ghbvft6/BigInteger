package pl.edu.pwr.wppt.cs.smartsec.math;

public class test {

	public static void main(String[] args) {
	    BigInteger a = new BigInteger((byte)1);
	    BigInteger b = new BigInteger((byte)1);
	    BigInteger c = new BigInteger((byte)2);
	    System.out.println(a.plus(b).equals(c));
	    System.out.println(a.minus(b).equals(b));
		short arr[] = new short[10];
		// BoxedShortArray a = new BoxedShortArray(arr);
		// TODO Auto-generated method stub
		// new BigNum("-1");
		/*
		 * byte t = (byte) 256; t -= (byte)0x01; System.out.println("t"+t);
		 * ArrayIteratorIndexCalculator[] testme = new
		 * ArrayIteratorIndexCalculator[10000000]; int i = 0; while(i<10000000){
		 * if(System.nanoTime()%2==0L){ testme[i] =
		 * ArrayIteratorIndexDec.getInstance(); }else{ testme[i] =
		 * ArrayIteratorIndexInc.getInstance(); } ++i; } i = 50000000;
		 * while(true){ try { Thread.sleep(11); } catch (InterruptedException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 * if(System.nanoTime()%2==0L){ i = testme[i].nextIndex((short)i);
		 * System.out.println(i); }else{ System.out.println(i); } }
		 */
	}

}
