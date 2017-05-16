package services;


public class GeneralService {

	private ProductService productService;
	private OfferService offerService;
	private ByCategoryService byCategoryService;
	private ByCombinationService byCombinationService;
	private ByProductService byProductService;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(final ProductService productService) {
		this.productService = productService;
	}

	public OfferService getOfferService() {
		return offerService;
	}

	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	public ByCategoryService getByCategoryService() {
		return byCategoryService;
	}

	public void setByCategoryService(ByCategoryService byCategoryService) {
		this.byCategoryService = byCategoryService;
	}

	public ByCombinationService getByCombinationService() {
		return byCombinationService;
	}

	public void setByCombinationService(ByCombinationService byCombinationService) {
		this.byCombinationService = byCombinationService;
	}

	public ByProductService getByProductService() {
		return byProductService;
	}

	public void setByProductService(ByProductService byProductService) {
		this.byProductService = byProductService;
	}

}
