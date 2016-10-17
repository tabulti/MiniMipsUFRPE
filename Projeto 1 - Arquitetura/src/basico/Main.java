package basico;

import java.util.ArrayList;

public class Main {


	public static void main(String[] args) {
		BancoRegistradores bancoRegistradores = new BancoRegistradores();

		Instruction instruction = new Instruction();
		ArrayList<String> instructionsArrayInput;
		ArrayList<String> instructionsArrayOutput = new ArrayList<>();


        //Lendo arquivo txt e retornando um array de instruções em hexadecimal
		instructionsArrayInput = Utils.carregarInstrucoes();
        String assemblyInstruction = "";
        //percorrendo array de instruções em hexadecimal
		for (String string : instructionsArrayInput) {

		    //recuperando uma instrução e formatando no padrão binario de 32 bit
			String numberConvertido = Utils.formatar(Utils.converter(string));

            //setando a operação da instrução e o tipo (R,J,I)
            assemblyInstruction = instruction.verifyOperationType(numberConvertido);
            instructionsArrayOutput.add(assemblyInstruction);

		}

	    Utils.writeFiles(instructionsArrayOutput);

    }

}
