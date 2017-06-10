package repositories;

import model.Buyer;

public class BuyerRepository extends HibernateGenericDAO<Buyer> implements GenericRepository<Buyer>{

	private static final long serialVersionUID = -9051864453284616513L;

	@Override
	protected Class<Buyer> getDomainClass() {
		return Buyer.class;
	}

}
