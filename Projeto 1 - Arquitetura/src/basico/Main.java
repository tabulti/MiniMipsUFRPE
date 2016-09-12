package basico;

/**
 * Created by Joao Paulo Ribeiro on 08/09/2016.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Instruction instruction = new Instruction();
		ArrayList<String> instructionsArrayInput;
		ArrayList<String> instructionsArrayOutput = new ArrayList<>();

        //Lendo arquivo txt e retornando um array de instru��es em hexadecimal
		instructionsArrayInput = Utils.readFiles();
        String assemblyInstruction = "";
        //percorrendo array de instru��es em hexadecimal
		for (String string : instructionsArrayInput) {

		    //recuperando uma instru��o e formatando no padr�o binario de 32 bit
			String numberConvertido = Utils.formater(Utils.converter(string));

            //setando a opera��o da instru��o e o tipo (R,J,I)
            assemblyInstruction = instruction.verifyOperationType(numberConvertido);
            instructionsArrayOutput.add(assemblyInstruction);

		}

	    Utils.writeFiles(instructionsArrayOutput);

    }

}
