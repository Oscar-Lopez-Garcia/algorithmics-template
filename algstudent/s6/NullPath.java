package s6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NullPath {

	private static final int MIN_WEIGHT = 10;
	private static final int MAX_WEIGHT = 99;
	private static final int TOLERANCE = 99;
	private boolean found = false;
	private List<Integer> nullPath;
	private static int[][] weights;
	private static boolean[] visited;
	private static int[] nodes;
	
	public NullPath(int n) {
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

	private void findNullPath(int origin, int end) {
		List<Integer> path = new ArrayList<>();
		path.add(origin);
		int cost = 0;
		visited[origin] = true;
		backtrack(origin,end,cost,path,visited);
//		if (found) {
//            System.out.println("NullPath found: " + nullPath);
//        } else {
//            System.out.println("No valid NullPath found.");
//        }
	}
	


	private void backtrack(int current, int end, int cost,List<Integer> path,boolean[] visited) {
		if(found) {
			return;
		}
		
		if(current==end && path.size()==visited.length) {
			if(cost<=TOLERANCE && cost>=-TOLERANCE) {
				found = true;
				nullPath = List.copyOf(path);
//				System.out.println("SOLUTION FOUND");
			}
		}
		
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				path.add(i);
				int sum = cost+weights[current][i];
				backtrack(i,end, sum,path,visited);
				path.remove(path.size()-1);
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
