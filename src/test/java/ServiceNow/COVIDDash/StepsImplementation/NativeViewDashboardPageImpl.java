package coviddash.steps.impl;

import com.nci.automation.utils.MiscUtils;
import com.nci.automation.web.EnvUtils;
import com.nci.automation.web.WebDriverUtils;
import com.nci.automation.xceptions.TestingException;
import appsCommon.PageCache;
import appsCommon.PageInitializer;




public class NativeViewDashboardPageImpl extends PageInitializer {

	private static PageCache pageCache = PageCache.getInstance();


	public void impersonateUser(String approver) throws TestingException {
	
		WebDriverUtils.webDriver.navigate().to(EnvUtils.getNativeViewUrl());
		MiscUtils.sleep(3000);
		pageCache.getNativeViewDashboardPage().clickNativeViewLink();
		MiscUtils.sleep(2000);
		pageCache.getNativeViewDashboardPage().clickUserDropDown();
		MiscUtils.sleep(500);
		pageCache.getNativeViewDashboardPage().clickImpersonateUserLink();
		MiscUtils.sleep(1000);
		pageCache.getNativeViewDashboardPage().clickImpersonateSearchDD();
		MiscUtils.sleep(1000);
		pageCache.getNativeViewDashboardPage().enterTextImpersntSearchBox(approver);
		MiscUtils.sleep(1000);	
		WebDriverUtils.webDriver.navigate().to(EnvUtils.getApplicationUrl());

	}
	
	
}
