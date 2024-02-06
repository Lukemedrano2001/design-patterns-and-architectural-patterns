package solid.isp;

import java.math.BigDecimal;

public class Vendedor implements IFuncionario, IComissionavel {

	@Override
	public BigDecimal salario() {
		return null;
	}

	@Override
	public BigDecimal gerarComissao() {
		return null;
	}
}