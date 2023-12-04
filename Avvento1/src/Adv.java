import java.io.*;

public class Adv {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("/Users/Martino/Documents/Codeprojects/Rust/avvento1/avvento.txt"));
			int result =0;
			int lineResult=0;
			int firstChar = 0;
			int indexFirst=0;
			int lastChar=0;
			int indexLast=0;
			boolean first,second;
			boolean lastIsChar;
			int lastStringChar=0;
			boolean firstIsChar;
			int firstStringChar=0;
			String line;
			String[] digits={"one","two","three","four","five","six","seven","eight","nine"};
			
			while((line=in.readLine())!=null) {
				lastIsChar=false;
				firstIsChar=false;
				lineResult=0;
				first=false;
				second=false;
				for(int i=0;i<line.length();i++) {
					char temp = line.charAt(i);
					if(temp>=48 && temp<=57) {
						if(!first) {
							firstChar=temp;
							indexFirst=i;
							indexLast=i;
							first=true;
							}
						else if(first) {
							lastChar=temp;
							second = true;
							indexLast=i;}
					}
				}
				{
					for(int i=0;i<digits.length;i++) {
						if(line.contains(digits[i])) {
							int lastindex =line.lastIndexOf(digits[i]);
							if(lastindex>=indexLast) {
								indexLast=lastindex;
								lastIsChar=true;
								lastStringChar =i+1;
							}
							int firstindex = line.indexOf(digits[i]);
							if(firstindex<=indexFirst) {
								indexFirst = firstindex;
								firstIsChar=true;
								firstStringChar=i+1;
							}
						}
					}
				}
				if(firstIsChar) {
					lineResult+=firstStringChar*10;
				}
				else {
				lineResult+=(int)(firstChar-48)*10;}
				if(lastIsChar) {
					lineResult+=lastStringChar;
				}
				else {
				if(second)
					lineResult+=(int)(lastChar-48);
				else {
					lineResult+=(int)(firstChar-48);
				}
				}
				System.out.println(lineResult);
				result+=lineResult;
			}
			System.out.println(result);
		} catch (Exception e) {
			
		}

	}

}
