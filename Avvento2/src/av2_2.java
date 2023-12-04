import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class av2_2 {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("real.txt"));
			Map<String, Integer> lut = new TreeMap<String,Integer>(); 
			
			String line;
			int result =0;
			int game;
			while((line=in.readLine())!=null) {
				lut.put("red", 0);
				lut.put("green",0);
				lut.put("blue", 0);
				boolean validGame = true;
				String[] firstSplit = line.split(":");
				String pescate[] = firstSplit[1].split(";"); 
				for(String round : pescate) {
					String cubi[] =round.split(",");
					for(String cube : cubi) {
						int cubetti = Integer.parseInt(cube.trim().split(" ")[0]);
						int cesto = lut.get(cube.trim().split(" ")[1]);
						if(cubetti>cesto) {
							lut.put(cube.trim().split(" ")[1],cubetti);
						}
					}
				}
				
				if(validGame) {
					int power = lut.get("red")*lut.get("green")*lut.get("blue");
					System.out.println(power);
					result+=power;
				}
				
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

}
