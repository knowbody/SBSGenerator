package generator.SBS;
/* Created by Mateusz Zatorski
 * mateuszzatorski@gmail.com
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AppGUI extends JFrame implements ActionListener {

	private JButton createAccBtn;
	private JButton deleteAccBtn;
	private JButton deleteFilesBtn;
	private static JTextArea note;
	private static JTextField groupGUI;
	private JLabel groupLabel;
	private JLabel noteLabel;
	private JScrollPane scroll;

	public AppGUI() {

		setLayout(new FlowLayout());
		setBounds(500, 20, 440, 670);
		setTitle("SBS Script Generator (by M. Zatorski)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		groupLabel = new JLabel("Enter the name of your group:");
		add(groupLabel);
		groupGUI = new JTextField(15);
		add(groupGUI);

		noteLabel = new JLabel("Enter full names:");
		add(noteLabel);
		note = new JTextArea(30, 30);
		note.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(note);
		scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll);

		createAccBtn = new JButton("GENERATE 'CREATE ACCOUNTS' SCRIPT");
		add(createAccBtn);
		deleteAccBtn = new JButton("GENERATE 'DELETE ACCOUNTS' SCRIPT");
		add(deleteAccBtn);
		deleteFilesBtn = new JButton("GENERATE 'DELETE DATA' SCRIPT");
		add(deleteFilesBtn);

		createAccBtn.addActionListener(this);
		deleteAccBtn.addActionListener(this);
		deleteFilesBtn.addActionListener(this);

		setVisible(true);
		setResizable(false);

	}

	public static JTextArea getNote() {
		return note;
	}

	public static JTextField getGroup() {
		return groupGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createAccBtn) {
			try {
				MyAppCreateAcc newAcc = new MyAppCreateAcc();
			} catch (IOException e1) {
				System.out.println(e1);
			}
			JOptionPane.showMessageDialog(null, "File created succesufully!");

		}

		if (e.getSource() == deleteAccBtn) {
			try {
				MyAppDeleteAll delAll = new MyAppDeleteAll();
			} catch (IOException e2) {
				System.out.println(e2);
			}
			JOptionPane.showMessageDialog(null, "File created succesufully!");

		}

		if (e.getSource() == deleteFilesBtn) {
			try {
				MyAppDeleteFiles delFiles = new MyAppDeleteFiles();
			} catch (IOException e3) {
				System.out.println(e3);
			}
			JOptionPane.showMessageDialog(null, "File created succesufully!");

		}

	}

}
