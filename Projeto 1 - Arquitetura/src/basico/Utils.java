package basico;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeMap;

public class Utils {

    private static String FILE_PATH_OUTPUT = "arquivos/saida.txt";
    private static String FILE_PATH_INPUT = "arquivos/entrada.txt";
    private static String REGISTER_FILE_PATH = "arquivos/registradores.txt";

    /**
     * Método que converte um numero hexadecimal no formato 0x0000000000
     * para um binário de 32 bits
     *
     * @param number
     * @return
     */
    public static String converter(String number) {
        number = number.substring(2, 10);//removendo 0x do inicio
        //return Integer.toBinaryString(parseInt(number, 16));
        return new BigInteger(number, 16).toString(2);
    }

    /**
     * Método que completa um binario com menos de 32 bits com 0's a esquerda
     *
     * @param number
     * @return
     */
    public static String formatar(String number) {
        int aux = 32 - number.length();
        char[] arrayToConcat;
        arrayToConcat = new char[aux];

        if (aux < 32) {
            for (int i = 0; i < aux; i++) {
                arrayToConcat[i] = '0';
            }
        }
        return new String(arrayToConcat).concat(number);
    }

    /**
     * Método que converte um binário para decimal
     *
     * @param string
     * @return
     */
    public static String binToDecimal(String string) {
        int decimal = Integer.valueOf(string, 2);
        return decimal + "";
    }

    /**
     * Metodo para ler instruções de um arquivo txt
     *
     * @return
     */
    public static ArrayList<String> carregarInstrucoes() {
        ArrayList<String> instructionsArray = new ArrayList<>();
        int i = 0;

        File file = new File(FILE_PATH_INPUT);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String data = null;
            String count = null;

            //gravando instruções no array
            while ((data = reader.readLine()) != null) {
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

    public static TreeMap<Integer, Integer> carregarRegistradores() {
        TreeMap<Integer, Integer> registradores = new TreeMap<>();
        File file = new File(REGISTER_FILE_PATH);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            String registrador[] = new String[2];
            String numeroRegistrador = "";
            Integer valorRegistrador = 0;


            //gravando instruções no array
            while ((line = reader.readLine()) != null) {
                registrador = line.split("=");
                registradores.put(Integer.parseInt(registrador[0]), Integer.parseInt(registrador[1]));
            }

            fileReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return registradores;
    }

    /**
     * Método para escrever instruções em um arquivo txt.
     *
     * @param instructions
     */
    public static void writeFiles(ArrayList<String> instructions) {
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
