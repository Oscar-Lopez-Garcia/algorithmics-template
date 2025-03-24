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
		
		for(String s:graph.keySet())
			solution.put(s, colours[0]);
		
		List<String> nodes = sortNodes(graph);
		
		for(String node:nodes) {
			
			String[] neighbour = new String[graph.get(node).size()];
			List<String> used= new ArrayList<>();
			
			for(int j=0;j<graph.get(node).size();j++) {
				neighbour[j]=String.valueOf(graph.get(node).get(j));
			}
			
			for(String s:neighbour)
				used.add(solution.get(s));
			
			for (String colour : colours) {
                if (!used.contains(colour)) {
                    solution.put(node, colour);
                    break;
                }
            }
		}
		return solution;
	}

	private static List<String> sortNodes(Map<String, List<String>> graph) {
		 List<String> nodes = new ArrayList<>(graph.keySet());
	     List<String> sortedNodes = new ArrayList<>();

	     while (!nodes.isEmpty()) {
	         String maxNode = nodes.get(0);
	         int maxDegree = graph.get(maxNode).size();

	         for (String node : nodes) {
	             if (graph.get(node).size() > maxDegree) {
	                 maxNode = node;
	                 maxDegree = graph.get(node).size();
	             }
	         }

	         sortedNodes.add(maxNode);
	         nodes.remove(maxNode);
	     }

	     return sortedNodes;
	}


}
