package com.oldmutual.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankAndBorrowSolutionsPage_Locators {
    @FindBy(xpath = "(//span[@class='om-button-text'][contains(.,'LEARN MORE')])[2]")
    public WebElement learnMoreButton_PersonalLoans;
}
