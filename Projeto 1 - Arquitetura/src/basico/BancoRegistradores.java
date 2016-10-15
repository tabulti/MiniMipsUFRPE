package basico;

import java.util.HashMap;

/**
 * Created by Luciano Junior on 10/15/2016.
 */
public class BancoRegistradores {

    private HashMap<String, Integer> registradores;

    public BancoRegistradores() {
        registradores = new HashMap<>();
        registradores = Utils.carregarRegistradores();
    }

    public int getValor (String registrador){
        return registradores.get(registrador);
    }

    public void setValor(String registrador, Integer valor){
        this.registradores.put(registrador, valor);
    }

}
