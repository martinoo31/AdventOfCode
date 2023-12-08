import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Av8_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		String instructions = in.readLine();
		in.readLine();
		String temp;
		Map<String, Coordinates> map = new TreeMap<String, Coordinates>();
		List<String> currentNodes = new ArrayList<String>();
		while ((temp = in.readLine()) != null) {
			String start = temp.split("=")[0].trim();
			if (start.charAt(2) == 'A')
				currentNodes.add(start);
			Coordinates end = new Coordinates(temp.split("=")[1].trim());
			map.put(start, end);
		}
		int steps = 0;
		int instructionCounter = 0;
		int[] stepsPerPath = new int[currentNodes.size()];
		for (int i = 0; i < currentNodes.size(); i++) {
			String currentPosition = currentNodes.get(i);
			while (currentPosition.charAt(2) != 'Z') {
				Coordinates path = map.get(currentPosition);
				if (instructions.charAt(instructionCounter) == 'L')
					currentPosition = path.left;
				else {
					currentPosition = path.right;
				}
				steps++;
				instructionCounter++;
				if (instructionCounter >= instructions.length())
					instructionCounter = 0;
			}
			System.out.println(steps);
			stepsPerPath[i] = steps;
			steps = 0;
			instructionCounter = 0;
		}
		int maxFactor = 0;
		Map<Integer,Integer> factor = new TreeMap<Integer,Integer>();
		for (int number : stepsPerPath) {
			int numberX =number;
			for (int i = 2; i <= numberX; i++) {
				int counter =0;
				while (numberX % i == 0) {
					counter++;
					if(i>maxFactor) {
						maxFactor = i;
					}
					numberX = numberX / i;
				}
				if(counter >0 &&(factor.get(i)==null || counter>factor.get(i)))
					factor.put(i, counter);
			}
		}
		long result=1;
		for(Entry<Integer,Integer> e : factor.entrySet()) {
			long primeFactor = (long)Math.pow(e.getKey(), e.getValue());
			System.out.println(primeFactor);
			result = result*primeFactor;
		}
		System.out.println(result);
	}

}
