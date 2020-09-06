import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RezistrationPageTest {

    private RezistrationPage rezistrationPage;
    private Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://profile.tut.by/register.html");
        rezistrationPage = new RezistrationPage(Driver.getDriver());
    }

    @Test
    public void getHeadingTest(){
        logger.info("start RezistrationPage test getHeadinhTest");
        Assert.assertEquals("Регистрация", rezistrationPage.getLogoText());
        logger.info("finish RezistrationPage test getHeadinhTest");
    }


    @After
    public void tearDown(){
        logger.info("start RezistrationPage readDown");
        Driver.close();
        logger.info("finish RezistrationPage readDown");
    }

}
