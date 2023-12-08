import java.util.*;
import java.io.*;

public class Av8_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader( new FileReader("real.txt"));
		String instructions = in.readLine();
		in.readLine();
		String temp;
		Map<String,Coordinates> map = new TreeMap<String,Coordinates>();
		while((temp=in.readLine())!=null) {
			String start = temp.split("=")[0].trim();
			Coordinates end = new Coordinates(temp.split("=")[1].trim());
			map.put(start, end);
		}
		int steps =0;
		int instructionCounter =0;
		String currentPosition = "AAA";
		while(!currentPosition.equals("ZZZ")) {
			System.out.println(currentPosition);
			Coordinates path = map.get(currentPosition);
			if(instructions.charAt(instructionCounter)=='L')
				currentPosition = path.left;
			else {
				currentPosition = path.right;
			}
			steps++;
			instructionCounter++;
			if(instructionCounter>=instructions.length())
				instructionCounter=0;
		}
		System.out.println(steps);

	}

}
