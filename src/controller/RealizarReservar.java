package controller;

//import java.time.LocalDate;
import javax.swing.JOptionPane;

public class RealizarReservar {

//	  private LocalDate DataFesta = LocalDate.now();
//    private int HoraInicio;
//    private int HoraRetorno;
//    private String FormaDePagamento;
//    private double PrecoFinal;

	public RealizarReservar() {

	}

    public void MenuReservar() {
		int opcao = 0;
		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu de Reserva: "+
			"\n1- Realizar reserva"+
			"\n2- Consultar reservas"+
			"\n9- Voltar  "));
			
			switch (opcao) {
				case 1:
					JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//RealizarReserva()
				break;

				case 2:	
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//ConsultarReserva()
				break;

				case 9:
					JOptionPane.showMessageDialog(null, "Voltando ao menu anterior");
				break;
				
				default:
				break;
			} // fim switch
		} // fim while
	} // fim Menu Reserva
    
	public void RealizarReserva() {

	}

	public void ConsultarReserva() {

	}

	public void CalcularTempo() {
		
	}
}