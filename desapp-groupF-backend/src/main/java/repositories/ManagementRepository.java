package repositories;

import model.Management;

public class ManagementRepository  extends HibernateGenericDAO<Management> implements GenericRepository<Management>{

	private static final long serialVersionUID = -8609241730704383903L;

	@Override
	protected Class<Management> getDomainClass() {
		return Management.class;
	}
}
