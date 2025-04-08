package av2;

public class ExecutarDespacho implements Despacho { //executa a interface Despacho retirando produtos do estoque
    @Override
    public void executar(Produto p, int quantidade) {
        p.removeQuantidade(quantidade);
        System.out.println("Retirada de " + quantidade + " itens");
    }
}
