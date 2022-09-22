package com.oldmutual.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalLoansCalculatorPage_Locators {

    @FindBy(css = "om-form-dropdown-field-wrapper#loanAmount span.selected-value-container")
    public WebElement loanAmountDropDownList;

    @FindBy(linkText = "Next")
    public WebElement nextButton;

    @FindBy(css = "om-form-dropdown-field-wrapper#repaymentDuration span.selected-value-container")
    public WebElement repaymentPeriodDropDownList;


    @FindBy(linkText = "Calculate")
    public WebElement calculateButton;

    @FindBy(css = "om-application-container#calculator_container div:nth-child(4) > h5 > strong")
    public WebElement estimatedRepaymentAmount;

}
