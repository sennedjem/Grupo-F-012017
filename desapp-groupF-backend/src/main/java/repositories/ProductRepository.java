package repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import fixture.ProductFixture;
import model.Product;

@Transactional
public class ProductRepository extends HibernateGenericDAO<Product> implements GenericRepository<Product> {

    private static final long serialVersionUID = -4036535812105672110L;

    public List<Product> findAll(){
    	return ProductFixture.createProducts();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Product> filterProduct(final String pattern) {
        return (List<Product>) this.getHibernateTemplate().execute(new HibernateCallback() {
            public List<Product> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.add(Restrictions.like("name", "%" + pattern + "%"));
                return criteria.list();
            }

        });
    }

    @Override
    protected Class<Product> getDomainClass() {
        return Product.class;
    }
    

}