package controllers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Log;

public class Listener implements ITestListener {
  @Override
  public void onTestStart(ITestResult iTestResult) {}

  @Override
  public void onTestSuccess(ITestResult iTestResult) {}

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    Log.error(iTestResult.getMethod().getMethodName());
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {}

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

  @Override
  public void onStart(ITestContext iTestContext) {}

  @Override
  public void onFinish(ITestContext iTestContext) {}
}
