package telasinterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dao.CadastroReservaDAO;
import tablecadastroreserva.CadastroReserva;

public class ProjetoCadastroReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final String[] tituloColunas = new String[] { "ID", "Nome do cliente", "RG", "Contato", "Numero do quarto", "Andar",
			"Data de inicio da reserva", "Data fim da reserva", "Status" };

	private JPanel telaCadastro;
	private JTextField idCliente;
	private JTextField nomeCliente;
	private JFormattedTextField rgCliente;
	private JFormattedTextField contatoCliente;
	private JTextField numeroQuarto;
	private JTextField numeroAndar;
	private JFormattedTextField inicioReserva;
	private JFormattedTextField fimReserva;
	private JTextField statusReserva;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoCadastroReserva frame = new ProjetoCadastroReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public ProjetoCadastroReserva() throws ParseException {
		setBackground(Color.ORANGE);
		setForeground(new Color(220, 20, 60));
		setFont(new Font("Arial Black", Font.ITALIC, 12));
		setTitle("Cadastro do hospede");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Inmetrics.LP1439\\workspace\\Hotelaria\\src\\test\\resources\\Imagem\\award-winning-crowne-plaza-orlando-universal-hotel.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 580);
		telaCadastro = new JPanel();
		telaCadastro.setBackground(Color.WHITE);
		telaCadastro.setForeground(new Color(218, 165, 32));
		telaCadastro.setBorder(new EmptyBorder(14, 14, 6, 14));
		setContentPane(telaCadastro);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 1045, 541);
		panel.setToolTipText("");
		panel.setLayout(null);

		JLabel title = DefaultComponentFactory.getInstance().createTitle("Hotel Rest Time - Controle de reservas ");
		title.setBounds(10, 8, 584, 30);
		title.setBackground(new Color(255, 255, 255));
		title.setForeground(new Color(139, 0, 139));
		title.setFont(new Font("Cambria", Font.ITALIC, 18));
		panel.add(title);

		JLabel nomedocliente = new JLabel("Nome do cliente :");
		nomedocliente.setBounds(10, 70, 171, 30);
		nomedocliente.setFont(new Font("Cambria", Font.BOLD, 13));
		nomedocliente.setForeground(new Color(255, 0, 0));
		panel.add(nomedocliente);

		nomeCliente = new JTextField();
		nomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres = "0987654321@#%*&!$()+_-¨¨=";// Lista de
																// caracters que
																// não devem ser
																// aceitos//

				if (caracteres.contains(evt.getKeyChar() + "")) {// se o
																	// character
																	// que gerou
																	// o evento
																	// estiver
																	// na
																	// lista//

					evt.consume();// aciona essa propriedade para eliminar a
									// ação do evento//

				}
			}
		});
		nomeCliente.setBounds(120, 76, 285, 21);
		panel.add(nomeCliente);
		nomeCliente.setColumns(10);

		JLabel rg = new JLabel("RG :");
		rg.setBounds(414, 78, 46, 14);
		rg.setForeground(new Color(255, 0, 0));
		rg.setFont(new Font("Cambria", Font.BOLD, 13));
		panel.add(rg);

		MaskFormatter maskData;
		try {

			maskData = new MaskFormatter("##.###.###-#");
			rgCliente = new JFormattedTextField();
			rgCliente.setColumns(10);
			maskData.install(rgCliente);
			rgCliente.setBounds(443, 76, 151, 21);
			panel.add(rgCliente);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel contato = new JLabel("Contato :");
		contato.setBounds(10, 111, 84, 14);
		contato.setForeground(new Color(255, 0, 0));
		contato.setFont(new Font("Cambria", Font.BOLD, 13));
		panel.add(contato);

		MaskFormatter maskData2;
		try {
			maskData2 = new MaskFormatter("(##)#####-####");
			contatoCliente = new JFormattedTextField();
			contatoCliente.setColumns(10);
			maskData2.install(contatoCliente);
			contatoCliente.setBounds(71, 111, 110, 20);
			panel.add(contatoCliente);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel numerodoquarto = new JLabel("Numero do quarto:");
		numerodoquarto.setBounds(213, 106, 147, 24);
		numerodoquarto.setForeground(new Color(255, 0, 0));
		numerodoquarto.setFont(new Font("Cambria", Font.BOLD, 13));
		panel.add(numerodoquarto);

		numeroQuarto = new JTextField();
		numeroQuarto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {

				String caracteres = "abcdefghijklmnopqrstuvxyz@#%*&!$()+_-¨¨=";

				if (caracteres.contains(evt.getKeyChar() + "")) {

					evt.consume();
				}
			}

		});
		numeroQuarto.setBounds(332, 108, 36, 21);
		numeroQuarto.setForeground(Color.BLACK);
		panel.add(numeroQuarto);
		numeroQuarto.setColumns(10);

		JLabel andar = new JLabel("Andar :");
		andar.setBounds(370, 111, 60, 14);
		andar.setForeground(new Color(255, 0, 0));
		andar.setFont(new Font("Cambria", Font.BOLD, 13));
		panel.add(andar);

		numeroAndar = new JTextField();
		numeroAndar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres = "abcdefghijklmnopqrstuvxyz@#%*&!$()+_-¨¨=";

				if (caracteres.contains(evt.getKeyChar() + "")) {

					evt.consume();

				}
			}

		});
		numeroAndar.setBounds(424, 110, 36, 18);
		numeroAndar.setForeground(Color.BLACK);
		panel.add(numeroAndar);
		numeroAndar.setColumns(10);

		JLabel datainiciodareserva = new JLabel("Data inicio da reserva :");
		datainiciodareserva.setBounds(10, 151, 193, 14);
		datainiciodareserva.setForeground(new Color(255, 0, 0));
		datainiciodareserva.setFont(new Font("Cambria", Font.BOLD, 13));
		panel.add(datainiciodareserva);

		MaskFormatter maskData3;
		try {
			maskData3 = new MaskFormatter("##/##/####");
			inicioReserva = new JFormattedTextField();
			inicioReserva.setColumns(10);
			inicioReserva.setBounds(153, 149, 84, 20);
			maskData3.install(inicioReserva);
			panel.add(inicioReserva);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel datafimdareserva = new JLabel("Data fim da reserva :");
		datafimdareserva.setBounds(242, 146, 171, 24);
		datafimdareserva.setForeground(new Color(255, 0, 0));
		datafimdareserva.setFont(new Font("Cambria", Font.BOLD, 12));
		panel.add(datafimdareserva);

		MaskFormatter maskData4;
		try {
			maskData4 = new MaskFormatter("##/##/####");
			fimReserva = new JFormattedTextField();
			fimReserva.setColumns(10);
			fimReserva.setBounds(359, 149, 89, 20);
			maskData4.install(fimReserva);
			panel.add(fimReserva);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel status = new JLabel("Status :");
		status.setBounds(453, 151, 60, 14);
		status.setForeground(new Color(255, 0, 0));
		status.setFont(new Font("Cambria", Font.BOLD, 12));
		panel.add(status);

		statusReserva = new JTextField();
		statusReserva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {

				String caracteres = "0987654321@#%*&!$()+_-¨¨=";

				if (caracteres.contains(evt.getKeyChar() + "")) {

					evt.consume();
				}
			}
		});
		statusReserva.setBounds(498, 149, 95, 20);
		statusReserva.setForeground(Color.BLACK);
		panel.add(statusReserva);
		statusReserva.setColumns(10);

		JButton inserir = new JButton("Inserir");
		inserir.setFont(new Font("Cambria", Font.BOLD, 12));
		inserir.setBounds(61, 190, 84, 23);
		inserir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				CadastroReserva cadastroReserva = new CadastroReserva();
				cadastroReserva.setNomedocliente(nomeCliente.getText());
				cadastroReserva.setRg(rgCliente.getText());
				cadastroReserva.setContato(contatoCliente.getText());
				cadastroReserva.setNumerodoquarto(numeroQuarto.getText());
				cadastroReserva.setAndar(numeroAndar.getText());
				cadastroReserva.setStatus(statusReserva.getText());
				cadastroReserva.setDatainiciodareserva(inicioReserva.getText());
				cadastroReserva.setDatafimdareserva(fimReserva.getText());

				String mensagemValidacao = validarCampos(cadastroReserva);
				if (mensagemValidacao.isEmpty()) {
					CadastroReservaDAO cadastroReservaDAO = new CadastroReservaDAO();
					cadastroReservaDAO.adiciona(cadastroReserva);
					JOptionPane.showMessageDialog(null,
							"Dados inseridos com sucesso, veja o novo cadastro na tabela abaixo!");
				} else {
					JOptionPane.showMessageDialog(null, mensagemValidacao);

				}

				idCliente.setText("");
				nomeCliente.setText("");
				rgCliente.setText("");
				contatoCliente.setText("");
				numeroQuarto.setText("");
				numeroAndar.setText("");
				statusReserva.setText("");
				inicioReserva.setText("");
				fimReserva.setText("");

				table.setModel(consultarTodosRegistros());
			}
		});
		inserir.setBackground(Color.WHITE);
		inserir.setForeground(new Color(204, 0, 0));
		panel.add(inserir);

		JButton atualizar = new JButton("Atualizar");
		atualizar.setBounds(229, 190, 95, 23);
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadastroReserva cadastroReserva = new CadastroReserva();
				cadastroReserva.setId_cadastro(Integer.valueOf(idCliente.getText()));
				cadastroReserva.setNomedocliente(nomeCliente.getText());
				cadastroReserva.setRg(rgCliente.getText());
				cadastroReserva.setContato(contatoCliente.getText());
				cadastroReserva.setNumerodoquarto(numeroQuarto.getText());
				cadastroReserva.setAndar(numeroAndar.getText());
				cadastroReserva.setStatus(statusReserva.getText());
				cadastroReserva.setDatainiciodareserva(inicioReserva.getText());
				cadastroReserva.setDatafimdareserva(fimReserva.getText());

				String mensagemValidacao = validarCampos(cadastroReserva);

				if (mensagemValidacao.isEmpty()) {
					CadastroReservaDAO cadastroReservaDAO = new CadastroReservaDAO();
					cadastroReservaDAO.altera(cadastroReserva);
					JOptionPane.showMessageDialog(null,
							"Dados atualizados com sucesso, veja o novo cadastro na tabela abaixo!");
				} else {
					JOptionPane.showMessageDialog(null, mensagemValidacao);

				}

				idCliente.setText("");
				nomeCliente.setText("");
				rgCliente.setText("");
				contatoCliente.setText("");
				numeroQuarto.setText("");
				numeroAndar.setText("");
				statusReserva.setText("");
				inicioReserva.setText("");
				fimReserva.setText("");

				table.setModel(consultarTodosRegistros());
			}
		});
		telaCadastro.setLayout(null);
		atualizar.setBackground(Color.WHITE);
		atualizar.setForeground(new Color(220, 20, 60));
		atualizar.setFont(new Font("Cambria", Font.BOLD, 12));
		panel.add(atualizar);
		telaCadastro.add(panel);

		JLabel subtit = DefaultComponentFactory.getInstance()
				.createTitle("Coloque as informa\u00E7\u00F5es abaixo para cadastrar um hospede.");
		subtit.setForeground(new Color(128, 0, 128));
		subtit.setBounds(10, 45, 339, 14);
		subtit.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel.add(subtit);

		JLabel id = new JLabel("Id:");
		id.setForeground(new Color(255, 0, 0));
		id.setFont(new Font("Cambria", Font.BOLD, 13));
		id.setBounds(617, 78, 60, 14);
		panel.add(id);

		idCliente = new JTextField();
		idCliente.setEditable(false);
		idCliente.setForeground(Color.BLACK);
		idCliente.setColumns(10);
		idCliente.setBounds(639, 77, 36, 18);
		panel.add(idCliente);

		JButton delete = new JButton("Deletar");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroReserva cadastroreserva = new CadastroReserva();
				CadastroReservaDAO dao = new CadastroReservaDAO();

				int linha = table.getSelectedRow();

				cadastroreserva.setId_cadastro(Integer.valueOf(idCliente.getText()));

				dao.delete(cadastroreserva);

				JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso");

				idCliente.setText("");
				nomeCliente.setText("");
				rgCliente.setText("");
				contatoCliente.setText("");
				numeroQuarto.setText("");
				numeroAndar.setText("");
				statusReserva.setText("");
				inicioReserva.setText("");
				fimReserva.setText("");

				table.setModel(consultarTodosRegistros());

			}
		});

		delete.setBackground(new Color(255, 255, 255));
		delete.setForeground(new Color(220, 20, 60));
		delete.setFont(new Font("Cambria", Font.BOLD, 11));
		delete.setBounds(403, 190, 95, 23);
		panel.add(delete);

		JLabel imagemfundo = DefaultComponentFactory.getInstance().createLabel("");
		imagemfundo.setBounds(737, 8, 298, 137);
		panel.add(imagemfundo);
		imagemfundo.setIcon(new ImageIcon(
				"C:\\Users\\Inmetrics.LP1439\\workspace\\Hotelaria\\src\\test\\resources\\Imagem\\award-winning-crowne-plaza-orlando-universal-hotel.jpg"));
		imagemfundo.setFont(new Font("Cambria", Font.PLAIN, 12));
		imagemfundo.setVerticalAlignment(SwingConstants.TOP);
		imagemfundo.setLabelFor(inserir);

		JPanel resultgrid = new JPanel();
		resultgrid.setBackground(new Color(173, 216, 230));
		resultgrid.setBounds(0, 213, 1035, 328);
		panel.add(resultgrid);
		resultgrid.setLayout(null);

		JScrollPane scrollres = new JScrollPane();
		scrollres.setBounds(10, 11, 1025, 317);
		resultgrid.add(scrollres);

		table = new JTable();
		table.setBackground(new Color(250, 235, 215));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int linha = table.getSelectedRow();

				if (linha > -1) {
					/*
					 * Copia os dados do registro selecionado para os campos
					 * texto
					 */

					idCliente.setText(table.getValueAt(linha, 0).toString());
					nomeCliente.setText(table.getValueAt(linha, 1).toString());
					rgCliente.setText(table.getValueAt(linha, 2).toString());
					contatoCliente.setText(table.getValueAt(linha, 3).toString());
					numeroQuarto.setText(table.getValueAt(linha, 4).toString());
					numeroAndar.setText(table.getValueAt(linha, 5).toString());
					inicioReserva.setText(table.getValueAt(linha, 6).toString());
					fimReserva.setText(table.getValueAt(linha, 7).toString());
					statusReserva.setText(table.getValueAt(linha, 8).toString());

				}
			}
		});
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(this.consultarTodosRegistros());

		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setMinWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setMinWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(98);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setMinWidth(130);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setMinWidth(95);
		scrollres.setViewportView(table);

		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				idCliente.setText("");
				nomeCliente.setText("");
				rgCliente.setText("");
				contatoCliente.setText("");
				numeroQuarto.setText("");
				numeroAndar.setText("");
				statusReserva.setText("");
				inicioReserva.setText("");
				fimReserva.setText("");

			}
		});
		limpar.setBounds(535, 191, 89, 23);
		panel.add(limpar);
	}

	private DefaultTableModel consultarTodosRegistros() {

		CadastroReservaDAO cadastroReservaDAO = new CadastroReservaDAO();
		List<CadastroReserva> listaCadastroReserva = cadastroReservaDAO.getLista();

		DefaultTableModel defaultTableModel = new DefaultTableModel(tituloColunas, 0);
		Object[] coluna = new Object[9];

		for (CadastroReserva cadastroReserva : listaCadastroReserva) {
			coluna[0] = cadastroReserva.getId_cadastro();
			coluna[1] = cadastroReserva.getNomeDoCliente();
			coluna[2] = cadastroReserva.getRg();
			coluna[3] = cadastroReserva.getContato();
			coluna[4] = cadastroReserva.getNumerodoquarto();
			coluna[5] = cadastroReserva.getAndar();
			coluna[6] = cadastroReserva.getDatainiciodareserva();
			coluna[7] = cadastroReserva.getDatafimdareserva();
			coluna[8] = cadastroReserva.getStatus();
			defaultTableModel.addRow(coluna);
		}

		return defaultTableModel;

	}

	private String validarCampos(CadastroReserva cadastroReserva) {

		String mensagemValidacao = "";

		if (cadastroReserva != null) {

			if (cadastroReserva.getNomeDoCliente() != null && cadastroReserva.getNomeDoCliente().isEmpty()) {
				mensagemValidacao = "Nome do cliente não preenchido!";
			} else if (cadastroReserva.getRg() != null && (cadastroReserva.getRg().isEmpty()
					|| "  .   .   - ".equalsIgnoreCase(cadastroReserva.getRg()))) {
				mensagemValidacao = "RG do cliente não preenchido!";
			} else if (cadastroReserva.getContato() != null && cadastroReserva.getContato().isEmpty()
					|| "(  )     -    ".equalsIgnoreCase(cadastroReserva.getContato())) {
				mensagemValidacao = "Contato do cliente não preenchido!";
			} else if (cadastroReserva.getNumerodoquarto() != null && cadastroReserva.getNumerodoquarto().isEmpty()) {
				mensagemValidacao = "Número do Quarto para a reserva, não preenchido!";
			} else if (cadastroReserva.getAndar() != null && cadastroReserva.getAndar().isEmpty()) {
				mensagemValidacao = "número do andar para a reserva, não preenchido!";
			} else if (cadastroReserva.getStatus() != null && cadastroReserva.getStatus().isEmpty()) {
				mensagemValidacao = "Status da reserva, não preenchido!";
			} else if (cadastroReserva.getDatainiciodareserva() != null
					&& cadastroReserva.getDatainiciodareserva().isEmpty()
					|| "  /  /    ".equalsIgnoreCase(cadastroReserva.getDatainiciodareserva())) {
				mensagemValidacao = "Data inicio, não preenchida!";
			} else if (cadastroReserva.getDatafimdareserva() != null && cadastroReserva.getDatafimdareserva().isEmpty()
					|| "  /  /    ".equalsIgnoreCase(cadastroReserva.getDatafimdareserva())) {
				mensagemValidacao = "Data fim, não preenchida!";
			}
		}

		return mensagemValidacao;
	}
}
