package repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import model.ListItem;
import model.Product;


public class ListItemRepository extends HibernateGenericDAO<ListItem> implements GenericRepository<ListItem>{

	private static final long serialVersionUID = 8924917634156058906L;

	@Override
	protected Class<ListItem> getDomainClass() {	
		return ListItem.class;
	}

}
