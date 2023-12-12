import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import model.Disciplina;
import repository.DisciplinaRepository;

public class DisciplinaTest {
	
	private DisciplinaRepository disciplinaRepository = new DisciplinaRepository();
	private Gson gson = new Gson();
	
	@Test
	public void cadastrar() {
		Disciplina novo = new Disciplina();
		novo.setId(1);
		novo.setDescricao("-----");
		novo.setProfessor("Miguel");
		int id = this.disciplinaRepository.cadastrar(novo);
		System.out.println(String.format("ID registrado: %d", id));
		Assert.assertTrue(id > 0);
	}
	
	@Test
	public void atualizar() {
		Disciplina novo = new Disciplina();
		novo.setId(1);
		novo.setDescricao("-----");
		novo.setProfessor("Thaiana");
		Disciplina atualizado = this.disciplinaRepository.atualizar(novo);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
	}
	
	@Test
	public void listar() {
		this.cadastrar();
		List<Disciplina> lista = this.disciplinaRepository.listar();		
		System.out.println(this.gson.toJson(lista));
	}
	
	@Test
	public void consultar() {
		this.cadastrar();
		Disciplina disciplina = this.disciplinaRepository.consultar(1);		
		System.out.println(this.gson.toJson(disciplina));
		Assert.assertTrue(disciplina != null);
	}
	
	@Test
	public void remover() throws Exception {
		this.cadastrar();
		Disciplina disciplina = new Disciplina();
		disciplina.setId(1);
		this.disciplinaRepository.remover(disciplina);	
	}

}
