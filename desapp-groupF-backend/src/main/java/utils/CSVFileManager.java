package utils;

import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

import model.Management;
import model.Product;

public class CSVFileManager {
	
	Management management;
	
	public CSVFileManager(Management management) {
		this.management = management;
	}
	
	@SuppressWarnings("resource")
	public void importProducts(String filePath) throws NumberFormatException, IOException{
	    String csvFile = filePath;
	    CSVReader reader = new CSVReader(new FileReader(csvFile));
	    String[] nextLine;
	    
	    while ((nextLine = reader.readNext()) != null) {
  	  	Product product = new Product();
	  	product.setId(Integer.parseInt(nextLine[0]));
	  	product.setName(nextLine[1]);
	  	product.setBrand(nextLine[2]);
	  	product.setPrice(Money.toMoney(nextLine[3]));
	  	product.setStock(Integer.parseInt(nextLine[4]));
	  	product.setImage(nextLine[5]);

	  	management.addProduct(product);
	    }
	}	
}
