package com.oldmutual.testcases;

import com.oldmutual.base.Page;
import com.oldmutual.pages.tasks.BankAndBorrowSolutions_Page;
import com.oldmutual.pages.tasks.PersonalLoansCalculator_Page;
import com.oldmutual.pages.tasks.PersonalLoans_Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoanRepaymentCalculatorTest {

    private BankAndBorrowSolutions_Page bankAndBorrowSolutions_page;
    private PersonalLoans_Page personalLoansPage;
    private PersonalLoansCalculator_Page personalLoansCalculatorPage;

    private String bankAndBorrowSolutions_PageTitle = "Bank and Borrow Solutions | Old Mutual";
    private String personalLoans_PageTitle = "Bank and Borrow Solutions | Old Mutual";
    String loanAmount = "R50 000";
    String loanTerm = "60 Months";
    private String estimatedMonthlyRepaymentAmount = "R1 656.43 - R1 810.05";

    @BeforeTest
    public void initializePages() {
        Page.initConfiguration();
        bankAndBorrowSolutions_page = new BankAndBorrowSolutions_Page();
        personalLoansPage = new PersonalLoans_Page();
        personalLoansCalculatorPage = new PersonalLoansCalculator_Page();
    }

    @Test
    public void loanRepaymentCalculatorTest() throws IOException {
        givenUserIsOnBankAndBorrowSolutions_Page();
        whenUserCalculateRepaymentTerm();
        thenEstimatedRepaymentAmountShouldBe();

    }

    @AfterMethod
    public void tearDown() {
        if (Page.driver != null) {
            Page.quitBrowser();
        }
    }

    public void givenUserIsOnBankAndBorrowSolutions_Page() throws IOException {
        bankAndBorrowSolutions_page.verifyPageTitle(bankAndBorrowSolutions_PageTitle);
        bankAndBorrowSolutions_page.navigateToPersonalLoansPage();

    }

    public void whenUserCalculateRepaymentTerm() throws IOException {
        personalLoansPage.verifyCorrectPage(personalLoans_PageTitle);
        personalLoansPage.navigateToPersonalLoansCalculatorPage();
        personalLoansCalculatorPage.selectLoanAmountFromDropDownList(loanAmount);
        personalLoansCalculatorPage.clickNext();
        personalLoansCalculatorPage.selectLoanTermFromDropDownList(loanTerm);
        personalLoansCalculatorPage.clickCalculateButton();

    }

    public void thenEstimatedRepaymentAmountShouldBe() throws IOException {
        personalLoansCalculatorPage.validateRepaymentAmount(estimatedMonthlyRepaymentAmount);

    }
}
