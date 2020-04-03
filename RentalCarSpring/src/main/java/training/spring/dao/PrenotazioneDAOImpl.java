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

import training.spring.entity.Auto;
import training.spring.entity.Prenotazione;
import training.spring.entity.Utente;
@Repository
@Transactional(rollbackFor = Exception.class)
public class PrenotazioneDAOImpl implements PrenotazioneDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void aggiungiPrenotazione(Prenotazione p) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(p);
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
	public void rimuoviPrenotazione(int id) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione p = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			p = session.get(Prenotazione.class, id);
			session.delete(p);
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
	public void accettaPrenotazione(Prenotazione p) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();;
			session.update(p);
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
	public void rifiutaPrenotazione(Prenotazione p) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(p);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Prenotazione> findAllPrenotazioni() {
		List<Prenotazione> result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();			
			CriteriaQuery<Prenotazione> cq = cb.createQuery(Prenotazione.class);
			Root<Prenotazione> root = cq.from(Prenotazione.class);
			cq.select(root);
			Query query = session.createQuery(cq);
			result = query.getResultList();
			return result;
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
	public Prenotazione findById(int id) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			prenotazione = session.get(Prenotazione.class, id);
			transaction.commit();
			return prenotazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Prenotazione findByUtente(Utente utente) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> cq = cb.createQuery(Prenotazione.class);
		Root<Prenotazione> root = cq.from(Prenotazione.class);
		Predicate u = cb.equal(root.get("utente"), utente);
		cq.where(u);
		TypedQuery<Prenotazione> query = session.createQuery(cq);
		prenotazione = query.getSingleResult() ;
		return prenotazione;
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
	public Prenotazione findByAuto(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> cq = cb.createQuery(Prenotazione.class);
		Root<Prenotazione> root = cq.from(Prenotazione.class);
		Predicate a = cb.equal(root.get("auto"), auto);
		cq.where(a);
		TypedQuery<Prenotazione> query = session.createQuery(cq);
		prenotazione = query.getSingleResult() ;
		return prenotazione;
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
