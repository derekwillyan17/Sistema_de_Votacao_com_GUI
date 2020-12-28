package GUI2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VotacaoController {
	
	@FXML
	private Button cand1;
	@FXML
	private Button cand2;
	@FXML
	private Button finalizar;
	
	private int candidato1 = 0, candidato2 = 0, total = 0;
	private String src = "//home//derekwillyan//Área de Trabalho//votacao.txt";
	
	public void onbtnVotar1(){

		this.candidato1 += 1;
		this.total += 1;
		JOptionPane.showMessageDialog(null, String.format("SUCESSO!!!"));
		
	}
	
	public void onbtnVotar2(){

		this.candidato2 += 1;
		this.total += 1;
		JOptionPane.showMessageDialog(null, String.format("SUCESSO!!!"));
		
	}
	
	public void onbtnFinal() throws IOException {
		
		if(this.candidato1 > this.candidato2) {
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.src, true))){
				
				bw.write(String.format("CANDIDATO 1 VENCEU!!!!!\n Total Candidato 1: %d\n Total Candidato 2: %d\n Total de eleitores: %d", this.candidato1, this.candidato2, this.total));
				bw.newLine();
				
			} catch(IOException e){
				
				e.getStackTrace();
				
			}
			
		} else if(this.candidato1 < this.candidato2) {
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.src, true))){
				
				bw.write(String.format("CANDIDATO 2 VENCEU!!!!!\n Total Candidato 1: %d\n Total Candidato 2: %d\n Total de eleitores: %d", this.candidato1, this.candidato2, this.total));
				bw.newLine();
				
				
			} catch(IOException e){
				
				e.getStackTrace();
				
			}
						
		} else if (this.candidato1 == this.candidato2) {
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.src, true))){
				
				bw.write(String.format("ELEIÇÃO EMPATADA!!!!!\n Total Candidato 1: %d\n Total Candidato 2: %d\n Total de eleitores: %d", this.candidato1, this.candidato2, this.total));
				bw.newLine();
				
				
			} catch(IOException e){
				
				e.getStackTrace();
				
			}
			

			
		}
		
		JOptionPane.showMessageDialog(null, String.format("Arquivo votacao.txt criado"));
		ganhador();
		
		this.candidato1 = 0;
		this.candidato2 = 0;
		this.total = 0;
		
	}

	public void ganhador() throws IOException {
		
		if(this.candidato1 > this.candidato2) {
		
			Stage s1 = new Stage();
			Parent FXMLganhador = FXMLLoader.load(getClass().getResource("/GUI2/Ganhador1.fxml"));
			Scene ganhadorScene = new Scene(FXMLganhador);
			s1.setScene(ganhadorScene);
			s1.setTitle("CANDIDATO 1 VENCEU");
			s1.show();
			
		} else if (this.candidato1 < this.candidato2) {
			
			Stage s1 = new Stage();
			Parent FXMLganhador = FXMLLoader.load(getClass().getResource("/GUI2/Ganhador2.fxml"));
			Scene ganhadorScene = new Scene(FXMLganhador);
			s1.setScene(ganhadorScene);
			s1.setTitle("CANDIDATO 2 VENCEU");
			s1.show();
			
		}
		
		
	}
	
}
