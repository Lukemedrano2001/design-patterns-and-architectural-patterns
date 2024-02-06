package gof.comportamento.state.states;

import gof.comportamento.state.player.Player;

public class EstadoPlay extends Estado {
	EstadoPlay(Player player) {
        super(player);
    } 
	
	@Override
    public String onLock() {
        player.changeState(new EstadoLocked(player));
        player.setCurrentTrackAfterStop();
        return "Parando de tocar.";
    }

    @Override
    public String onPlay() {
        player.changeState(new EstadoReady(player));
        return "Pausado...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}