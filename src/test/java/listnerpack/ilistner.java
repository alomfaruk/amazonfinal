package listnerpack;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IListenersAnnotation;
import org.testng.internal.annotations.IListeners;

import utilitiespack.utilities;

public  class ilistner extends utilities implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		this.driver=((utilities)result.getInstance()).driver;
		screenshorts("sucess");

	}

	@Override
	public void onTestFailure(ITestResult result) {
        this.driver=((utilities)result.getInstance()).driver;
        screenshorts("failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.driver=((utilities)result.getInstance()).driver;
		screenshorts("skipped");

	}

	

}
