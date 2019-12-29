import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The MainMenu class will handle events in the menu.
 */
public class MainMenu {
	public static int click;
	@FXML
	private ImageView playButton;
	private Pane mainMenuPane;

	public MainMenu() throws IOException {
		FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
		mainMenuLoader.setController(this);
		mainMenuPane = mainMenuLoader.load();
		playButton.setOnMouseClicked(e -> {
			playAction();
		});
	}

	public Pane getMainMenuPane() {
		return mainMenuPane;
	}

	/**
	 * @see Main.playButton();
	 */
	private void playAction() {
		
		Main.playButton(click);
	}

}