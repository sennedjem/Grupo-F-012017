package repositories;

import model.Offer;

public class OfferRepository extends HibernateGenericDAO<Offer> implements GenericRepository<Offer>{

	private static final long serialVersionUID = 8691011043617136773L;

	@Override
	protected Class<Offer> getDomainClass() {
		return Offer.class;
	}
}
