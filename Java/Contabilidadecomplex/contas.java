package Contabilidadecomplex;

public class contas extends itemBase {
    private String codigo;
    private TipoConta tipo;

    public contas(String codigo, String descricao, Grupo grupo, TipoConta tipo) {
        super(descricao, grupo);
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getCodigo() { return codigo; }
    public TipoConta getTipo() { return tipo; }

    @Override
    public String id() { return codigo; }

    @Override
    public String linha() {
        return "CONTA | " + codigo + " | " + descricao + " | " + grupo + " | " + tipo;
    }

    @Override
    public String toString() {
        return linha();
    }
}