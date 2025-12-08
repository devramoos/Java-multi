package TiposDeDados;

public class DadosNaoPrimitivos {
    static void main(String[] args) {
    String nome = "Naruto Uzumaki";
    String nomeEmCaixaAlta = nome.toUpperCase();
    System.out.println("Esse texto esta em CAPSLOCK: " + nomeEmCaixaAlta);
    System.out.println("Esse texto esta normal: " + nome);

    String aldeia = "Aldeia da Folha";
    String aldeiaCaixaBaixa = aldeia.toLowerCase();
    System.out.println("Esse texto esta em minusculo: " + aldeiaCaixaBaixa);
    System.out.println("Esse texto esta normal: " + aldeia);
    }
}
