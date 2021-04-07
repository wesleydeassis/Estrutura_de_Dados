package cliente;

public class NO {
    public Clientes clientes;
	public NO prox;
	
	public NO(Clientes clientes) {
		this.clientes = clientes;
		prox = null;
	}
}