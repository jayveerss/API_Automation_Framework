package org.module.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class ReportListener implements ITestListener {

    private static final Logger log = Logger.getLogger(ReportListener.class.getName());
    @Override
    public void onTestStart(ITestResult iTestResult) {
    log.info("Test case execution started "+ iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test case execution completed "+ iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test case execution failed "+ iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test case execution skipped "+ iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
