import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.InputEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class SozlukAnaEkran extends JFrame{

	private JPanel contentPane;
	private JTextField aramaCubugu;
	private JTextField norvecceText;
	private JTextField turkceText;
	private JTextField inglizceText;
	private JTable table;
	private JLabel kelimeSayiLabel;


	DefaultTableModel model;
	TableRowSorter<TableModel> tableRowSorter;

	ArrayList<Kelime> kelimeListesi = new ArrayList<>();
	ArrayList<Integer> kaydetList = new ArrayList<>();
	
	int kelimeSayisi;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SozlukAnaEkran frame = new SozlukAnaEkran();
					File file = new File("C:","sozluk.txt");
					file.createNewFile();
					frame.kelimeGoster(file);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void ara(String metin) {
		
		model = (DefaultTableModel) table.getModel();
		tableRowSorter = new TableRowSorter<>(model);
		table.setRowSorter(tableRowSorter);
		tableRowSorter.setRowFilter(RowFilter.regexFilter(metin));
	}
	
	
	public void kelimeGoster(File file) {
		
		model = (DefaultTableModel) table.getModel();
		String icerik = "";
		model.setRowCount(0);
		
		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))){
			
			while(scanner.hasNextLine()) {
				icerik = scanner.nextLine();
				if(icerik.charAt(icerik.length() - 1) == ',') icerik += " ";
				
				String[] array= icerik.split(",");
				kelimeListesi.add(new Kelime(array[1], array[2], array[3], Integer.valueOf(array[0])));
				String[] array2 = {array[1],array[2],array[3]};
				model.addRow(array2);
				icerik = "";
			}
			scanner.close();
			kelimeSayisi = table.getRowCount();
			kelimeSayiLabel.setText(String.valueOf(kelimeSayisi));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
	}
	
	public void kaydet() {
		
		model = (DefaultTableModel) table.getModel();
		File file = new File("sozluk.txt");
		String icerik = "";
		
		try {
			FileWriter writer = new FileWriter(file);
			for (int i = 0; i < table.getRowCount(); i++) {
				icerik = kelimeListesi.get(i).getDurum() +  "," + model.getValueAt(i, 0).toString() + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2)  + "\n";
				writer.write(icerik);
			}
			writer.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public SozlukAnaEkran() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				if (kaydetList.isEmpty() == false) {
					
					JOptionPane pane = new JOptionPane();
					String ObjButtons[] = {"Yes","No","Cancel"};
					int result = JOptionPane.showOptionDialog(null, "Kaydedilmemiş değişikleriniz var. Değişiklikler kaydedilsin mi?", "Değişiklik", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
					
						if (result == JOptionPane.YES_OPTION) {
							kaydet();
							System.exit(0);
						}
						else if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
							pane.setVisible(false);
						}
						else {
							System.exit(0);
						}
				}
				
				else {
					System.exit(0);
				}
			}
			
		});
		setBounds(430, 60, 544, 727);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Dosya");
		menuBar.add(mnNewMenu);
		
		JMenuItem kaydetButon = new JMenuItem("Kaydet");
		kaydetButon.setFont(new Font("Segoe UI", Font.BOLD, 12));
		kaydetButon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(kaydetButon);
		
		JMenuItem dosyaAcButon = new JMenuItem("Dosya A\u00E7");
		dosyaAcButon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(dosyaAcButon);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 255, 47));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kelime Aray\u0131n:");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 20, 133, 29);
		contentPane.add(lblNewLabel);
		
		aramaCubugu = new JTextField();
		aramaCubugu.setBounds(179, 20, 301, 29);
		contentPane.add(aramaCubugu);
		aramaCubugu.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 59, 432, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 255, 47));
		panel.setBounds(291, 81, 218, 160);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 7));
		
		JButton ekleButon = new JButton("Kelime Ekle");
		panel.add(ekleButon);
		ekleButon.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		JButton silButon = new JButton("Kelime Sil");
		panel.add(silButon);
		silButon.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		JButton ogrendimButon = new JButton("Kelimeyi \u00D6\u011Frendim");
		panel.add(ogrendimButon);
		ogrendimButon.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		JButton quizButon = new JButton("Quiz");
		panel.add(quizButon);
		quizButon.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		JLabel lblNewLabel_1 = new JLabel("Norve\u00E7\u00E7e:");
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(24, 71, 87, 44);
		contentPane.add(lblNewLabel_1);
		
		norvecceText = new JTextField();
		norvecceText.setBounds(121, 81, 134, 29);
		contentPane.add(norvecceText);
		norvecceText.setColumns(10);
		
		turkceText = new JTextField();
		turkceText.setColumns(10);
		turkceText.setBounds(121, 212, 134, 29);
		contentPane.add(turkceText);
		
		JLabel lblTrke = new JLabel("T\u00FCrk\u00E7e:");
		lblTrke.setForeground(new Color(128, 0, 128));
		lblTrke.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblTrke.setBounds(24, 202, 87, 44);
		contentPane.add(lblTrke);
		
		inglizceText = new JTextField();
		inglizceText.setColumns(10);
		inglizceText.setBounds(121, 145, 134, 29);
		contentPane.add(inglizceText);
		
		JLabel lblIngilizce = new JLabel("Ingilizce:");
		lblIngilizce.setForeground(new Color(128, 0, 128));
		lblIngilizce.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblIngilizce.setBounds(24, 135, 87, 44);
		contentPane.add(lblIngilizce);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 256, 485, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 312, 485, 346);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
				new Object[][] {	
				},
				new String[] {
						"Norveççe","İngilizce","Türkçe"
				}));
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel_2 = new JLabel("Toplam kelime say\u0131s\u0131:");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(48, 277, 135, 25);
		contentPane.add(lblNewLabel_2);
		
		kelimeSayiLabel = new JLabel();
		kelimeSayiLabel.setForeground(new Color(220, 20, 60));
		kelimeSayiLabel.setFont(new Font("Segoe Print", Font.PLAIN, 17));
		kelimeSayiLabel.setBounds(179, 276, 56, 26);
		contentPane.add(kelimeSayiLabel);

		
		aramaCubugu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String metin = aramaCubugu.getText();
				ara(metin);
			}
		});
		
		
		dosyaAcButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int a = chooser.showOpenDialog(null);
				
				if (a == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					kelimeGoster(file);
				}
			}
		});
		
		
		kaydetButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kaydet();
				JOptionPane.showMessageDialog(null, "Değişiklikler Kaydedildi.");
				
				kaydetList.clear();
			}
		});
		
		
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] objects = {norvecceText.getText(), inglizceText.getText(), turkceText.getText()};
				model.addRow(objects);
				kelimeListesi.add(new Kelime(norvecceText.getText(), inglizceText.getText(), turkceText.getText(), 1));
				
				kelimeSayisi++;
				kelimeSayiLabel.setText(String.valueOf(kelimeSayisi));
				kaydetList.add(1);
			}
		});

		
		silButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = table.getSelectedRow();
				if (a == -1) {
					JOptionPane.showMessageDialog(null, "Silincecek bir satır seçiniz");
				}
				else {		
					model.removeRow(a);
					kelimeSayisi--;
					kelimeSayiLabel.setText(String.valueOf(kelimeSayisi));
					kaydetList.add(1);
				}
			}
		});
		
		
		quizButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kaydet();
				QuizEkran quizEkran = new QuizEkran(kelimeListesi);
				setVisible(false);
				quizEkran.setVisible(true);
			}
		});

		
		ogrendimButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = table.getSelectedRow();
				
					if (ogrendimButon.getText().equals("Kelimeyi Öğrendim")) {
						kelimeListesi.get(a).setDurum(2);
						ogrendimButon.setText("Kelimeyi Unuttum");
					}
					else {
						kelimeListesi.get(a).setDurum(1);
						ogrendimButon.setText("Kelimeyi Öğrendim");
					}
					
				kaydetList.add(1);
			}
		});
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				table.convertRowIndexToView(a);
				norvecceText.setText(table.getValueAt(a, 0).toString());
				inglizceText.setText(table.getValueAt(a, 1).toString());
				turkceText.setText(table.getValueAt(a, 2).toString());
				if (kelimeListesi.get(a).getDurum() == 1) {
					ogrendimButon.setText("Kelimeyi Öğrendim");
				}
				else {
					ogrendimButon.setText("Kelimeyi Unuttum");
				}
			}
		});		
	}
}
