package repositories;

import model.Admin;

public class AdminRepository extends HibernateGenericDAO<Admin> implements GenericRepository<Admin> {

	private static final long serialVersionUID = -2977276188139065217L;

	@Override
	protected Class<Admin> getDomainClass() {
		return Admin.class;
	}

}
