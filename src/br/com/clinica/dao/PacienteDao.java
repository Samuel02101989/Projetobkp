package br.com.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.clinica.model.Paciente;


public class PacienteDao {
	private static PacienteDao instance;
	protected EntityManager entityManager;

	public static PacienteDao getInstance() {
		if (instance == null) {
			instance = new PacienteDao();
		}

		return instance;
	}

	public PacienteDao() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	// find() chamando o EntityManager passando o tipo de classe o id que deve
	// ser buscado, ja traz um objeto medico

	public Paciente getById(final int idPaciente) {
		return entityManager.find(Paciente.class, idPaciente);
	}

	public Paciente getByCpf(final String cpf) {
		Paciente paciente = new Paciente();
		
		try {
		if (cpf != null && !cpf.isEmpty()) {
			String jpql = "select p from Paciente p where p.cpf = :cpf";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("cpf", cpf);
			List<Paciente> pacienteResult = query.getResultList();

			paciente = pacienteResult.get(0);
		}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CPF inexistente!!!");
		}
		return paciente;

	}

	public List<Paciente> findAll() {
		return entityManager.createQuery("FROM" + Paciente.class.getName()).getResultList();
	}

	// usa as configurações presentes no arquivo persistence.xml para criar uma
	// instância de EntityManagerFactory.
	// Depois disso verificamos se o atributo entityManager é nulo, ou seja,
	// nunca foi criado,
	// sendo assim usamos o createEntityManager() para criar uma instância de
	// EntityManager que é responsável
	// por realizar as operações de CRUD no banco de dados.

	public void persist(Paciente paciente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(paciente);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			/*
			 * printStackTrace() exception padrão para erros de leitura e
			 * gravação. Você está a capturando e usando o método
			 * printStackTrace() para, se houver algo errado, ele escrever no
			 * console o tal erro.
			 */
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * o metodo merge segue o mesmo principio do metodo persist(), a unica
	 * diferença é que a merge atualiza o registro e nao apenas insere no banco.
	 * Mas se registro nao existir no banco usando esse metodo ele ira inserir
	 * o mesmo,
	 */
	public void merge(Paciente paciente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(paciente);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			/*
			 * printStackTrace() exception padrão para erros de leitura e
			 * gravação. Você está a capturando e usando o método
			 * printStackTrace() para, se houver algo errado, ele escrever no
			 * console o tal erro.
			 */
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * primeiro procura no banco de dados para só entao remover. o removebyId()
	 * recebe o id que deve ser removido enquanto que o remove recebe o objeto.
	 */

	public void remove(Long Idpaciente) {
		EntityManager em = getEntityManager();
		Paciente paciente = em.find(Paciente.class, Idpaciente);
		try {
			em.getTransaction().begin();
			em.remove(paciente);//executa remove
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erroo");
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int idPaciente) {
		try {
			Paciente paciente = getById(idPaciente);
			//remove(paciente);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ");
		}

	}


	}


