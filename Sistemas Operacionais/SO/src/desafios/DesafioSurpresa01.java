package desafios;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;
public class DesafioSurpresa01 {

	static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;

    public static void main(String[] args)
    {
        String[] cmds = {
            "cmd /c start cmd.exe",
            "type nul > filename.txt",
            "echo So alegria hahaha > filename.txt",
        };
        try {
            pro = run.exec(String.join("& ", cmds));

            read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
           
				read.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
    }
}