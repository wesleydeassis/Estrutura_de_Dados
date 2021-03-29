package controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class Consultas {
	
	private String codTema;
	private String tema;
	private String descricao;
	private String preco;
	private NO_Enfeites inicio;

	public String ListaEnfeites()  {
		
		NO_Enfeites aux = inicio;
		String enfeite = " ";
		boolean lista;
		try {
			 String fileName = "ArquivoEnfeites.txt";	
		        BufferedReader ler = new BufferedReader(new FileReader( fileName ));
				if (lista = ler.readLine() != null ) {
					while (aux != null){
						codTema = ler.readLine();
						tema = ler.readLine();
						descricao = ler.readLine();
						preco = ler.readLine();
			
						aux.enfeites.setCodTema(codTema);
						aux.enfeites.setTemaEnfeite(tema);
						aux.enfeites.setDescricaoEnfeite(descricao);
						aux.enfeites.setPreco(preco);
						System.out.println("lista: \n Codigo:" +aux.enfeites.getCodTema()+ " Tema: " +aux.enfeites.getTemaEnfeite() + " Descricao: " +aux.enfeites.getDescricaoEnfeite() + " Preco: " + aux.enfeites.getPreco());
						aux = aux.prox;
				}		
				}
		} catch (Exception e) {
			// TODO: handle exception
		} // fim try e catch 
	
		
		return enfeite;
	} // fim da lista de enfeites
} // fim consulta
