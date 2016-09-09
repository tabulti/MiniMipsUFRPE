package basico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Utils {
	
	private static String FILE_PATH_OUTPUT = "C:\\New folder/saida_novo.txt";
	private static String FILE_PATH_INPUT = "C:\\Users\\Joao Paulo Ribeiro\\Documents\\MiniMipsUFRPE\\Projeto 1 - Arquitetura/entrada.txt";
	
	
	public static String converter(String number){
		number = number.substring(2,10);//removendo 0x do inicio
		return Integer.toBinaryString(parseInt(number, 16));
	}
	
	public static String formater(String number){
		int aux = 32 - number.length();
		char[] arrayToConcat;
		arrayToConcat = new char[aux];
		
		if(aux < 32){
			for(int i = 0; i < aux; i++){
				arrayToConcat[i] = '0';
			}
		}
		
		return new String(arrayToConcat).concat(number);
	}

	public static String binToDecimal(String string){
		int num = Integer.valueOf(parseInt(string));
		int decimal = 0;
		int potencia = 0;

		for(int i = string.length() - 1; i >= 0; i--){
			decimal += Math.pow(2, potencia) *
					Character.getNumericValue(string.charAt(i));
			potencia++;
		}
		return decimal + "";
	}

	public static String formaterRegistersToDecimal(String instructionBin, String typeInstruction){
		if(typeInstruction == "R"){
			String rs = " $" + binToDecimal(instructionBin.substring(6, 11)) + ",";
			String rd = " $" + binToDecimal(instructionBin.substring(11, 16)) + ",";
			String rt = " $" + binToDecimal(instructionBin.substring(16, 21));
			return rs + rd + rt;
		}
		else if(typeInstruction == "I"){
			//TODO
		}
		else if(typeInstruction == "J"){
			//TODO
		}
		return null;
	}
	
	//TODO: tratar os caracteres 0x...
	@SuppressWarnings("null")
	public static ArrayList<String> readFiles(){
		ArrayList<String> instructionsArray = new ArrayList<>();
		int i = 0;
		
		File file = new File(FILE_PATH_INPUT);
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String data = null;
			String count = null;
			
			//gravando instruções no array
			while((data = reader.readLine()) != null){
				instructionsArray.add(i, data);
				i++;
			}
			fileReader.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return instructionsArray;
	}
	
	
	public static void writeFiles(String[] instructions){
		File file = new File(FILE_PATH_OUTPUT);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (String instruction : instructions) {
				writer.write(instruction);
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
