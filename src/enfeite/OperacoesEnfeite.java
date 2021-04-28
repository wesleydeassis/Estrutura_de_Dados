package enfeite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class OperacoesEnfeite {

	private int codTema;
	private String tema;
	private String descricao;
	private double preco;
	private NO inicio;
	
	public OperacoesEnfeite() {
		inicio = null;
	}

	public void MenuEnfeites() {
		int opcao = 0;
		while (opcao != 99) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu de Enfeites: \n"+
			"\n1- Cadastrar enfeite"+
			"\n2- Gravar lista de enfeites"+
			"\n3- Listar enfeites"+
			"\n4- Buscar enfeite por tema"+
			"\n5- Remover da enfeite da lista"+
			"\n6- Recuperar da lista"+
			"\n7- Mostrar lista recuperada"+
			"\n99- Voltar  "));
			
			switch (opcao) {
				case 1:
					CadastrarEnfeites();
				break;

				case 2:	
					GravarEnfeites();
				break;

				case 3:
					ListarEnfeites();
				break;

				case 4:
					tema = JOptionPane.showInputDialog("Digite o nome do tema para buscar: ");
					BuscarEnfeites(tema);
				break;

				case 5:
					int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser removida: "));
					System.out.println(RemoverEnfeites(posicao));
				break;

				case 6:
					JOptionPane.showMessageDialog(null, "Em desenvolvimento ... ");
					//RecuperarListaEnfeites();
				break;

				case 7:
					PercorreListaEnfeites();
				break;
				
				case 99:
					JOptionPane.showMessageDialog(null, "Voltando ao menu anterior");
				break;
				default:
				break;
			} // fim switch
		} // fim while
	} // fim cadastro enfeites
	

	public void CadastrarEnfeites() {   // adicionar no final da lista
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);

		codTema = (int)(Math.random() * 1000);
		enfeites.setCodTema(codTema);

		tema = JOptionPane.showInputDialog("Informe o tema do enfeite");
		enfeites.setTemaEnfeite(tema);

		descricao = JOptionPane.showInputDialog("Informe a descrição do enfeite");
		enfeites.setDescricaoEnfeite(descricao);

		preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do tema"));
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista est� vazia
			NO n = new NO(enfeites);	// carrega o valor de "e" no n� criado
			inicio = n;									// carrega inicio com "n" - novo n� criado
		}  // fim if
		else {
				NO aux = inicio;				// cria endere�o de n� "aux" e carrega com o endere�o de inicio
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endere�o
				} // fim while
				NO n = new NO(enfeites);	// cria um novo n� com endere�o "n" e carrega dado "e"
				aux.prox = n;								// carrega n aux o endere�o de n		
		} // fim do else
		JOptionPane.showMessageDialog(null, "Enfeite cadastrado com sucesso!");  
		System.out.println("Enfeite Cadastrado: \n" + 
							" Código: " +enfeites.getCodTema() + 
							" - Tema: " +enfeites.getTemaEnfeite()+ 
							" - Descrição: " + enfeites.getDescricaoEnfeite() +
							" - Preço: " + enfeites.getPreco());
	} // cadastro enfeites
	
	
	public void GravarEnfeites()  {
		NO aux = inicio;
		
		try {
			String fileName = "ArquivoEnfeites.txt";	
		    BufferedWriter gravar = new BufferedWriter(new FileWriter( fileName ));	
		
			while (aux != null) {
	            gravar.write("** Novo Enfeite:"); 
				gravar.newLine();

				codTema = aux.enfeites.getCodTema();
	            gravar.write(String.valueOf(aux.enfeites.getCodTema())); 
				gravar.newLine();

				tema = aux.enfeites.getTemaEnfeite();
	            gravar.write(aux.enfeites.getTemaEnfeite()); 
				gravar.newLine();

				descricao = aux.enfeites.getDescricaoEnfeite();
	            gravar.write(aux.enfeites.getDescricaoEnfeite()); 
				gravar.newLine();

				preco = aux.enfeites.getPreco();
	            gravar.write(String.valueOf(aux.enfeites.getPreco())); 
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
	

	public void ListarEnfeites() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "Lista está vazia!"); 
		} // if
		else {
			NO aux1 = inicio;	// cria��o de duas variaveis
			
			while (aux1 != null) {
				System.out.println("Código: " +aux1.enfeites.getCodTema() +" - Tema: " +aux1.enfeites.getTemaEnfeite()+" - Descrição: "+ aux1.enfeites.getDescricaoEnfeite() + " - Preço: " + aux1.enfeites.getPreco()); 
				aux1 = aux1.prox;
			} // fim while
		} // fim else
	} // fim lista enfeites
	

	public void BuscarEnfeites(String tema) {
		String aux = "";

		for ( NO nodo = inicio; nodo != null; nodo = nodo.prox ) {
			aux = nodo.enfeites.getTemaEnfeite();
			try {
				if ( tema.equalsIgnoreCase(aux) ) {
					JOptionPane.showMessageDialog(null, "Enfeite será apresentado no console!"); 
					System.out.println( "Código " +nodo.enfeites.getCodTema()+ 
										" - Tema: "+ nodo.enfeites.getTemaEnfeite()+
										" - Descrição: " + nodo.enfeites.getDescricaoEnfeite()+
										" - Preço: "+nodo.enfeites.getPreco());
					break;
				} //fim if
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Enfeite não localizado!"); 
			}
		} // fim for
	} // fim buscar
	
	
	public String RemoverInicio() {			// 6 remover no inico da lista
		int codTema1 = 0;								// criar as variaveis
		String tema1 = "";
		String descricao1 = "";
		double preco1 = 0.0;

		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A Lista está vazia");
		} // fim inicio 
		else {
			codTema1 = inicio.enfeites.getCodTema();				
			tema1 = inicio.enfeites.getTemaEnfeite();				
			descricao1 = inicio.enfeites.getDescricaoEnfeite();
			preco1 = inicio.enfeites.getPreco();
			JOptionPane.showMessageDialog(null, "Enfeite removido com sucesso!"); 
			inicio = inicio.prox;			// passar para inicio o ender�o do proximos endere�o
		} // fim else

		return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
	} // fim da classe Remove Inicio
	
	public String RemoveFinal() {					// 5 remover no final da lista
		int codTema1 = 0;								// criar as variaveis
		String tema1 = "";
		String descricao1 = "";
		double preco1 = 0.0;

		
		if (inicio == null ) {
			JOptionPane.showMessageDialog(null, " Lista está vazia");
		}
		else {
			if (inicio.prox == null) {			// inicio � o primeiro elemento da lista
				codTema1 = inicio.enfeites.getCodTema();				
				tema1 = inicio.enfeites.getTemaEnfeite();				
				descricao1 = inicio.enfeites.getDescricaoEnfeite();
				preco1 = inicio.enfeites.getPreco();	

				JOptionPane.showMessageDialog(null, "Enfeite removido com sucesso!"); 	
				inicio = null;					// informa que � o ultimo elemento da lista
			} // fim if
			else {		
				NO aux = LocalizaDadoRemocaoFim(inicio, inicio);

				codTema1 = aux.prox.enfeites.getCodTema();				
				tema1 = aux.prox.enfeites.getTemaEnfeite();				
				descricao1 = aux.prox.enfeites.getDescricaoEnfeite();
				preco1 = aux.prox.enfeites.getPreco();	

				JOptionPane.showMessageDialog(null, "Enfeite removido com sucesso!"); 
				aux.prox = null;			// coloca null para mostrar o fim da lista. 
			} // fim else
		} // fim else

		return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
	} // fim remover no final
	

	public NO LocalizaDadoRemocaoFim(NO aux1, NO aux2) {
		if ( aux1.prox != null ) {
			return LocalizaDadoRemocaoFim(aux1.prox, aux1);
		}
		return aux2 ;
	}
	
	
	public String RemoverEnfeites(int pos) {
		int codTema1 = 0;								// criar as variaveis
		String tema1 = "";
		String descricao1 = "";
		double preco1 = 0.0;

		int i = 1; 
		NO aux = inicio;	// criar um endere�amento aux com valor inicial
		
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
			JOptionPane.showMessageDialog(null, "Enfeite removido com sucesso!"); 
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
				JOptionPane.showMessageDialog(null, "Enfeite removido com sucesso!"); 
				return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
			} // fim else
			else {						// remover qualquer posi��o
				aux = inicio;			// carrega aux com inicio
				NO aux2 = aux;			// cria endere�amenteo aux 2 e copia aux
				
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

				JOptionPane.showMessageDialog(null, "Enfeite removido com sucesso!"); 
				return "Código : " + codTema1 + " - Tema: " + tema1 + " - Descrição: " +descricao1 + " - Preço: " +preco1;
			} // fim else
		} // fim else
	} // fim metodo escolher remover


	public void RecuperarListaEnfeites()  {	
		try {
			String fileName = "ArquivoEnfeites.txt";
			BufferedReader ler = new BufferedReader(new FileReader(fileName));
			String linha = ler.readLine();

			while ( linha != null ) {        		
				codTema = Integer.parseInt(ler.readLine());
				tema = ler.readLine();
				descricao = ler.readLine();
				preco = Double.parseDouble(ler.readLine());

				System.out.println("\n"+codTema + tema+ descricao + preco);
					
				GerarListaEnfeites(codTema, tema, descricao, preco);
				ler.close();
			}
		} 
		catch (Exception e) {
			System.err.println("Ocorreu um erro!");
		} // fim try e catch 
	} // fim da lista de enfeites
	

	public void GerarListaEnfeites(int codTema, String tema, String descricao, double preco) {
		NO aux = inicio;
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);

		enfeites.setCodTema(codTema);
		enfeites.setTemaEnfeite(tema);
		enfeites.setDescricaoEnfeite(descricao);
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista est� vazia
			NO n = new NO(enfeites);	// carrega o valor de "e" no n� criado
			inicio = n;									// carrega inicio com "n" - novo n� criado
		}  // fim if
		else {
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endere�o
				} // fim while
				NO n = new NO(enfeites);	// carrega o valor de "e" no n� criado
				aux.prox = n;								// carrega n aux o endere�o de n		
		}  // fim do else
	}  //fim gerar lista
	

	public void PercorreListaEnfeites() {
		
		if (inicio == null) {
			System.out.println("Lista vazia");
		} // if
		else {
			NO aux1 = inicio;	// cria��o de duas variaveis
				
			while (aux1 != null) {
				System.out.println("Codigo: " +aux1.enfeites.getCodTema() +" Tema: " +aux1.enfeites.getTemaEnfeite()+" Descri��o: "+ aux1.enfeites.getDescricaoEnfeite() + " Pre�o: " + aux1.enfeites.getPreco()); 
				aux1 = aux1.prox;
			} // fim while
		} // fim else
	} // fim percorre lista
} // fim classe