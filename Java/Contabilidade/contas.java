package Contabilidade;

public class contas {
    private String codigo;
    private String descricao;
    private String grupoContabil;

    public contas(String codigo, String descricao, String grupoContabil) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.grupoContabil = grupoContabil;
    }

    public String getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }
    public String getGrupoContabil() { return grupoContabil; }

    @Override
    public String toString() {
        return codigo + " | " + descricao + " | " + grupoContabil;
    }
}
