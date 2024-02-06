package gof.criacao.builder.carro.componentes;

public class GPSNavegador {
	private String rota = "123, Avenida Paulista, São Paulo até Copacabana, Rio de Janeiro";

    public GPSNavegador() {}

    public GPSNavegador(String rotaManual) {
        this.rota = rotaManual;
    }

    public String getRota() {
        return rota;
    }
    
    @Override
    public String toString() {
    	return String.format(" | Rota: %s", this.getRota());
    }
}