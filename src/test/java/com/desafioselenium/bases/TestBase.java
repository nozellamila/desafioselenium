package com.desafioselenium.bases;

import com.desafioselenium.GlobalParameters;
import com.desafioselenium.utils.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {


    @BeforeEach
    public void beforeTest(){
        GlobalParameters globalParameters= new GlobalParameters();
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.createInstance();
        driverFactory.INSTANCE.manage().window().maximize();
        driverFactory.INSTANCE.navigate().to(globalParameters.URL_DEFAULT);
    }

    @AfterEach
    public void afterTest(){
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.quitInstace();
    }

}
