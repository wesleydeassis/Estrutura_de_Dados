package view;

import javax.swing.JOptionPane;
import controller.Cadastro_enfeites;

public class Main {
	public static void main(String[] args) {
		Cadastro_enfeites enfeites = new Cadastro_enfeites();
		int opcao = 0;
		
		while (opcao != 99) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Inicio: \n1- Cadastrar Enfeites \n99- Sair  "));
			
			switch (opcao) {
				case 1:
					enfeites.Cadastro_Enfeites();
				break;
				
				case 99:
					JOptionPane.showMessageDialog(null, "Finalizando o programa");
				break;
					
				default:
				break;
			} // fim switch
		} // fim while
	} // fim main
} // fim classe