import java.io.*;
import java.util.Vector;

public class Av5_1  {
	
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		Vector<Long> seeds=new Vector<Long>();
		String[] seedsS=in.readLine().split(":")[1].trim().split("\s+");
		
		for(String s:seedsS) {
			seeds.add(Long.parseLong(s));
		}
		String line;
		Vector<Long> map=new Vector<Long>(seeds);
		long[] mappings= new long[3];
		int numberOfSeeds = seeds.size();
		String[] stringMapping;
		//boolean startMapping = false;
		while((line=in.readLine())!=null) {
			if(line.isEmpty()) {
				continue;}
			if(line.contains("map")) {
				if(map.size()<numberOfSeeds) {
				for(Long s : seeds) {
					map.add(s);
				}}
				seeds=new Vector<Long>(map);
				map = new Vector<Long>();
			}
			else {
				stringMapping = line.split("\s+");
				for(int i=0;i<stringMapping.length;i++) {
					mappings[i]=Long.parseLong(stringMapping[i]);
				}
				long lowerBound=mappings[1];
				long upperBound=mappings[1]+mappings[2];
				long seed;
				for(int i=0;i<seeds.size();i++) {
					seed = seeds.get(i);
					if(seed<upperBound && seed>=lowerBound) {
						map.add(mappings[0]+(seed-lowerBound));
						seeds.remove(i);
						i--;
					}
				}				
			}
		}
		if(map.size()<numberOfSeeds) {
			for(Long s : seeds) {
				map.add(s);
			}}
		long min=map.get(0);
		for(Long m : map) {
			System.out.println(m);
			if(min>m) {
				min =m;
			}
		}
		System.out.println(min);
	}	
}
