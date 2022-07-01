package com.skillstorm.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.skillstorm.beans.Owner;
import com.skillstorm.beans.Vehicle;

public class OwnerDAO {

	//any vehicle who's year > 1900, who's car price > 50000 and who's owner's name has an a
	public List<Vehicle> findWithCriteria(int year, double price, String name) {
		Session session = HibernateFactory.getSessionfactory().openSession();
		
		//in hibernate criteria uses the builder pattern
		//Restrictions: greater than, less than, equal to, like, etc
		//Projection: sum, count, average, etc
		@SuppressWarnings("unchecked")
		List<Vehicle> vehicles = session.createCriteria(Vehicle.class)
									  .createAlias("owner", "ownerAlias", JoinType.INNER_JOIN) //how criteria handles joins
									  //.add(Restrictions.eq("color", color)) 
									  .add(Restrictions.gt("year", year))
									  .add(Restrictions.gt("price", price))
									  .add(Restrictions.ilike("ownerAlias.name", "%" + name + "%")) //ilike is case insensitive
									  //.setProjection(Projections.sum("id")) //aggregates
									  .list();
		
		session.close();
		
		return vehicles;
	}
	
	public List<Vehicle> findWithHQL(int year, double price, String name) {
		Session session = HibernateFactory.getSessionfactory().openSession();
		
		String hql = "select vehicleAlias from Vehicle as vehicleAlias inner join vehicleAlias.owner as ownerAlias"
					 + " where vehicleAlias.year > :year and vehicleAlias.price > :price and ownerAlias.name like :name";
		
		Query query = session.createQuery(hql);
		query.setParameter("year", year);
		query.setParameter("price", price);
		query.setParameter("name", "%" + name + "%");
		
		session.close();
		
		return query.list();
	}
	
	public List<Owner> findAll() {
		//need to get the session factory to get a session
		SessionFactory sessionFactory = HibernateFactory.getSessionfactory();
		//ask the session factory for a session
		Session session = sessionFactory.openSession();
		
		//in jdbc we call
		//String sql = "Select * from owners;";
		//hibernate uses hibernate query language not sql
		//hql has different syntax very OOP based
		String hql = "from Owner";
		
		//can add .uniqueResult() to get just one back, but will throw an exception if more than
		//one is returned
		Query query = session.createQuery(hql);
		
		session.disconnect(); //need to disconnect my session. returns it to the sessionfactory's pool
		
		return query.list();
	}
	
	public Owner findById(Integer id) {
		SessionFactory sessionFactory = HibernateFactory.getSessionfactory();
		Session session = sessionFactory.openSession();
		
		//returns an Object even though you tell it what type you want
		//this will return null if nothing is found
		Owner obj = (Owner) session.get(Owner.class, id);
		
		//another way to grab an element
		//this will throw an exception if the entry doesnt exist
		//returns a proxy which means it runs faster, doesnt run the query until you use what is returned
		//needs the session to be open for this to work
		//Owner obj = (Owner) session.load(Owner.class, id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		session.close();
		
		return obj;
	}
	
	public List<Owner> findBySimilarName(String name) {
		Session session = HibernateFactory.getSessionfactory().openSession();
		
		//in mysql
		//String sql = "select * from owners where name like '%Jo%'";
		//hibernate
		//also has parameters, but no counting question marks
		//named parameters -> :<ParamName>
		String hql = "from Owner where name like :x";
		
		Query query = session.createQuery(hql);
		query.setParameter("x", "%" + name + "%");
		
		session.close();
		
		return query.list();
	}
	
	public void save(Owner owner) {
		SessionFactory sessionFactory = HibernateFactory.getSessionfactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			//transaction gives me the generated id by default
			Serializable id = session.save(owner);
			tx.commit(); //if no errors we commit it
			System.out.println("Saved Record: " + id);
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback(); //if any error occurs
		} finally {
			session.close();
		}
	}
}
