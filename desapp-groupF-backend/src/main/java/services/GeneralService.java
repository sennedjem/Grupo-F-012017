package services;


public class GeneralService {

	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(final ProductService productService) {
		this.productService = productService;
	}

}
