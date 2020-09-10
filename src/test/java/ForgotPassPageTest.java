import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForgotPassPageTest {

    private ForgotPassPage forgotPassPage;
    private Logger logger;


    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://profile.tut.by/recover.html");
        forgotPassPage = new ForgotPassPage(Driver.getDriver());
    }

    @Test
    public void getHeadingTest(){
        logger.info("start ForgotPassPageTest test getHeadingTest");
        Assert.assertEquals("", forgotPassPage.getLogoText());
        logger.info("finish ForgotPassPageTest test getHeadingTest");
    }

    @Test
    public void checkRuTextError(){
        logger.info("start ForgotPassPageTest test checkRuTextError");
        forgotPassPage.findMail("Почта");
        Assert.assertEquals("Неправильная Эл. почта", forgotPassPage.getRuMailErrorText());
        logger.info("finish ForgotPassPageTest test checkRuTextError");
    }



    @After
    public void tearDown(){
        logger.info("start ForgotPassPageTest readDown");
        Driver.close();
        logger.info("finish ForgotPassPageTest readDown");
    }
}

