import java.util.*;
import java.io.*;

public class Av9_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		long result=0;
		String line;
		String numbers[];
		while((line=in.readLine())!=null) {
			numbers = line.split("\s+");
			Vector<Integer> e = new Vector<Integer>();
			for(int i=0;i<numbers.length;i++) {
				e.add(Integer.parseInt(numbers[i]));
			}
			Vector<Vector<Integer>> comp = new Vector<Vector<Integer>>();
			comp.add(e);
			boolean allZeros = false;
			while(!allZeros) {
				allZeros=true;
				Vector<Integer> r=comp.lastElement();
				for(int i=0;i<r.size();i++) {
					if(r.get(i)!=0) {
						allZeros = false;
						break;
					}
				}
				if(!allZeros) {
					Vector<Integer> differences = new Vector<Integer>();
					for(int i=0;i<(r.size()-1);i++) {
						differences.add(r.get(i+1)-r.get(i));
					}
					comp.add(differences);					
				}
				else {
					long serieSolution =0;
					for(int i=comp.size()-1;i>=0;i--) {
						serieSolution+=comp.get(i).lastElement();
						System.out.print(serieSolution+" ");
					}
					System.out.println();
					result+=serieSolution;
					
				}
			}
			
		}
		System.out.println(result);
	}

}
