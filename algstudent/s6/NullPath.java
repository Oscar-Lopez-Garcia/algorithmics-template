package s6;

import java.util.Random;

public class NullPath {

	private static final int MIN_WEIGHT = 10;
	private static final int MAX_WEIGHT = 99;
	private static final int TOLERANCE = 99;
	private static int[][] weights;
	private static boolean[] visited;
	private static int[] nodes;
	
	public static void main(String arg[]) {
		int n = 50;
		int origin = 0;
		int end = n-1;
		visited = new boolean[n];
		weights=new int[n][n];
		nodes=new int[n];
		nodes[origin]=0;
		nodes[end]=n-1;
		fillInWeights(weights);
		findNullPath(origin, end);
	}

	private static void findNullPath(int origin, int end) {
		int sum = 1;
		int cost = 0;
		visited[origin] = true;
		for(int i = 0;i<weights.length-1;i++) {
			if(i!=origin && i!=end) {
				visited[i]=true;
				cost+=weights[origin][i];
				int prev = nodes[i];
				nodes[i]=sum;
				sum++;
				checkPath(i,end,cost,sum);
				cost-=weights[origin][i];
				sum--;
				nodes[i]=prev;
				visited[i]=false;
			}
		}
	}
	


	private static void checkPath(int current, int end, int cost,int sum) {
		boolean finished = true;
		for(int i=0;i<visited.length;i++) {
			if(i!=end)
				if(!visited[i]) {
					finished=false;
					break;
				}
		}
		
		if(finished) {
			cost+=weights[current][end];
			nodes[end]=sum;
			if(cost<=TOLERANCE) {
				System.out.println("SOLUTION FOUND");
				int count =0;
				for(int i=0;i<nodes.length;i++) {
					if(nodes[i]==count) {
						System.out.print(nodes[i]+" ");
						count++;
						continue;
					}
				}
				System.exit(0);
			}
		}
		
			for(int i=0;i<visited.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					cost+=weights[current][i];
					int prev = nodes[i];
					nodes[i]=sum;
					sum++;
					checkPath(i,end,cost,sum);
					cost-=weights[current][i];
					sum--;
					nodes[i]=prev;
					visited[i]=false;
				}	
			}
		
	}

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
					if(r.nextInt(10)<5) {
						w[i][j]=r.nextInt(MIN_WEIGHT,MAX_WEIGHT);
					} else {
						w[i][j]=-r.nextInt(MIN_WEIGHT,MAX_WEIGHT);
					}
				}
			}
	}
	
	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}
}
