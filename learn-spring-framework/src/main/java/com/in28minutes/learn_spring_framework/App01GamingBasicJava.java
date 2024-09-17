package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		var game = new SuperContraGame(); // 1.Object Creation
		var game1 = new MarioGame();
		var game2 = new PacmanGame();
		var gameRunner = new GameRunner(game); 
		// 2.Object Creation + Wiring of dependencies
		// game is a dependency of GameRunner
		var gameRunner1 = new GameRunner(game1);
		var gameRunner2 = new GameRunner(game2);
		gameRunner.run();
		gameRunner1.run();
		gameRunner2.run();
	}

}
