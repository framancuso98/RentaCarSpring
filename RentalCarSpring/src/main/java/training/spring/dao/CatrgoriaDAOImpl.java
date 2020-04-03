package training.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.spring.entity.Categoria;

@Transactional(rollbackFor = Exception.class)
@Repository
public class CatrgoriaDAOImpl implements CategoriaDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCategorie() {
		List<Categoria> result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();			
			CriteriaQuery<Categoria> cq = cb.createQuery(Categoria.class);
			Root<Categoria> root = cq.from(Categoria.class);
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
				session.clear();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	@Override
	public Categoria findById(int id) {
		Categoria categoria = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			categoria = session.get(Categoria.class, id);
			transaction.commit();
			return categoria;
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
