package entity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {
	private StringBuffer s;

	public Word(StringBuffer s) {
		this.s = s;
	}

	public void amountWords() {
		String[] str = s.toString().split("(?=[�-�_A-Z])");
		StringBuffer word = readWords();
		int count = 0;
		int c = 0;
		List<Integer> intW = new ArrayList<>();
		String[] w = word.toString().split("\\s+");
		for(int j = 0; j < w.length; j++) {
			intW.add(j,0);
		}
		
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("[\\s.,;:]\\s*");
			for(int j = 0; j < w.length; j++) {
				for(int n = 0; n < words.length; n++) {
					if(w[j].equals(words[n]))count++;
				}
				c = i + 1; 
				System.out.println("\"" + w[j] + "\"" + " ����������� � ���������� " + count + " ��� � " + c + " �����������");
				intW.set(j, intW.get(j) + count);
				count = 0;
			}
			System.out.println("*****************************************************");
		}
		Collections.sort(intW);
		Collections.reverse(intW);
		System.out.println("=====================================================");
		System.out.println("����� ���������� ���������:");
		for(int j = 0; j < w.length; j++) {
			System.out.println("\"" + w[j] + "\"" + " ����������� � ���������� " + intW.get(j) + " ��� � ������");
		}
		System.out.println("=====================================================");
	}

	private StringBuffer readWords() {
		StringBuffer s = new StringBuffer();
		String path = new File("").getAbsolutePath();
		try(FileReader reader = new FileReader(path + "//source//Words.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                 s.append((char)c);
            } 
        }
        catch(IOException e){
             e.printStackTrace();
        }
		return s;
	}
}
