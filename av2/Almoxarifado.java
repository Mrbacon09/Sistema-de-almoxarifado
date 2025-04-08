package av2;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class Almoxarifado {

    private static Almoxarifado instancia; // Singleton: garante que só existe uma instância da classe Almoxarifado
    private static Map<Integer, Produto> produtos = new HashMap<>(); // Mapeia o id do produto com o objeto Produto, permitindo acesso rápido ao produto pelo id
    private Almoxarifado() {}       // Construtor para impedir instância externa
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

    public static List<Produto> verificarEstoque() { //Verifica quantos de cada um dos produtos estão disponíveis no estoque agrupando-o em uma lista
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
    
    public static void gerarRelatorio(){ //Gera o relatorio de produtos disponíveis a partir da lista de produtos
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
