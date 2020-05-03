import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizEkran extends JFrame {

	ArrayList<String> ikinciListe = new ArrayList<>();

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField9;
	private JTextField textField6;
	private JTextField textField10;
	private JTextField textField7;
	private JTextField textField11;
	private JTextField textField8;
	private JTextField textField12;
	
	JLabel label = new JLabel();
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;

	int denemeSayisi = 3;
	int bosSoru;
	int i;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SozlukAnaEkran anaEkran = new SozlukAnaEkran();
					QuizEkran frame = new QuizEkran(anaEkran.kelimeListesi);
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
	public QuizEkran(ArrayList<Kelime> kelimeListesi) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1314, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("Hardangerfjordveg:");
		label1.setForeground(new Color(0, 0, 255));
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1.setBounds(33, 26, 134, 43);
		contentPane.add(label1);
		
		textField1 = new JTextField();
		textField1.setForeground(new Color(0, 0, 0));
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField1.setBounds(177, 31, 147, 33);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		label2 = new JLabel("Hardangerfjordveg:");
		label2.setForeground(new Color(0, 0, 255));
		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label2.setBounds(351, 26, 134, 43);
		contentPane.add(label2);
		
		textField2 = new JTextField();
		textField2.setForeground(new Color(0, 0, 0));
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField2.setColumns(10);
		textField2.setBounds(491, 31, 147, 33);
		contentPane.add(textField2);
		
		label3 = new JLabel("Hardangerfjordveg:");
		label3.setForeground(new Color(0, 0, 255));
		label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label3.setBounds(673, 26, 134, 43);
		contentPane.add(label3);
		
		textField3 = new JTextField();
		textField3.setForeground(new Color(0, 0, 0));
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField3.setColumns(10);
		textField3.setBounds(817, 31, 147, 33);
		contentPane.add(textField3);
		
		label4 = new JLabel("Hardangerfjordveg:");
		label4.setForeground(new Color(0, 0, 255));
		label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4.setBounds(979, 26, 134, 43);
		contentPane.add(label4);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField4.setColumns(10);
		textField4.setBounds(1123, 31, 147, 33);
		contentPane.add(textField4);
		
		label5 = new JLabel("Hardangerfjordveg:");
		label5.setForeground(new Color(0, 0, 255));
		label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5.setBounds(33, 111, 134, 43);
		contentPane.add(label5);
		
		textField5 = new JTextField();
		textField5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField5.setColumns(10);
		textField5.setBounds(177, 116, 147, 33);
		contentPane.add(textField5);
		
		label9 = new JLabel("Hardangerfjordveg:");
		label9.setForeground(new Color(0, 0, 255));
		label9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label9.setBounds(33, 211, 134, 43);
		contentPane.add(label9);
		
		textField9 = new JTextField();
		textField9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField9.setColumns(10);
		textField9.setBounds(177, 216, 147, 33);
		contentPane.add(textField9);
		
		label6 = new JLabel("Hardangerfjordveg:");
		label6.setForeground(new Color(0, 0, 255));
		label6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label6.setBounds(351, 111, 134, 43);
		contentPane.add(label6);
		
		label10 = new JLabel("Hardangerfjordveg:");
		label10.setForeground(new Color(0, 0, 255));
		label10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label10.setBounds(351, 211, 134, 43);
		contentPane.add(label10);
		
		label7 = new JLabel("Hardangerfjordveg:");
		label7.setForeground(new Color(0, 0, 255));
		label7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label7.setBounds(673, 111, 134, 43);
		contentPane.add(label7);
		
		label11 = new JLabel("Hardangerfjordveg:");
		label11.setForeground(new Color(0, 0, 255));
		label11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label11.setBounds(673, 211, 134, 43);
		contentPane.add(label11);
		
		label8 = new JLabel("Hardangerfjordveg:");
		label8.setForeground(new Color(0, 0, 255));
		label8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label8.setBounds(979, 111, 134, 43);
		contentPane.add(label8);
		
		label12 = new JLabel("Hardangerfjordveg:");
		label12.setForeground(new Color(0, 0, 255));
		label12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label12.setBounds(979, 206, 134, 43);
		contentPane.add(label12);
		
		textField6 = new JTextField();
		textField6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField6.setColumns(10);
		textField6.setBounds(491, 116, 147, 33);
		contentPane.add(textField6);
		
		textField10 = new JTextField();
		textField10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField10.setColumns(10);
		textField10.setBounds(491, 216, 147, 33);
		contentPane.add(textField10);
		
		textField7 = new JTextField();
		textField7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField7.setColumns(10);
		textField7.setBounds(817, 116, 147, 33);
		contentPane.add(textField7);
		
		textField11 = new JTextField();
		textField11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField11.setColumns(10);
		textField11.setBounds(817, 216, 147, 33);
		contentPane.add(textField11);
		
		textField8 = new JTextField();
		textField8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField8.setColumns(10);
		textField8.setBounds(1123, 116, 147, 33);
		contentPane.add(textField8);
		
		textField12 = new JTextField();
		textField12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField12.setColumns(10);
		textField12.setBounds(1123, 211, 147, 33);
		contentPane.add(textField12);
		
		JButton konrolEtButon = new JButton("Kontrol Et");
		konrolEtButon.setForeground(new Color(255, 0, 0));
		konrolEtButon.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		konrolEtButon.setBounds(425, 319, 184, 67);
		contentPane.add(konrolEtButon);
		
		JButton tekrarButon = new JButton("Yeni Quiz");
		tekrarButon.setForeground(new Color(50, 205, 50));
		tekrarButon.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		tekrarButon.setBounds(702, 319, 184, 67);
		contentPane.add(tekrarButon);
		
		Icon icon = new ImageIcon("icon.png");
		JButton anaMenuButon = new JButton(icon);
		
		anaMenuButon.setForeground(Color.GREEN);
		anaMenuButon.setBounds(1203, 365, 65, 60);
		contentPane.add(anaMenuButon);
		
		JLabel[] object = {label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12};
		JTextField[] textObject = {textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,textField9,textField10,textField11,textField12};
		
		ArrayList<Integer> aList = new ArrayList<>();
		
		tekrar(kelimeListesi, object, textObject, aList);
		
		konrolEtButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				denemeSayisi--;
				int kaciDogru = 0;
				
				for (int b = 0; b < ikinciListe.size(); b++) {
					
					if (!object[b].getText().equals("")) {
						
						if (textObject[b].getText().equals(kelimeListesi.get(aList.get(b)).getIngilizceKelime().trim())) {
							textObject[b].setForeground(new Color(0, 0, 0));
							textObject[b].setEditable(false);
							kaciDogru++;
						}
						else {
							textObject[b].setForeground(new Color(255, 0, 0));
							if (denemeSayisi <= 0) {
								textObject[b].setText(kelimeListesi.get(aList.get(b)).getIngilizceKelime().trim());
							}
						}
					}
					
				}
				
				if (kaciDogru == i) {
					JOptionPane.showMessageDialog(null, "Tebrikler bütün soruları doğru cevapladınız !!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Maalesef, bazı cevaplarınız yanlış !!!");
				}
			}
		});
		
		
		tekrarButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aList.clear();
				tekrar(kelimeListesi, object, textObject, aList);
			}
		});
		
		
		anaMenuButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SozlukAnaEkran.main(null);
			}
		});
	}

	
	public void tekrar(ArrayList<Kelime> kelimeListesi, JLabel[] object, JTextField[] textObject, ArrayList<Integer> aList) {
		
		Random random = new Random();
		
		denemeSayisi = 3;
		int dondurmeSayisi = 12;
		
		pointer: for (i = 0; i < dondurmeSayisi && i < kelimeListesi.size(); i++) {
			
			if (kelimeListesi.get(i).getDurum() == 1) {
				
				textObject[i].setEditable(true);
				textObject[i].setText("");
				textObject[i].setForeground(new Color(0, 0, 0));
				int a = random.nextInt(kelimeListesi.size());
				
					if (ikinciListe.contains(kelimeListesi.get(a).getNorvecceKelime())) {
						i--;
						kelimeListesi.remove(a);
						continue pointer;
					}
					else {
						object[i].setText(kelimeListesi.get(a).getNorvecceKelime());
						ikinciListe.add(kelimeListesi.get(a).getNorvecceKelime());
					}
				aList.add(a);
				
			}
			else {
				kelimeListesi.remove(i);
				i--;
			}
			
		}
		
		for (bosSoru = i; bosSoru < textObject.length; bosSoru++) {
			object[bosSoru].setText("");
			textObject[bosSoru].setEditable(false);
		}
	}
}
