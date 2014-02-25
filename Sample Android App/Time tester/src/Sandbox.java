
public class Sandbox {
	
	public static void main(String[] args){
		
		long test1 = System.currentTimeMillis();
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		long test2 = System.currentTimeMillis();
		System.out.println((test2-test1)/1000);
		
	}

}
