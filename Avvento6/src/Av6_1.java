import java.io.*;
import java.util.Arrays;

public class Av6_1 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		String line1 = in.readLine();
		String line2 = in.readLine();
		
		line1 = line1.split(":")[1].trim();
		line2 = line2.split(":")[1].trim();
		
		String[] stringTimes = line1.split("\s+");
		String[] stringDistances = line2.split("\s+");
		
		int[] times = new int[stringTimes.length];
		int[] distances = new int[stringTimes.length];
		for(int i=0;i<stringTimes.length;i++) {
			times[i]=Integer.parseInt(stringTimes[i]);
			distances[i]=Integer.parseInt(stringDistances[i]);
		}
		
		int raceDuration;
		int minimumDistance;
		int[] margins = new int[times.length];
		
		for(int i=0;i<times.length;i++) {
			raceDuration = times[i];
			minimumDistance = distances[i];
			
			for(int j=0;j<raceDuration;j++) {
				int speed = j;
				if(minimumDistance<((raceDuration-speed)*speed)) {
					margins[i]++;
				}
			}			
		}
		
		int result=1;
		for(int i : margins) {
			System.out.println(i);
			result = result*i;
		}
		System.out.println(result);
	}

}
