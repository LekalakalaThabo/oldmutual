package com.oldmutual.pages.tasks;

import com.oldmutual.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.IOException;
import java.util.ArrayList;

public class PersonalLoans_Page extends Page {

    //    public PersonalLoansPage_Locators locators;
    @FindBy(xpath = "//span[@class='om-button-text'][contains(.,'CALCULATE')]")
    public WebElement calculateButton;

    public PersonalLoans_Page() {
//        this.locators = new PersonalLoansPage_Locators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);

    }

    public void verifyCorrectPage(String expectedPageTitle) throws IOException {
        String actualPageTitle = driver.getTitle();
        verifyEquals(actualPageTitle, expectedPageTitle);

    }

    public void navigateToPersonalLoansCalculatorPage() {
        click(calculateButton);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
    }

}
