package com.orgname.test.web.pagesactions.actions;

import com.orgname.test.web.pagesactions.pages.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("cucumber-glue")
public class HomePageAction {

    @Lazy
    @Autowired
    HomePage homePage;


}