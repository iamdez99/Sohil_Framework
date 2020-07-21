package ldLink.utils;




public class LDLinkPageCache {

	private static ThreadLocal<LDLinkPageCache> pageCache = new ThreadLocal<LDLinkPageCache>();

	private LDLinkPageCache() {
		// Private Constructor
	}

	public synchronized static LDLinkPageCache getInstance() {
		if (pageCache.get() == null) {
			pageCache.set(new LDLinkPageCache());
		}
		return pageCache.get();
	}

	// private pages variables
	

	// private Pages variable if any
	
	// add implementation class object like bellow
//	public ITrustLoginPageImpl getITrustLoginPageImpl() {
//		if (loginPageImpl == null)
//			loginPageImpl = new ITrustLoginPageImpl();
//		return loginPageImpl;
//	}

	
	/**
	 * This method will destroy any object that was created.
	 */
	public void destroyInstances() {
		//Like below. if you don't create object here, all scenario will not run
//		if (loginPageImpl != null)
//			loginPageImpl = null;

	}
}
