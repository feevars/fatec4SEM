package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ListaDupla;
import controller.MetodosAdicionais;
import model.Aluno;
import model.Disciplina;
import model.Media;

public class BarraDeFerramentas extends JPanel implements MetodosAdicionais {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListenerBarraDeFerramentas formListener;

	private JButton btnRemoveAlunoInicio;
	private JButton btnRemoveAlunoPosicao;
	private JButton btnRemoveAlunoFinal;

	private JButton btnRemoveDisciplinaInicio;
	private JButton btnRemoveDisciplinaPosicao;
	private JButton btnRemoveDisciplinaFinal;

	private JButton btnRemoveMediaInicio;
	private JButton btnRemoveMediaPosicao;
	private JButton btnRemoveMediaFinal;

	private JButton btnOrdenarMedias;
	private JButton btnAlunosAprovados;
	private JButton btnAlunosReprovados;

	public BarraDeFerramentas(ListaDupla<Media> listaMedias, ListaDupla<Aluno> listaAlunos,
			ListaDupla<Disciplina> listaDisciplinas) {

		this.btnRemoveAlunoInicio = new JButton("<html>Remover aluno do início da lista</html>");
		this.btnRemoveAlunoPosicao = new JButton("<html>Remover aluno de uma posição determinada</html>");
		this.btnRemoveAlunoFinal = new JButton("<html>Remover aluno do final da lista</html>");
		JPanel painelBtnAluno = new JPanel();
		painelBtnAluno.setLayout(new BoxLayout(painelBtnAluno, BoxLayout.Y_AXIS));
		painelBtnAluno.add(btnRemoveAlunoInicio);
		painelBtnAluno.add(btnRemoveAlunoPosicao);
		painelBtnAluno.add(btnRemoveAlunoFinal);

		this.btnRemoveAlunoInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaAlunos.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					listaAlunos.removePrimeiro();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Primeiro item da lista removido.\nLista de alunos:\n\n" + listaAlunos.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnRemoveAlunoPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaAlunos.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					int posicao = Integer.parseInt(
							JOptionPane.showInputDialog("Digite a posição que deseja remover:\n(não é o id!!!)"));
					if (posicao < 1 || posicao > listaAlunos.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição que você digitou não existe.");
					} else {
						if (posicao == 1) {

							listaAlunos.removePrimeiro();
						} else if (posicao == listaAlunos.getQtdNo()) {
							listaAlunos.removeUltimo();
						} else {
							listaAlunos.removePosicao(posicao);
						}
						EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this, "O item " + posicao
								+ " da lista foi removido.\nLista de alunos:\n\n" + listaAlunos.listaString());
						formListener.FormEventOcurred(ev);
					}
				}
			}
		});

		this.btnRemoveAlunoFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaAlunos.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					listaAlunos.removeUltimo();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Último item da lista removido.\nLista de alunos:\n\n" + listaAlunos.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnRemoveDisciplinaInicio = new JButton("<html>Remover disciplina do início da lista</html>");
		this.btnRemoveDisciplinaPosicao = new JButton("<html>Remover disciplina de uma posição determinada</html>");
		this.btnRemoveDisciplinaFinal = new JButton("<html>Remover disciplina do final da lista</html>");
		JPanel painelBtnDisciplina = new JPanel();
		painelBtnDisciplina.setLayout(new BoxLayout(painelBtnDisciplina, BoxLayout.Y_AXIS));
		painelBtnDisciplina.add(btnRemoveDisciplinaInicio);
		painelBtnDisciplina.add(btnRemoveDisciplinaPosicao);
		painelBtnDisciplina.add(btnRemoveDisciplinaFinal);

		this.btnRemoveDisciplinaInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaDisciplinas.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					listaDisciplinas.removePrimeiro();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Primeiro item da lista removido.\nLista de disciplinas:\n\n"
									+ listaDisciplinas.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnRemoveDisciplinaPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaDisciplinas.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					int posicao = Integer.parseInt(
							JOptionPane.showInputDialog("Digite a posição que deseja remover:\n(não é o id!!!)"));
					if (posicao < 1 || posicao > listaDisciplinas.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição que você digitou não existe.");
					} else {
						if (posicao == 1) {

							listaDisciplinas.removePrimeiro();
						} else if (posicao == listaDisciplinas.getQtdNo()) {
							listaDisciplinas.removeUltimo();
						} else {
							listaDisciplinas.removePosicao(posicao);
						}
						EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
								"O item " + posicao + " da lista foi removido.\nLista de disciplinas:\n\n"
										+ listaDisciplinas.listaString());
						formListener.FormEventOcurred(ev);
					}
				}
			}
		});

		this.btnRemoveDisciplinaFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaDisciplinas.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					listaDisciplinas.removeUltimo();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Último item da lista removido.\nLista de disciplinas:\n\n"
									+ listaDisciplinas.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnRemoveMediaInicio = new JButton("<html>Remover média do início da lista</html>");
		this.btnRemoveMediaPosicao = new JButton("<html>Remover média de uma posição determinada</html>");
		this.btnRemoveMediaFinal = new JButton("<html>Remover média do final da lista</html>");
		JPanel painelBtnMedia = new JPanel();
		painelBtnMedia.setLayout(new BoxLayout(painelBtnMedia, BoxLayout.Y_AXIS));
		painelBtnMedia.add(btnRemoveMediaInicio);
		painelBtnMedia.add(btnRemoveMediaPosicao);
		painelBtnMedia.add(btnRemoveMediaFinal);

		this.btnRemoveMediaInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaMedias.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					listaMedias.removePrimeiro();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Primeiro item da lista removido.\nLista de media:\n\n" + listaMedias.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnRemoveMediaPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaMedias.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					int posicao = Integer.parseInt(
							JOptionPane.showInputDialog("Digite a posição que deseja remover:\n(não é o id!!!)"));
					if (posicao < 1 || posicao > listaMedias.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição que você digitou não existe.");
					} else {
						if (posicao == 1) {

							listaMedias.removePrimeiro();
						} else if (posicao == listaMedias.getQtdNo()) {
							listaMedias.removeUltimo();
						} else {
							listaMedias.removePosicao(posicao);
						}
						EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this, "O item " + posicao
								+ " da lista foi removido.\nLista de medias:\n\n" + listaMedias.listaString());
						formListener.FormEventOcurred(ev);
					}
				}
			}
		});

		this.btnRemoveMediaFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaMedias.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível remover.");
				} else {
					listaMedias.removeUltimo();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Último item da lista removido.\nLista de alunos:\n\n" + listaMedias.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnOrdenarMedias = new JButton("<html>Ordenar médias</html>");
		this.btnAlunosAprovados = new JButton("<html>Exibir alunos aprovados</html>");
		this.btnAlunosReprovados = new JButton("<html>Exibir alunos reprovados</html>");
		JPanel painelBtnOutrosMetodos = new JPanel();
		painelBtnOutrosMetodos.setLayout(new BoxLayout(painelBtnOutrosMetodos, BoxLayout.Y_AXIS));
		painelBtnOutrosMetodos.add(btnOrdenarMedias);
		painelBtnOutrosMetodos.add(btnAlunosAprovados);
		painelBtnOutrosMetodos.add(btnAlunosReprovados);

		this.btnOrdenarMedias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaMedias.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, impossível ordenar médias.");
				} else {
					Media[] vetorMedias = new Media[listaMedias.getQtdNo()];
					vetorMedias = MetodosAdicionais.ListaDuplaVetorMedias(listaMedias, vetorMedias);
					MetodosAdicionais.mergeSortMedias(vetorMedias);
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this, "Lista de médias ordenadas:\n\n"
							+ MetodosAdicionais.vetorMediasPrint(vetorMedias, listaAlunos, listaDisciplinas));
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.btnAlunosAprovados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaMedias.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, nada a exibir.");
				} else {
					Media[] vetorMedias = new Media[listaMedias.getQtdNo()];
					vetorMedias = MetodosAdicionais.ListaDuplaVetorMedias(listaMedias, vetorMedias);
					MetodosAdicionais.mergeSortMedias(vetorMedias);
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this, "Lista de alunos aprovados:\n\n"
							+ MetodosAdicionais.alunosAprovados(vetorMedias, listaAlunos, listaDisciplinas));
					formListener.FormEventOcurred(ev);
				}
			}
		});
		
		this.btnAlunosReprovados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaMedias.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia, nada a exibir.");
				} else {
					Media[] vetorMedias = new Media[listaMedias.getQtdNo()];
					vetorMedias = MetodosAdicionais.ListaDuplaVetorMedias(listaMedias, vetorMedias);
					MetodosAdicionais.mergeSortMedias(vetorMedias);
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this, "Lista de alunos reprovados:\n\n"
							+ MetodosAdicionais.alunosReprovados(vetorMedias, listaAlunos, listaDisciplinas));
					formListener.FormEventOcurred(ev);
				}
			}
		});

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(painelBtnAluno);
		this.add(painelBtnDisciplina);
		this.add(painelBtnMedia);
		this.add(painelBtnOutrosMetodos);
	}

	public void setFormListener(ListenerBarraDeFerramentas listener) {
		this.formListener = listener;
	}
}