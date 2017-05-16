package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.ByCategory;
import model.ByCombination;
import model.ByProduct;
import model.Offer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class OfferServiceTestCase {

    @Autowired
    @Qualifier("services.offer")
    private OfferService offerService;
    
    @Autowired
    @Qualifier("services.byCategory")
    private ByCategoryService byCategoryService;
    
    @Autowired
    @Qualifier("services.byCombination")
    private ByCombinationService byCombinationService;
    
    @Autowired
    @Qualifier("services.byProduct")
    private ByProductService byProductService;
    
    @Test
    public void testSaveByCategory() {
    	ByCategory byCategory = new ByCategory();
    	byCategoryService.save(byCategory);
        Assert.assertEquals(1, byCategoryService.retriveAll().size());
        byCategoryService.delete(byCategory);
    }

    @Test
    public void testSaveByCombination() {
    	ByCombination byCombination = new ByCombination();
    	byCombinationService.save(byCombination);
        Assert.assertEquals(1, byCombinationService.retriveAll().size());
        byCombinationService.delete(byCombination);
    }
    
    @Test
    public void testSaveByProduct() {
    	ByProduct byProduct = new ByProduct();
    	byProductService.save(byProduct);
        Assert.assertEquals(1, byProductService.retriveAll().size());
        byProductService.delete(byProduct);
    }
}