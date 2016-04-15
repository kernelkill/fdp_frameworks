package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.entidade.Usuario;


public class UsuarioDAO {

	
	EntityManager em;	
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}

	//Insert ou Update
	public Usuario salvar(Usuario usuario){
		em.getTransaction().begin();
		Usuario u =  em.merge(usuario);
		em.getTransaction().commit();
		return u;
	}
	
	public void excluir(Usuario usuario){
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public  Usuario buscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarTodos(){
		Query q = em.createQuery("select u from Usuario u");
		
		return q.getResultList();
	}
	

}
