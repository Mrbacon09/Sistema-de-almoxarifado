package av2;


// Classe abstrata Produto, cria uma generalização para os produtos
public abstract class Produto {
    // Atributos
    private int id;
    private String nome;
    private int quantidade;
    private String categoria;

    public Produto(int id, String nome, int quantidade, String categoria){ // Construtor
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    // Getters e Setters para modificação dos atributos(encapsulamento da classe)
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public  int getQuantidade() { 
        return quantidade; 
    }
    public void setQuantidade(int quantidade) { 
        this.quantidade = quantidade; 
    }

    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) { 
        this.categoria = categoria; 
    }
    //---------------------------------------------------------//

    public void addQuantidade(int q) { // Adiciona quantidade do produto ao estoque
        this.quantidade = this.quantidade + q; 
    }

    public void removeQuantidade(int q) { // Subtrai a quatidade de produtos e evita quantidades negativas
        
        if (this.quantidade < 0) {
            this.quantidade = 0; 
            System.out.println("Estoque insuficiente!" + this.quantidade + " itens retirados.");
        }
        this.quantidade = this.quantidade - q;
    }

}