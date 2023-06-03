package gof.subsistema2.crm;

import gof.criacionais.singleton.SingletonLazy;

public class CepApi {

    private static CepApi instancia = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstancia(){
        return instancia;
    }

    public String recuperarCidade(String cep){
        return "Tanguá";
    }

    public String recuperarEstado(String cep){
        return "RJ";
    }
}
