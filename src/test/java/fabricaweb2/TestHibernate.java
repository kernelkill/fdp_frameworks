package fabricaweb2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
		//Fabrica de EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricaweb2");
		
		//Gerenciador de Entidade
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		usu.setNome("Joabe");
		usu.setLogin("jbk");
		usu.setSenha("12345");
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
//		Usuario usuExcluir = usuarioDAO.buscarPorId(2);
//		usuarioDAO.excluir(usuExcluir);
		
//		List<Usuario> usuListar = usuarioDAO.buscarTodos();
//		for (Usuario usuario : usuListar) {
//			System.out.println(usuario.toString());
//		}
		
		Usuario usuModificar = usuarioDAO.buscarPorId(1);
		usuModificar.setLogin("kachorroski");
		usuModificar.setNome("Joabe");
		usuarioDAO.salvar(usuModificar);	
		
//		System.out.println(usuExcluir + "foi excluido com sucesso!");
	}

}
