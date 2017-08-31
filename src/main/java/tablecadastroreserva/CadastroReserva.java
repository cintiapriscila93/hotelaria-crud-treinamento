package tablecadastroreserva;



// Classe que representa as informações referente a um cadastroreserva .//
public class CadastroReserva {

	private int id_cadastro;
	private String nomeDoCliente;
	private String rg;
	private String contato;
	private String numerodoquarto;
	private String andar;
	private String datainiciodareserva;
	private String datafimdareserva;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId_cadastro() {
		return id_cadastro;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public String getRg() {
		return rg;
	}

	public String getContato() {
		return contato;
	}

	public String getNumerodoquarto() {
		return numerodoquarto;
	}

	public String getAndar() {
		return andar;
	}

	public String getDatainiciodareserva() {
		return datainiciodareserva;
	}

	public String getDatafimdareserva() {
		return datafimdareserva;
	}

	public void setId_cadastro(int id_cadastro) {
		this.id_cadastro = id_cadastro;
	}

	public void setNomedocliente(String nomedocliente) {
		this.nomeDoCliente = nomedocliente;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public void setNumerodoquarto(String numerodoquarto) {
		this.numerodoquarto = numerodoquarto;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public void setDatainiciodareserva(String inicioReserva) {
		this.datainiciodareserva = inicioReserva;
	}

	public void setDatafimdareserva(String string) {
		this.datafimdareserva = string;
	}

}
