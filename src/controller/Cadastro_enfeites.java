package controller;

import javax.swing.JOptionPane;

public class Cadastro_enfeites {
	private int codTema;
	private String tema;
	private String descricao;
	private double preco;
	private int ops;
	private NO_Enfeites inicio;
	
	 
	public void Cadastro_enfeites() {
		while (ops != 99) {
			ops = Integer.parseInt(JOptionPane.showInputDialog("Cadastro & Consulta: \n1-Cadastro de Enfeites \n8-Ver Lista \n99-Sair  "));

		switch (ops) {
			case 1:
				Cadastro_Enfeite();
				break;
				
			case 8:
				ListaEnfeites();

			case 99:
				System.out.println("Saindo");
			default:
				break;
			} // fim switch
		} // fim while
		
	} // fim cadastro Enfeites
	

	public void Cadastro_Enfeite() {   // adicionar no final da lista
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);
		codTema = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do tema"));
		enfeites.setCodTema(codTema);
		tema = JOptionPane.showInputDialog("Informe o tema do enfeite");
		enfeites.setTemaEnfeite(tema);
		descricao = JOptionPane.showInputDialog("Informe a descriçáo do enfeite");
		enfeites.setDescricaoEnfeite(descricao);
		preco = Integer.parseInt(JOptionPane.showInputDialog("Informe o preço do tema"));
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista está vazia
			NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no nó criado
			inicio = n;									// carrega inicio com "n" - novo nó criado
		}  // fim if
		else {
				NO_Enfeites aux = inicio;				// cria endereço de nó "aux" e carrega com o endereço de inicio
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endereço
				} // fim while
				NO_Enfeites n = new NO_Enfeites(enfeites);	// cria um novo nó com endereço "n" e carrega dado "e"
				aux.prox = n;								// carrega n aux o endereço de n		
		}  // fim do else
		System.out.println("cadastro: " + "Codigo Tema: " +enfeites.getCodTema() + " Tema:" +enfeites.getTemaEnfeite()+ " Descrição: " + enfeites.getDescricaoEnfeite() +" Preço: " + enfeites.getPreco());
		// gravar em texto.
	} // cadastro enfeites
	
	
	public String ListaEnfeites() {
		NO_Enfeites aux = inicio;
		String enfeite = " ";
		while (aux != null){
			codTema = aux.enfeites.getCodTema();
			tema = aux.enfeites.getTemaEnfeite();
			descricao = aux.enfeites.getDescricaoEnfeite();
			preco = aux.enfeites.getPreco();
			System.out.println(" \n Codigo enfeite:" +aux.enfeites.getCodTema()+ " Tema " +aux.enfeites.getTemaEnfeite() + " Descricao " +aux.enfeites.getDescricaoEnfeite() + " Preco " + aux.enfeites.getPreco());
			aux = aux.prox;
		}
		return enfeite;

	} // fim da lista de enfeites
	
} // fim classe
