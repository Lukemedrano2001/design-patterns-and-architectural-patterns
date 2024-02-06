package gof.comportamento.state.states;

import gof.comportamento.state.player.Player;

public class EstadoReady extends Estado {
	public EstadoReady(Player player) {
        super(player);
    }

	@Override
    public String onLock() {
        player.changeState(new EstadoLocked(player));
        return "Bloqueado...";
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new EstadoPlay(player));
        return action;
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