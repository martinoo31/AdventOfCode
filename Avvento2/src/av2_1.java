import java.io.*;
import java.util.*;

public class av2_1 {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("real.txt"));
			Map<String, Integer> lut = new TreeMap<String,Integer>(); 
			lut.put("red", 12);
			lut.put("green",13);
			lut.put("blue", 14);
			String line;
			int result =0;
			int game;
			while((line=in.readLine())!=null) {
				boolean validGame = true;
				String[] firstSplit = line.split(":");
				game = Integer.parseInt(firstSplit[0].split(" ")[1]);
				String pescate[] = firstSplit[1].split(";"); 
				for(String round : pescate) {
					String cubi[] =round.split(",");
					for(String cube : cubi) {
						int cubetti = Integer.parseInt(cube.trim().split(" ")[0]);
						int cesto = lut.get(cube.trim().split(" ")[1]);
						if(cubetti>cesto) {
							validGame = false;
							break;
						}
					}
					if(!validGame) {
						break;
					}
				}
				
				if(validGame) {
					System.out.println(game);
					result+=game;
				}
				
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
