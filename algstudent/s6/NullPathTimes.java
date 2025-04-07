package s6;

public class NullPathTimes {

	public static void main(String[] args) {       
        for (int n = 55; n <= 10000000; n += 5) {
            long total = 0;
            for (int i = 0; i < 100; i++) {
                long start = System.currentTimeMillis();
                new NullPath(n);
                long end = System.currentTimeMillis();
                total += (end - start);
            }
            System.out.println(n + ":\t" + total / 100);
        }
	}

}
