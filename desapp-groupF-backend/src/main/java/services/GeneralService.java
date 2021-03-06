package services;


public class GeneralService {

	private ManagementService managementService;
	private ProductService productService;
	private OfferService offerService;
	private ByCategoryService byCategoryService;
	private ByCombinationService byCombinationService;
	private ProductManagementService productManagementService;
	private ByProductService byProductService;
	private UsersService usersService;
	
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

	public ManagementService getManagementService() {
		return managementService;
	}

	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}

	public ProductManagementService getProductManagementService() {
		return productManagementService;
	}

	public void setProductManagementService(ProductManagementService productManagementService) {
		this.productManagementService = productManagementService;
	}
	
	public UsersService getUsersService(){
		return usersService;
	}
	
	public void setUsersService(UsersService usersService){
		this.usersService = usersService;
	}

}
