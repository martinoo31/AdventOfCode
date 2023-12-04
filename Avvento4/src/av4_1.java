import java.io.*;
import java.util.*;

public class av4_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("real.txt"));
		int result =0;
		String line;
		String[] temp;
		int matches;
		String[] vincentiS;
		String[] possedutiS;
		
		int[] vincenti;
		int[] posseduti;
		List<Integer> gratta=new ArrayList<Integer>();;
		int prova;
		int numLine=0;
		while((line=in.readLine())!=null) {
			try {gratta.get(numLine);}catch(IndexOutOfBoundsException e) {
				gratta.add(0);
			}
			matches=0;
			temp = line.split(":");
			vincentiS = temp[1].split("\\p{Punct}")[0].trim().split("\\s+");
			possedutiS = temp[1].split("\\p{Punct}")[1].trim().split("\\s+");
			vincenti = new int[vincentiS.length];
			for(int i=0;i<vincentiS.length;i++) {
				vincenti[i] = Integer.parseInt(vincentiS[i]);
			}
			posseduti = new int[possedutiS.length];
			for(int i=0;i<possedutiS.length;i++) {
				posseduti[i] = Integer.parseInt(possedutiS[i]);
			}
			for(int i=0;i<posseduti.length;i++) {
				prova = posseduti[i];
				for(int j=0;j<vincenti.length;j++) {
					if(prova==vincenti[j]) {
						matches++;
						break;
					}
				}
			}
			if(matches>0) {
				int multiplier= 1+gratta.get(numLine);
				for(int i=1;i<=matches;i++) {
					if(numLine+i>=gratta.size()) {
						gratta.add(1*multiplier);
					}
					else {
						int previousMatches = gratta.get(i+numLine);
						gratta.set(i+numLine, (previousMatches+1*multiplier));
						//System.out.println((previousMatches+1*multiplier));
					}
				}
				
			}
			numLine++;
		}
		for(Integer i:gratta) {
			System.out.println(i+1);
		}
		result = gratta.parallelStream().mapToInt(a->(a+1)).sum();
		System.out.println(result);
	}

}
