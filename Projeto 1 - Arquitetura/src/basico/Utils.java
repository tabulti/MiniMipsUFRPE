package basico;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Utils {

    private static String FILE_PATH_OUTPUT = "arquivos/saida.txt";
    private static String FILE_PATH_INPUT = "arquivos/entrada.txt";
    private static String REGISTER_FILE_PATH = "arquivos/registradores.txt";

    /**
     * M�todo que converte um numero hexadecimal no formato 0x0000000000
     * para um bin�rio de 32 bits
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
     * M�todo que completa um binario com menos de 32 bits com 0's a esquerda
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
     * M�todo que converte um bin�rio para decimal
     *
     * @param string
     * @return
     */
    public static String binToDecimal(String string) {
        int decimal = Integer.valueOf(string, 2);
        return decimal + "";
    }

    /**
     * Metodo para ler instru��es de um arquivo txt
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

            //gravando instru��es no array
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

    public static LinkedHashMap<String, Integer> carregarRegistradores() {
        LinkedHashMap<String, Integer> registradores = new LinkedHashMap<>();
        File file = new File(REGISTER_FILE_PATH);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            String registrador[] = new String[2];
            String numeroRegistrador = "";
            Integer valorRegistrador = 0;


            //gravando instru��es no array
            while ((line = reader.readLine()) != null) {
                registrador = line.split("=");
                registradores.put(registrador[0], Integer.parseInt(registrador[1]));
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
     * M�todo para escrever instru��es em um arquivo txt.
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

    public static int getByte(String value, int position) {
        String aux = value;
        String result = "";

        if (aux.charAt(0) == '1') {
            aux = twoComplement(aux);
        }
        for (int i = aux.length(); i < 32; i++) {
            aux = "0" + aux;
        }
        for (int i = 31 - (position * 8); i > 23 - (position * 8); i--) {
            result = aux.charAt(i) + result;
        }

        if (value.charAt(0) == '1') {
            return Integer.parseInt(aux, 2) * -1;
        } else {
            return Integer.parseInt(aux, 2);
        }
    }

    public static int getByteU(String value, int position) {
        String result = "";
        for (int i = value.length(); i < 32; i++) {
            value = "0" + value;
        }
        for (int i = 31 - (position * 8); i > 23 - (position * 8); i--) {
            result = value.charAt(i) + result;
        }
        return Integer.parseInt(result, 2);
    }

    public static String twoComplement(String value) {
        String[] split = value.split("");
        value = "";
        boolean status = false;
        for (int i = split.length - 1; i >= 0; i--) {
            if (status && split[i].equals("0")) {
                value = "1" + value;
            } else if (!status && split[i].equals("0")) {
                value = "0" + value;
            } else if (status && split[i].equals("1")) {
                value = "0" + value;
            } else if (!status && split[i].equals("1")) {
                value = "1" + value;
                status = true;
            }
        }
        return value;
    }

    public static String setByte(String value, int position, int nValue) {
        String aux = value;
        String result = "";
        String newValue = Integer.toBinaryString(nValue);

        for (int i = newValue.length(); i < 32; i++) newValue = "0" + newValue;
        newValue = newValue.substring(newValue.length() - 8, newValue.length());

        for (int i = aux.length(); i < 32; i++) aux = "0" + aux;
        int j = 0;
        for (int i = 0; i < 32; i++) {
            if (i > 23 - (position * 8) && i < 31 - (position * 8)) {
                result += newValue.charAt(j);
                j++;
            } else result += aux.charAt(i);
        }

        return result;
    }
}
