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

import training.spring.entity.Auto;

@Transactional(rollbackFor = Exception.class)
@Repository
public class AutoDAOimpl implements AutoDAO{


	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Auto> findAllAuto() {
		List<Auto> result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();			
			CriteriaQuery<Auto> cq = cb.createQuery(Auto.class);
			Root<Auto> root = cq.from(Auto.class);
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
	public void addAuto(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(auto);
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
	public Auto findById(int id) {
		Session session = null;
		Transaction transaction = null;
		Auto auto = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			auto = session.get(Auto.class,id);
			transaction.commit();
			return auto;
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
	public void deleteAuto(int id) {
		Session session = null;
		Transaction transaction = null;
		Auto auto = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			auto = session.get(Auto.class, id);
			session.delete(auto);
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
	public void update(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(auto);
			//session.saveOrUpdate(auto);
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
	
	
	
}
