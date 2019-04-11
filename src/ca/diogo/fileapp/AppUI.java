package ca.diogo.fileapp;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AppUI extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5867113682653418888L;

	private Label label1 = new Label("Operation");
	private Label label2 = new Label("Parameter 1");
	private Label label3 = new Label("Parameter 2");
	
	private Choice param1 = new Choice();
	
	private TextField param2 = new TextField("");
	private TextField param3 = new TextField("");
	
	private Button operation = new Button("Run operation");
	
	public AppUI() {
		super("FileApp UI");
		setLayout(null);
		setSize(390, 180);
		add(label1);
		add(label2);
		add(label3);
		add(param1);
		add(param2);
		add(param3);
		add(operation);
		
		label1.setBounds(30, 60, 70, 20);
		label2.setBounds(30, 82, 70, 20);
		label3.setBounds(30, 104, 70, 20);
		param1.setBounds(110, 60, 250, 20);
		param2.setBounds(110, 82, 250, 20);
		param3.setBounds(110, 104, 250, 20);
		operation.setBounds(110, 126, 250, 20);
		
		param1.add("createDirectory");
		param1.add("deleteDirectory");
		param1.add("deleteFile");
		param1.add("listDirectory");
		param1.add("copyFile");
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		operation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileApp.main(new String[] {param1.getSelectedItem(), param2.getText(), param3.getText()});
			}
		});
	}
	
	public static void main(String[] args) {
		AppUI app = new AppUI();
		app.setVisible(true);
	}
}
