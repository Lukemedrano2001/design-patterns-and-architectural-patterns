package gof.comportamento.state;

import gof.comportamento.state.player.Player;
import gof.comportamento.state.player.PlayerGUI;

public class Application {
	public static void main(String[] args) {
        Player player = new Player();
        PlayerGUI playerGUI = new PlayerGUI(player);
        playerGUI.init();
    }
}