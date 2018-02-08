package com.mindtree.ticket_tracking.dao.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ticket_tracking.dao.EmployeeDao;
import com.mindtree.ticket_tracking.entity.Employee;
import com.mindtree.ticket_tracking.exceptions.EmployeeDaoException;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Employee> getAllEmployee() throws EmployeeDaoException {

		try {
			return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
		} catch (HibernateException hibernateException) {

			throw new EmployeeDaoException("Error in data retrieval", hibernateException);

		}
	}

	public Employee getEmployeeByMid(String mid) {
		return this.sessionFactory.getCurrentSession().get(Employee.class, new String(mid));
	}

	public void deleteEmployee(String mid) {
		this.sessionFactory.getCurrentSession().remove(this.getEmployeeByMid(mid));
	}

	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

}
