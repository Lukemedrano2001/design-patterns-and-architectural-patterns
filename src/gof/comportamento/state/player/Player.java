package gof.comportamento.state.player;

import java.util.ArrayList;
import java.util.List;

import gof.comportamento.state.states.Estado;
import gof.comportamento.state.states.EstadoReady;

public class Player { 
	private Estado estado; 
	private boolean playing = false;
	private List<String> playlist = new ArrayList<String>();
	private int trackAtual = 0; 
	
	public Player() {
	    this.estado = new EstadoReady(this);
	    setPlaying(true);
	    for (int i = 1; i <= 12; i++) {
	        playlist.add("Track " + i);
	    }
	}
	
	public void changeState(Estado state) {
	    this.estado = state;
	}
	
	public Estado getState() {
	    return estado;
	}
	
	public void setPlaying(boolean playing) {
	    this.playing = playing;
	}
	
	public boolean isPlaying() {
	    return playing;
	}
	
	public String startPlayback() {
	    return "Tocando " + playlist.get(trackAtual);
	}
	
	public String nextTrack() {
	    trackAtual++;
	    if (trackAtual > playlist.size() - 1) {
	        trackAtual = 0;
	    }
	    
	    return "Tocando " + playlist.get(trackAtual);
	}
	
	public String previousTrack() {
	    trackAtual--;
	    if (trackAtual < 0) {
	        trackAtual = playlist.size() - 1;
	    }
	    
	    return "Tocando " + playlist.get(trackAtual);
	}
	
	public void setCurrentTrackAfterStop() {
	    this.trackAtual = 0;
	}
}