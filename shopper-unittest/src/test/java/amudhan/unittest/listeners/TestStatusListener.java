package amudhan.unittest.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * This listener gets called according to status changes in the unit tests<br/>
 * 
 * @author amudhan
 *
 */
public class TestStatusListener extends TestListenerAdapter {

  private static final Logger logger = LoggerFactory.getLogger(TestStatusListener.class);

  @Override
  public void onTestStart(ITestResult tr) {
    logger.info("----------------------------------");
    logger.info(tr.getName() + " started");
    logger.info("Method: " + tr.getMethod().getMethodName());
    logger.info("Description: " + tr.getMethod().getDescription());
  }

  @Override
  public void onTestSuccess(ITestResult tr) {
    logger.info(tr.getName() + " passed");
  }

  @Override
  public void onTestFailure(ITestResult tr) {
    logger.info(tr.getTestName() + " failed");
  }

  @Override
  public void onTestSkipped(ITestResult tr) {
    logger.info(tr.getName() + " skipped");
  }

}
