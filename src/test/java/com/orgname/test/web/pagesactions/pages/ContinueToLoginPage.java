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
public class ContinueToLoginPage extends BasePage {

    @FindBy(className= "login_button")
    private WebElement loginButton;

    public void clickLoginButton() {
        waitForVisibilityOfElementClick(loginButton);
    }
}
