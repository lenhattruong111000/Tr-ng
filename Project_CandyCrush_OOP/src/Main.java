import java.awt.EventQueue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The Main class will control the entire application
 */

public class Main extends Application {
	/** Windows Properties */
	private static final String screenTitle = "Candy Crush";

	/** GameBoard properties */
	private static final int numberOfColumn[] = {15 };

	private static final int numberOfRow[] = { 10 };
	/** Timer Properties */
	private static final int time = 5; // sec

	private static final int timerUpdateInterval = 1000; // ms
	private static final int timerInitialDelay = 1000;
	/** Gameplay Properties */
	private static final int numberOfCandyColor = 6;

	/** Display Var */
	private static Stage stage;

	private static Scene scene;
	private static Board board;
	private static MainMenu mainMenu;
	private static GameBoard gameBoard;
	private static HeaderBoard headerBoard;
	private static TimeHandler timeHandler;
	private static GameOver gameOver;
	private static int click = 0; //thêm 1 cái click ngay đây 

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage _stage) throws Exception {
		// Set up Candy
		Candy.init();

		// Set up menu
		mainMenu = new MainMenu();

		// Wrap up and display
		stage = _stage;
		stage.setTitle(screenTitle);
		stage.setResizable(false);
		Pane root = mainMenu.getMainMenuPane();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	/**
	 * Change the scene when hit play button Init the size according to the
	 * difficulty
	 * 
	 * @param _diff
	 *            difficulty
	 */
/*đây nữa */	public static void playButton(int _click) {
		click = _click;
		try {
			headerBoard = new HeaderBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set up Game Board
		try {
			gameBoard = new GameBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set up Board
		board = new Board(numberOfRow[0], numberOfColumn[0], numberOfCandyColor);
		board.generateBoard();

		// Set up timer
		timeHandler = new TimeHandler(time);

		// Wrap up and display
		VBox root = new VBox();
		root.getChildren().addAll(headerBoard.getHeaderPane(), gameBoard.getGameBoardPane());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		gameBoard.play();
	}

	/**
	 * Is called between every timer-update-interval
	 * 
	 * @see timerUpdateInterval
	 */
	public static void timerAction() {
		headerBoard.setTimeValue(timeHandler.toString());
	}
	
	/**
	 * To be executed when the Time Handler runs out
	 */
	public static void timerEndAction() {
		
		System.out.println("ENDGAME");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver window = new GameOver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	
/*đây nữa*/	public static GameOver getGameOver() {
		return gameOver;
	}

	public static Board getBoard() {
		return board;
	}

	public static GameBoard getGameBoard() {
		return gameBoard;
	}

	public static HeaderBoard getHeaderBoard() {
		return headerBoard;
	}

	public static int getNumberofcandycolor() {
		return numberOfCandyColor;
	}

	public static int getNumberofcolumn() {
		return numberOfColumn[0];
	}

	public static int getNumberofrow() {
		return numberOfRow[0];
	}

	public static int getTimerinitialdelay() {
		return timerInitialDelay;
	}

	public static int getTimerupdateinterval() {
		return timerUpdateInterval;
	}
}