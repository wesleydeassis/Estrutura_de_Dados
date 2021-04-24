package cliente;

//import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class OperacoesClientes {
   private String CPF_RNE;
   private String Nome;
   private String Telefone;
   private String Endereco;
   private LocalDate DataCadastro = LocalDate.now();
   private int QtdeAluguel;
   private NO inicio;

   public OperacoesClientes() {
		inicio = null;
	}

	public void MenuClientes() {
		int opcao = 0;
		while (opcao != 99) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu de Clientes: \n "+
																	"\n1- Cadastrar Cliente"+
																	"\n2- Gravar lista cliente"+
																	"\n3- Listar clientes"+
																	"\n4- Buscar cliente por CPF ou RNE"+
																	"\n5- Remover cliente da lista"+
																	"\n6- Recuperar da lista"+
																	"\n7- Mostrar Lista recuperada"+
																	"\n99- Voltar  "));
			
			switch (opcao) {
				case 1:
                    //JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					CadastrarClientes();
				break;

				case 2:	
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//GravarCliente();
				break;

				case 3:
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//ListarClientes();
				break;

				case 4:
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//CPF_RNE = JOptionPane.showInputDialog("Digitar codigo do tema para busca: ");
					//BuscarClientes(CPF_RNE);
				break;

				case 5:
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser removida: "));
					//System.out.println(RemoverClientes(posicao));
				break;

				case 6:
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//RecuperarListaClientes();
				break;

				case 7:
                    JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//PercorreListaClientes();
				break;

				case 99:
					JOptionPane.showMessageDialog(null, "Voltando ao menu anterior");
				break;

				default:
				break;
			} // fim switch
		} // fim while
	} // fim MenuClientes()

	public void CadastrarClientes() {
		Clientes cliente = new Clientes(CPF_RNE, Nome, Endereco, Telefone, DataCadastro, QtdeAluguel);
			
		CPF_RNE = JOptionPane.showInputDialog("Digite CPF ou RNE: "); 
		cliente.setCPF_RNE(CPF_RNE);
			
		Nome = JOptionPane.showInputDialog("Informe o Nome do Cliente");
		cliente.setNome(Nome);
			
		Endereco = JOptionPane.showInputDialog("Informe o Endereço do Cliente");
		cliente.setEndereco(Endereco);
			
		Telefone = JOptionPane.showInputDialog("Informe o Telefone do Cliente");
		cliente.setTelefone(Telefone);
			
		cliente.setDataCadastro(DataCadastro);
			
		QtdeAluguel = Integer.parseInt(JOptionPane.showInputDialog("Digite Quantidade de Aluguel: ")); 
		cliente.setQtdeAluguel(QtdeAluguel);
			
		if (inicio == null) {								// verifica se a lista esta vazia
			NO n = new NO(cliente);	
			inicio = n;
			n.prox = null;
			n.anterior = null;									
		}  // fim if
		else {
			NO aux = inicio;				
			while (aux.prox != null) {					// buscando o ultimo elemento da lista	
				aux = aux.prox;						
			} // fim while
			NO n = new NO(cliente);		// cria um novo Nó
			aux.prox = n;	
			n.anterior = aux;
			n.prox = null;
		} // fim do else
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");  
		System.out.println("Cliente Cadastrado: \n" + 
								" - CPF_RNE: " + cliente.getCPF_RNE() + 
								" - Nome: " + cliente.getNome()+ 
								" - Telefone: " + cliente.getTelefone() +
								" - Data Cadastro : " + cliente.getDataCadastro()+
								" - Quantidade aluguel " + cliente.getQtdeAluguel());
	
	} // fim CadastrarClientes() 
} //fim classe