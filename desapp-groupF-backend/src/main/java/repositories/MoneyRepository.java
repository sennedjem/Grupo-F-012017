package repositories;

import javax.transaction.Transactional;

import utils.Money;

@Transactional
public class MoneyRepository extends HibernateGenericDAO<Money> implements GenericRepository<Money> {

    private static final long serialVersionUID = -4036535812105672110L;


    @Override
    protected Class<Money> getDomainClass() {
        return Money.class;
    }
    

}