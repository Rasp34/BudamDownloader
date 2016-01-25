package BudamDownloader;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class UISwicher extends Thread {
	
	boolean switchButton;
	boolean switchText;
	JButton button = null;
	JFormattedTextField textField = null;
	
	public UISwicher(JButton button, boolean setEnableButton, JFormattedTextField textField, boolean setEnableText){
		
//		Primary state element
		super("UIswicher");
		this.switchButton = setEnableButton;
		this.button = button;
		this.textField = textField;
		this.switchText = setEnableText;

	}
	
	public void setEnable(boolean setEnableButton,  boolean setEnableText) {
		
		this.switchButton = setEnableButton;
		this.switchText = setEnableText;
		
	}
	
	@Override
	public void run() {
		
//		Change state UI element
		button.setEnabled(switchButton);
		textField.setEnabled(switchText);
				
		
	}
	

}