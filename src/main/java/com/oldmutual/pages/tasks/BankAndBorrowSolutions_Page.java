package com.oldmutual.pages.tasks;

import com.oldmutual.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.IOException;

public class BankAndBorrowSolutions_Page extends Page {
    //    public BankAndBorrowSolutionsPage_Locators locators;
    @FindBy(xpath = "(//span[@class='om-button-text'][contains(.,'LEARN MORE')])[2]")
    public WebElement learnMoreButton_PersonalLoans;

    @FindBy(xpath = "//strong[contains(.,'Bank and borrow')]")
    public WebElement useToScrollDownToLearnMore;

    public BankAndBorrowSolutions_Page() {
//        this.locators = new BankAndBorrowSolutionsPage_Locators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void verifyPageTitle(String expectedPageTitle) throws IOException {
        String actualPageTitle = driver.getTitle();
        verifyEquals(actualPageTitle, expectedPageTitle);
    }

    public BankAndBorrowSolutions_Page navigateToPersonalLoansPage() {
        scrollIntoView(useToScrollDownToLearnMore);
        click(learnMoreButton_PersonalLoans);
        return this;
    }


}
