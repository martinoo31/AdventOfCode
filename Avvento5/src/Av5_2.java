import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Av5_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		Vector<Range> seeds=new Vector<Range>();
		String[] seedsS=in.readLine().split(":")[1].trim().split("\s+");
		
		for(int i=0;i<seedsS.length;i+=2) {
			seeds.add(new Range(Long.parseLong(seedsS[i]),Long.parseLong(seedsS[i+1])));
		}
		String line;
		Vector<Range> map=new Vector<Range>(seeds);
		long[] mappings= new long[3];
		int numberOfRanges = seeds.size();
		String[] stringMapping;
		//boolean startMapping = false;
		while((line=in.readLine())!=null) {
			if(line.isEmpty()) {
				continue;}
			if(line.contains("map")) {
				if(map.size()<numberOfRanges) {
				for(Range r : seeds) {
					map.add(r);
				}}
				seeds=new Vector<Range>(map);
				map = new Vector<Range>();
			}
			else {
				stringMapping = line.split("\s+");
				for(int i=0;i<stringMapping.length;i++) {
					mappings[i]=Long.parseLong(stringMapping[i]);
				}
				long lowerBound=mappings[1];
				long upperBound=mappings[1]+mappings[2];
				Range range;
				for(int i=0;i<seeds.size();i++) {
					range= seeds.get(i);
					if(range.end<upperBound && range.end>=lowerBound && range.start <lowerBound) {
						map.add(new Range(mappings[0],range.end-lowerBound+1));
						range.setEnd(lowerBound-1);
						numberOfRanges++;
					}
					else if(range.end<upperBound && range.start>=lowerBound) {
						seeds.remove(range);
						map.add(new Range(mappings[0]+(range.start-lowerBound),range.length));						
						i--;
					}
					else if(range.end>upperBound && range.start>=lowerBound && range.start <upperBound) {
						map.add(new Range(mappings[0]+(range.start-lowerBound),(upperBound-range.start)));
						range.setEnd(range.start);
						numberOfRanges++;
					}
					else if(range.end>=upperBound && range.start<=lowerBound) {
						map.add(new Range(mappings[0],upperBound-lowerBound));
						seeds.remove(range);
						i--;
						if(range.end>upperBound) {
							seeds.add(new Range(upperBound,range.end-upperBound));
							numberOfRanges++;
						}
						if(range.start<lowerBound) {
							seeds.add(new Range(range.start,lowerBound-range.start));
							numberOfRanges++;
						}
					}
				}				
			}
		}
		if(map.size()<numberOfRanges) {
			for(Range r : seeds) {
				map.add(r);
			}}
		long min=map.get(0).end;
		for(Range r : map) {
			System.out.println(r.start);
			if(min>r.start) {
				min =r.start;
			}
		}
		System.out.println(min);
	

	}

}
