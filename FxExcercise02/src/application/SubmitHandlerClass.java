package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SubmitHandlerClass implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, LogInInfo.txtUserName.getText() + "\n" + LogInInfo.txtPassword.getText()
				+ LogInInfo.txtName.getText());
		LogInInfo.txtName.setText(LogInInfo.txtUserName.getText());
		
	}
	
}
