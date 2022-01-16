package com.desafioselenium.bases;

import com.desafioselenium.GlobalParameters;
import com.desafioselenium.utils.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import java.lang.reflect.Method;

public class TestBase {
    @BeforeAll
    public void beforeSuite(){
        new GlobalParameters();
    }

    @Before
    public void beforeTest(Method method){
        DriverFactory.createInstance();
        DriverFactory.INSTANCE.manage().window().maximize();
        DriverFactory.INSTANCE.navigate().to(GlobalParameters.URL_DEFAULT);
    }

    @After
    public void afterTest(){
        DriverFactory.quitInstace();
    }

    @AfterAll
    public void afterSuite(){
    }
}
