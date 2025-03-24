package algstudent.s4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GreedyTimes {

	public static void main(String[] args) {
		long t1, t2;

		for (int n = 8; n <= 65536; n *= 2) {

			t1 = System.currentTimeMillis();
		
			greedy(n);
				
			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1));
		}
	}

	public static void greedy(int n) {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader("g"+n+".json")) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			@SuppressWarnings("unchecked")
			Map<String, List<String>> graph = (Map<String, List<String>>) jsonObject.get("graph");

			Map<String, String> solution = GraphColouring.greedy(graph);
			try (FileWriter file = new FileWriter("solution.json")) {
				file.write(new JSONObject(solution).toJSONString());
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
