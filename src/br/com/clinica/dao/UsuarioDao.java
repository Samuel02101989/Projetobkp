package br.com.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.security.auth.login.LoginContext;
import javax.swing.JOptionPane;

import com.mysql.jdbc.log.Log;

import br.com.clinica.model.Paciente;
import br.com.clinica.model.Usuario;
import br.com.clinica.view.TelaLoginClinica;

public class UsuarioDao {
	// Parte do codigo para efetuar a persisençia no banco de dados com JPA
	
	private static UsuarioDao instance;
	protected EntityManager entityManager;
	
	public static UsuarioDao getInstance(){
		if(instance == null){
			instance = new UsuarioDao();
		}
		return instance;
	}
	
	public UsuarioDao(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica");
		 if(entityManager == null){
			 entityManager = factory.createEntityManager();
		 }
		 
		 return entityManager;
	}
	
	public Usuario getById(final int idUsuario) {
		return entityManager.find(Usuario.class, idUsuario);
	}
	
//	find() chamando o EntityManager passando o tipo de classe o id que deve ser buscado, ja traz um objeto medico
	
	public boolean getByLogo(String loginUsuario, String senhaUsuario){
		       
			if((loginUsuario != null && !loginUsuario.isEmpty())   && (senhaUsuario != null && !senhaUsuario.isEmpty())){
				
				String login = loginUsuario.trim().toLowerCase();
				String senha = senhaUsuario.trim().toLowerCase();
				
				String jpql = "select u from Usuario u where u.loginUsuario = :user AND u.senhaUsuario = :senha";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("user", login);
				query.setParameter("senha", senha);
		
		        List<Usuario> usuarioResult = query.getResultList();
		        if(usuarioResult.get(0) != null){
		        	return true;
		        	
		        }else{
		        	return false;
		        }
			}
		return false;
}

//	lista os dados da tabela
	
	public List<Usuario> findAll(){
		return entityManager.createQuery("FROM" + Usuario.class.getName()).getResultList();
	}
	
//  usa as configurações presentes no arquivo persistence.xml para criar uma instância de EntityManagerFactory. 
//  Depois disso verificamos se o atributo entityManager é nulo, ou seja, nunca foi criado, 
//  sendo assim usamos o createEntityManager() para criar uma instância de EntityManager que é responsável 
//  por realizar as operações de CRUD no banco de dados.
	
	public void persist(Usuario usuario){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			
			/*
			 * printStackTrace() exception padrão para erros de leitura e gravação. Você está a capturando e 
			 * usando o método printStackTrace() para, se houver algo errado, ele escrever no console o tal erro.
			 */
			
			e.printStackTrace();
			entityManager.getTransaction().getRollbackOnly();
		}
	}
	
	
	/*    o metodo merge segue o mesmo principio do metodo persist(), a unica diferença é que a merge
	 *    atualiza o registro e nao apenas insere no banco. Mas seo registro nao existir no banco
	 *    usando esse metodo ele ira inserir o mesmo,
	 */
	
	public void merge(Usuario usuario){
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
		
	
	/*primeiro procura no banco de dados para só entao remover.
     * o removebyId() recebe o id que deve ser removido enquanto que o remove
     * recebe o objeto.
     */
	
		public void remove(Usuario usuario){
			
			try {
				entityManager.getTransaction().begin();
				usuario = entityManager.find(Usuario.class, usuario.getIdUsuario());
				entityManager.remove(usuario);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
			}
		}
		
		public void removeById(final int idUsuario){
			try {
				Usuario usuario = getById(idUsuario);
				remove(usuario);
				
			} catch (Exception e) {
		      e.printStackTrace();
			}
		}
		
		
	}

