package teste;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	private boolean succeeded;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		
		Connection con = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 267);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login ");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 11, 227, 38);
		contentPane.add(lblLogin);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(10, 60, 46, 14);
		contentPane.add(lblUsurio);
		
		user = new JTextField();
		user.setBounds(10, 80, 227, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 111, 46, 14);
		contentPane.add(lblSenha);
		
		pass = new JPasswordField();
		pass.setBounds(10, 130, 227, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -3);
		java.sql.Date sqldate2 = new java.sql.Date(c.getTimeInMillis());
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Janela janela = new Janela();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM login WHERE username = '"+user.getText()+"' AND password = '"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()){
						try{
							Statement stmt2 = con.createStatement();
							String sql2 = "SELECT * FROM aluno WHERE login_username = '"+user.getText()+"'"
									+ "AND dataInscricao between '"+sqldate2+"' AND '"+sqldate+"'";
							ResultSet rs2 = stmt2.executeQuery(sql2);
							if(rs2.next()){
							JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
						    succeeded = true;
						    dispose();
						    janela.setVisible(true);	
							}else{
								JOptionPane.showMessageDialog(null, "O período de acesso do usuário expirou!");
								succeeded = false;
							}
						}catch(Exception e1){
							System.out.println(e1);
						}
						
					}else{ 
						JOptionPane.showMessageDialog(null, "Usuário e senha incorretos!");
						succeeded = false;
					}
				}catch(Exception e){
					System.out.println(e);
				}
				
			}
			
		});
		btnEntrar.setBounds(10, 176, 89, 23);
		contentPane.add(btnEntrar);
		
		
	}
	public boolean isSucceeded(){
		return succeeded;
	}
}
