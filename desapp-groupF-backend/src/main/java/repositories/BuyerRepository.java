package repositories;

import java.util.List;

import model.Buyer;
import model.Product;

public class BuyerRepository extends HibernateGenericDAO<Buyer> implements GenericRepository<Buyer>{

	private static final long serialVersionUID = -9051864453284616513L;

	@Override
	protected Class<Buyer> getDomainClass() {
		return Buyer.class;
	}

	public Buyer getByEmail(String email){
		List<Buyer> buyersFinded = (List<Buyer>) this.getHibernateTemplate().find("FROM Buyer bu WHERE bu.buyerEmail = ?",email);
		if (buyersFinded.size()>0){
			return buyersFinded.get(0);
		}
		return null;
	}
}
