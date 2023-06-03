import gof.comportamentais.strategy.*;
import gof.criacionais.singleton.SingletonEager;
import gof.criacionais.singleton.SingletonLazy;
import gof.criacionais.singleton.SingletonLazyHolder;
import gof.estrutural.facade.Facade;

public class Executar {
    public static void main(String[] args) {
        System.out.println("-------------------------------");
        System.out.println("------------SINGLETON-----------");
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);


        System.out.println("-------------------------------");
        System.out.println("------------STRATEGY-----------");

        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.move();
        robo.move();
        robo.setComportamento(agressivo);
        robo.move();
        robo.move();
        robo.move();
        robo.setComportamento(defensivo);
        robo.move();

        System.out.println("-------------------------------");
        System.out.println("------------FACADE-----------");

        Facade facade =  new Facade();
        facade.migrarCliente("Jean", "000000-00");

    }
}
