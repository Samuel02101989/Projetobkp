package br.com.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.clinica.model.Agenda;
import br.com.clinica.model.Medico;

public class AgendaDao {
	// Parte do codigo para efetuar a persisençia no banco de dados com JPA
	
		private static AgendaDao instance;
		protected EntityManager entityManager;
		
		public static AgendaDao getInstance(){
			if(instance == null){
				 instance = new AgendaDao ();
			}
			
			return instance;
		}
		
		public AgendaDao(){
			entityManager = getEntityManager();
		}
		
		private EntityManager getEntityManager(){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica");
			 if(entityManager == null){
				 entityManager = factory.createEntityManager();
			 }
			 
			 return entityManager;
		}
		
//		find() chamando o EntityManager passando o tipo de classe o id que deve ser buscado, ja traz um objeto agenda
	     public Agenda getByidAgenda(final Long idAgenda){
                Agenda agenda = new Agenda();
                
	    	 try{
	    	 if(idAgenda!=null && !idAgenda.toString().isEmpty()){	 
	    	 String jpql = "select a from Agenda a where a.idAgenda = :idagenda";
	    	 Query query = entityManager.createQuery(jpql);
	    	 query.setParameter("idagenda", idAgenda);
	    	 List <Agenda> agendaResutl = query.getResultList();
	    	 agenda = agendaResutl.get(0);
	      }
	    	 }catch (Exception e){
	    		   e.printStackTrace();
	    		   JOptionPane.showMessageDialog(null, "CRM inexistente!!");
	        	}
	    	 
	    	 return agenda;
	   }
	     public List<Agenda>findAll(){
	    	 return entityManager.createQuery("FROM" + Agenda.class.getName()).getResultList();
	    }
	     
	     
	     
	//  usa as configurações presentes no arquivo persistence.xml para criar uma instância de EntityManagerFactory. 
	//  Depois disso verificamos se o atributo entityManager é nulo, ou seja, nunca foi criado, 
	//  sendo assim usamos o createEntityManager() para criar uma instância de EntityManager que é responsável 
	//  por realizar as operações de CRUD no banco de dados.   
		
	     public void persist(Agenda agenda){
	    	 try {
	    		 entityManager.getTransaction().begin();
	    		 entityManager.persist(agenda);
	    		 entityManager.getTransaction().commit();
				
			} catch (Exception e) {
				/*
				 * printStackTrace() exception padrão para erros de leitura e gravação. Você está a capturando e 
				 * usando o método printStackTrace() para, se houver algo errado, ele escrever no console o tal erro.
				 */
				e.printStackTrace();
				entityManager.getTransaction().rollback();
			}
	     }
		
	/*    o metodo merge segue o mesmo principio do metodo persist(), a unica diferença é que a merge
	 *    atualiza o registro e nao apenas insere no banco. Mas seo registro nao existir no banco
	 *    usando esse metodo ele ira inserir o mesmo,
	 */
	     public void merge(Agenda agenda){
	    	 try {
	    		 entityManager.getTransaction().begin();
	    		 entityManager.merge(agenda);
	    		 entityManager.getTransaction().commit();
				
			} catch (Exception e) {
	/*
	 * printStackTrace() exception padrão para erros de leitura e gravação. Você está a capturando e 
	 * usando o método printStackTrace() para, se houver algo errado, ele escrever no console o tal erro.
	 */
				e.printStackTrace();
				entityManager.getTransaction().rollback();
			}
	     }
	     
	     /*primeiro procura no banco de dados para só entao remover.
	      * o removebyId() recebe o id que deve ser removido enquanto que o remove
	      * recebe o objeto.
	      */
	     
	     public void remove(Agenda agenda){
	    	 try {
	    		 entityManager.getTransaction().begin();
	    		 agenda = entityManager.find(Agenda.class, agenda.getIdAgenda());
	    		 entityManager.remove(agenda);
	    		 entityManager.getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
			}
	     }
	     
	     public void removeById(final Long idAgenda){
	    	 try {
				Agenda agenda = getByidAgenda(idAgenda);
				remove(agenda);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	 
	     }
}
