package cliente;

public class NO {
    public Clientes clientes;
	public NO prox;
	public NO anterior;
	
	public NO (Clientes clientes) {
		this.clientes = clientes;
		prox = null;
		anterior = null;
	}
}