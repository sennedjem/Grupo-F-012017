package repositories;

import model.MarketingManager;

public class MarketingManagerRepository extends HibernateGenericDAO<MarketingManager> implements GenericRepository<MarketingManager> {

	private static final long serialVersionUID = -5882622741850101851L;

	@Override
    protected Class<MarketingManager> getDomainClass() {
        return MarketingManager.class;
    }
}
