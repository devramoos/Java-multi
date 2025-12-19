package Contabilidadecomplex;

public class fluxo extends itemBase {
    private double valor;
    private Natureza natureza;

    public fluxo(String descricao, Grupo grupo, double valor, Natureza natureza) {
        super(descricao, grupo);
        this.valor = valor;
        this.natureza = natureza;
    }

    public double getValor() { return valor; }
    public Natureza getNatureza() { return natureza; }

    @Override
    public String id() { return descricao; } // simples: remove por descricao (como você já queria)

    @Override
    public String linha() {
        return "MOV   | " + descricao + " | " + grupo + " | " + natureza + " | " + valor;
    }

    @Override
    public String toString() {
        return linha();
    }
}