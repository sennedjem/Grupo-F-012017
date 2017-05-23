package repositories;

import utils.Money;

public class MoneyRepository extends HibernateGenericDAO<Money> implements GenericRepository<Money>{

	
	private static final long serialVersionUID = 657002383876822127L;

	@Override
	protected Class<Money> getDomainClass() {
		return Money.class;
	}

}
