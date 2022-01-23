package com.desafioselenium.utils;

import com.desafioselenium.GlobalParameters;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver INSTANCE = null;

    public static void createInstance(){
        GlobalParameters globalParameters = new GlobalParameters();
        Browsers browsers = new Browsers();
        String browser = globalParameters.BROWSER_DEFAULT;
        String execution = globalParameters.EXECUTION;

        if (INSTANCE==null){
            if(execution.equals("local")){
                if(browser.equals("chrome")){
                    INSTANCE = browsers.getLocalChrome();
                }else if(browser.equals("chromeHeadless")){
                    INSTANCE = browsers.getLocalChromeHeadless();
                }else if(browser.equals("firefox")){
                    INSTANCE = browsers.getLocalFirefox();
                }else if (browser.equals("ie")){
                    INSTANCE = browsers.getLocalInternetExplorer();
                }else{
                    try{
                        throw new Exception("O browser informado não existe ou não é suportado pela automação");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            if(execution.equals("remota")){
                if(browser.equals("chrome")){
                    INSTANCE = browsers.getRemoteChrome();
                }else if(browser.equals("chromeHeadless")){
                    INSTANCE = browsers.getRemoteChromeHeadless();
                }else if(browser.equals("firefox")){
                    INSTANCE = browsers.getRemoteFirefox();
                }else if (browser.equals("ie")){
                    INSTANCE = browsers.getRemoteInternetExplorer();
                }else{
                    try{
                        throw new Exception("O browser informado não existe ou não é suportado pela automação");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void quitInstace(){
        INSTANCE.quit();
        INSTANCE = null;
    }
}
