package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroAluno extends JFrame {

	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField matriculaField;
	private JTextField vertenteField;
	private View view;

	public CadastroAluno(View view) {
		this.view = view;

		// Configurações da janela
		setTitle("Cadastro de Aluno");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 2));

		// Campos de texto
		JLabel nomeLabel = new JLabel("Nome:");
		nomeField = new JTextField();

		JLabel cpfLabel = new JLabel("CPF:");
		cpfField = new JTextField();

		JLabel matriculaLabel = new JLabel("Matrícula:");
		matriculaField = new JTextField();

		JLabel vertenteLabel = new JLabel("Vertente:");
		vertenteField = new JTextField();

		// Botão Cadastrar
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarAluno();
			}
		});

		// Adiciona os componentes à janela
		add(nomeLabel);
		add(nomeField);
		add(cpfLabel);
		add(cpfField);
		add(matriculaLabel);
		add(matriculaField);
		add(vertenteLabel);
		add(vertenteField);
		add(new JLabel());
		add(cadastrarButton);
	}

	public void mostrar() {
		setVisible(true);
	}

	private void cadastrarAluno() {
		String nome = nomeField.getText();
		String cpf = cpfField.getText();
		String matricula = matriculaField.getText();
		String vertente = vertenteField.getText();

		Aluno aluno = new Aluno(nome, cpf, matricula, vertente);
		view.adicionarAluno(aluno);
		JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");

		// Limpa os campos de texto após o cadastro
		nomeField.setText("");
		cpfField.setText("");
		matriculaField.setText("");
		vertenteField.setText("");
	}
}
