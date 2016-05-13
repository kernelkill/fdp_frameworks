package fabricaweb2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.dao.UsuarioDAOJPA;
import br.com.fabricadeprogramador.entidade.Usuario;
import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration

public class TestUsuarioDAO2 {
	
	@Autowired
	UsuarioDAO usuarioDAO; 
	
	
	@Test
	public void testSalvar(){
		
		//Criando novo usuario
		Usuario usu = new Usuario();
		usu.setNome("Antonio Manoel");
		usu.setLogin("manu");
		usu.setSenha("123456789987");
	
		usuarioDAO.salvar(usu);
	}
	
	
	@Test
	public void testBuscaPorID(){
		
		Usuario usu = new Usuario();
		usu.setNome("Marcos");
		usu.setLogin("marcostest");
		usu.setSenha("testsenha");
		
		Usuario usuSalvo = usuarioDAO.salvar(usu);
		Integer idSalvo = usuSalvo.getId();
		
		Usuario usuBuscado = usuarioDAO.buscarPorId(idSalvo);
		
		Assert.assertEquals(usuSalvo, usuBuscado);
		
	}
	
	@Test
	@Transactional
	public void testeExcluir() throws DAOException{
		//criar um novo usuario
		Usuario usu = new Usuario();
		usu.setNome("Joabe kachorroski");
		usu.setLogin("kachorroski");
		usu.setSenha("122222");
		
		//Salvar Usuario no teste
		Usuario usuSalvo =  usuarioDAO.salvar(usu);
		
		//Buscar por ID
		//Usuario usuExc =  usuarioDAO.buscarPorId(usuSalvo.getId());
		
		//Excluir Usuario
		usuarioDAO.excluir(usuSalvo);
		
		//Buscar usuario escluido por ID
		Usuario usuExcluido =  usuarioDAO.buscarPorId(usuSalvo.getId());
		
		//Verificar se o objeto ainda permanece no banco, se não entao o Teste esta OK
		Assert.assertEquals(usuExcluido, null);
	}
	
	@Test
	public void testeBuscarTodos(){
		
		//criar um novo usuario
		Usuario usu = new Usuario();
		usu.setNome("Joabe kachorroski");
		usu.setLogin("kachorroski");
		usu.setSenha("122222");
		
		//Salvar Usuario no teste
		usuarioDAO.salvar(usu);
		
		//Buscar todos
		List<Usuario> todos = usuarioDAO.buscarTodos();
		
		//Testa pra ver se esta me retornando um banco vazio ou nao.
		Assert.assertTrue(todos.size()>0);		
	}
}
