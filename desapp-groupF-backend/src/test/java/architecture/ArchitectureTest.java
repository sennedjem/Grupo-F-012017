package architecture;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;
import org.reflections.Reflections;

import services.GenericService;

public class ArchitectureTest {
	
	private String packageAspects = "aspects";
	private String packageBuilders = "builders";
	private String packageExceptions = "exceptions";
	private String packageFixture = "fixture";
	private String packageModel = "model";
	private String packageServices = "services";
	private String packageServiceRest = "servicesRest";
	private String packageUtils = "utils";

	/*
	 * Se verifica que en los paquetes "NO service" no haya clases que
	 * extiendan de "GenericService"
	 * 
	 */
	@Test
	public void testPackegeWhithoutService() throws InstantiationException, IllegalAccessException {

		int correctClasses = 0;
		ArrayList<String> namesPackages = new ArrayList<String>();

		namesPackages.add(this.packageAspects);
		namesPackages.add(this.packageBuilders);
		namesPackages.add(this.packageExceptions);
		namesPackages.add(this.packageFixture);
		namesPackages.add(this.packageModel);
		namesPackages.add(this.packageServiceRest);
		namesPackages.add(this.packageUtils);

		for (String pack : namesPackages) {
			Object[] classes = this.getAllClassForPackage(pack, GenericService.class);
			correctClasses += classes.length;
		}
		assertEquals(0, correctClasses);
	}

	@Test
	public void testPackegeWhithService() throws InstantiationException, IllegalAccessException {

		int correctClasses = 0;
		ArrayList<String> namesPackages = new ArrayList<String>();

		namesPackages.add(this.packageServices);

		for (String pack : namesPackages) {
			Object[] classes = this.getAllClassForPackage(pack, GenericService.class);
			correctClasses += classes.length;
		}
		assertNotEquals(0, correctClasses);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object[] getAllClassForPackage(String namePackage, Class xclase) {

		Reflections reflections = new Reflections(namePackage);
		Object[] classes = ((HashSet) reflections.getSubTypesOf(xclase)).toArray();
		return classes;
	}

}
