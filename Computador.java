package pacote1.electronicos;

public class Computador{

	private String marca;
	private String modelo;
	private double preco;
	private int codigo;
	private String especificacoes;
			Tempo tempo = new Tempo();
	
	public Computador(String marca,String modelo,String especificacoes, double preco, int codigo){
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
		this.codigo = codigo;
		this.especificacoes = especificacoes;
	}
	
	public String Dados(){
		return "\n===================== Computador ========================\n\t" +
			   "Codigo: " + codigo + "\n\t" +
               "Marca: " + marca + "\n\t" +
               "Modelo: " + modelo + "\n\t" +
               "Especificações: " + especificacoes + "\n\t" +
               "Preco: " + preco + "\n\t" +
               "Data do Cadastro: " + tempo.dataFormatada +
               "\n=====================================================";
	}
}
