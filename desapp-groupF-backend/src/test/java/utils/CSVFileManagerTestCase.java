package utils;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import model.Management;

public class CSVFileManagerTestCase {

	private Management management;
	private CSVFileManager csvFileManager;
	private String file;
	
	@Before
	public void setUp(){
		management = new Management();
		csvFileManager = new CSVFileManager(management);
		file = "./src/test/java/utils/csvProductsTest.csv";
	}

	@Test
	public void testImportProductsSize() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals(3, management.getProducts().size());
	}
	
	@Test
	public void testImportProductsId() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals((Integer)1, management.getProducts().get(0).getId());
	}
	
	@Test
	public void testImportProductsName() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals("name2", management.getProducts().get(1).getName());
	}
	
	@Test
	public void testImportProductsBrand() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals("brand3", management.getProducts().get(2).getBrand());
	}
	
	@Test
	public void testImportProductsPrice() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals(new Money(43,3), management.getProducts().get(2).getPrice());
	}
	
	@Test
	public void testImportProductsStock() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals((Integer)53, management.getProducts().get(2).getStock());
	}
	
	@Test
	public void testImportProductsImage() throws NumberFormatException, IOException {
		csvFileManager.importProducts(file);
		assertEquals(3, management.getProducts().size());
		assertEquals("image1", management.getProducts().get(0).getImage());
	}
}
