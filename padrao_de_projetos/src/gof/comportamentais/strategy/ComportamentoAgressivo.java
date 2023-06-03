package gof.comportamentais.strategy;

public class ComportamentoAgressivo implements Comportamento {

    @Override
    public void mover() {
        System.out.println("movendo agressivo");
    }
}
