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
		ArrayList<Instruction> instructionsArrayOutput = new ArrayList<>();

        //Lendo arquivo txt e retornando um array de instru��es em hexadecimal
		instructionsArrayInput = Utils.readFiles();

        //percorrendo array de instru��es em hexadecimal
		for (String string : instructionsArrayInput) {

		    //recuperando uma instru��o e formatando no padr�o binario de 32 bit
			String numberConvertido = Utils.formater(Utils.converter(string));

            //setando a opera��o da instru��o e o tipo (R,J,I)
			instruction.verifyOperationType(numberConvertido);

            //Configurando parametros da instru��o pelo tipo
            if(instruction.getType() == Consts.TYPE_R){
                //Caso a instru��o possua 3 registradores...
                if(instruction.getQtdRegistres() == Consts.TYPE_3_REGISTRERS){
                    //setando os 3 registradores da instru��o tipo R
                    instruction.setupInstructionTypeR3Registrers(numberConvertido);
                }
                else if(instruction.getQtdRegistres() == Consts.TYPE_2_REGISTRERS){
                    //TODO
                }
                else if(instruction.getQtdRegistres() == Consts.TYPE_1_REGISTRERS){
                    //TODO
                }

            }
            else if(instruction.getType() == Consts.TYPE_I){
                //TODO
            }
            else if(instruction.getType() == Consts.TYPE_J){
                //TODO
            }


            //adicionando no array as instru��es com os par�metros setados
            instructionsArrayOutput.add(instruction);

            //TODO: Formatar as instru��es no formato de sa�da desejado (String) de acordo com os parametros setados
            //TODO: Escrever as instru��es formatadas num txt

		}

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
