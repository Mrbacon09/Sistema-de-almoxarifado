package av2;

import java.util.List;
public class Relatorio<T> { //usa uma lista de objetivos genéricos para gerar relatorios de diferentes tipos de objetos
    public void gerar(List<T> itens) {
        for (T item : itens) { 
            if (item instanceof Produto) { //tratamento de tipos para evitar erros de execução, nesse caso o instanceof verifica se o objeto é do tipo Produto
            // e se for, ele faz o cast para Produto e imprime os atributos do produto
            Produto produto = (Produto) item;
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade());
            } else {
            System.out.println(item.getClass().getSimpleName() + ": " + item.toString());
            }
        }
    }
}
