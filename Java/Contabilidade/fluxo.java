package Contabilidade;

public class fluxo {
    private String descricao;
    private String grupo;
    private double valor;

    public fluxo(String descricao, String grupo, double valor) {
        this.descricao = descricao;
        this.grupo = grupo;
        this.valor = valor;
    }

    public String getDescricao() { return descricao; }
    public String getGrupo() { return grupo; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return descricao + " | " + grupo + " | " + valor;
    }
}
