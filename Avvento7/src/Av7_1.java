import java.util.*;
import java.io.*;

public class Av7_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		String line;
		List<Hand> hands = new ArrayList<Hand>();
		while((line=in.readLine())!=null) {
			hands.add(new Hand(line.split("\s+")[0],Integer.parseInt(line.split("\s+")[1])));
		}
		hands.sort(new Comparator1());
		long result=0;
		for(int i=0;i<hands.size();i++) {
			System.out.println(hands.get(i).cards+" "+hands.get(i).bid);
			result+=(i+1)*hands.get(i).bid;
		}
		System.out.println(result);
	}

}
