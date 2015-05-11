package filmovi.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.IntegerSyntax;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.json.JSONException;
import org.json.JSONObject;

import filmovi.Film;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FilmGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private void ugasiAplikaciju(){
		int sifra=JOptionPane.showConfirmDialog(contentPane, "Da li želite da izaðete iz programa?", "Izlaz", JOptionPane.YES_NO_CANCEL_OPTION);
		if(sifra==JOptionPane.YES_OPTION) System.exit(0);
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	public static boolean isDouble(String s) {
	    try { 
	        Double.parseDouble(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilmGUI frame = new FilmGUI();
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
	public FilmGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ugasiAplikaciju();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FilmGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Film");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(150, 2));
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		final JTextArea textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(22, 22));
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(150, 2));
		contentPane.add(scrollPane_1, BorderLayout.EAST);
		
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setPreferredSize(new Dimension(22, 22));
		scrollPane_1.setViewportView(textArea_1);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);
		
		JMenuItem mntmIspisi = new JMenuItem("Ispisi");
		mntmIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JSONObject object = new JSONObject();
				Film film = new Film();
				
				try {
					if (textField.getText().isEmpty()) {
				
					film.setNaziv("Unknown");
					object.put("Naziv", "Unknown");
				} else {
					film.setNaziv(textField.getText());
					object.put("Naziv", textField.getText());
				}
				if (textField_1.getText().isEmpty()) {
					film.setGodina(0);
					object.put("Godina", "Unknown");
				} else {
					film.setGodina(Integer.parseInt(textField_1.getText()));
					object.put("Godina", textField_1.getText());
				}
				if (textField_2.getText().isEmpty()) {
					film.setReziser("Unknown");
					object.put("Reziser", "Unknown");
				} else {
					film.setReziser(textField_2.getText());
					object.put("Reziser", textField_2.getText());
				}
				
				if (textField_3.getText().isEmpty()) {
					film.setZanr("Unknown");
					object.put("Zanr", "Unknown");
				} else {
					film.setZanr(textField_3.getText());
					object.put("Zanr", textField_3.getText());
				}
				if (textField_4.getText().isEmpty()) {
					film.setOcenaGledalaca(0.00);;
					object.put("Ocena gledalaca", "Unknown");
				} else {
					film.setOcenaGledalaca(Double.parseDouble(textField_4.getText()));
					object.put("Ocena Gledalaca", textField_4.getText());
				}
				
				textArea.setText(film.toString());
				textArea_1.setText(object.toString(4));
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
				
			}
		});
		popupMenu.add(mntmIspisi);
		
		JMenuItem mntmIzadji = new JMenuItem("Izadji");
		mntmIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ugasiAplikaciju();
			}
		});
		popupMenu.add(mntmIzadji);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(textArea_1, popupMenu_1);
		
		JMenuItem mntmIspisi_1 = new JMenuItem("Ispisi");
		mntmIspisi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JSONObject object = new JSONObject();
				Film film = new Film();
				
				try {
					if (textField.getText().isEmpty()) {
				
					film.setNaziv("Unknown");
					object.put("Naziv", "Unknown");
				} else {
					film.setNaziv(textField.getText());
					object.put("Naziv", textField.getText());
				}
				if (textField_1.getText().isEmpty()) {
					film.setGodina(0);
					object.put("Godina", "Unknown");
				} else {
					film.setGodina(Integer.parseInt(textField_1.getText()));
					object.put("Godina", textField_1.getText());
				}
				if (textField_2.getText().isEmpty()) {
					film.setReziser("Unknown");
					object.put("Reziser", "Unknown");
				} else {
					film.setReziser(textField_2.getText());
					object.put("Reziser", textField_2.getText());
				}
				
				if (textField_3.getText().isEmpty()) {
					film.setZanr("Unknown");
					object.put("Zanr", "Unknown");
				} else {
					film.setZanr(textField_3.getText());
					object.put("Zanr", textField_3.getText());
				}
				if (textField_4.getText().isEmpty()) {
					film.setOcenaGledalaca(0.00);;
					object.put("Ocena gledalaca", "Unknown");
				} else {
					film.setOcenaGledalaca(Double.parseDouble(textField_4.getText()));
					object.put("Ocena Gledalaca", textField_4.getText());
				}
				
				textArea.setText(film.toString());
				textArea_1.setText(object.toString(4));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
				
			}
		});
		popupMenu_1.add(mntmIspisi_1);
		
		JMenuItem mntmIzadji_1 = new JMenuItem("Izadji");
		mntmIzadji_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ugasiAplikaciju();
			}
		});
		popupMenu_1.add(mntmIzadji_1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaziv.setPreferredSize(new Dimension(100, 10));
		panel.add(lblNaziv);
		
		textField = new JTextField();
		textField.setToolTipText("Uneti naziv filma!");
		textField.setPreferredSize(new Dimension(100, 15));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblGodina = new JLabel("Godina");
		lblGodina.setHorizontalAlignment(SwingConstants.CENTER);
		lblGodina.setPreferredSize(new Dimension(100, 10));
		panel.add(lblGodina);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Uneti godinu kada je film izasao!");
		textField_1.setPreferredSize(new Dimension(100, 15));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblReziser = new JLabel("Reziser");
		lblReziser.setHorizontalAlignment(SwingConstants.CENTER);
		lblReziser.setPreferredSize(new Dimension(100, 10));
		panel.add(lblReziser);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Uneti rezisera filma!");
		textField_2.setPreferredSize(new Dimension(100, 15));
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblZanr = new JLabel("Zanr");
		lblZanr.setHorizontalAlignment(SwingConstants.CENTER);
		lblZanr.setPreferredSize(new Dimension(100, 10));
		panel.add(lblZanr);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Uneti zanr filma!");
		textField_3.setPreferredSize(new Dimension(100, 15));
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblOcenaGledalaca = new JLabel("Ocena");
		lblOcenaGledalaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcenaGledalaca.setPreferredSize(new Dimension(100, 10));
		panel.add(lblOcenaGledalaca);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Uneti kako su gledaoci ocenili film!");
		textField_4.setPreferredSize(new Dimension(100, 15));
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnIspisi = new JButton("Ispisi");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JSONObject object = new JSONObject();
				Film film = new Film();
				
				try {
					if (textField.getText().isEmpty()) {
				
					film.setNaziv("Unknown");
					object.put("Naziv", "Unknown");
				} else {
					film.setNaziv(textField.getText());
					object.put("Naziv", textField.getText());
				}
				if (textField_1.getText().isEmpty()||!isInteger(textField_1.getText())) {
					film.setGodina(0);
					object.put("Godina", "Unknown");
				} else {
					film.setGodina(Integer.parseInt(textField_1.getText()));
					object.put("Godina", textField_1.getText());
				}
				if (textField_2.getText().isEmpty()) {
					film.setReziser("Unknown");
					object.put("Reziser", "Unknown");
				} else {
					film.setReziser(textField_2.getText());
					object.put("Reziser", textField_2.getText());
				}
				
				if (textField_3.getText().isEmpty()) {
					film.setZanr("Unknown");
					object.put("Zanr", "Unknown");
				} else {
					film.setZanr(textField_3.getText());
					object.put("Zanr", textField_3.getText());
				}
				if (textField_4.getText().isEmpty()||!isDouble(textField_4.getText())) {
					film.setOcenaGledalaca(0.00);;
					object.put("Ocena gledalaca", "Unknown");
				} else {
					film.setOcenaGledalaca(Double.parseDouble(textField_4.getText()));
					object.put("Ocena Gledalaca", textField_4.getText());
				}
				
				textArea.setText(film.toString());
				textArea_1.setText(object.toString(4));
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnIspisi.setPreferredSize(new Dimension(100, 23));
		panel.add(btnIspisi);
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ugasiAplikaciju();
			}
		});
		btnIzadji.setPreferredSize(new Dimension(100, 23));
		panel.add(btnIzadji);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
