package basico;

import java.util.ArrayList;

public class Main {


	public static void main(String[] args) {
		BancoRegistradores bancoRegistradores = BancoRegistradores.getInstance();
		Decodificador instruction = new Decodificador();
		ULA ula = ULA.getInstance();
		Object instrucao;
		R typeR;
		I typeI;
		J typeJ;

		ArrayList<String> instrucoes;
		ArrayList<String> output = new ArrayList<>();

        //Carrega todas as instru��es em HEXADECIMAL
		instrucoes = Utils.carregarInstrucoes();

        //Percorre cada instru��o do array
		for (String string : instrucoes) {

		    //Converte para bin�rio de 32 bits.
			String instrucaoBinaria = Utils.formatar(Utils.converter(string));

            //Decodifica a Instru��o (Tipo R, I, J)
            instrucao = instruction.decodificar(instrucaoBinaria);

			if(instrucao instanceof R){
				typeR = (R) instrucao;
				output.add(typeR.getAssembly());
				output.add(ula.executarInstrucao(typeR));
			}else if(instrucao instanceof I){
				typeI = (I) instrucao;
				output.add(typeI.getAssembly());
				output.add(ula.executarInstrucao(typeI));
			}else if(instrucao instanceof J){
				typeJ = (J) instrucao;
				output.add(typeJ.getAssembly());
				output.add(ula.executarInstrucao(typeJ));
			}else if(instrucao instanceof String){
				output.add(instrucao.toString());
				output.add(ula.executarInstrucao(instrucao));
			}

		}

		//Escreve no Arquivo de Sa�da
	    Utils.writeFiles(output);

    }

}
