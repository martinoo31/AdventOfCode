import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class av3_1 {

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		String temp;
		Map<Coppia, List<Integer>> gear = new HashMap<Coppia, List<Integer>>();
		int rows = 0, columns = 0;
		while ((temp = in.readLine()) != null) {
			rows++;
			columns = temp.length();
		}
		in.close();
		in = new BufferedReader(new FileReader("test.txt"));
		char[][] matrix = new char[rows][columns];
		int carattere;
		int i = 0;
		int j = 0;
		while ((carattere = in.read()) > -1) {
			if (carattere == '\n') {
				i++;
				j = 0;
			} else {
				matrix[i][j] = (char) carattere;
				j++;
			}
		}

		int result = 0;
		boolean valid;
		int number;
		char letto;
		char adiacente;
		String riga;
		number = 0;
		valid = false;
		Set<Coppia> positions = new HashSet<Coppia>();
		for (i = 0; i < rows; i++) {
			number = 0;
			valid = false;

			for (j = 0; j < columns; j++) {
				letto = matrix[i][j];
				if (letto >= 48 && letto <= 57) {
					number = (number * 10) + (letto - 48);
						for (int a = -1; a < 2; a++) {
							for (int b = -1; b < 2; b++) {
								try {
									adiacente = matrix[i - a][j - b];
									if (adiacente == '*') {
										valid = true;
										positions.add(new Coppia((i - a),(j - b)));
										continue;
									}
								} catch (IndexOutOfBoundsException e) {
								}
							}

						}
					if (valid && j == columns - 1) {
						for (Coppia gearPosition : positions) {
							List<Integer> operandi = gear.get(gearPosition);
							if (operandi == null) {
								operandi = new LinkedList<Integer>();
								operandi.add(number);
								gear.put(gearPosition, operandi);
							} else {
								operandi.add(number);
							}
						}
						positions=new HashSet<Coppia>();
					}
				} else {
					if (valid) {
						for (Coppia gearPosition : positions) {
							List<Integer> operandi = gear.get(gearPosition);
							if (operandi == null) {
								operandi = new LinkedList<Integer>();
								operandi.add(number);
								gear.put(gearPosition, operandi);
							} else {
								operandi.add(number);
							}
						}
						positions=new HashSet<Coppia>();
					}
					number = 0;
					valid = false;
				}
			}
		}
		for (Entry<Coppia, List<Integer>> e : gear.entrySet()) {
			List<Integer> li = e.getValue();
			if (li.size() == 2) {
				System.out.println(li.get(0) + "*" + li.get(1));
				result += li.get(0) * li.get(1);
			}
		}
		System.out.println(result);
	}

}
