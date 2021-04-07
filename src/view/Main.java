package view;

import javax.swing.JOptionPane;
import cliente.OperacoesClientes;
import controller.RealizarReservar;
import enfeite.OperacoesEnfeite;

public class Main {
	public static void main(String[] args) {		

		OperacoesEnfeite enfeites = new OperacoesEnfeite();
		OperacoesClientes clientes = new OperacoesClientes();
		RealizarReservar reserva = new RealizarReservar();

		int opcao = 0;
		
		while (opcao != 99) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Buffet: \n\n"+ 
							"1 - Cadastrar Enfeites \n"+ 
							"2 - Cadastrar Clientes\n"+ 
							"3 - Registrar Aluguel \n"+ 
							"99 - Sair "));
			
			switch (opcao) {
				case 1:
					enfeites.MenuEnfeites();
				break;

				case 2:
					clientes.MenuClientes();
				break;

				case 3:
					reserva.MenuReservar();
				break;
				
				case 99:
					JOptionPane.showMessageDialog(null, "Finalizando o programa");
				break;
					
				default:
				break;
			} // fim switch
		} // fim while
    } //fim main
} // fim classe