package com.test.app.repo.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.entities.Memo;

@Repository
public class MemoRepo {
	@Autowired
	private SessionFactory sessionFactory;

	public Memo get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Memo m = new Memo();
		try {
			m = (Memo) session.get(Memo.class, id);
			txn.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		return m;
	}

	public Boolean insert(Memo m) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(m);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
	}
	
	public Boolean update(Memo m) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		//'Memo' instead of 'tbmemo'
		try {
			Query query = session.createQuery("UPDATE   Memo  SET content = :content, date = :date, domain   = :domain, isenable   = :isenable,ispublic   = :ispublic, title   = :title,url   = :url, userid   = :userid WHERE id   = :id");
			query.setParameter("content", m.getContent());
			query.setParameter("date", m.getDate());
			query.setParameter("domain", m.getDomain());
			query.setParameter("isenable", m.isIsenable());
			query.setParameter("ispublic", m.isIspublic());
			query.setParameter("title", m.getTitle());
			query.setParameter("url", m.getUrl());
			query.setParameter("userid", m.getUserid());
			query.setParameter("id", m.getId());
			query.executeUpdate();
			txn.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
	}
	
	public Boolean update1(Memo m) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.update(m);
			txn.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
	}

}
