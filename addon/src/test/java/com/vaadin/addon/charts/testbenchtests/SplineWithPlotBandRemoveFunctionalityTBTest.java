package com.vaadin.addon.charts.testbenchtests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.addon.charts.demoandtestapp.lineandscatter.SplineWithPlotBandRemoveFunctionality;
import com.vaadin.testbench.By;

public class SplineWithPlotBandRemoveFunctionalityTBTest extends
        AbstractParallelTest {

    boolean screenshotErrors = false;

    @Test
    public void test() throws IOException, AssertionError {
        driver.get(getTestUrl());
        WebElement button = driver.findElement(By.id("vaadin-button"));
        // toggle first to give focus for button
        button.click();
        button.click();

        waitBetweenShots();
        captureAndCompare("1-start");

        button.click();
        waitBetweenShots();
        captureAndCompare("2-removed");

        button.click();

        waitBetweenShots();
        captureAndCompare("1-start");

    }

    protected void captureAndCompare(String name) throws IOException {
        assertTrue(testBench(driver).compareScreen(
                getTestViewName() + "-" + name));
    }

    protected void waitBetweenShots() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getTestViewName() {
        return SplineWithPlotBandRemoveFunctionality.class.getSimpleName();
    }

    @Override
    protected String getPackageName() {
        return "lineandscatter";
    }

}
