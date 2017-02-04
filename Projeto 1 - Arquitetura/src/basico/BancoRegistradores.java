package basico;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class BancoRegistradores {

    private final int BASE = 8192;
    private int[] memoria;
    private LinkedHashMap<String, Integer> registradores;
    private static BancoRegistradores instance;

    public static BancoRegistradores getInstance() {
        if (instance == null) {
            instance = new BancoRegistradores();
        }
        return instance;
    }

    public BancoRegistradores() {
        memoria = new int[32];
        for (int i = 0; i < 32; i++) {
            memoria[i] = 0;
        }
        registradores = new LinkedHashMap<>();
        registradores = Utils.carregarRegistradores();
    }

    public int getValor(String registrador) {
        return registradores.get(registrador);
    }

    public void setValor(String registrador, Integer valor) {
        this.registradores.put(registrador, valor);
    }

    public String showValores() {
        String valores = "";
        String registrador;
        for (String key : registradores.keySet()) {
            registrador = key + "=" + registradores.get(key) + ";";
            valores += registrador;
        }
        return valores;
    }

    public void setMemoria(int position, int value) {
        if (position % BASE == 0) {
            position = position / BASE;
            memoria[position] = value;
        }
    }

    public int getMemoria(int position) {
        if (position % BASE == 0) {
            position = position / BASE;
            return memoria[position];
        }
        return -1;
    }

}
