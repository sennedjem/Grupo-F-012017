package repositories;

import model.ByCombination;

public class ByCombinationRepository extends HibernateGenericDAO<ByCombination> implements GenericRepository<ByCombination>  {

	private static final long serialVersionUID = 8074021168308950568L;

	@Override
	protected Class<ByCombination> getDomainClass() {
		return ByCombination.class;
	}
}
