package gof.estruturais.decorator.codigoFonte;

public class CodigoFonteDecorator implements ICodigoFonte {
	private ICodigoFonte wrapper;
	
	public CodigoFonteDecorator(ICodigoFonte codigo) {
        this.wrapper = codigo;
    }

    @Override
    public void escreverDado(String dado) {
    	wrapper.escreverDado(dado);
    }

    @Override
    public String lerDado() {
        return wrapper.lerDado();
    }
}