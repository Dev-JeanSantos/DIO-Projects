package gof.comportamentais.strategy;

public class ComportamentoDefensivo implements Comportamento {

    @Override
    public void mover() {
        System.out.println("movendo defensivamente");
    }
}
