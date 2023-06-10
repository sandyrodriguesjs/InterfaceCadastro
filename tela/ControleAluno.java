package tela;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControleAluno {

	private List<Aluno> alunos;
	private DefaultTableModel tableModel;

	public ControleAluno(List<Aluno> alunos, DefaultTableModel tableModel) {
		this.alunos = alunos;
		this.tableModel = tableModel;
	}

	public void listarAlunos() {
		// Limpa a tabela antes de listar os alunos
		tableModel.setRowCount(0);

		// Lista os alunos na tabela
		for (Aluno aluno : alunos) {
			Object[] row = { aluno.getNome(), aluno.getCpf(), aluno.getMatricula(), aluno.getVertente() };
			tableModel.addRow(row);
		}
	}

	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
}
