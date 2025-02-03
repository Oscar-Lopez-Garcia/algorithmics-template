package lab0;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class JavaA1 {

	public JavaA1() {
		for(int i = 10000; i<=640000;i=i*2) {
					Time t1 = new Time(1000000);
			        List<Integer> primes = listadoPrimos(i);
			        Time t2 = new Time(1000000);
			        System.out.println("n ="+ i + "*** time =" + ((t2.getTime()-t1.getTime()))+ " milliseconds)");
			      
		}
	}
	
	private boolean primoA1(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	private List<Integer> listadoPrimos(int n) {
		List<Integer> primes = new ArrayList<>();
		
		for(int i = 2; i <=n;i++)
			if(primoA1(i))
				primes.add(i);
		
		return primes;
	}
}
