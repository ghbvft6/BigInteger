package pl.edu.pwr.wppt.cs.smartsec.math;



public class test {
	

	public static void main(String[] args) {
		
		
		
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
