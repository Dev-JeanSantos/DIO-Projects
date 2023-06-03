package gof.criacionais.singleton;

/**
 * Singleton "preguiçoso"
 *
 * @author Dev-JeanSantos
 */

public class SingletonLazy {

    private static SingletonLazy instancia;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstancia(){
        if(instancia == null){
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
