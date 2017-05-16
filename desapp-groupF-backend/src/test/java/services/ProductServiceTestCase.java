package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Product;
import services.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class ProductServiceTestCase {

    @Autowired
    @Qualifier("services.product")
    private ProductService productService;

    @Test
    public void testSave() {
    	productService.save(new Product());
        Assert.assertEquals(1, productService.retriveAll().size());
    }

}