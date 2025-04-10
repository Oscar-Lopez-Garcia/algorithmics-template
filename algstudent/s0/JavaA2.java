package lab0;

import java.util.ArrayList;
import java.util.List;

public class JavaA2 {

	public JavaA2() {
		for(int i = 10000; i<=640000;i=i*2) {
					long t1 = System.currentTimeMillis();
			        List<Integer> primes = listadoPrimos(i);
			        long t2 = System.currentTimeMillis();
			        System.out.println("n ="+ i + "*** time =" + ((t2-t1))+ " milliseconds)");
			      
		}
	}
	
	private boolean primoA2(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	private List<Integer> listadoPrimos(int n) {
		List<Integer> primes = new ArrayList<>();
		
		for(int i = 2; i <=n;i++)
			if(primoA2(i))
				primes.add(i);
		
		return primes;
	}
}
