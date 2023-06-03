package gof.criacionais.singleton;

/**
 * Singleton "Apressado"
 *
 * @author Dev-JeanSantos
 */

public class SingletonEager {

    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia(){
        return instancia;
    }
}
