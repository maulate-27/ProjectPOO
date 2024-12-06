package pacote1.electronicos;

public class Celular{

	private String marca1;
	private String modelo1;
	private double preco1;
	private int codigo1;
	private String especificacoes1;
			Tempo tempo = new Tempo();

	public Celular(String marca1, String modelo1, String especificacoes1, double preco1, int codigo1){
		this.marca1 = marca1;
		this.modelo1 = modelo1;
		this.preco1 = preco1;
		this.especificacoes1 = especificacoes1;
		this.codigo1 = codigo1;
	}
	
	public String Dados(){
		return "\n=================== Celulares ===================\n\t" +
			   "Codigo: " + codigo1 + "\n\t" +
               "Marca: " + marca1 + "\n\t" +
               "Modelo: " + modelo1 + "\n\t" +
               "Especificações: " + especificacoes1 + "\n\t" +
               "Preco: " + preco1 + "\n\t" +
               "Data do Cadastro: " + tempo.dataFormatada +
               "\n===============================================";
	}
}

	
