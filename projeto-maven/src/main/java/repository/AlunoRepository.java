package repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import model.Aluno;

@Stateful
public class AlunoRepository {

	private static List<Aluno> listaAlunos = new ArrayList<>();

	public List<Aluno> listar() {
		return listaAlunos;
	}

	public Aluno consultar(Integer id) {
		for(Aluno aluno: listaAlunos) {
			if(aluno.getId().intValue() == id) {
				return aluno;
			}
		}
		return null;
	}

	public int cadastrar(Aluno novo) {
		int maxId = listaAlunos.size() + 1;
		novo.setId(maxId);
		listaAlunos.add(novo);
		return novo.getId();
	}

	public Aluno atualizar(Aluno aluno) {	
		listaAlunos.add(aluno);		
		return aluno;
	}

	public void remover(Aluno aluno) throws Exception {
		Aluno atual = this.consultar(aluno.getId());
		if(atual == null)
			throw new Exception("Funcionário não encontrado");

		listaAlunos.remove(atual);
	}

	public Aluno consultar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}