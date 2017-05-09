package repositories;

import model.ByCategory;

public class ByCategoryRepository extends HibernateGenericDAO<ByCategory> implements GenericRepository<ByCategory> {


	private static final long serialVersionUID = -8385451629222152814L;

	@Override
	protected Class<ByCategory> getDomainClass() {
		return ByCategory.class;
	}
}
