package fabricaweb2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
//		//Fabrica de EntityManager
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricaweb2");
//		
//		//Gerenciador de Entidade
//		EntityManager em = emf.createEntityManager();
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf =   (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		Usuario usu = new Usuario();
		usu.setNome("Maria da Silva");
		usu.setLogin("marisil");
		usu.setSenha("789456");
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		usuarioDAO.salvar(usu);
		
		
//		Usuario usuExcluir = usuarioDAO.buscarPorId(2);
//		usuarioDAO.excluir(usuExcluir);
		
//		List<Usuario> usuListar = usuarioDAO.buscarTodos();
//		for (Usuario usuario : usuListar) {
//			System.out.println(usuario.toString());
//		}
		
//		Usuario usuModificar = usuarioDAO.buscarPorId(1);
//		usuModificar.setLogin("kachorroski");
//		usuModificar.setNome("Joabe");
//		usuarioDAO.salvar(usuModificar);	
		
//		System.out.println(usuExcluir + "foi excluido com sucesso!");
	}

}
