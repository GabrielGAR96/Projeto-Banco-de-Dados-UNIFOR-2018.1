package teste;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField aMatr;
	private JTextField aNome;
	private JTextField aLogin;
	private JTextField aEnder;
	private ButtonGroup bg = new ButtonGroup();
	private JTable table;
	private JTextField cLogin;
	private JTextField cSenha;
	private JTable table_1;
	private JTextField fMatr;
	private JTextField fNome;
	private JTextField fEnder;
	private JTable table_2;
	private JTable table_3;
	private JTextField mCodigo;
	private JTextField mCredito;
	private JTextField mNome;
	private JTextField assuntoCodigo;
	private JTextField assuntoCodigoMateria;
	private JTextField assuntoNome;
	private JTable table_4;
	private JTextField pCodigo;
	private JTextField pCodAssunto;
	private JTextField pEnunciado;
	private JTextField pObjetiva;
	private JTable table_5;
	private JTextField rCodPergunta;
	private JTextField rCodResposta;
	private JTextField rTextoResposta;
	private JTable table_6;
	private JTextField vfMatr;
	private JTable table_7;
	private JDateChooser dateChooser;
	private JTextField mValor;
	private JTextField vfDuvida;
	private JTextField vfSimulado;
	private JTextField emIdaluno;
	private JTextField emIdmateria1;
	private JTable table_8;
	private JTextField emIdfacilitador;
	private JTextField emIdmateria2;
	private JTable table_9;
	private JTextField simCodsim;
	private JTextField simCodfac;
	private JTextField simCodmat;
	private JComboBox comboBox;
	private JTable table_10;
	private JTextField pCodsim;
	private JTextField nCodaluno;
	private JTextField nNota;
	private JTextField nCodsim;
	private JTable table_11;
	private JTextField dCod;
	private JTextField dCodal;
	private JTextField dTexto;
	private JTextField dCodfac;
	private JTable table_12;
	private JTextField pIdaluno;
	private JTextField pNomealuno;
	private JTextField pNomefac;
	private JTextField pIdfac;
	private JTable table_13;
	private JTable table_14;
	private JTextField pIdmataluno;
	private JTextField pMedia;
	private JTextField pIdmatfac;
	private JTextField pQtde;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		Connection con = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 664, 254);
		contentPane.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Alunos", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 655, 212);
		panel_2.add(panel_3);

		JLabel lblSelecioneOQue_2 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		lblSelecioneOQue_2.setBounds(10, 11, 220, 14);
		panel_3.add(lblSelecioneOQue_2);

		aMatr = new JTextField();
		aMatr.setColumns(10);
		aMatr.setBounds(10, 57, 86, 20);
		panel_3.add(aMatr);

		aNome = new JTextField();
		aNome.setColumns(10);
		aNome.setBounds(123, 57, 109, 20);
		panel_3.add(aNome);

		aLogin = new JTextField();
		aLogin.setColumns(10);
		aLogin.setBounds(10, 113, 86, 20);
		panel_3.add(aLogin);

		aEnder = new JTextField();
		aEnder.setColumns(10);
		aEnder.setBounds(10, 164, 220, 20);
		panel_3.add(aEnder);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					String query = "SELECT * FROM aluno";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		

		scrollPane_1.setBounds(271, 11, 374, 130);
		panel_3.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				jTable_Display_AlunosMouseClicked(e);
			}

		});

		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Aluno", "Nome", "Endere\u00E7o", "Inscricao", "Login" }));

		JButton btnAlunoAlterar = new JButton("Alterar");
		btnAlunoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = dateChooser.getDate();
					java.sql.Date sqldate = new java.sql.Date(date.getTime());
					
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE aluno SET idaluno = " + aMatr.getText() + ", " + "nome = '"
							+ aNome.getText() + "', " + "endereco = '" + aEnder.getText() + "', "
							+ "datainscricao = '" + sqldate.toString() + "', " + "login_username = '" + aLogin.getText()
							+ "' WHERE idaluno = " + aMatr.getText() + ";";

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAlunoAlterar.setBounds(407, 152, 109, 45);
		panel_3.add(btnAlunoAlterar);

		JButton btnExcluirAluno = new JButton("Excluir ");
		btnExcluirAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o aluno selecionada?");

				if (i == 0) {
					try {
						String query = "DELETE FROM aluno WHERE idaluno = " + aMatr.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);

						pst.execute();

						JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnExcluirAluno.setBounds(536, 152, 109, 45);
		panel_3.add(btnExcluirAluno);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Date date = dateChooser.getDate();
					java.sql.Date sqldate = new java.sql.Date(date.getTime());
					
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
					
					String sql = "INSERT INTO aluno (idaluno, nome, endereco, inscricao, datainscricao, login_username) VALUES (?, ?, ?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, aMatr.getText());
					pst.setString(2, aNome.getText());
					pst.setString(3, aEnder.getText());
					pst.setString(4, "0");
					pst.setString(5, sqldate.toString());
					pst.setString(6, aLogin.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Aluno registrado(a) com sucesso!");
					
					Statement stmt2 = con.createStatement();
					stmt2.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não é possível cadastrar o aluno!");
					System.out.println(e1);
				}
			}
		});
		btnCadastrar_1.setBounds(271, 152, 109, 45);
		panel_3.add(btnCadastrar_1);
		

		JLabel label = new JLabel("Matr\u00EDcula");
		label.setBounds(10, 32, 75, 14);
		panel_3.add(label);

		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(123, 32, 46, 14);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Login");
		label_2.setBounds(10, 88, 46, 14);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("Endere\u00E7o");
		label_3.setBounds(10, 144, 97, 14);
		panel_3.add(label_3);
		
		JLabel lblDataDeInscrio = new JLabel("Data de inscri\u00E7\u00E3o");
		lblDataDeInscrio.setBounds(123, 88, 138, 14);
		panel_3.add(lblDataDeInscrio);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(123, 113, 107, 20);
		panel_3.add(dateChooser);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("Cadastre aqui o usu\u00E1rio");
		lblInsiraOsDados.setBounds(10, 11, 199, 14);
		panel.add(lblInsiraOsDados);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de usu\u00E1rio (Login)");
		lblNomeDeUsurio.setBounds(9, 42, 220, 14);
		panel.add(lblNomeDeUsurio);
		
		cLogin = new JTextField();
		cLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cLogin.setBounds(9, 67, 296, 20);
		panel.add(cLogin);
		cLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Insira a senha ");
		lblNewLabel.setBounds(10, 98, 143, 14);
		panel.add(lblNewLabel);
		
		cSenha = new JPasswordField();
		cSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cSenha.setBounds(10, 123, 295, 20);
		panel.add(cSenha);
		cSenha.setColumns(10);
		
		JButton btrButtonCadastro = new JButton("Cadastrar");
		btrButtonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				
				try {
					String query = "INSERT INTO login VALUES (?, ?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, cLogin.getText());
					pst.setString(2, cSenha.getText());
					
					String sql = "SELECT login_username FROM aluno WHERE login_username = '"+cLogin.getText()+"'";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()){						
						JOptionPane.showMessageDialog(null, "Usuário e senha cadastrados com sucesso!");
						pst.execute();
						
					}else{
						JOptionPane.showMessageDialog(null, "Nome de usuário não encontrado!");						
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    
				}
			}
		});
		btrButtonCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btrButtonCadastro.setBounds(10, 167, 132, 34);
		panel.add(btrButtonCadastro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String query = "SELECT * FROM login";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setBounds(323, 11, 326, 190);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			jTable_Display_CadastroMouseClicked(e);
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Login", "Senha"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o login selecionado?");
				
				if (i == 0) {
					try {
						
						String query = " DELETE FROM login WHERE username = '" + cLogin.getText() +"'";
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
						pst.execute();

						JOptionPane.showMessageDialog(null, "Login removido com sucesso!");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não é possível remover o login selecionado! \n"
								+ "Uma chave estrangeira faz referência à mesma!");
						e1.printStackTrace();
					}
				}				
			}
		});
		btnExcluir_1.setBounds(173, 167, 132, 34);
		panel.add(btnExcluir_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Facilitador", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(0, 0, 659, 212);
		panel_1.add(panel_6);
		
		JLabel label_4 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_4.setBounds(10, 11, 220, 14);
		panel_6.add(label_4);
		
		fMatr = new JTextField();
		fMatr.setColumns(10);
		fMatr.setBounds(10, 61, 86, 20);
		panel_6.add(fMatr);
		
		fNome = new JTextField();
		fNome.setColumns(10);
		fNome.setBounds(121, 61, 109, 20);
		panel_6.add(fNome);
		
		fEnder = new JTextField();
		fEnder.setColumns(10);
		fEnder.setBounds(10, 117, 220, 20);
		panel_6.add(fEnder);
			
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					String query = "SELECT * FROM facilitador";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		scrollPane_2.setBounds(271, 11, 374, 130);
		panel_6.add(scrollPane_2);
		
		
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jTable_Display_FacilitadoresMouseClicked(e);
					}
				});
		
			table_2.setColumnSelectionAllowed(true);
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID Facilitador", "Nome", "Endere\u00E7o", "Valor"
				}
			));
		scrollPane_2.setViewportView(table_2);
		
		
		JButton btnFacilitadorAlterar = new JButton("Alterar");
		btnFacilitadorAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE facilitador SET idfacilitador = " + fMatr.getText() + ", "
							+ "nome = '" + fNome.getText() + "', " 
							+ "endereco = '" + fEnder.getText() + "' "							
							+ "WHERE idfacilitador = " + fMatr.getText() ;

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFacilitadorAlterar.setBounds(407, 152, 109, 45);
		panel_6.add(btnFacilitadorAlterar);
	
			
		JButton btnExcluirFacilitador = new JButton("Excluir ");
		btnExcluirFacilitador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o facilitador selecionado?");

				if (i == 0) {
					try {
						String query = "DELETE FROM facilitador WHERE idfacilitador = " + fMatr.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);

						pst.execute();

						JOptionPane.showMessageDialog(null, "Facilitador removido com sucesso!");

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnExcluirFacilitador.setBounds(536, 152, 109, 45);
		panel_6.add(btnExcluirFacilitador);
		
		JButton btnCadastrarFacilitador = new JButton("Cadastrar");
		btnCadastrarFacilitador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO facilitador (idfacilitador, nome, endereco, pagamento) VALUES (?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, fMatr.getText());
					pst.setString(2, fNome.getText());
					pst.setString(3, fEnder.getText());
					pst.setString(4, "0");
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Faciliador registrado(a) com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "O facilitador já está cadastrado!");
					System.out.println(e1);
				}
			}
		});
		btnCadastrarFacilitador.setBounds(271, 152, 109, 45);
		panel_6.add(btnCadastrarFacilitador);
		
		JLabel label_5 = new JLabel("Matr\u00EDcula");
		label_5.setBounds(10, 36, 75, 14);
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("Nome");
		label_6.setBounds(123, 36, 46, 14);
		panel_6.add(label_6);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 92, 137, 14);
		panel_6.add(lblEndereo);
		
		JPanel panel_13 = new JPanel();
		tabbedPane.addTab("Notas", null, panel_13, null);
		panel_13.setLayout(null);
		
		JLabel label_14 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_14.setBounds(10, 11, 220, 14);
		panel_13.add(label_14);
		
		JLabel lblCdigoAluno = new JLabel("C\u00F3digo Aluno");
		lblCdigoAluno.setBounds(10, 36, 115, 14);
		panel_13.add(lblCdigoAluno);
		
		nCodaluno = new JTextField();
		nCodaluno.setColumns(10);
		nCodaluno.setBounds(10, 61, 109, 20);
		panel_13.add(nCodaluno);
		
		JLabel lblNotaDoAluno = new JLabel("Nota do aluno");
		lblNotaDoAluno.setBounds(10, 148, 180, 14);
		panel_13.add(lblNotaDoAluno);
		
		nNota = new JTextField();
		nNota.setColumns(10);
		nNota.setBounds(10, 173, 109, 20);
		panel_13.add(nNota);
		
		nCodsim = new JTextField();
		nCodsim.setColumns(10);
		nCodsim.setBounds(10, 117, 109, 20);
		panel_13.add(nCodsim);
		
		JLabel lblCdigoDoSimulado = new JLabel("C\u00F3digo do Simulado");
		lblCdigoDoSimulado.setBounds(10, 92, 142, 14);
		panel_13.add(lblCdigoDoSimulado);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(265, 11, 374, 130);
		panel_13.add(scrollPane_11);
		
		table_11 = new JTable();
		table_11.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID simulado", "ID aluno", "nota"
			}
		));
		scrollPane_11.setViewportView(table_11);
		
		JButton btnInserir_1 = new JButton("Inserir");
		btnInserir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO simulado_has_aluno VALUES (?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, nCodsim.getText());
					pst.setString(2, nCodaluno.getText());
					pst.setString(3, nNota.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Simulado alocado ao aluno(a) com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível alocar o simulado ao aluno(a)!");
					System.out.println(e1);
				}
				
			}
		});
		btnInserir_1.setBounds(509, 148, 130, 20);
		panel_13.add(btnInserir_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item selecionado?");
				
				if (i == 0) {
					try {
						String query = " DELETE FROM simulado_has_aluno WHERE simulado_idsimulado = " + nCodsim.getText() + " AND aluno_idaluno = " + nCodaluno.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
						pst.execute();

						JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
						

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não é possível remover o item selecionado!");
						e1.printStackTrace();
					}
				}
			}
		});
		btnRemover.setBounds(509, 173, 130, 20);
		panel_13.add(btnRemover);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT simulado_idsimulado AS IDsimulado, aluno_idaluno AS IDaluno, nota FROM simulado_has_aluno ORDER BY IDsimulado ASC, nota DESC";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_11.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRanking.setBounds(265, 148, 130, 20);
		panel_13.add(btnRanking);
		
		JButton btnAproveitamento = new JButton("Aproveitamento");
		btnAproveitamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idaluno, nome, ROUND(AVG(nota), 2) AS média FROM aluno JOIN simulado_has_aluno "
							+ "ON idaluno = aluno_idaluno GROUP BY aluno_idaluno";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_11.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAproveitamento.setBounds(265, 175, 130, 20);
		panel_13.add(btnAproveitamento);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		tabbedPane.addTab("Valores Facilitador", null, panel_9, null);
		
		JLabel label_13 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_13.setBounds(10, 11, 220, 14);
		panel_9.add(label_13);
		
		vfMatr = new JTextField();
		vfMatr.setColumns(10);
		vfMatr.setBounds(10, 57, 109, 20);
		panel_9.add(vfMatr);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String query = "SELECT facilitador_idfacilitador as idfacilitador, valorduvida, valorsimulado FROM valoresfacilitador";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_7.setBounds(271, 11, 374, 130);
		panel_9.add(scrollPane_7);
		
				
				table_7 = new JTable();
				scrollPane_7.setViewportView(table_7);
				table_7.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(java.awt.event.MouseEvent e) {
						jTable_Display_ValoresFacilitadorMouseClicked(e);
					}
				});
				
		table_7.setColumnSelectionAllowed(true);
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID facilitador", "Valor duvida", "Valor simulado"
			}
		));
		scrollPane_7.setViewportView(table_7);
		
		JLabel lblLogin = new JLabel("Matr\u00EDcula");
		lblLogin.setBounds(10, 32, 75, 14);
		panel_9.add(lblLogin);
		
		vfDuvida = new JTextField();
		vfDuvida.setColumns(10);
		vfDuvida.setBounds(10, 113, 109, 20);
		panel_9.add(vfDuvida);
		
		JLabel lblValorDaDuvida = new JLabel("Valor por duvida");
		lblValorDaDuvida.setBounds(10, 88, 146, 14);
		panel_9.add(lblValorDaDuvida);
		
		vfSimulado = new JTextField();
		vfSimulado.setColumns(10);
		vfSimulado.setBounds(10, 169, 109, 20);
		panel_9.add(vfSimulado);
		
		JLabel lblValorPorSimulado = new JLabel("Valor por simulado");
		lblValorPorSimulado.setBounds(10, 144, 116, 14);
		panel_9.add(lblValorPorSimulado);
		
		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO valoresfacilitador (facilitador_idfacilitador, valorduvida, valorsimulado) VALUES (?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, vfMatr.getText());
					pst.setString(2, vfDuvida.getText());
					pst.setString(3, vfSimulado.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Valores do facilitador(a) registrados com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar os valores do facilitador!");
					System.out.println(e1);
				}
			}
		});
		button.setBounds(271, 152, 109, 45);
		panel_9.add(button);
		
		JButton button_1 = new JButton("Alterar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE valoresfacilitador SET facilitador_idfacilitador = " + vfMatr.getText() + ", "
							+ "valorduvida = '" + vfDuvida.getText() + "', " 
							+ "valorsimulado = '" + vfSimulado.getText() + "' "							
							+ "WHERE facilitador_idfacilitador = " + vfMatr.getText() ;

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(536, 152, 109, 45);
		panel_9.add(button_1);
		
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Matéria", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT * FROM materia";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_3.setBounds(275, 11, 374, 130);
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jTable_Display_MateriasMouseClicked(e);
			}
		});
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome da Disciplina", "Cr\u00E9ditos"
			}
		));
		scrollPane_3.setViewportView(table_3);
		
		JButton btnCadastrarMateria = new JButton("Cadastrar");
		btnCadastrarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO  materia(idmateria, nomemateria, creditos, valor_inscricao) VALUES (?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, mCodigo.getText());
					pst.setString(2, mNome.getText());
					pst.setString(3, mCredito.getText());
					pst.setString(4, mValor.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Matéria cadastrada com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a matéria!");
					System.out.println(e1);
				}
			}
		});		
		btnCadastrarMateria.setBounds(275, 152, 109, 45);
		panel_4.add(btnCadastrarMateria);
		
		JButton btnAlterarMateria = new JButton("Alterar");
		btnAlterarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE materia SET idmateria = " + mCodigo.getText() + ", "
					             + "nomemateria = '" + mNome.getText() + "', " 
					             + "creditos = " + mCredito.getText() + ", "
					             + "valor_inscricao = " + mValor.getText() 
							     + " WHERE idmateria = " + mCodigo.getText() + ";";

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();
			        }catch(Exception e1) {
				     e1.printStackTrace();
		 	    }
		    }
		});
		btnAlterarMateria.setBounds(411, 152, 109, 45);
		panel_4.add(btnAlterarMateria);
		
		JButton btnExcluirMateria = new JButton("Excluir ");
		btnExcluirMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a matéria selecionada?");

				if (i == 0) {
					try {
						String query = "DELETE FROM materia WHERE idmateria = " + mCodigo.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);

						pst.execute();

						JOptionPane.showMessageDialog(null, "Matéria removida com sucesso!");

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnExcluirMateria.setBounds(540, 152, 109, 45);
		panel_4.add(btnExcluirMateria);
		
		JLabel label_9 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_9.setBounds(10, 11, 220, 14);
		panel_4.add(label_9);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 36, 75, 14);
		panel_4.add(lblCdigo);
		
		mCodigo = new JTextField();
		mCodigo.setColumns(10);
		mCodigo.setBounds(10, 61, 86, 20);
		panel_4.add(mCodigo);
		
		JLabel lblCrditos = new JLabel("Cr\u00E9ditos");
		lblCrditos.setBounds(123, 36, 75, 14);
		panel_4.add(lblCrditos);
		
		mCredito = new JTextField();
		mCredito.setColumns(10);
		mCredito.setBounds(123, 61, 109, 20);
		panel_4.add(mCredito);
		
		JLabel lblNomeDaDisciplina = new JLabel("Nome");
		lblNomeDaDisciplina.setBounds(10, 92, 86, 14);
		panel_4.add(lblNomeDaDisciplina);
		
		mNome = new JTextField();
		mNome.setColumns(10);
		mNome.setBounds(10, 117, 86, 20);
		panel_4.add(mNome);
		
		mValor = new JTextField();
		mValor.setColumns(10);
		mValor.setBounds(121, 117, 109, 20);
		panel_4.add(mValor);
		
		JLabel lblValor_1 = new JLabel("Valor inscri\u00E7\u00E3o");
		lblValor_1.setBounds(121, 92, 109, 14);
		panel_4.add(lblValor_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		tabbedPane.addTab("Assunto", null, panel_8, null);
		
		
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT * FROM assunto";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_4.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_4.setBounds(275, 11, 374, 130);
		panel_8.add(scrollPane_4);
		
	
		
		table_4 = new JTable();
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTable_Display_AssuntosMouseClicked(e);
			}
		});
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Assunto", "Nome ", "C\u00F3digo Mat\u00E9ria"
			}
		));
		scrollPane_4.setViewportView(table_4);
		
		
		JButton btnCadastrarAssunto = new JButton("Cadastrar");
		btnCadastrarAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO  assunto(idassunto, nomeassunto, materia_idmateria) VALUES (?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, assuntoCodigo.getText());
					pst.setString(2, assuntoNome.getText());
					pst.setString(3, assuntoCodigoMateria.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Assunto cadastrado com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o assunto!");
					System.out.println(e1);
				}
			}
		});
		btnCadastrarAssunto.setBounds(275, 152, 109, 45);
		panel_8.add(btnCadastrarAssunto);
		
		
		JButton btnAlterarAssunto = new JButton("Alterar");
		btnAlterarAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE assunto SET idassunto = " + assuntoCodigo.getText() + ", "
					             + "nomeassunto = '" + assuntoNome.getText() + "', " 
					             + "materia_idmateria = " + assuntoCodigoMateria.getText() + ""
							     + " WHERE idassunto = " + assuntoCodigo.getText() + ";";

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();
			        }catch(Exception e1) {
				     e1.printStackTrace();
		 	    }
				
			}
		});
		btnAlterarAssunto.setBounds(411, 152, 109, 45);
		panel_8.add(btnAlterarAssunto);
			
		JButton btnExcluirAssunto = new JButton("Excluir ");
		btnExcluirAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o assunto selecionada?");

				if (i == 0) {
					try {
						String query = "DELETE FROM assunto WHERE idassunto = " + assuntoCodigo.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);

						pst.execute();

						JOptionPane.showMessageDialog(null, "Assunto removida com sucesso!");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não foi possível remover o assunto, pois há uma chave estrangeira!");
						e1.printStackTrace();
					}
				}
			}
		});
		btnExcluirAssunto.setBounds(540, 152, 109, 45);
		panel_8.add(btnExcluirAssunto);
		
		JLabel label_10 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_10.setBounds(10, 11, 220, 14);
		panel_8.add(label_10);
		
		JLabel lblCdigoAssunto = new JLabel("C\u00F3digo Assunto");
		lblCdigoAssunto.setBounds(10, 36, 115, 14);
		panel_8.add(lblCdigoAssunto);
		
		assuntoCodigo = new JTextField();
		assuntoCodigo.setColumns(10);
		assuntoCodigo.setBounds(10, 61, 86, 20);
		panel_8.add(assuntoCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo da Mat\u00E9ria");
		lblCodigo.setBounds(123, 36, 142, 14);
		panel_8.add(lblCodigo);
		
		assuntoCodigoMateria = new JTextField();
		assuntoCodigoMateria.setColumns(10);
		assuntoCodigoMateria.setBounds(123, 61, 109, 20);
		panel_8.add(assuntoCodigoMateria);
		
		JLabel lblNomeDaAssunto = new JLabel("Nome do assunto");
		lblNomeDaAssunto.setBounds(10, 92, 180, 14);
		panel_8.add(lblNomeDaAssunto);
		
		assuntoNome = new JTextField();
		assuntoNome.setColumns(10);
		assuntoNome.setBounds(10, 117, 220, 20);
		panel_8.add(assuntoNome);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Perguntas", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel label_11 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_11.setBounds(10, 11, 220, 14);
		panel_5.add(label_11);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo Pergunta");
		lblCdigo_1.setBounds(10, 36, 103, 14);
		panel_5.add(lblCdigo_1);
		
		pCodigo = new JTextField();
		pCodigo.setColumns(10);
		pCodigo.setBounds(10, 61, 86, 20);
		panel_5.add(pCodigo);
		
		JLabel lblCdigoAssunto_1 = new JLabel("C\u00F3digo Assunto");
		lblCdigoAssunto_1.setBounds(10, 92, 103, 14);
		panel_5.add(lblCdigoAssunto_1);
		
		pCodAssunto = new JTextField();
		pCodAssunto.setColumns(10);
		pCodAssunto.setBounds(10, 117, 86, 20);
		panel_5.add(pCodAssunto);
		
		JLabel lblEnunciado = new JLabel("Enunciado");
		lblEnunciado.setBounds(12, 148, 95, 14);
		panel_5.add(lblEnunciado);
		
		pEnunciado = new JTextField();
		pEnunciado.setColumns(10);
		pEnunciado.setBounds(10, 173, 208, 20);
		panel_5.add(pEnunciado);
		
		JLabel lblObjetiva = new JLabel("Objetiva");
		lblObjetiva.setBounds(121, 92, 97, 14);
		panel_5.add(lblObjetiva);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxNewCheckBox.isSelected()){
					pObjetiva.setText("true");
				}else{
					pObjetiva.setText("false");
				}				
			}
		});

		
		chckbxNewCheckBox.setBounds(121, 116, 21, 23);
		panel_5.add(chckbxNewCheckBox);
		
		
		pObjetiva = new JTextField();
		pObjetiva.setEditable(false);
		pObjetiva.setColumns(10);
		pObjetiva.setBounds(148, 117, 70, 20);
		panel_5.add(pObjetiva);
		
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT * FROM perguntas";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_5.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_5.setBounds(271, 11, 374, 130);
		panel_5.add(scrollPane_5);
		
		table_5 = new JTable();
		table_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTable_Display_PerguntasMouseClicked(e);
				
			}

			
		});
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"cod pergunta", "enunciado", "objetiva", "cod assunto", "cod simulado"
			}
		));
		scrollPane_5.setViewportView(table_5);
		
		JButton btnCadastrarPergunta = new JButton("Cadastrar");
		btnCadastrarPergunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO perguntas VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, pCodigo.getText());
					pst.setString(2, pEnunciado.getText());
					pst.setBoolean(3, objetivaCheck());
					pst.setString(4, pCodAssunto.getText());
					pst.setString(5, pCodsim.getText());					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Pergunta registrada com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a pergunta!");
					System.out.println(e1);
				}
			}
		});
		
		
		btnCadastrarPergunta.setBounds(271, 152, 109, 45);
		panel_5.add(btnCadastrarPergunta);
		
		JButton btnAlterarPergunta = new JButton("Alterar");
		btnAlterarPergunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE perguntas SET idperguntas = " + pCodigo.getText() + ", "
					             + "enunciado = '" + pEnunciado.getText() + "', " 
					             + "assunto_idassunto = " + pCodAssunto.getText() + ", "
					             + "objetiva = " + objetivaCheck() + ", "
					             + "simulado_idsimulado = " + pCodsim.getText()
							     + " WHERE idperguntas = " + pCodigo.getText() + ";";

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();
			        }catch(Exception e1) {
				     e1.printStackTrace();
		 	    }
			}
		});
		btnAlterarPergunta.setBounds(407, 152, 109, 45);
		panel_5.add(btnAlterarPergunta);
		
		JButton btnExcluirPergunta = new JButton("Excluir ");
		btnExcluirPergunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a pergunta selecionada?");
				
				if (i == 0) {
					try {
						
						String query = " DELETE FROM perguntas WHERE idperguntas = " + pCodigo.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
						pst.execute();

						JOptionPane.showMessageDialog(null, "Pergunta removido com sucesso!");
						

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não é possível remover a pergunta selecionada! \n"
								+ "Uma chave estrangeira faz referência à mesma!");
						e1.printStackTrace();
					}
				}	
			}
		});
		btnExcluirPergunta.setBounds(536, 152, 109, 45);
		panel_5.add(btnExcluirPergunta);
		
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Respostas", null, panel_7, null);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String query = "SELECT * FROM respostas";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_6.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_6.setBounds(275, 11, 374, 130);
		panel_7.add(scrollPane_6);
		
		table_6 = new JTable();
		table_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTable_Display_RespostasMouseClicked(e);				
			}

		});
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo resposta", "Resposta", "C\u00F3digo pergunta"
			}
		));
		scrollPane_6.setViewportView(table_6);
		
		JLabel label_12 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_12.setBounds(10, 11, 220, 14);
		panel_7.add(label_12);
		
		JLabel lblCdigoResposta = new JLabel("C\u00F3digo Resposta");
		lblCdigoResposta.setBounds(10, 36, 103, 14);
		panel_7.add(lblCdigoResposta);
		
		JLabel lblCdigoDaPergunta = new JLabel("C\u00F3digo da Pergunta");
		lblCdigoDaPergunta.setBounds(123, 36, 142, 14);
		panel_7.add(lblCdigoDaPergunta);
		
		rCodPergunta = new JTextField();
		rCodPergunta.setColumns(10);
		rCodPergunta.setBounds(123, 61, 109, 20);
		panel_7.add(rCodPergunta);
		
		rCodResposta = new JTextField();
		rCodResposta.setColumns(10);
		rCodResposta.setBounds(10, 61, 86, 20);
		panel_7.add(rCodResposta);
		
		JLabel lblResposta = new JLabel("Resposta");
		lblResposta.setBounds(10, 92, 180, 14);
		panel_7.add(lblResposta);
		
		rTextoResposta = new JTextField();
		rTextoResposta.setColumns(10);
		rTextoResposta.setBounds(10, 117, 220, 20);
		panel_7.add(rTextoResposta);
		
		JButton btnCadastrarResposta = new JButton("Cadastrar");
		btnCadastrarResposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    checarfkrespostas();
				    if(checarfkrespostas()){
					inserirrespostas();		
					}else JOptionPane.showMessageDialog(null, "Não é possível cadastrar uma resposta para uma pergunta subjetiva!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "A resposta já está cadastrada!");
					System.out.println(e1);
				}
				
			}
		});
		
		
		btnCadastrarResposta.setBounds(275, 152, 109, 45);
		panel_7.add(btnCadastrarResposta);
		
		JButton btnAlterarResposta = new JButton("Alterar");
		btnAlterarResposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

					String query = "UPDATE respostas SET idrespostas = " + rCodResposta.getText() + ", "
					             + "textoresposta = '" + rTextoResposta.getText() + "', " 
					             + "perguntas_idperguntas = " + rCodPergunta.getText() 
							     + " WHERE idrespostas = " + rCodResposta.getText() + ";";

					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dados atualizados!");
					pst.close();
			        }catch(Exception e1) {
				     e1.printStackTrace();
		 	    }
			}
		});
		btnAlterarResposta.setBounds(411, 152, 109, 45);
		panel_7.add(btnAlterarResposta);
		
		JButton btnExcluirResposta = new JButton("Excluir ");
		btnExcluirResposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a resposta selecionada?");
				
				if (i == 0) {
					try {
						
						String query = " DELETE FROM respostas WHERE idrespostas = " + rCodResposta.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
						pst.execute();

						JOptionPane.showMessageDialog(null, "Resposta removida com sucesso!");
						

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não é possível remover a resposta selecionada! \n"
								+ "Uma chave estrangeira faz referência à mesma!");
						e1.printStackTrace();
					}
				}
			}
		});
		btnExcluirResposta.setBounds(540, 152, 109, 45);
		panel_7.add(btnExcluirResposta);
		
		
		chckbxNewCheckBox.setBounds(121, 116, 21, 23);
		panel_5.add(chckbxNewCheckBox);
		
		JLabel lblCdigoSimulado_1 = new JLabel("C\u00F3digo Simulado");
		lblCdigoSimulado_1.setBounds(123, 36, 103, 14);
		panel_5.add(lblCdigoSimulado_1);
		
		pCodsim = new JTextField();
		pCodsim.setColumns(10);
		pCodsim.setBounds(123, 61, 95, 20);
		panel_5.add(pCodsim);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("Escolher matérias", null, panel_10, null);
		panel_10.setLayout(null);
		
		JLabel lblRegistrarMatriasDos = new JLabel("Aluno");
		lblRegistrarMatriasDos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrarMatriasDos.setBounds(10, 11, 161, 25);
		panel_10.add(lblRegistrarMatriasDos);
		
		JLabel lblNewLabel_1 = new JLabel("Facilitador");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(329, 11, 144, 25);
		panel_10.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(318, 11, 1, 190);
		panel_10.add(separator);		
		
		JLabel lblIdAluno = new JLabel("ID aluno");
		lblIdAluno.setBounds(10, 47, 77, 14);
		panel_10.add(lblIdAluno);
		
		emIdaluno = new JTextField();
		emIdaluno.setColumns(10);
		emIdaluno.setBounds(10, 72, 86, 20);
		panel_10.add(emIdaluno);
		
		emIdmateria1 = new JTextField();
		emIdmateria1.setColumns(10);
		emIdmateria1.setBounds(10, 128, 86, 20);
		panel_10.add(emIdmateria1);
		
		JLabel lblCdDisciplina = new JLabel("C\u00F3d disciplina");
		lblCdDisciplina.setBounds(10, 103, 109, 14);
		panel_10.add(lblCdDisciplina);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String query = "SELECT aluno_idaluno as IDaluno, materia_idmateria as IDmateria FROM aluno_has_materia";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_8.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_8.setBounds(117, 11, 191, 154);
		panel_10.add(scrollPane_8);
		
		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID aluno", "ID mat\u00E9ria"
			}
		));
		scrollPane_8.setViewportView(table_8);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Statement stmt = con.createStatement();
				stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
				
				String sql = "INSERT INTO aluno_has_materia VALUES (?, ?)";
				
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, emIdaluno.getText());
				pst.setString(2, emIdmateria1.getText());
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Disciplina alocada ao aluno(a) com sucesso!");
				
				pst.close();
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Não foi possível alocar a disciplina ao aluno(a)!");
				System.out.println(e1);
			}
			}
		});
		btnInserir.setBounds(10, 160, 89, 23);
		panel_10.add(btnInserir);
		
		JButton button_2 = new JButton("Inserir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO facilitador_has_materia VALUES (?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, emIdfacilitador.getText());
					pst.setString(2, emIdmateria2.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Disciplina alocada ao facilitador com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível alocar a disciplina ao facilitador!");
					System.out.println(e1);
				}
			}
		});
		button_2.setBounds(336, 160, 89, 23);
		panel_10.add(button_2);
		
		JLabel lblIdFacilitador = new JLabel("ID facilitador");
		lblIdFacilitador.setBounds(339, 47, 109, 14);
		panel_10.add(lblIdFacilitador);
		
		emIdfacilitador = new JTextField();
		emIdfacilitador.setColumns(10);
		emIdfacilitador.setBounds(339, 72, 86, 20);
		panel_10.add(emIdfacilitador);
		
		JLabel label_8 = new JLabel("C\u00F3d disciplina");
		label_8.setBounds(339, 103, 109, 14);
		panel_10.add(label_8);
		
		emIdmateria2 = new JTextField();
		emIdmateria2.setColumns(10);
		emIdmateria2.setBounds(339, 128, 86, 20);
		panel_10.add(emIdmateria2);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT facilitador_idfacilitador as IDfacilitador, materia_idmateria as IDmateria FROM facilitador_has_materia";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_9.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_9.setBounds(446, 11, 191, 154);
		panel_10.add(scrollPane_9);
		
		table_9 = new JTable();
		table_9.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID facilitador", "ID mat\u00E9ria"
			}
		));
		scrollPane_9.setViewportView(table_9);
		
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("Simulados", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel label_7 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_7.setBounds(10, 11, 220, 14);
		panel_11.add(label_7);
		
		JLabel lblCdigoSimulado = new JLabel("C\u00F3digo simulado");
		lblCdigoSimulado.setBounds(10, 36, 115, 14);
		panel_11.add(lblCdigoSimulado);
		
		simCodsim = new JTextField();
		simCodsim.setColumns(10);
		simCodsim.setBounds(10, 61, 86, 20);
		panel_11.add(simCodsim);
		
		JLabel lblCdigoFacilitador_1 = new JLabel("C\u00F3digo facilitador");
		lblCdigoFacilitador_1.setBounds(10, 92, 86, 14);
		panel_11.add(lblCdigoFacilitador_1);
		
		simCodfac = new JTextField();
		simCodfac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0){
					simCodfac.setEnabled(false);
				}else{
					simCodfac.setEnabled(true);
				}
			}
		});
		simCodfac.setColumns(10);
		simCodfac.setBounds(10, 117, 86, 20);
		panel_11.add(simCodfac);
		
		simCodmat = new JTextField();
		simCodmat.setColumns(10);
		simCodmat.setBounds(121, 117, 109, 20);
		panel_11.add(simCodmat);
		
		JLabel lblCdigoMatria = new JLabel("C\u00F3digo mat\u00E9ria");
		lblCdigoMatria.setBounds(121, 92, 109, 14);
		panel_11.add(lblCdigoMatria);
		
		JLabel lblCdigoFacilitador = new JLabel("Tipo de pergunta");
		lblCdigoFacilitador.setBounds(123, 36, 127, 14);
		panel_11.add(lblCdigoFacilitador);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT * FROM simulado";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_10.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_10.setBounds(275, 11, 374, 130);
		panel_11.add(scrollPane_10);
		
		table_10 = new JTable();
		table_10.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID simulado", "ID facilitador", "ID mat\u00E9ria"
			}
		));
		scrollPane_10.setViewportView(table_10);
		
		JButton button_3 = new JButton("Cadastrar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					if(comboBox.getSelectedIndex() == 1){
					String sql = "INSERT INTO simulado (idsimulado, fhm_materia_idmateria) VALUES (?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, simCodsim.getText());
					pst.setString(2, simCodmat.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Simulado registrado com sucesso!");
					
					pst.close();
					}else{
						
							String sql = "INSERT INTO simulado (idsimulado, fhm_facilitador_idfacilitador, fhm_materia_idmateria) VALUES (?, ?, ?)";
							
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1, simCodsim.getText());
							pst.setString(2, simCodfac.getText());
							pst.setString(3, simCodmat.getText());
							
							pst.execute();
							
							JOptionPane.showMessageDialog(null, "Simulado registrado com sucesso!");
							
							pst.close();							
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível registrar o simulado!");
					System.out.println(e1);
				}
			}
		});
		button_3.setBounds(275, 152, 109, 45);
		panel_11.add(button_3);
		
		JButton button_4 = new JButton("Excluir");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o simulado selecionado?");
				
				if (i == 0) {
					try {
						
						String query = " DELETE FROM simulado WHERE idsimulado = " + simCodsim.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
						pst.execute();

						JOptionPane.showMessageDialog(null, "Simulado removida com sucesso!");
						

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não é possível remover o simulado selecionado!");
						e1.printStackTrace();
					}
				}
			}
		});
		button_4.setBounds(540, 152, 109, 45);
		panel_11.add(button_4);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 1)
				simCodfac.setEnabled(false);
				else
					simCodfac.setEnabled(true);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Subjetiva", "Objetiva", "Ambos"}));
		comboBox.setBounds(121, 61, 109, 20);
		panel_11.add(comboBox);
		
		JPanel panel_12 = new JPanel();
		tabbedPane.addTab("Dúvidas", null, panel_12, null);
		panel_12.setLayout(null);
		
		JLabel label_15 = new JLabel("Selecione a op\u00E7\u00E3o desejada");
		label_15.setBounds(10, 11, 220, 14);
		panel_12.add(label_15);
		
		JLabel lblCdigoDvida = new JLabel("C\u00F3digo d\u00FAvida");
		lblCdigoDvida.setBounds(10, 36, 103, 14);
		panel_12.add(lblCdigoDvida);
		
		dCod = new JTextField();
		dCod.setColumns(10);
		dCod.setBounds(10, 61, 86, 20);
		panel_12.add(dCod);
		
		JLabel lblIdAluno_1 = new JLabel("ID aluno");
		lblIdAluno_1.setBounds(10, 92, 86, 14);
		panel_12.add(lblIdAluno_1);
		
		dCodal = new JTextField();
		dCodal.setColumns(10);
		dCodal.setBounds(10, 117, 86, 20);
		panel_12.add(dCodal);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(123, 36, 75, 14);
		panel_12.add(lblTexto);
		
		dTexto = new JTextField();
		dTexto.setColumns(10);
		dTexto.setBounds(123, 61, 109, 20);
		panel_12.add(dTexto);
		
		JLabel lblIdFacilitador_1 = new JLabel("ID facilitador");
		lblIdFacilitador_1.setBounds(121, 92, 109, 14);
		panel_12.add(lblIdFacilitador_1);
		
		dCodfac = new JTextField();
		dCodfac.setColumns(10);
		dCodfac.setBounds(121, 117, 109, 20);
		panel_12.add(dCodfac);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT * FROM duvidas";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_12.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane_12.setBounds(275, 11, 374, 130);
		panel_12.add(scrollPane_12);
		
		table_12 = new JTable();
		table_12.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID duvida", "Texto", "ID aluno", "ID facilitador"
			}
		));
		scrollPane_12.setViewportView(table_12);
		
		JButton button_5 = new JButton("Cadastrar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Statement stmt = con.createStatement();
					stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
					
					String sql = "INSERT INTO duvidas VALUES (?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, dCod.getText());
					pst.setString(2, dTexto.getText());
					pst.setString(3, dCodal.getText());
					pst.setString(4, dCodfac.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Dúvida registrada com sucesso!");
					
					pst.close();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível registrar a dúvida!");
					System.out.println(e1);
				}
			}
		});
		button_5.setBounds(275, 152, 109, 45);
		panel_12.add(button_5);
		
		JButton button_7 = new JButton("Excluir ");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a dúvida selecionada?");
				
				if (i == 0) {
					try {
						
						String query = " DELETE FROM duvidas WHERE idduvidas = " + dCod.getText();
						PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
						pst.execute();

						JOptionPane.showMessageDialog(null, "Dúvida removida com sucesso!");
						

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não é possível remover a dúvida selecionada!");
						e1.printStackTrace();
					}
				}
			}
		});
		button_7.setBounds(540, 152, 109, 45);
		panel_12.add(button_7);
		
		JPanel panel_14 = new JPanel();
		tabbedPane.addTab("Pesquisar", null, panel_14, null);
		panel_14.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(318, 11, 1, 190);
		panel_14.add(separator_1);
		
		JLabel label_16 = new JLabel("Aluno");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_16.setBounds(10, 11, 161, 25);
		panel_14.add(label_16);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT idaluno, nome, fhm_materia_idmateria AS idmateria, ROUND(AVG(nota), 2) AS media "
							+ "FROM aluno JOIN simulado_has_aluno JOIN simulado "
							+ "ON idaluno = aluno_idaluno "
							+ "AND idsimulado = simulado_idsimulado "
							+ "GROUP BY aluno_idaluno, fhm_materia_idmateria";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_13.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_13.setBounds(117, 11, 191, 138);
		panel_14.add(scrollPane_13);
		
		table_13 = new JTable();
		scrollPane_13.setViewportView(table_13);
		
		pIdaluno = new JTextField();
		pIdaluno.setColumns(10);
		pIdaluno.setBounds(10, 72, 86, 20);
		panel_14.add(pIdaluno);
		
		pNomealuno = new JTextField();
		pNomealuno.setColumns(10);
		pNomealuno.setBounds(10, 128, 86, 20);
		panel_14.add(pNomealuno);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(207, 178, 101, 23);
		panel_14.add(btnPesquisar);
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.setBounds(536, 178, 101, 23);
		panel_14.add(btnPesquisar_1);
		
		pNomefac = new JTextField();
		pNomefac.setColumns(10);
		pNomefac.setBounds(339, 128, 86, 20);
		panel_14.add(pNomefac);
		
		pIdfac = new JTextField();
		pIdfac.setColumns(10);
		pIdfac.setBounds(339, 72, 86, 20);
		panel_14.add(pIdfac);
		
		JLabel label_21 = new JLabel("Facilitador");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_21.setBounds(329, 11, 144, 25);
		panel_14.add(label_21);
		
		JScrollPane scrollPane_14 = new JScrollPane();
		scrollPane_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "SELECT idfacilitador, nome, materia_idmateria AS idmateria, COUNT(fhm_facilitador_idfacilitador) AS qtdemsimulados "
							+ "FROM facilitador JOIN facilitador_has_materia JOIN simulado "
							+ "ON idfacilitador = facilitador_idfacilitador "
							+ "AND idfacilitador = fhm_facilitador_idfacilitador "
							+ "AND materia_idmateria = fhm_materia_idmateria "
							+ "GROUP BY idfacilitador, materia_idmateria;";
					PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_14.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_14.setBounds(446, 11, 191, 138);
		panel_14.add(scrollPane_14);
		
		table_14 = new JTable();
		scrollPane_14.setViewportView(table_14);
		
		pIdmataluno = new JTextField();
		pIdmataluno.setColumns(10);
		pIdmataluno.setBounds(10, 181, 86, 20);
		panel_14.add(pIdmataluno);
		
		pMedia = new JTextField();
		pMedia.setColumns(10);
		pMedia.setBounds(117, 179, 70, 20);
		panel_14.add(pMedia);
		
		pIdmatfac = new JTextField();
		pIdmatfac.setColumns(10);
		pIdmatfac.setBounds(339, 183, 86, 20);
		panel_14.add(pIdmatfac);
		
		pQtde = new JTextField();
		pQtde.setColumns(10);
		pQtde.setBounds(446, 181, 70, 20);
		panel_14.add(pQtde);
		
		JRadioButton rdbtnIdAluno = new JRadioButton("ID aluno");
		bg.add(rdbtnIdAluno);
		rdbtnIdAluno.setBounds(10, 42, 101, 23);
		panel_14.add(rdbtnIdAluno);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		bg.add(rdbtnNome);
		rdbtnNome.setBounds(10, 99, 101, 23);
		panel_14.add(rdbtnNome);
		
		JRadioButton rdbtnIdMatria = new JRadioButton("ID mat\u00E9ria");
		bg.add(rdbtnIdMatria);
		rdbtnIdMatria.setBounds(10, 152, 101, 23);
		panel_14.add(rdbtnIdMatria);
		
		JRadioButton rdbtnMdia = new JRadioButton("M\u00E9dia");
		bg.add(rdbtnMdia);
		rdbtnMdia.setBounds(117, 152, 109, 23);
		panel_14.add(rdbtnMdia);
		
		JRadioButton rdbtnNome1 = new JRadioButton("Nome");
		buttonGroup.add(rdbtnNome1);
		rdbtnNome1.setBounds(339, 99, 101, 23);
		panel_14.add(rdbtnNome1);
		
		JRadioButton rdbtnIdMatria1 = new JRadioButton("ID mat\u00E9ria");
		buttonGroup.add(rdbtnIdMatria1);
		rdbtnIdMatria1.setBounds(339, 152, 101, 23);
		panel_14.add(rdbtnIdMatria1);
		
		JRadioButton rdbtnQuantidadeMatrias = new JRadioButton("Quantidade simulados");
		buttonGroup.add(rdbtnQuantidadeMatrias);
		rdbtnQuantidadeMatrias.setBounds(446, 152, 191, 23);
		panel_14.add(rdbtnQuantidadeMatrias);
		
		JRadioButton rdbtnIdFacilitador = new JRadioButton("ID facilitador");
		buttonGroup.add(rdbtnIdFacilitador);
		rdbtnIdFacilitador.setBounds(339, 42, 101, 23);
		panel_14.add(rdbtnIdFacilitador);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String query = "SELECT idaluno, nome, fhm_materia_idmateria AS idmateria, ROUND(AVG(nota), 2) AS media "
						+ "FROM aluno JOIN simulado_has_aluno JOIN simulado "
						+ "ON idaluno = aluno_idaluno "
						+ "AND idsimulado = simulado_idsimulado "
						+ "GROUP BY aluno_idaluno, fhm_materia_idmateria";
				if(rdbtnIdAluno.isSelected()) query = "SELECT idaluno, nome, fhm_materia_idmateria AS idmateria, ROUND(AVG(nota), 2) AS media "
						+ "FROM aluno JOIN simulado_has_aluno JOIN simulado "
						+ "ON idaluno = aluno_idaluno "
						+ "AND idsimulado = simulado_idsimulado "
						+ "WHERE idaluno like '" + pIdaluno.getText() + "%' "
						+ "GROUP BY aluno_idaluno, fhm_materia_idmateria";
				if(rdbtnNome.isSelected()) query = "SELECT idaluno, nome, fhm_materia_idmateria AS idmateria, ROUND(AVG(nota), 2) AS media "
						+ "FROM aluno JOIN simulado_has_aluno JOIN simulado "
						+ "ON idaluno = aluno_idaluno "
						+ "AND idsimulado = simulado_idsimulado "
						+ "WHERE nome like '" + pNomealuno.getText() + "%' "
						+ "GROUP BY aluno_idaluno, fhm_materia_idmateria";
				if(rdbtnIdMatria.isSelected()) query = "SELECT idaluno, nome, fhm_materia_idmateria AS idmateria, ROUND(AVG(nota), 2) AS media "
						+ "FROM aluno JOIN simulado_has_aluno JOIN simulado "
						+ "ON idaluno = aluno_idaluno "
						+ "AND idsimulado = simulado_idsimulado "
						+ "WHERE fhm_materia_idmateria like '" + pIdmataluno.getText() + "%' "
						+ "GROUP BY aluno_idaluno, fhm_materia_idmateria";
				if(rdbtnMdia.isSelected()) query = "SELECT idaluno, nome, fhm_materia_idmateria AS idmateria, ROUND(AVG(nota), 2) AS media "
						+ "FROM aluno JOIN simulado_has_aluno JOIN simulado "
						+ "ON idaluno = aluno_idaluno "
						+ "AND idsimulado = simulado_idsimulado "						
						+ "GROUP BY aluno_idaluno, fhm_materia_idmateria "
						+ "HAVING AVG(nota) like '" + pMedia.getText() + "%' ";
				PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table_13.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
			}
		});
		
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "SELECT idfacilitador, nome, materia_idmateria AS idmateria, COUNT(fhm_facilitador_idfacilitador) AS qtdesimulados "
						+ "FROM facilitador JOIN facilitador_has_materia JOIN simulado "
						+ "ON idfacilitador = facilitador_idfacilitador "
						+ "AND idfacilitador = fhm_facilitador_idfacilitador "
						+ "AND materia_idmateria = fhm_materia_idmateria "
						+ "GROUP BY idfacilitador, materia_idmateria;";
					if(rdbtnIdFacilitador.isSelected()) query = "SELECT idfacilitador, nome, materia_idmateria AS idmateria, COUNT(fhm_facilitador_idfacilitador) AS qtdesimulados "
							+ "FROM facilitador JOIN facilitador_has_materia JOIN simulado "
							+ "ON idfacilitador = facilitador_idfacilitador "
							+ "AND idfacilitador = fhm_facilitador_idfacilitador "
							+ "AND materia_idmateria = fhm_materia_idmateria "
							+ "WHERE idfacilitador like '" + pIdfac.getText() + "%' "
							+ "GROUP BY idfacilitador, materia_idmateria;";
					if(rdbtnNome1.isSelected()) query = "SELECT idfacilitador, nome, materia_idmateria AS idmateria, COUNT(fhm_facilitador_idfacilitador) AS qtdesimulados "
							+ "FROM facilitador JOIN facilitador_has_materia JOIN simulado "
							+ "ON idfacilitador = facilitador_idfacilitador "
							+ "AND idfacilitador = fhm_facilitador_idfacilitador "
							+ "AND materia_idmateria = fhm_materia_idmateria "
							+ "WHERE nome like '" + pNomefac.getText() + "%' "
							+ "GROUP BY idfacilitador, materia_idmateria;";
					if(rdbtnIdMatria1.isSelected()) query = "SELECT idfacilitador, nome, materia_idmateria AS idmateria, COUNT(fhm_facilitador_idfacilitador) AS qtdesimulados "
							+ "FROM facilitador JOIN facilitador_has_materia JOIN simulado "
							+ "ON idfacilitador = facilitador_idfacilitador "
							+ "AND idfacilitador = fhm_facilitador_idfacilitador "
							+ "AND materia_idmateria = fhm_materia_idmateria "
							+ "WHERE materia_idmateria like '" + pIdmatfac.getText() + "%' "
							+ "GROUP BY idfacilitador, materia_idmateria;";
					if(rdbtnQuantidadeMatrias.isSelected()) query = "SELECT idfacilitador, nome, materia_idmateria AS idmateria, COUNT(fhm_facilitador_idfacilitador) AS qtdesimulados "
							+ "FROM facilitador JOIN facilitador_has_materia JOIN simulado "
							+ "ON idfacilitador = facilitador_idfacilitador "
							+ "AND idfacilitador = fhm_facilitador_idfacilitador "
							+ "AND materia_idmateria = fhm_materia_idmateria "
							+ "GROUP BY idfacilitador, materia_idmateria "
							+ "HAVING COUNT(fhm_facilitador_idfacilitador) like '" + pQtde.getText() + "%'";
					
				PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table_14.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}
	
	private boolean checarfkrespostas() throws Exception{
		Statement stmt = sqlConnection.dbConnector().createStatement();
		String sql = "SELECT * FROM perguntas, respostas WHERE objetiva = 1 AND idperguntas = "+ rCodPergunta.getText()+ ";";
		ResultSet rs = stmt.executeQuery(sql);
		return rs.next();
	}
	
	
	private void inserirrespostas() throws Exception{
		
		Statement stmt = sqlConnection.dbConnector().createStatement();
		stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
		
		String sql = "INSERT INTO respostas (idrespostas, textoresposta, perguntas_idperguntas) VALUES (?, ?, ?)";
		
		PreparedStatement pst = sqlConnection.dbConnector().prepareStatement(sql);
		pst.setString(1, rCodResposta.getText());
		pst.setString(2, rTextoResposta.getText());
		pst.setString(3, rCodPergunta.getText());
		
		pst.execute();
		
		JOptionPane.showMessageDialog(null, "Resposta registrada com sucesso!");
		
		pst.close();		
	}
	
	private boolean objetivaCheck(){
		if(pObjetiva.getText().equals("true"))return true;
		else return false;
	}
	

	private void jTable_Display_AlunosMouseClicked(MouseEvent e) {
		// private void
		// jTable_Display_AlunosMouseClicked(java.awt.event.MouseEvent e) {
		int i = table.getSelectedRow();

		TableModel model = table.getModel();
		
		aMatr.setText(model.getValueAt(i, 0).toString());
		aNome.setText(model.getValueAt(i, 1).toString());
		aEnder.setText(model.getValueAt(i, 2).toString());
		String datevalue = model.getValueAt(i, 4).toString();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datevalue);
			dateChooser.setDate(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}				
		aLogin.setText(model.getValueAt(i, 5).toString());

	}
	private void jTable_Display_FacilitadoresMouseClicked(MouseEvent e) {
		int i = table_2.getSelectedRow();

		TableModel model = table_2.getModel();

		fMatr.setText(model.getValueAt(i, 0).toString());
		fNome.setText(model.getValueAt(i, 1).toString());
		fEnder.setText(model.getValueAt(i, 2).toString());
//		fEnder.setText(model.getValueAt(i, 3).toString());

	}
	
	private void jTable_Display_CadastroMouseClicked(MouseEvent e){
		int i = table_1.getSelectedRow();
		
		TableModel model = table_1.getModel();
		
		cLogin.setText(model.getValueAt(i, 0).toString());
		cSenha.setText(model.getValueAt(i, 1).toString());
	}
	
	private void jTable_Display_MateriasMouseClicked(MouseEvent e){
		int i = table_3.getSelectedRow();
		
		TableModel model = table_3.getModel();
		
		mCodigo.setText(model.getValueAt(i, 0).toString());
		mNome.setText(model.getValueAt(i, 1).toString());
		mCredito.setText(model.getValueAt(i, 2).toString());
		mValor.setText(model.getValueAt(i, 3).toString());
		
	}
	
	private void jTable_Display_AssuntosMouseClicked(MouseEvent e){
		int i = table_4.getSelectedRow();
		
		TableModel model = table_4.getModel();
		
		assuntoCodigo.setText(model.getValueAt(i, 0).toString());
		assuntoNome.setText(model.getValueAt(i, 1).toString());
		assuntoCodigoMateria.setText(model.getValueAt(i, 2).toString());
	}

	private void jTable_Display_PerguntasMouseClicked(MouseEvent e) {
        int i = table_5.getSelectedRow();
		
		TableModel model = table_5.getModel();
		
		
		
		pCodigo.setText(model.getValueAt(i, 0).toString());
		pEnunciado.setText(model.getValueAt(i, 1).toString());
		pObjetiva.setText(model.getValueAt(i, 2).toString());
		pCodAssunto.setText(model.getValueAt(i, 3).toString());
		pCodsim.setText(model.getValueAt(i, 4).toString());		
		
		
	}
	

	private void jTable_Display_RespostasMouseClicked(MouseEvent e) {
        int i = table_6.getSelectedRow();
		
		TableModel model = table_6.getModel();
		
		rCodResposta.setText(model.getValueAt(i, 0).toString());
		rTextoResposta.setText(model.getValueAt(i, 1).toString());
		rCodPergunta.setText(model.getValueAt(i, 2).toString());
		
	}

	private void jTable_Display_ValoresFacilitadorMouseClicked(MouseEvent e) {
        int i = table_7.getSelectedRow();
		
		TableModel model = table_7.getModel();
		
		vfMatr.setText(model.getValueAt(i, 0).toString());
		vfDuvida.setText(model.getValueAt(i, 1).toString());
		vfSimulado.setText(model.getValueAt(i, 2).toString());
		
	}
	
	public void Show_ValorFacilitador_In_JTable() {
		ArrayList<ValoresFacilitador> list = getValoresFacilitadorList();
		DefaultTableModel model = (DefaultTableModel) table_7.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdFacilitador();
			row[1] = list.get(i).getValorDuvida();
			row[1] = list.get(i).getValorSimulado();

			model.addRow(row);
		}
	}
	
	public void Show_Alunos_In_JTable() {
		ArrayList<Aluno> list = getAlunosList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdaluno();
			row[1] = list.get(i).getNome();
			row[2] = list.get(i).getEndereco();
			row[3] = list.get(i).getInscricao();
			row[4] = list.get(i).getDatainscricao();			
			row[5] = list.get(i).getLogin_username();

			model.addRow(row);
		}
	}
	
	public void Show_Facilitador_In_JTable() {
		ArrayList<Facilitadores> list = getFacilitadoresList();
		DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		Object[] row = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdfacilitador();
			row[1] = list.get(i).getNome();
			row[2] = list.get(i).getEndereco();
			row[3] = list.get(i).getPagamento();

			model.addRow(row);
		}
	}
	
	
	
	
	public void Show_Login_In_JTable(){		
		ArrayList<Cadastro> list = getCadastroList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getLogin();
			row[1] = list.get(i).getSenha();				
			
			model.addRow(row);
		}		
	}
	
	public void Show_Materia_In_JTable(){		
		ArrayList<Materia> list = getMateriaList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getCodigo();
			row[1] = list.get(i).getNomeMateria();
			row[2] = list.get(i).getCreditos();
			row[3] = list.get(i).getValorinscricao();
			
			model.addRow(row);
		}		
	}
	
	public void Show_Assunto_In_JTable(){		
		ArrayList<Assunto> list = getAssuntoList();
		DefaultTableModel model = (DefaultTableModel) table_4.getModel();
		Object[] row = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getCodigoAssunto();
			row[1] = list.get(i).getNomeAssunto();
			row[2] = list.get(i).getCodigo();
			
			model.addRow(row);
		}		
	}
	
	public void Show_Perguntas_In_JTable() {
		ArrayList<Perguntas> list = getPerguntasList();
		DefaultTableModel model = (DefaultTableModel) table_5.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdperguntas();
			row[1] = list.get(i).getEnunciado();
			row[2] = list.get(i).isObjetiva();
			row[3] = list.get(i).getIdassunto();
			row[4] = list.get(i).getIdsimulado();

			model.addRow(row);
		}
	}
	
	public void Show_Respostas_In_JTable() {
		ArrayList<Respostas> list = getRespostasList();
		DefaultTableModel model = (DefaultTableModel) table_6.getModel();
		Object[] row = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdrespostas();
			row[1] = list.get(i).getTexto();
			row[2] = list.get(i).getCodigoperguntas();

			model.addRow(row);
		}
	}
	
	

	private ArrayList<Facilitadores> getFacilitadoresList() {
		ArrayList<Facilitadores> usersList = new ArrayList<Facilitadores>();
		Connection connection = sqlConnection.dbConnector();
		
		String query = "SELECT * FROM  `facilitador` ";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Facilitadores user;
			while (rs.next()) {
				user = new Facilitadores(rs.getInt("idfacilitador"), rs.getString("nome"), rs.getString("endereco"),rs.getDouble("pagamento"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	public ArrayList<Aluno> getAlunosList() {
		ArrayList<Aluno> usersList = new ArrayList<Aluno>();
		Connection connection = sqlConnection.dbConnector();
		
		String query = "SELECT * FROM  `aluno` ";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Aluno user;
			while (rs.next()) {
				user = new Aluno(rs.getInt("idaluno"), rs.getString("nome"), rs.getString("endereco"), rs.getDate("datainscricao"),
						rs.getDouble("inscricao"), rs.getString("login_username"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	private ArrayList<Cadastro> getCadastroList() {
		ArrayList<Cadastro> usersList = new ArrayList<Cadastro>();
		Connection connection = sqlConnection.dbConnector();

		String query = "SELECT * FROM  `login` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Cadastro user;
			while (rs.next()) {
				user = new Cadastro(rs.getString("username"), rs.getString("password"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	private ArrayList<Materia> getMateriaList() {
		ArrayList<Materia> usersList = new ArrayList<Materia>();
		Connection connection = sqlConnection.dbConnector();

		String query = "SELECT * FROM  `materia` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Materia user;
			while (rs.next()) {
				user = new Materia(rs.getInt("idmateria"), rs.getString("nomemateria"), rs.getInt("creditos"), rs.getDouble("valor_inscricao"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	private ArrayList<Assunto> getAssuntoList() {
		ArrayList<Assunto> usersList = new ArrayList<Assunto>();
		Connection connection = sqlConnection.dbConnector();

		String query = "SELECT * FROM  `assunto` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Assunto user;
			while (rs.next()) {
				user = new Assunto(rs.getInt("idassunto"), rs.getString("nomeassunto"), rs.getInt("CodigoMateria"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	private ArrayList<Perguntas> getPerguntasList() {
		ArrayList<Perguntas> usersList = new ArrayList<Perguntas>();
		Connection connection = sqlConnection.dbConnector();

		String query = "SELECT * FROM  `perguntas` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Perguntas user;
			while (rs.next()) {
				user = new Perguntas(rs.getInt("idperguntas"), rs.getString("enunciado"), rs.getBoolean("objetiva"), 
						rs.getInt("assunto_idassunto"), rs.getInt("simulado_idsimulado"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	private ArrayList<Respostas> getRespostasList() {
		ArrayList<Respostas> usersList = new ArrayList<Respostas>();
		Connection connection = sqlConnection.dbConnector();

		String query = "SELECT * FROM  `respostas` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Respostas user;
			while (rs.next()) {
				user = new Respostas(rs.getInt("idrespostas"), rs.getString("textoresposta"), rs.getInt("perguntas_idperguntas"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	public ArrayList<ValoresFacilitador> getValoresFacilitadorList() {
		ArrayList<ValoresFacilitador> usersList = new ArrayList<ValoresFacilitador>();
		Connection connection = sqlConnection.dbConnector();
		
		String query = "SELECT * FROM  `valoresfacilitador` ";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			ValoresFacilitador user;
			while (rs.next()) {
				user = new ValoresFacilitador(rs.getInt("idfacilitador"), rs.getDouble("valorduvida"), rs.getDouble("valorsimulado"));
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	public ArrayList<Integer> idAluno(){
		Connection connection = sqlConnection.dbConnector();
		ArrayList<Integer> idalunos = new ArrayList<Integer>();
		String query = "SELECT idaluno FROM  `aluno` ";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			int i;
			while (rs.next()) {
				i = new Integer(rs.getInt("idaluno"));
				idalunos.add(i);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idalunos;
	}
}
