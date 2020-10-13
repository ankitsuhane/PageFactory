package com.orgname.framework.web;

import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("cucumber-glue")
public class BasePage extends  WebDriverFactory{

    public static BasePage CurrentPage;

    public <TPage> TPage getInstance(Class <TPage> page){
        Object obj = PageFactory.initElements(getWebDriver(),page);
        return page.cast(obj);
    }

    public static <TPage> TPage As(Class<TPage> pageInstance)
    {
        try
        {
            return (TPage) pageInstance;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return null;
    }
}
