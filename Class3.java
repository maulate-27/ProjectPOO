package pacote1;

import java.security.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import pacote1.electronicos.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;


public class Class3 extends JFrame implements ActionListener {

	//Declaracao de componentes
	JButton btnr1,btnr2,btnr3;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7;
	JTextArea ar1;
	JLabel l1,l2,l3,l4,l5,l6;
	JScrollPane scrool;
	JComboBox<String> c1; 
	String[] item = {"Computador","Celulares"};
	int codigo;
	boolean ok = false;
	
	//Declaracao de Produtos
	Computador computador;
	Celular celular;

	public Class3(){
	
		//Configuracoes da Janela	
		getContentPane().setBackground(Color.lightGray);
		setTitle("SIGELECTRONICO");
		setSize(600,400);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		//Objectos dos componentes
		btnr1 = new JButton("Cadastrar");
		btnr2 = new JButton("Gerar Codigo");
		btnr3 = new JButton("Buscar");
		c1 = new JComboBox<>(item);
		txt1 = new JTextField(10);
		txt2 = new JTextField(10);
		txt3 = new JTextField(10);
		txt4 = new JTextField(10);
		txt5 = new JTextField(10);
		txt6 = new JTextField(10);
		ar1 = new JTextArea(20,40);
		scrool = new JScrollPane(ar1);
		l1 = new JLabel("Marca");
		l2 = new JLabel("Codigo");
		l3 = new JLabel("Especificacoes");
		l4 = new JLabel("Modelo");
		l5 = new JLabel("Preco");
		l6 = new JLabel("Modelo");
		
		
		btnr1.setBounds(400,180,110,20);
		btnr2.setBounds(30,150,180,20);
		btnr3.setBounds(310,10,110,20);
		
		txt1.setBounds(50,10,260,20);
		scrool.setBounds(10,210,590,150);
		
		//set do Cadastro
		c1.setBounds(30,35,120,20);
		
		//Marca
		l1.setBounds(30,60,110,20);
		txt2.setBounds(80,60,110,20);
		
		//Codigo
		l2.setBounds(30,115,110,20);
		txt3.setBounds(85,115,110,20);
		
		//Especificacoes
		l3.setBounds(30,85,110,20);
		txt4.setBounds(140,85,110,20);
		
		//Modelo
		l4.setBounds(310,60,110,20);
		txt5.setBounds(365,60,110,20);
		
		//Preco
		l5.setBounds(300,85,110,20);
		txt6.setBounds(350,85,110,20);

		//JTextArea config
		ar1.setEditable(false);
		ar1.setLineWrap(true);
		ar1.setWrapStyleWord(true);
		
		//add Botoes
		add(btnr1);
		add(btnr3);
		add(btnr2);
		
		//add Menu and JTextArea
		add(c1);
		add(scrool);
		
		//add Labels
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		
		//add JTextField
		add(txt1);
		add(txt2);
		add(txt3);
		add(txt4);
		add(txt5);
		add(txt6);
		
		//Abilitando as teclas
		btnr1.addActionListener(this);
		btnr2.addActionListener(this);
		btnr3.addActionListener(this);
	}
	
	public void gerCodigo(){
	SecureRandom num = new SecureRandom();
	codigo = num.nextInt(90000) + 10000;
	txt3.setText(" " + codigo);
	ok = true;
		
	}
	
	public void cadastrar(){
		try{	
			String dados = "";
			String tipo = (String) c1.getSelectedItem();
			String marca = txt2.getText();
			String modelo = txt5.getText();
			double preco = Double.parseDouble(txt6.getText());
			String especificacoes = txt4.getText();
			//int codigo = Integer.parseInt(txt3.getText());
			
				
			if(tipo.equals("Computador")){
				computador = new Computador(marca,modelo,especificacoes,preco,codigo);
				ar1.append(computador.Dados());
				dados = computador.Dados();
			}else if(tipo.equals("Celulares")){
				celular = new Celular(marca,modelo,especificacoes,preco,codigo);
				ar1.append(celular.Dados());
				dados = celular.Dados();
			}
					
			FileWriter writer = new FileWriter("dados_eletronicos.txt", true);
        		writer.write(dados + "\n");
       		writer.close();
					
			txt2.setText("");
			txt6.setText("");
			txt3.setText("");
			ok=false;
			txt5.setText("");
			txt4.setText("");
					
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(this, "Erro: Verifique os campos numéricos (Preço e Código).", "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
				
		}catch(NullPointerException ex){
			JOptionPane.showMessageDialog(this, "Erro: Certifique-se de que todos os campos estão preenchidos.", "Erro de Dados", JOptionPane.ERROR_MESSAGE);
				
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				 
		}
				
	}
	
	public void actionPerformed(ActionEvent e){
		if(!ok){
			if(e.getSource() == btnr2){
				gerCodigo();
			}
		}
			
		if(e.getSource() == btnr1){
			cadastrar();
					
		}else if(e.getSource() == btnr3){
				
			String codigoBusca = txt1.getText(); 
		    boolean encontrado = false;
		    ar1.setText("");

   			try {
        		BufferedReader reader = new BufferedReader(new FileReader("dados_eletronicos.txt"));
        		String linha;
        		StringBuilder dadosProduto = new StringBuilder();

        		while ((linha = reader.readLine()) != null) {
            		if (linha.contains("Codigo: " + codigoBusca) && linha.contains(computador.Dados())) {
                		dadosProduto.append(linha).append("\n");
                		encontrado = true;
            		}
        		}
        		reader.close();

        		if (encontrado) {
            		ar1.setText(dadosProduto.toString());
           
        		}else {
        			JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Resultado da Busca", JOptionPane.INFORMATION_MESSAGE);
        		}

    		} catch (Exception ex) {
        		JOptionPane.showMessageDialog(this, "Erro ao buscar o produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    		}

				
		} /*else if(e.getSource() == btnr4){
				//ar1.setText("");
				String codigoBusca = txt1.getText().trim(); // Código do produto a ser removido
    boolean encontrado = false;

    try {
        BufferedReader reader = new BufferedReader(new FileReader("dados_eletronicos.txt"));
        StringBuilder conteudoAtualizado = new StringBuilder();
        String linha;

        while ((linha = reader.readLine()) != null) {
            if (linha.contains("Codigo: " + codigoBusca)) { // Verifica se a linha contém o código buscado
                encontrado = true;
            } else {
                conteudoAtualizado.append(linha).append("\n"); // Mantém as outras linhas
            }
        }
        reader.close();

        if (encontrado) {
            // Reescreve o arquivo sem o produto removido
            FileWriter writer = new FileWriter("dados_eletronicos.txt");
            writer.write(conteudoAtualizado.toString());
            writer.close();
            JOptionPane.showMessageDialog(this, "Produto removido com sucesso.", "Remoção Concluída", JOptionPane.INFORMATION_MESSAGE);
            ar1.setText(""); // Limpa o JTextArea após a remoção
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro na Remoção", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro ao remover o produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
			}*/
				
	}
	
}
