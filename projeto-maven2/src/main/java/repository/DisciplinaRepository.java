package repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import model.Disciplina;

@Stateful
public class DisciplinaRepository {
	
	private static List<Disciplina> listaDisciplinas = new ArrayList<>();

	public List<Disciplina> listar() {
		return listaDisciplinas;
	}

	public Disciplina consultar(Integer id) {
		for(Disciplina disciplina: listaDisciplinas) {
			if(disciplina.getId().intValue() == id) {
				return disciplina;
			}
		}
		return null;
	}

	public int cadastrar(Disciplina nova) {
		int maxId = listaDisciplinas.size() + 1;
		nova.setId(maxId);
		listaDisciplinas.add(nova);
		return nova.getId();
	}

	public Disciplina atualizar(Disciplina disciplina) {	
		listaDisciplinas.add(disciplina);		
		return disciplina;
	}
	
	public void remover(Disciplina disciplina) throws Exception {
		Disciplina atual = this.consultar(disciplina.getId());
		if(atual == null)
			throw new Exception("Disciplina não encontrada");
		
		listaDisciplinas.remove(atual);
	}
}
