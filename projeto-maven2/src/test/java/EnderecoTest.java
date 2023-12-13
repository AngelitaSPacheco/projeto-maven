import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import model.Endereco;
import repository.EnderecoRepository;

public class EnderecoTest {
	

	private EnderecoRepository enderecoRepository = new EnderecoRepository();
	private Gson gson = new Gson();
	
	@Test
	public void cadastrar() {
		Endereco novo = new Endereco();
		novo.setId(1);
		novo.setLogradouro("rua");
		novo.setBairro("Centro");
		novo.setNumero(10);
		novo.setMunicipio("Imbituba");
		novo.setEstado("SC");
		novo.setCep(1234);
		int id = this.enderecoRepository.cadastrar(novo);
		System.out.println(String.format("ID registrado: %d", id));
		Assert.assertTrue(id > 0);
	}
	
	@Test
	public void atualizar() {
		Endereco novo = new Endereco();
		novo.setId(1);
		novo.setLogradouro("rua");
		novo.setBairro("Centro");
		novo.setNumero(10);
		novo.setMunicipio("Imbituba");
		novo.setEstado("SC");
		novo.setCep(1234);;
		Endereco atualizado = this.enderecoRepository.atualizar(novo);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
	}
	
	@Test
	public void listar() {
		this.cadastrar();
		List<Endereco> lista = this.enderecoRepository.listar();		
		System.out.println(this.gson.toJson(lista));
	}
	
	@Test
	public void consultar() {
		this.cadastrar();
		Endereco endereco = this.enderecoRepository.consultar(1);		
		System.out.println(this.gson.toJson(endereco));
		Assert.assertTrue(endereco != null);
	}
	
	@Test
	public void remover() throws Exception {
		this.cadastrar();
		Endereco endereco = new Endereco();
		endereco.setId(1);
		this.enderecoRepository.remover(endereco);	
	}

}
