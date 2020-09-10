import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationPageTest {

    private RegistrationPage registrationPage;
    private Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://profile.tut.by/register.html");
        registrationPage = new RegistrationPage(Driver.getDriver());
    }

    @Test
    public void getHeadingTest(){
        logger.info("start RegistrationPage test getHeadingTest");
        Assert.assertEquals("Регистрация", registrationPage.getLogoText());
        logger.info("finish RegistrationPage test getHeadingTest");
    }

    @Test
    public void  getMailErrorTest(){
        logger.info("start RegistrationPage test getMailErrorTest");
        registrationPage.regLogin("1", "12345678", "Name Family", "1", "1");
        Assert.assertEquals("Минимум 2 символа для поля Почта", registrationPage.getMailShortError());
        logger.info("finish RegistrationPage test getMailErrorTest");
    }

    @Test
    public void  getMailRuErrorTest(){
        logger.info("start RegistrationPage test getMailRuErrorTest");
        registrationPage.regLogin("Почта", "12345678", "Name Family", "1", "1");
        Assert.assertEquals("Логин должен начинаться с латинской буквы (a–z)", registrationPage.getMailError());
        logger.info("finish RegistrationPage test getMailRuErrorTest");
    }

    @Test
    public void  getPassErrorTest(){
        logger.info("start RegistrationPage test getPassErrorTest");
        registrationPage.regLogin("Test1357951", "1", "Name Family", "1", "1");
        Assert.assertEquals("Минимум 8 символов для поля Пароль", registrationPage.getPassShortError());
        logger.info("finish RegistrationPage test getPassErrorTest");
    }

    @Test
    public void  getMailIsNotEmptyErrorTest(){
        logger.info("start RegistrationPage test getMailIsNotEmptyErrorTest");
        registrationPage.regLogin("Test", "12345678", "Name Family", "1", "1");
        Assert.assertEquals("Пользователь с таким логином уже существует", registrationPage.getMailIsNotEmptyError());
        logger.info("finish RegistrationPage test getMailIsNotEmptyErrorTest");
    }

    @Test
    public void  twoGetMailIsNotEmptyErrorTest(){
        logger.info("start RegistrationPage test getMailIsNotEmptyErrorTest");
        registrationPage.regLogin("Test", "1234567", "Name Family", "1", "1");
        Assert.assertEquals("Минимум 8 символов для поля Пароль", registrationPage.getPassShortError());
        logger.info("finish RegistrationPage test getMailIsNotEmptyErrorTest");
    }

   @After
    public void tearDown(){
        logger.info("start RegistrationPage readDown");
        Driver.close();
        logger.info("finish RegistrationPage readDown");
    }

}