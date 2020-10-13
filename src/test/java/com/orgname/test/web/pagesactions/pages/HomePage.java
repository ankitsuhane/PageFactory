package com.orgname.test.web.pagesactions.pages;

import com.orgname.framework.web.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("cucumber-glue")
public class HomePage extends BasePage {

    @FindBy(css = ".login-new > .classicTxt")
    private WebElement login;

    @FindBy (css=".error-code")
    private WebElement pageNotFound;

    public ContinueToLoginPage login(){
        login.click();
        return getInstance(ContinueToLoginPage.class);
    }
}
