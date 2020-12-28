package GUI2;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	@FXML
	private Button iniciar;
	@FXML
	private Button sair;
	
	@FXML
	public void onbtnIniciar() {
		
		Main.mudarcena("votacao");
		
	}
	
	@FXML
	public void onbtnSair() {
		
		Platform.exit();
		
	}
	
	
}
