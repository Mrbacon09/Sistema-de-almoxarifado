package av2;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class Almoxarifado {

    private static Almoxarifado instancia;
    private static Map<Integer, Produto> produtos = new HashMap<>();
    private Almoxarifado() {}
    public static Almoxarifado getInstance() {
        if (instancia == null) {
            instancia = new Almoxarifado();
        }
        return instancia;
    }

    public void executar(int id, int quantidade) {
        Produto produto = produtos.get(id);
        if (produto != null) {
            new ExecutarDespacho().executar(produto, quantidade);
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    // Sobrecarga: cadastrar um ou vários
    public void cadastrar(Produto p) { 
        produtos.put(p.getId(), p); 
    }

    public <ProdutoPerecivel> void cadastrar(Produto... produtosArray) {
        for (Produto p : produtosArray) {
            produtos.put(p.getId(), p);
        }
    }

    public class ExecutarDespacho implements Despacho {
        @Override
        public void executar(Produto p, int quantidade) {
            p.removeQuantidade(quantidade);
            System.out.println("Retirada de " + quantidade + " itens");
        }
    }

    public static List<Produto> verificarEstoque() { 
        List<Produto> lista = new ArrayList<>();
        for (Produto p : produtos.values()) {
            if (p.getQuantidade() > 0) {
                lista.add(p);
            }
            else {
                System.out.println("Sem estoque de " + p.getNome());
            }
        }
        return lista;
    }
    
    public static void gerarRelatorio(){
        Relatorio<Produto> relatorio = new Relatorio<>();
        relatorio.gerar( verificarEstoque() );
    }

        
  public static void main(String[] args) {
        Almoxarifado almox = Almoxarifado.getInstance();
        Produto p1 = new IdentificaProduto(1,"Produto 1", 10, "perecível");
        System.out.println("\n");
        Produto p2 = new IdentificaProduto(2,"Produto 2", 20, "Não perecível");
        System.out.println("\n");
        Produto p3 = new IdentificaProduto(3,"Produto 3", 30, "perecível");
        System.out.println("\n");   
        Produto p4 = new IdentificaProduto(4,"Produto 4", 40, "Não perecível");
        System.out.println("\n");
        System.out.println("//-------------------------------------------------//");

        almox.cadastrar(p1);
        almox.cadastrar(p2);
        almox.cadastrar(p3);
        almox.cadastrar(p4);

        System.out.println("\n");

        System.out.println("Almoxarifado antes do despache: ");
        Almoxarifado.gerarRelatorio();

        System.out.println("\n");
        System.out.println("//-------------------------------------------------//");
        System.out.println("\n");
        almox.executar(1, 5);
        almox.executar(2, 15);
        almox.executar(3, 35);
        almox.executar(4, 20);
        System.out.println("\n");
        System.out.println("//-------------------------------------------------//");
        System.out.println("\n");

        System.out.println("Almoxarifado após o despache: ");
        Almoxarifado.gerarRelatorio();
    }
    
}
