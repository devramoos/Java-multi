package Contabilidadecomplex;

public abstract class itemBase implements registravel {
    protected String descricao;
    protected Grupo grupo;

    protected itemBase(String descricao, Grupo grupo) {
        this.descricao = descricao;
        this.grupo = grupo;
    }

    public String getDescricao() { return descricao; }
    public Grupo getGrupo() { return grupo; }
}
