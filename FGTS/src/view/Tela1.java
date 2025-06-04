package view;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela1 {

	private JFrame frmCalculo;
	private JTextField txtNome;
	private JTextField txtSalario;
	private JLabel lblErro;
	private JLabel lblErro1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 window = new Tela1();
					window.frmCalculo.setVisible(true);
					window.frmCalculo.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculo = new JFrame();
		frmCalculo.setTitle("Calculo");
		frmCalculo.setResizable(false);
		frmCalculo.setBackground(new Color(255, 255, 255));
		frmCalculo.setBounds(100, 100, 547, 404);
		frmCalculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informe seu nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(62, 128, 129, 14);
		frmCalculo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe seu salário:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(62, 170, 129, 14);
		frmCalculo.getContentPane().add(lblNewLabel_1);
		
		lblErro = new JLabel("");
		lblErro.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblErro.setForeground(Color.RED);
		lblErro.setBounds(201, 143, 305, 14);
		frmCalculo.getContentPane().add(lblErro);
		
		lblErro1 = new JLabel("");
		lblErro1.setForeground(Color.RED);
		lblErro1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblErro1.setBounds(201, 185, 305, 14);
		frmCalculo.getContentPane().add(lblErro1);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    String nome = txtNome.getText().trim();
				    String salarioStr = txtSalario.getText().trim();

				    String regexNome = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]{5,50}$";
				    String regexSalario = "^\\d+([\\.,]\\d{2})?$";

				    if (!nome.matches(regexNome)) {
				        String msg = "O nome precisa ter entre 5 a 50 caracteres e não pode conter números.";
				        lblErro.setText(msg);
				        JOptionPane.showMessageDialog(null, msg);
				        return;
				    } else {
				        lblErro.setText("");
				    }

				    if (!salarioStr.matches(regexSalario)) {
				        String msg = "Informe um salário válido no formato fracionário (ex: 2599,99).";
				        lblErro1.setText(msg);
				        JOptionPane.showMessageDialog(null, msg);
				        return;
				    }

				    salarioStr = salarioStr.replace(",", ".");
				    double salario = Double.parseDouble(salarioStr);

				    if (salario < 1518.00) {
				        String msg = "O salário não pode ser inferior a R$ 1518,00.";
				        lblErro1.setText(msg);
				        JOptionPane.showMessageDialog(null, msg);
				        return;
				    } else {
				        lblErro1.setText("");
				    }

				    double fgts = (salario * 0.08);
				    
				    String salarioFormatado = String.format("R$ %.2f", salario);
				    String fgtsFormatado = String.format("R$ %.2f", fgts).replace(".", ",");

				    String mensagemFinal = String.format("Nome: %s\nSalário: %s\nFGTS: %s", nome, salarioFormatado, fgtsFormatado);

				    JOptionPane.showMessageDialog(null, mensagemFinal);
				    
				} catch (Exception erro) {
				    JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
				}
			}
		});

		btnCalcular.setBounds(62, 293, 89, 23);
		frmCalculo.getContentPane().add(btnCalcular);
		
		txtNome = new JTextField();
		txtNome.setBounds(201, 126, 255, 20);
		frmCalculo.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(201, 168, 255, 20);
		frmCalculo.getContentPane().add(txtSalario);
		txtSalario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(" ");
				txtSalario.setText(" ");
				lblErro.setText(" ");
		        lblErro1.setText(" ");
			}
		});
		btnLimpar.setBounds(215, 293, 89, 23);
		frmCalculo.getContentPane().add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(367, 293, 89, 23);
		frmCalculo.getContentPane().add(btnSair);
		
		JLabel lblNewLabel_2 = new JLabel("Cálculo do FGTS");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(189, 45, 139, 38);
		frmCalculo.getContentPane().add(lblNewLabel_2);
		

	}
}
