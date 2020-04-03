package training.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.spring.entity.Utente;
@Transactional(rollbackFor = Exception.class)
@Repository
public class UtenteDAOImpl implements UtenteDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findAllUtente() {
		List<Utente> result = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();			
			CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);
			Root<Utente> root = cq.from(Utente.class);
			cq.select(root);
			Query query = session.createQuery(cq);
			result = query.getResultList();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addUtente(Utente utente) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			 session.saveOrUpdate(utente);
			 transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	   
	}

	@Override
	public Utente findById(int id) {
		Session session = null;
		Transaction transaction = null;
		Utente utente = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			utente = session.get(Utente.class,id);
			transaction.commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteUtente(int id) {
		Session session = null;
		Transaction transaction = null;
		Utente utente = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			utente = session.byId(Utente.class).load(id);
			session.delete(utente);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			try {
				session.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

	/*@Override
	public Utente login(String nome, String cognome) {
		Session session = null;
		Transaction transaction = null;
		Utente utente = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);
		Root<Utente> root = cq.from(Utente.class);
		Predicate nomeUtente = cb.equal(root.get("nome"), nome);
		Predicate cognomeUtente = cb.equal(root.get("cognome"), cognome);
		cq.where(nomeUtente, cognomeUtente);
		TypedQuery<Utente> query = session.createQuery(cq);
		utente = query.getSingleResult() ;
		return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}*/

	@Override
	public void update(Utente utente) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(utente);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

	@Override
	public Utente findByUsername(String username) {
		Session session = null;
		Transaction transaction = null;
		Utente utente = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);
		Root<Utente> root = cq.from(Utente.class);
		Predicate user = cb.equal(root.get("username"), username);
		cq.where(user);
		TypedQuery<Utente> query = session.createQuery(cq);
		utente = query.getSingleResult() ;
		return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
