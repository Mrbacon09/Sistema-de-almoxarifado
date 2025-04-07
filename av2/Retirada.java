package av2;

public class Retirada implements Despacho{ //classe implementa a interface Despacho para a retirada de produtos do estoque 
    @Override
    public void executar(Produto p, int quantidade) {
        p.removeQuantidade(quantidade);
        System.out.println("Retirada de " + quantidade + " itens");
    }
}