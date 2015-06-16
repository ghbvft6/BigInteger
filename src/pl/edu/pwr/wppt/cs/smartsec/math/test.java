package pl.edu.pwr.wppt.cs.smartsec.math;



public class test {
	

	public static void main(String[] args) {
		byte[] num1 = {10,10,30};
		byte[] num2 = {10,10,30};
		byte[] num3 = {5,5,15};
        byte[] num4 = {15,15,45};
		BigInteger a = new BigInteger();
		BigInteger b = new BigInteger();
		System.out.println(a.plus(num1).printBytes().plus(num2).printBytes().equals(b.plus(num3).printBytes().plus(num4).printBytes()));
		
		byte[] num11 = {2};
        byte[] num22 = {0,0,2};
        byte[] num33 = {0,0,2};
        byte[] num44 = {2};
		BigInteger a2 = new BigInteger((byte)1);
        BigInteger b2 = new BigInteger((byte)1);
        System.out.println(a2.times(num11).printBytes().times(num22).printBytes().equals(b2.times(num33).printBytes().times(num44).printBytes()));
		
//		Thread t = new Thread(new Runnable(){
//			final Some x = Some.getInstance();
//			public void run() {
//				long time = System.currentTimeMillis();
//				long result=0;
//				for(int i= 0;i<50000000;++i) result+=System.currentTimeMillis();
//				System.out.println(System.currentTimeMillis()-time);
//				
//			}
//			
//		});
//		t.start();
		System.out.println("first");
		
		
//	    BigInteger a = new BigInteger((byte)1);
//	    BigInteger b = new BigInteger((byte)1);
//	    BigInteger c = new BigInteger((byte)2);
//	    BigInteger d = new BigInteger((byte)0xFF);
//	    BigInteger e = new BigInteger((byte)0x10);
//	    BigInteger d2 = new BigInteger((byte)0xEF);
//	    BigInteger e2 = new BigInteger((byte)0x20);
//	    System.out.println(a.plus(b).equals(c));
//	    System.out.println(a.minus(b).equals(b));
//	    System.out.println(e.plus(d).equals(d2.plus(e2)));
//		short arr[] = new short[10];
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

//package pl.edu.pwr.wppt.cs.smartsec.math;
//
//import javacard.framework.*;
//
//    public class test extends Applet {
//
//	/*public class SampleClass<E>{
//		public static E a;
//	}*/
//
//	//public static SampleClass a = new SampleClass<s>();
//
//	static final byte PLAIN_CLA = (byte) 0x00;
//	
//	public static void install(byte[] bArray,short bOffset,byte bLength) {
// 	  new test(bArray, bOffset, bLength);
//  	} 
//	
//  	private test (byte[] bArray, short bOffset, byte bLength){
//			register();
//  	}
//	
//	public boolean select() {
//          return true;
//  	}
//
//	public void deselect() {
//	}
//	
//  	public void process(APDU apdu) {
//		if (selectingApplet()) {
//			return;
//		}
//		byte[] buffer = apdu.getBuffer();
//		apdu.setIncomingAndReceive();
//		short lenOfData = (short)(buffer[ISO7816.OFFSET_LC]);
//		byte[] tmp = new byte[lenOfData];
//		
//		Util.arrayCopyNonAtomic(buffer, ISO7816.OFFSET_CDATA, tmp, (short)0, (short)tmp.length);
//		
//		for(short i=(short)0; i<lenOfData;i++){
//			buffer[i]= tmp[(short)(tmp.length-1-i)];
//		}
//		
//	    BigInteger d = new BigInteger((byte)0xFF);
//	    BigInteger e = new BigInteger((byte)0x10);
//	    BigInteger d2 = new BigInteger((byte)0xEF);
//	    BigInteger e2 = new BigInteger((byte)0x20);
//	    
//	    buffer = e.plus(d).getBytes();
//		
//		apdu.setOutgoingAndSend((short) 0, (short)buffer.length);
// 	}
//
//}
