package repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import model.Endereco;

@Stateful
public class EnderecoRepository {

	private static List<Endereco> listaEnderecos = new ArrayList<>();

	public List<Endereco> listar() {
		return listaEnderecos;
	}

	public Endereco consultar(Integer id) {
		for(Endereco endereco: listaEnderecos) {
			if(endereco.getId().intValue() == id) {
				return endereco;
			}
		}
		return null;
	}

	public int cadastrar(Endereco novo) {
		int maxId = listaEnderecos.size() + 1;
		novo.setId(maxId);
		listaEnderecos.add(novo);
		return novo.getId();
	}

	public Endereco atualizar(Endereco endereco) {	
		listaEnderecos.add(endereco);		
		return endereco;
	}

	public void remover(Endereco endereco) throws Exception {
		Endereco atual = this.consultar(endereco.getId());
		if(atual == null)
			throw new Exception("Endereço não encontrado");

		listaEnderecos.remove(atual);
	}
}