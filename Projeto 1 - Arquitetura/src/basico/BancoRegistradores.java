package basico;

import java.util.TreeMap;

public class BancoRegistradores {

    private TreeMap<Integer, Integer> registradores;
    private static BancoRegistradores instance;

    public static BancoRegistradores getInstance(){
        if(instance == null){
            instance = new BancoRegistradores();
        }
        return instance;
    }

    public BancoRegistradores() {
        registradores = new TreeMap<>();
        registradores = Utils.carregarRegistradores();
    }

    public int getValor(Integer registrador) {
        return registradores.get(registrador);
    }

    public void setValor(Integer registrador, Integer valor) {
        this.registradores.put(registrador, valor);
    }

    public String showValores() {
        String valores = "";
        String registrador;
        for (Integer key : registradores.keySet()) {
            registrador = "$" + key + "=" + registradores.get(key) + ";";
            valores += registrador;
        }
        return valores;
    }

}
