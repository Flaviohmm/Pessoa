package entidade;

public class PessoaFisica extends Pessoa {

	private Double gastos_saude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double renda_anual, Double gastos_saude) {
		super(nome, renda_anual);
		this.gastos_saude = gastos_saude;
	}

	public Double getGastos_saude() {
		return gastos_saude;
	}

	public void setGastos_saude(Double gastos_saude) {
		this.gastos_saude = gastos_saude;
	}

	@Override
	public Double calculaImpostos() {
		double impostos = 0.0;
		if (getRenda_anual() < 20000.00) {
			impostos = getRenda_anual() * 0.15;
		} else if (getRenda_anual() >= 20000.00 && gastos_saude != null) {
			impostos = (getRenda_anual() * 0.25) - (gastos_saude * 0.5);
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
