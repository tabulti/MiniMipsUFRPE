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
        int counter;
        int indexInstr = 0;
        //Percorre cada instru��o do array
        for (counter = 0; counter < (instrucoes.size() * 4); counter += 4) {
            indexInstr = counter / 4;
            //desvio para baixo

            //Converte para bin�rio de 32 bits.
            String instrucaoBinaria = Utils.formatar(Utils.converter(instrucoes.get(indexInstr)));

            //Decodifica a Instru��o (Tipo R, I, J)
            instrucao = instruction.decodificar(instrucaoBinaria);
            System.out.println("Indice: " + indexInstr);


            if (instrucao instanceof R) {
                typeR = (R) instrucao;
                output.add(typeR.getAssembly());
                System.out.println("TYPE R: " + typeR.getAssembly());
                output.add(ula.executarInstrucao(typeR, counter));
            } else if (instrucao instanceof I) {
                typeI = (I) instrucao;
                output.add(typeI.getAssembly());
                System.out.println("TYPE I: " + typeI.getAssembly());
                output.add(ula.executarInstrucao(typeI, counter));
            } else if (instrucao instanceof J) {
                typeJ = (J) instrucao;
                output.add(typeJ.getAssembly());
                output.add(ula.executarInstrucao(typeJ, counter));
                System.out.println("TYPE J: " + typeJ.getAssembly());
            } else if (instrucao instanceof String) {
                output.add(instrucao.toString());
                output.add(ula.executarInstrucao(instrucao, counter));
            }

            if (ula.isJump()) {
                counter = ula.getJump();
            }


        }
        //Escreve no Arquivo de Sa�da
        Utils.writeFiles(output);

    }

}
