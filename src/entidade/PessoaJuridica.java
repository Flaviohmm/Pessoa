package entidade;

public class PessoaJuridica extends Pessoa {

	private Integer numFuncionario;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double renda_anual, Integer numFuncionario) {
		super(nome, renda_anual);
		this.numFuncionario = numFuncionario;
	}

	public Integer getNumFuncionario() {
		return numFuncionario;
	}

	public void setNumFuncionario(Integer numFuncionario) {
		this.numFuncionario = numFuncionario;
	}

	@Override
	public Double calculaImpostos() {
		double impostos = 0.0;
		if (numFuncionario > 10) {
			impostos = getRenda_anual() * 0.14;
		} else {
			impostos = getRenda_anual() * 0.16;
		}

		return impostos;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(getNome() + ": $ " + String.format("%.2f", calculaImpostos()));
		return strBuilder.toString();
	}
	
	

}
