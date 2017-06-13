package repositories;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import model.Product;
import utils.Category;

public class ProductManagementRepository extends HibernateDaoSupport{

	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts(){
		List<Product> find = (List<Product>) this.getHibernateTemplate().find("from " + Product.getClassName() + " o");
        return find;
	}

	@Transactional
    public void save(final Object aProduct) {
        this.getHibernateTemplate().save(aProduct);
        this.getHibernateTemplate().flush();
    }
	
	public void delete(final Integer id) {
		Session session = this.currentSession();
		String hql = "delete from Product where ID= :id";
		session.createQuery(hql).setLong("id", new Integer(id)).executeUpdate();
    }
}