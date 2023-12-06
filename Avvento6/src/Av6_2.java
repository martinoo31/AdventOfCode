import java.io.*;
import java.util.Arrays;

public class Av6_2 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("real2.txt"));
		String line1 = in.readLine();
		String line2 = in.readLine();
		
		line1 = line1.split(":")[1].trim();
		line2 = line2.split(":")[1].trim();
		
		String[] stringTimes = line1.split("\s+");
		String[] stringDistances = line2.split("\s+");
		
		long[] times = new long[stringTimes.length];
		long[] distances = new long[stringTimes.length];
		for(int i=0;i<stringTimes.length;i++) {
			times[i]=Long.parseLong(stringTimes[i]);
			distances[i]=Long.parseLong(stringDistances[i]);
		}
		
		long raceDuration;
		long minimumDistance;
		long[] margins = new long[times.length];
		
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
		
		long result=1;
		for(long i : margins) {
			result = result*i;
		}
		System.out.println(result);
	}

}