package basico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Instruction instruction = new Instruction();
		ArrayList<String> instructionsArray;
		
		instructionsArray = Utils.readFiles();
		
		for (String string : instructionsArray) {
			String numberConvertido = Utils.formater(Utils.converter(string));
			
			instruction.verifyOperationType(numberConvertido);

			System.out.println(string);
			System.out.println(numberConvertido);
//			System.out.println("A operação identificada é de: " + instruction.getOperationName());
//			System.out.println(instruction.printInstByType(instruction.getType()) + "\n");
			System.out.println(instruction.getOperationName().concat(instruction.getRs()
					+ instruction.getRd())
					+ instruction.getRt());
		}

		System.out.println("A operação identificada é de: " 
				+ instruction.getOperationName());
		
		/*try {
			FileWriter exitFile = new FileWriter("C:\\New Folder/saida.txt");
			PrintWriter recordFile = new PrintWriter(exitFile);
			recordFile.printf(instruction.getOperationName());
			exitFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

}
