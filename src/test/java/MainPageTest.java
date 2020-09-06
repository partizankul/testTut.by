import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainPageTest {

    private MainPage mainPage;
    private Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://www.tut.by/");
        mainPage = new MainPage(Driver.getDriver());
    }

    @Test
    public void getHeadingTest(){
        logger.info("start MainPage test getHeadinhTest");
        Assert.assertEquals("", mainPage.getLogoText());
        logger.info("finish MainPage test getHeadinhTest");
    }

    @Test
    public void findSignInFieldTest(){
        logger.info("start MainPage test findSignInFieldTest");
        mainPage.clickSignInButton();
        Assert.assertEquals("Вход", mainPage.getsignInText());
        logger.info("finish MainPage test findSignInFieldTest");
    }
    @Test
    public void singInTest(){
        logger.info("start MainPage test signInTest");
        mainPage.signInMail("test@tut.by", "test");
        Assert.assertEquals("Неверное имя пользователя или пароль", mainPage.getMailOrPassError());
        logger.info("finish MainPage test signInTest");
    }


    @After
    public void tearDown(){
        logger.info("start MainPageTest readDown");
        Driver.close();
        logger.info("finish MainPageTest readDown");
    }
}
