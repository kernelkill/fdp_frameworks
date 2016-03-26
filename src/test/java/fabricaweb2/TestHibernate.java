package fabricaweb2;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
		//Fabrica de EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricaweb2");
		
		//Gerenciador de Entidade
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		usu.setNome("Jao");
		usu.setLogin("jj");
		usu.setSenha("123");
		
		em.getTransaction().begin();
		
		em.persist(usu);
		
		em.getTransaction().commit();

	}

}
