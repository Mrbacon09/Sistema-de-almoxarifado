package av2;

// Subclasse de produto que separa produtos perecíveis de não perecíveis e verifica validade, sendo assim, uma classe especializada de produto

import java.time.LocalDate;

public class IdentificaProduto extends Produto { //herda a classe abstrata Produto
    private LocalDate dataValidade = LocalDate.of(LocalDate.now().getYear(),(int) (Math.random() * 12) + 1,(int) (Math.random() * 28) + 1); 
    // gera data de validade aleatória para produto perecível(vai até 28 para evitar erro no mês de fevereiro)

    public IdentificaProduto(int id, String nome, int quantidade, String categoria) { //construtor herda atributos da classe pai, adiciona o atributo dataValidade se o produto for perecível e verifica sua validade
        super(id, nome, quantidade, categoria);
        if ("perecível".equals(categoria)) {
            System.out.println("Produto perecível  com id: " + id + " e com validade: " + dataValidade);
            verificarValidade();
        } 
        else {
            System.out.println( "Produto não perecível com id: " + id + " cadastrado ");
        }
    }
        
    public boolean isVencido() { //verifica se a data de validade é menor que a data atual
        
        return LocalDate.now().isAfter(dataValidade);
    }

    public void verificarValidade() { //verifica se o produto está vencido ou não
        if (isVencido() && getCategoria().equals("perecível")) {
            System.out.println("Produto vencido!");
        } else if(getCategoria().equals("perecível")){
            System.out.println("Produto dentro do prazo de validade.");
        }
        else{
            System.out.println("Produto não perecível não possui data de validade.");
        }
    }

} 
        
       


    
    
