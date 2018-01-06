package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Controller;
import entity.Cup;
import entity.Player;
import entity.PlayerList;
import gameRules.Logic;

class EndGameTest {
	
	Player player;
	Controller controller;
	PlayerList players;
	Scanner boundry;
	Logic gameLogic;
	Cup cup;

	@BeforeEach
	void setUp() throws Exception {
		this.player = new Player();
		this.controller = new Controller(players, boundry, gameLogic, cup);
	}

	@Test
	void removePlayerTest() {
		this.player.addBalance(-30001);
		int expected = this.player.getField();
		this.controller.launchGame();
		int actual = this.player.getField();
		assertEquals(actual, expected);
	}

}
