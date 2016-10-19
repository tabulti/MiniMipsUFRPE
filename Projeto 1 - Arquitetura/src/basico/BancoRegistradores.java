package basico;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class BancoRegistradores{

    private LinkedHashMap<String, Integer> registradores;
    private static BancoRegistradores instance;

    public static BancoRegistradores getInstance() {
        if (instance == null) {
            instance = new BancoRegistradores();
        }
        return instance;
    }

    public BancoRegistradores() {
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

}
