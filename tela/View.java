package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {

    private List<Aluno> alunos;
    private DefaultTableModel tableModel;
    private JTable table;
    private ControleAluno controleAluno;

    public View() {
        // Configurações da janela
        setTitle("Página Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal com cor de fundo rosa claro
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 228, 225)); // Define a cor de fundo do painel como rosa claro
        panel.setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 228, 225)); // Define a cor de fundo da janela como rosa claro
        add(panel);

        // Tabela de alunos
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Matrícula");
        tableModel.addColumn("Vertente");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(255, 228, 225)); // Define a cor de fundo da tabela como rosa claro
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão Cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(0, 200, 0)); // Define a cor do botão como verde
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroAluno form = new CadastroAluno(View.this);
                form.mostrar();
            }
        });

        // Botão Listar
        JButton listarButton = new JButton("Listar");
        listarButton.setBackground(new Color(0, 0, 200)); // Define a cor do botão como azul
        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleAluno.listarAlunos();
            }
        });

        // Botão Atualizar
        JButton atualizarButton = new JButton("Atualizar");
        atualizarButton.setBackground(new Color(255, 255, 0)); // Define a cor do botão como amarelo
        atualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarAluno();
            }
        });

        // Botão Deletar
        JButton deletarButton = new JButton("Deletar");
        deletarButton.setBackground(new Color(255, 0, 0)); // Define a cor do botão como vermelho
        deletarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletarAluno();
            }
        });

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(255, 228, 225)); // Define a cor de fundo do painel como rosa claro
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(listarButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(deletarButton);
        panel.add(buttonPanel, BorderLayout.NORTH);

        // Exibe a janela
        setVisible(true);

        // Inicializa a lista de alunos
        alunos = new ArrayList<>();

        // Inicializa o controller de alunos
        controleAluno = new ControleAluno(alunos, tableModel);
    }

    private void deletarAluno() {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do aluno a ser deletado:");

        boolean alunoEncontrado = false;
        Aluno alunoRemovido = null;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoEncontrado = true;
                alunoRemovido = aluno;
                break;
            }
        }

        if (alunoEncontrado) {
            alunos.remove(alunoRemovido);
            controleAluno.listarAlunos();
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
        }
    }

    private void atualizarAluno() {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do aluno:");

        boolean alunoEncontrado = false;
        Aluno alunoAtualizado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoEncontrado = true;
                alunoAtualizado = aluno;
                break;
            }
        }

        if (alunoEncontrado) {
            String novaVertente = JOptionPane.showInputDialog("Digite a nova vertente do aluno:");

            alunoAtualizado.setVertente(novaVertente);
            controleAluno.listarAlunos();
            JOptionPane.showMessageDialog(null, "Dados do aluno atualizados com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
        }
    }

    public void adicionarAluno(Aluno aluno) {
        controleAluno.adicionarAluno(aluno);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new View();
            }
        });
    }
}
