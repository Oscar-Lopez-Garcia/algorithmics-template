package algstudent.s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphColouring {

	static String[] colours = {"red", "blue", "green", "yellow","orange",
			"purple", "cyan", "magenta", "lime"};
	
	public static Map<String, String> greedy(Map<String, List<String>> graph) {
		Map<String,String> solution = new HashMap<String,String>();
		
		List<String> used= new ArrayList<>();
		
		List<String> visited = new ArrayList<>();
		
		for(String s:graph.keySet())
			solution.put(s, colours[0]);
		
		used.add("red");
		
		for(int i=0;i<solution.size();i++) {
			String node = selectNextNode(graph,visited);
			
			String[] aux = new String[graph.get(node).size()];
			
			for(int j=0;j<graph.get(node).size();j++) {
				aux[j]=String.valueOf(graph.get(node).get(j));
			}
			
			for(String s:aux)
				if(solution.get(s).equals(solution.get(node))) 
					solution.put(s, selectColourDifferentFrom(solution.get(node),used));
			used.add(solution.get(node));
		}
		return solution;
	}

	private static String selectNextNode(Map<String, List<String>> graph, List<String> visited) {
		int max = 0;
		String key = null;
		for(String s:graph.keySet())
			if(graph.get(s).size()>max && !visited.contains(s)) {
				max = graph.get(s).size();
				key=s;
			}
		visited.add(key);
		return key;
	}

	private static String selectColourDifferentFrom(String colour, List<String> used) {
		for(String s: colours) {
			if(s!=colour && !used.contains(s))
				return s;
		}
		return null;
	}

}
