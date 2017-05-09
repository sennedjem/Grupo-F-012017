package repositories;

import model.ByProduct;

public class ByProductRepository extends HibernateGenericDAO<ByProduct> implements GenericRepository<ByProduct>{

	private static final long serialVersionUID = 1485172596581370792L;

	@Override
	protected Class<ByProduct> getDomainClass() {
		return ByProduct.class;
	}
	
}
