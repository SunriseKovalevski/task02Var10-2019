package runner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import entity.Word;
import runner.Runner;

public class Runner {
	public void start() {
		runner();
	}
	
	private void runner() {
		StringBuffer s = readFile();
		Word word = new Word(s);
		word.amountWords(); 	
		
	}
		
	private StringBuffer readFile() {
		String path = new File("").getAbsolutePath();
		StringBuffer s = new StringBuffer();
		try(FileReader reader = new FileReader(path + "\\source\\Test.txt"))
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
