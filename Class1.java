package pacote1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Class1 extends JFrame implements ActionListener{

	//set Declaration
	JTextField[] txt = new JTextField[100];
	JPasswordField txt1;
	JButton[] btnr = new JButton[100];
	JLabel[] Lb = new JLabel[100];
	Class3 cl1;
	boolean ok=false;
	
	public Class1(){
	
	//Configuracoes da Janela
		setTitle("Proojecto Final");
		setSize(600,400);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.GRAY);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set Initialization
		Lb[0] = new JLabel("BEM VINDO AO SIGELECTRONICO");
		Lb[1] = new JLabel("Senha: ");
		txt1 = new JPasswordField(10);
		btnr[0] = new JButton("Login");
		
		
		//setLocationBounds
		txt1.setBounds(265,80,110,20);
		Lb[0].setBounds(200,50,300,20);
		Lb[1].setBounds(210,85,200,10);
		btnr[0].setBounds(250,110, 130,20);
		
		//adds
		add(Lb[0]);
		add(txt1);
		add(Lb[1]);
		add(btnr[0]);
		
		//abilitando o botao login
		btnr[0].addActionListener(this);	
			
		fechar(this);	
	}
	
	public void fechar(JFrame ty){
		if(ok==true){
			ty.setVisible(false);
		}else {
		
			ty.setVisible(true);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		String senha = txt1.getText();
		String senha1 = "maulass@27";
		while(!ok){
			if(senha.equals(senha1)){
			
				cl1 = new Class3();
				
				ok =true;
				txt1.setText("");
			}else {
				JOptionPane.showMessageDialog(this,"Senha incorrecta tente novamente");
				txt1.setText("");
			}
		}

	}
}
