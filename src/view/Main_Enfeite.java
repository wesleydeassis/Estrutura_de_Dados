package view;

import javax.swing.JOptionPane;

import controller.Cadastro_enfeites;

public class Main_Enfeite {

	public static void main(String[] args) {
		
		int ops = 0;
//		Cadastro_enfeites enfeites = new Cadastro_enfeites();
		
		while (ops != 99) {
			Cadastro_enfeites enfeites = new Cadastro_enfeites();
			
			ops = Integer.parseInt(JOptionPane.showInputDialog("Inicio: \n1-Cadastro Enfeite \n99-Sair  "));

			switch (ops) {
			case 1:
				enfeites.Cadastro_enfeites();
				break;

			case 2: 
				
				break;

			default:
				break;
			}
			
		}
	} // fim maim


} // fim classe
