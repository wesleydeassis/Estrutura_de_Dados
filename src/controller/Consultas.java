package controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class Consultas {
	private String codTema;
	private String tema;
	private String descricao;
	private String preco;
	private NO_Enfeites inicio;
	
	public Consultas() {
		inicio = null;
	}
	
	public void RecuperarListaEnfeites()  {
		
		try {
			String fileName = "ArquivoEnfeites.txt";
			BufferedReader ler = new BufferedReader(new FileReader(fileName));
			String linha = ler.readLine();

			while ( linha != null ) {        		
				codTema = ler.readLine();
				tema = ler.readLine();
				descricao = ler.readLine();
				preco = ler.readLine();

				System.out.println("\n"+codTema + tema+ descricao + preco);
					
				GerarLista(codTema, tema, descricao, preco);
				ler.close();
			}
		} 
		catch (Exception e) {
			System.err.println("Ocorreu um erro!");
		} // fim try e catch 
	} // fim da lista de enfeites
	
	public void GerarLista(String codTema, String tema, String descricao, String preco) {
		NO_Enfeites aux = inicio;
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);

		enfeites.setCodTema(codTema);
		enfeites.setTemaEnfeite(tema);
		enfeites.setDescricaoEnfeite(descricao);
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista est� vazia
			NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no n� criado
			inicio = n;									// carrega inicio com "n" - novo n� criado
		}  // fim if
		else {
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endere�o
				} // fim while
				NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no n� criado
				aux.prox = n;								// carrega n aux o endere�o de n		
		}  // fim do else
	}  //fim gerar lista
	
	public void PercorreListaEnfeite() {
		
			if (inicio == null) {
				System.out.println("Lista vazia");
			} // if
			else {
				NO_Enfeites aux1 = inicio;	// cria��o de duas variaveis
				
				while (aux1 != null) {
					System.out.println("Codigo: " +aux1.enfeites.getCodTema() +" Tema: " +aux1.enfeites.getTemaEnfeite()+" Descri��o: "+ aux1.enfeites.getDescricaoEnfeite() + " Pre�o: " + aux1.enfeites.getPreco()); 
					aux1 = aux1.prox;
				} // fim while
			} // fim else
		} // fim percorre lista
} // fim consulta