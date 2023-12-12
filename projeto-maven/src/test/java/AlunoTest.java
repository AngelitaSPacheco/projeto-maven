import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoTest {
	
	private AlunoRepository alunoRepository = new AlunoRepository();
	private Gson gson = new Gson();
	
	@Test
	public void cadastrar() {
		Aluno novo = new Aluno();
		novo.setId(1);
		novo.setNome("Angelita");
		novo.setSobrenome("Pacheco");
		novo.setIdade(18);
		novo.setSerie("1° ano");
		novo.setSexo("F");
		int id = this.alunoRepository.cadastrar(novo);
		System.out.println(String.format("ID registrado: %d", id));
		Assert.assertTrue(id > 0);
	}
	
	@Test
	public void atualizar() {
		Aluno novo = new Aluno();
		novo.setId(1);
		novo.setNome("Angelita");
		novo.setSobrenome("de Souza Pacheco");
		novo.setIdade(18);
		novo.setSerie("1° ano");
		novo.setSexo("F");
		Aluno atualizado = this.alunoRepository.atualizar(novo);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
	}
	
	@Test
	public void listar() {
		this.cadastrar();
		List<Aluno> lista = this.alunoRepository.listar();		
		System.out.println(this.gson.toJson(lista));
	}
	
	@Test
	public void consultar() {
		this.cadastrar();
		Aluno aluno = this.alunoRepository.consultar(1);		
		System.out.println(this.gson.toJson(aluno));
		Assert.assertTrue(aluno != null);
	}
	
	@Test
	public void remover() throws Exception {
		this.cadastrar();
		Aluno aluno = new Aluno();
		aluno.setId(1);
		this.alunoRepository.remover(aluno);	
	}

}
