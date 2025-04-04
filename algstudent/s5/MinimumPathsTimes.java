package labs.en._25.algstudent.s5;

import java.util.Random;

//MINIMUM PATHS IN A GRAPH BY FLOYD-WARSHALL
//IT IS A SOLUTION BY DYNAMIC PROGRAMMING
//ITS TIME COMPLEXITY IS CUBIC O(n^3)
public class MinimumPathsTimes {
	private static final int MIN_WEIGHT = 10;
	private static final int MAX_WEIGHT = 100;
	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths

	public static void main(String arg[]) {
		long t1, t2;

		for (int n = 200; n <= 1000000000; n *= 2) {
			

			t1 = System.currentTimeMillis();

			run(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1));
		}
	}
	
	public static void run(int size) {
		int n = size; //nodes of example graph
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];

		fillInWeights(weights); //weights for the example
//		System.out.println("WEIGHT MATRIX IS:");
		printMatrix(weights);

		floyd(weights, costs, p);

//		System.out.println("MINIMUM COST MATRIX IS:");
		printMatrix(costs);

//		System.out.println("P MATRIX IS:");
		printMatrix(p);

//		System.out.println();
//		System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
//		System.out.println();
		for (int source = 0; source <= n-1; source++)
			for (int target = 0; target <= n-1; target++)
				if (source != target) {
//					System.out.print("FROM " + v[source] + " TO " + v[target] + " = ");
					minimumPath(v, weights, costs, p, source, target);
//					System.out.println();
					if (costs[source][target] < 10000000);
//						System.out.println("MINIMUM COST=" + costs[source][target]);
//					System.out.println("**************");
				}

	}

	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				costs[i][j]=weights[i][j];
				p[i][j]=-1;
			}
		}
		
		for (int pivot = 0; pivot < n; pivot++) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (costs[i][j] > costs[i][pivot] + costs[pivot][j]) {
	                    costs[i][j] = costs[i][pivot] + costs[pivot][j];
	                    p[i][j] = pivot;
	                }
	            }
	        }
	    }
	}

	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
		int pivot = steps[source][target];
		if(pivot!=-1) {
//			System.out.print(v[source]+"->");
			path(v,steps,source,pivot);
//			System.out.print(v[pivot]+"->");
			path(v,steps,pivot,target);
//			System.out.print(v[target]);
		} else if(costs[source][target]==10000000) {
//			System.out.print("NO PATH FOUND");
		}else {
//			System.out.print(v[source]+"->"+v[target]);
		}
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if(steps[i][j]!=-1) {
			int pivot=steps[i][j];
			path(v,steps,i,pivot);
//			System.out.print(v[pivot]+"->");
			path(v,steps,pivot,j);
		}
	}

	/* load the example cost matrix */
	static void fillInWeights(int[][] w) {
		for (int i = 0; i < w.length; i++)
			for (int j = 0; j < w.length; j++)
				if(i==j)
					w[i][j]=0;
				else
					w[i][j] = 10000000;

		Random r = new Random();
		for (int i = 0; i < w.length; i++)
			for (int j = 0; j < w.length; j++) {
				if(i!=j) {
					if(w[j][i]==10000000) {
						if(r.nextInt(10)<5) {
							weights[i][j]=r.nextInt(MIN_WEIGHT,MAX_WEIGHT);
						}
					}
				}
			}
	}
	
	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
			}
//				System.out.print(String.format("%10s", a[i][j]));
//			System.out.println();
		}
//		System.out.println();
	}

}