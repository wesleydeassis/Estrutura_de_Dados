package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Cadastro_enfeites {

	Consultas consultas = new Consultas();
	private String codTema;
	private String tema;
	private String descricao;
	private String preco;
	private int ops;
	private NO_Enfeites inicio;
	
	 
	public Cadastro_enfeites() {
		inicio = null;

	}

	public void Cadastro_Enfeites() {
		while (ops != 99) {

			ops = Integer.parseInt(JOptionPane.showInputDialog("Inicio: "+
			"\n1- Cadastro Enfeite"+
			"\n2- Gravar Lista Enfeites"+
			"\n3- Listar Enfeites"+
			"\n4- Busca por Tema"+
			"\n5- Remover da Lista enfeites"+
			"\n6- Remover da Lista"+
			"\n7- Mostar Lista recuperada"+
			"\n99- Sair  "));
			
			Consultas consulta = new Consultas();

			switch (ops) {
				case 1:
					Cad_Enfeite();;
				break;

				case 2:	
					GravarEnfeites();
				break;

				case 3:
					ListaEnfeite();
				break;

				case 4:
					tema = JOptionPane.showInputDialog("Digitar codigo do tema para busca: ");
					BuscarEnfeites(tema);
				break;

				case 5:
					int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser removida: "));
					System.out.println(RemoverEnfeite(pos));
				break;

				case 6:
					consulta.RecuperarListaEnfeites();
				break;

				case 7:
					consulta.PercorreListaEnfeite();
				break;
				
				default:
				break;
			} // fim switch
		} // fim while
	} // fim cadastro enfeites
	

	public void Cad_Enfeite() {   // adicionar no final da lista
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);

		codTema = JOptionPane.showInputDialog("Informe o código do tema");
		enfeites.setCodTema(codTema);

		tema = JOptionPane.showInputDialog("Informe o tema do enfeite");
		enfeites.setTemaEnfeite(tema);

		descricao = JOptionPane.showInputDialog("Informe a descrição do enfeite");
		enfeites.setDescricaoEnfeite(descricao);

		preco = JOptionPane.showInputDialog("Informe o preço do tema");
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista est� vazia
			NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no n� criado
			inicio = n;									// carrega inicio com "n" - novo n� criado
		}  // fim if
		else {
				NO_Enfeites aux = inicio;				// cria endere�o de n� "aux" e carrega com o endere�o de inicio
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endere�o
				} // fim while
				NO_Enfeites n = new NO_Enfeites(enfeites);	// cria um novo n� com endere�o "n" e carrega dado "e"
				aux.prox = n;								// carrega n aux o endere�o de n		
		} // fim do else
		JOptionPane.showMessageDialog(null, "Enfeitae cadastrado com sucesso!");  
		System.out.println("Enfeite Cadastrado: \n" + 
							" Código: " +enfeites.getCodTema() + 
							" - Tema: " +enfeites.getTemaEnfeite()+ 
							" - Descrição: " + enfeites.getDescricaoEnfeite() +
							" - Preço: " + enfeites.getPreco());
	} // cadastro enfeites
	
	
	public void GravarEnfeites()  {
		NO_Enfeites aux = inicio;
		
		try {
			String fileName = "ArquivoEnfeites.txt";	
		    BufferedWriter gravar = new BufferedWriter(new FileWriter( fileName ));	
		
			while (aux != null) {
	            gravar.write(0); 
				gravar.newLine();

				codTema = aux.enfeites.getCodTema();
	            gravar.write(aux.enfeites.getCodTema()); 
				gravar.newLine();

				tema = aux.enfeites.getTemaEnfeite();
	            gravar.write(aux.enfeites.getTemaEnfeite()); 
				gravar.newLine();

				descricao = aux.enfeites.getDescricaoEnfeite();
	            gravar.write(aux.enfeites.getDescricaoEnfeite()); 
				gravar.newLine();

				preco = aux.enfeites.getPreco();
	            gravar.write(aux.enfeites.getPreco()); 
				gravar.newLine();

				aux = aux.prox;
			}
		     gravar.close();  			
		} 
		catch (Exception e) {
			System.err.println("Ocorreu um erro!");
		}  // fim try-catch
		JOptionPane.showMessageDialog(null, "Lista gravada com sucesso!");
	} // fim gravar  enfeites
	

	public void ListaEnfeite() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "Lista está vazia!"); 
		} // if
		else {
			NO_Enfeites aux1 = inicio;	// cria��o de duas variaveis
			
			while (aux1 != null) {
				System.out.println("Código: " +aux1.enfeites.getCodTema() +" - Tema: " +aux1.enfeites.getTemaEnfeite()+" - Descrição: "+ aux1.enfeites.getDescricaoEnfeite() + " - Preço: " + aux1.enfeites.getPreco()); 
				aux1 = aux1.prox;
			} // fim while
		} // fim else
	} // fim lista enfeites
	

	public void BuscarEnfeites(String tema) {
		String aux = "";
		for(NO_Enfeites nodo = inicio; nodo != null; nodo = nodo.prox) {
			aux = nodo.enfeites.getTemaEnfeite();

		    if ( tema.equalsIgnoreCase(aux) ) {
				JOptionPane.showMessageDialog(null, "Enfeitae será apresentado no console!"); 
		        System.out.println( "Código " +nodo.enfeites.getCodTema()+ 
									" - Tema: "+ nodo.enfeites.getTemaEnfeite()+
									" - Descrição: " + nodo.enfeites.getDescricaoEnfeite()+
									" - Preço: "+nodo.enfeites.getPreco());
		        break;
		    } //fim if
			else {
				JOptionPane.showMessageDialog(null, "Enfeitae não localizado!"); 
			} // fim else
		} // fim for
	} // fim buscar
	
	public String RemoverInicio() {			// 6 remover no inico da lista
		String codTema1 = "";								// criar as variaveis
		String tema1 = "";
		String descricao1 = "";
		String preco1 = "";

		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A Lista está vazia");
		} // fim inicio 
		else {
			codTema1 = inicio.enfeites.getCodTema();				
			tema1 = inicio.enfeites.getTemaEnfeite();				
			descricao1 = inicio.enfeites.getDescricaoEnfeite();
			preco1 = inicio.enfeites.getPreco();
			JOptionPane.showMessageDialog(null, "Enfeitae removido com sucesso!"); 
			inicio = inicio.prox;			// passar para inicio o ender�o do proximos endere�o
		} // fim else

		return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
	} // fim da classe Remove Inicio
	
	public String RemoveFinal() {					// 5 remover no final da lista
		String codTema1 = "";								// criar as variaveis
		String tema1 = "";
		String descricao1 = "";
		String preco1 = "";
		
		if (inicio == null ) {
			JOptionPane.showMessageDialog(null, " Lista está vazia");
		}
		else {
			if (inicio.prox == null) {			// inicio � o primeiro elemento da lista
				codTema1 = inicio.enfeites.getCodTema();				
				tema1 = inicio.enfeites.getTemaEnfeite();				
				descricao1 = inicio.enfeites.getDescricaoEnfeite();
				preco1 = inicio.enfeites.getPreco();	

				JOptionPane.showMessageDialog(null, "Enfeitae removido com sucesso!"); 	
				inicio = null;					// informa que � o ultimo elemento da lista
			} // fim if
			else {		
				NO_Enfeites aux = LocalizaDadoRemocaoFim(inicio, inicio);

				codTema1 = aux.prox.enfeites.getCodTema();				
				tema1 = aux.prox.enfeites.getTemaEnfeite();				
				descricao1 = aux.prox.enfeites.getDescricaoEnfeite();
				preco1 = aux.prox.enfeites.getPreco();	

				JOptionPane.showMessageDialog(null, "Enfeitae removido com sucesso!"); 
				aux.prox = null;			// coloca null para mostrar o fim da lista. 
			} // fim else
		} // fim else

		return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
	} // fim remover no final
	

	public NO_Enfeites LocalizaDadoRemocaoFim(NO_Enfeites aux1, NO_Enfeites aux2) {
		if ( aux1.prox != null ) {
			return LocalizaDadoRemocaoFim(aux1.prox, aux1);
		}
		return aux2 ;
	}
	
	
	public String RemoverEnfeite(int pos) {
		String codTema1 = "";								// criar as variaveis
		String tema1 = "";
		String descricao1 = "";
		String preco1 = "";	
		int i = 1; 
		NO_Enfeites aux = inicio;	// criar um endere�amento aux com valor inicial
		
		if ( inicio == null ) {
			JOptionPane.showMessageDialog(null, "Lista está vazia!");
			
			codTema1 = inicio.enfeites.getCodTema();				
			tema1 = inicio.enfeites.getTemaEnfeite();				
			descricao1 = inicio.enfeites.getDescricaoEnfeite();
			preco1 = inicio.enfeites.getPreco();
			
			return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
		} // fim IF 
		
		if ( pos == 1 ) {  // remo��o pos = 1, remo��o ser� no inicio da lista
			codTema1 = aux.enfeites.getCodTema();
			tema1 = aux.enfeites.getTemaEnfeite();
			descricao1 = aux.enfeites.getDescricaoEnfeite();
			preco1 = aux.enfeites.getPreco();

			RemoverInicio();
			JOptionPane.showMessageDialog(null, "Enfeitae removido com sucesso!"); 
			return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
		} // Fim IF
		else {
			while (aux.prox != null) {  // remover no final da lista
				aux = aux.prox;   // guarda no aux o endere�o do proximo da posi��o
				i++;				// vai guardando os posi�oes ate encontral null
			} // fim While
			if (pos > i || pos <=0) {  // posicoes invalidas
				JOptionPane.showMessageDialog(null, "Posição inválida");
				
				return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
			} // fim IF
			else if (pos == i){			// Remo��o no final
				codTema1 = aux.enfeites.getCodTema();
				tema1 = aux.enfeites.getTemaEnfeite();
				descricao1 = aux.enfeites.getDescricaoEnfeite();
				preco1 = aux.enfeites.getPreco();

				RemoveFinal();
				JOptionPane.showMessageDialog(null, "Enfeitae removido com sucesso!"); 
				return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
			} // fim else
			else {						// remover qualquer posi��o
				aux = inicio;			// carrega aux com inicio
				NO_Enfeites aux2 = aux;			// cria endere�amenteo aux 2 e copia aux
				
				while(pos > 1) {
					aux2 = aux;
					aux = aux.prox;
					pos --;
				} // while

				codTema1 = aux.enfeites.getCodTema();
				tema1 = aux.enfeites.getTemaEnfeite();
				descricao1 = aux.enfeites.getDescricaoEnfeite();
				preco1 = aux.enfeites.getPreco();
				aux2.prox = aux.prox;

				JOptionPane.showMessageDialog(null, "Enfeitae removido com sucesso!"); 
				return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
			} // fim else
		} // fim else
	} // fim metodo escolher remover
} // fim classe