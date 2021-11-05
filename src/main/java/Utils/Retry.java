package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{  //retry failed tests
    private int retryCount = 0;
    private static final int maxRetryCount = 0;  //maxRetryCount count re-try

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
