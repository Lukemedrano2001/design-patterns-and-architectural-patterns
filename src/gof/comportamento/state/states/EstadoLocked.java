package gof.comportamento.state.states;

import gof.comportamento.state.player.Player;

public class EstadoLocked extends Estado {
	
	public EstadoLocked(Player player) {
        super(player);
        player.setPlaying(false);
    }

	@Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new EstadoReady(player));
            return "Parando de tocar.";
        } else {
            return "Bloqueado...";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new EstadoReady(player));
        return "Pronto";
    }

    @Override
    public String onNext() {
        return "Bloqueado...";
    }

    @Override
    public String onPrevious() {
        return "Bloqueado...";
    }
}