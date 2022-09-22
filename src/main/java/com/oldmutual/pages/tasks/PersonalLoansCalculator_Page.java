package com.oldmutual.pages.tasks;

import com.oldmutual.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.IOException;

public class PersonalLoansCalculator_Page extends Page {

//    public PersonalLoansCalculatorPage_Locators locators;

    @FindBy(css = "om-form-dropdown-field-wrapper#loanAmount span.selected-value-container")
    public WebElement loanAmountDropDownList;

    @FindBy(xpath = "//button[@class='theme-default secondary-large'][contains(.,'Next')]")
    public WebElement nextButton;

    @FindBy(css = "om-form-dropdown-field-wrapper#repaymentDuration span.selected-value-container")
    public WebElement repaymentPeriodDropDownList;


    @FindBy(xpath = "//button[@class='theme-default primary-large'][contains(.,'Calculate')]")
    public WebElement calculateButton;

    @FindBy(css = "om-application-container#calculator_container div:nth-child(4) > h5 > strong")
    public WebElement estimatedRepaymentAmount;

    public PersonalLoansCalculator_Page() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void selectLoanAmountFromDropDownList(String loanAmount) {
        scrollIntoView(loanAmountDropDownList);
        click(loanAmountDropDownList);
        click(driver.findElement(By.id(loanAmount.replaceAll("\\s", ""))));
//        select(loanAmountDropDownList, loanAmount);
    }

    public void clickNext() {
        click(nextButton);
    }

    public void selectLoanTermFromDropDownList(String loanTerm) {
//        select(repaymentPeriodDropDownList, loanTerm);
        click(repaymentPeriodDropDownList);
        click(driver.findElement(By.id(loanTerm)));
    }

    public void clickCalculateButton() {
        click(calculateButton);

    }

    public void validateRepaymentAmount(String expectedEstimatedMonthlyRepaymentAmount) throws IOException {
        String actualEstimatedMonthlyRepaymentAmount = estimatedRepaymentAmount.getText();
        verifyEquals(expectedEstimatedMonthlyRepaymentAmount, actualEstimatedMonthlyRepaymentAmount);
    }
}
