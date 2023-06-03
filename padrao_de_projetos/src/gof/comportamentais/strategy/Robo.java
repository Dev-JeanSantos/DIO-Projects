package gof.comportamentais.strategy;

public class Robo {

    private Comportamento comportamento;

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void move(){
        comportamento.mover();
    }
}
