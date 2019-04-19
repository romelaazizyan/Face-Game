

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Face extends JFrame {

	private JPanel contentPane;
	private FacePanel facePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Face frame = new Face();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Face() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 70, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		facePanel = new FacePanel();
		contentPane.add(facePanel, BorderLayout.CENTER);
		
		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);
	}

	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		controlPanel.setLayout(new GridLayout(15, 1, 0, 0));
		
		JCheckBox chckbxEyes = new JCheckBox("Eyes");
		chckbxEyes.setSelected(true);
		controlPanel.add(chckbxEyes);
		
		JCheckBox chckbxNose = new JCheckBox("Nose");
		controlPanel.add(chckbxNose);
		
		JCheckBox chckbxMouth = new JCheckBox("Mouth");
		controlPanel.add(chckbxMouth);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxEyes.isSelected() && chckbxNose.isSelected() && chckbxMouth.isSelected()){
					facePanel.changeEyes();
					facePanel.changeNose();
					facePanel.changeMouth();
				} else if(chckbxNose.isSelected() && chckbxEyes.isSelected()){
					facePanel.changeNose();
					facePanel.changeEyes();
				} else if(chckbxMouth.isSelected() && chckbxNose.isSelected()){
					facePanel.changeMouth();
					facePanel.changeNose();
				} else if(chckbxMouth.isSelected() && chckbxEyes.isSelected()){
					facePanel.changeMouth();
					facePanel.changeEyes();
				} else if(chckbxEyes.isSelected()) {
					facePanel.changeEyes();
				} else if(chckbxNose.isSelected()) {
					facePanel.changeNose();
				} else if(chckbxMouth.isSelected()) {
					facePanel.changeMouth();
				} else {
					facePanel.changeBackground();
				}
			}
		});
		controlPanel.add(btnUpdate);
		return controlPanel;
	}
}
