package lab0;

public class Loop5 {
	
	public static long loop5(long n) {
		long cont = 0;
		long n1 = n;
		long n2 = n;
		do {
			do {
				for (long i = 1; i <= n; i++)
					for (long j = n; j >= 0; j -= 2)
						cont++;
				n2=n2/2;
			} while(n2>=1);
			n1 = n1 / 2;
		} while (n1 >= 1);

		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (long n = 100; n <= 819200; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop5(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);

		} // for
	} // main
	
} 