package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static Stage stage;
	public static Scene mainScene, votacaoScene;
	
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		
		try {
		
			Parent FXMLmain = FXMLLoader.load(getClass().getResource("/GUI2/Main.fxml"));
			mainScene = new Scene(FXMLmain);
			
			Parent FXMLvotacao = FXMLLoader.load(getClass().getResource("/GUI2/Votacao.fxml"));
			votacaoScene = new Scene(FXMLvotacao);
			
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("SISTEMA DE VOTAÇÃO - MENU");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mudarcena(String cena) {
		
		switch (cena) {
		case "main":
			
			stage.setScene(mainScene);
			stage.setTitle("SISTEMA DE VOTAÇÃO - MENU");
			stage.show();
			
			break;
		case "votacao":
			
			stage.setScene(votacaoScene);
			stage.setTitle("SISTEMA DE VOTAÇÃO - VOTAÇÃO");
			stage.show();
			
			break;

		default:
			break;
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
