package gof.comportamento.state.states;

import gof.comportamento.state.player.Player;

public abstract class Estado {
	Player player;
	
	Estado(Player player){
		this.player = player;
	}
	
	public abstract String onLock();
	public abstract String onPlay();
	public abstract String onNext();
	public abstract String onPrevious();
}