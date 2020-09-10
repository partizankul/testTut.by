import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    private By logo = By.xpath("//h1[text()=\"Регистрация\"]");
    private By  createMailBtn = By.xpath("//*[@for=\"field-create-email\"]");
    private By  mailField = By.xpath("//*[@id=\"field-email\"]");
    private By  passField = By.xpath("//*[@id=\"field-password\"]");
    private By  nameAndFamilyField = By.xpath("//*[@id=\"field-fio\"]");
    private By  birthdayField = By.xpath("//*[@id=\"field-birthday\"]");
    private By  phoneNumberField = By.xpath("//*[@id=\"field-phone\"]");
    private By  newsCheckbox = By.xpath("//*[@id=\"send-mailing\"]");
    private By  regBtn = By.xpath("//*[@id=\"reg_submit\"]");
    private By mailError = By.xpath("//*[text()=\"Логин должен начинаться с латинской буквы (a–z)\"]");
    private By mailShortError = By.xpath("//*[text()=\"Минимум 2 символа для поля Почта\"]");
    private By mailIsNotEmptyError = By.xpath("//*[text()=\"Пользователь с таким логином уже существует\"]");
    private By passShortError = By.xpath("//*[text()=\"Минимум 8 символов для поля Пароль\"]");
    private By fioError = By.xpath("//*[text()=\"Допустимы только буквы, дефис и пробел\"]");	// выскакиевает при вводе цифр
    private By birthdayError = By.xpath("//*[text()=\"Неправильная дата рождения\"]");
    private By phoneNumberError = By.xpath("//*[text()=\"Неправильный телефон\"]");

    public String getLogoText(){return driver.findElement(logo).getText();}
    public RegistrationPage clickCreateMailBtn(){
        driver.findElement(createMailBtn).click();
        return new RegistrationPage(driver);
    }
    public RegistrationPage typeMail(String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    public RegistrationPage typePass(String pass){
        driver.findElement(passField).sendKeys(pass);
        return this;
    }
    public RegistrationPage typeNameAndFamily(String nameAndFamily){
        driver.findElement(nameAndFamilyField).sendKeys(nameAndFamily);
        return this;
    }
    public RegistrationPage typeBithday (String bithday){
        driver.findElement(birthdayField).sendKeys(bithday);
        return this;
    }
    public RegistrationPage typePhoneNumber (String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    public RegistrationPage clickNewsCheckbox(){
        WebElement checkbox = driver.findElement(newsCheckbox);
        if(checkbox.isSelected()){
            checkbox.click();
        }return new RegistrationPage(driver);
    }
    public RegistrationPage clickRegBtn(){
        driver.findElement(regBtn).click();
        return new RegistrationPage(driver);
    }
    public RegistrationPage regLogin(String mail, String pass, String nameAndFamily, String birthday, String phoneNumber){
        this.typeMail(mail);
        this.typePass(pass);
        this.typeNameAndFamily(nameAndFamily);
        this.typeBithday(birthday);
        this.typePhoneNumber(phoneNumber);
        clickNewsCheckbox();
        clickRegBtn();
        return new RegistrationPage(driver);
    }
    public String getMailError(){
        return driver.findElement(mailError).getText();}
    public String getMailShortError(){return driver.findElement(mailShortError).getText();}
    public String getMailIsNotEmptyError(){return driver.findElement(mailIsNotEmptyError).getText();}
    public String getPassShortError(){return driver.findElement(passShortError).getText();}
    //	public String getFioError(){return driver.findElement(fioError).getText();}
    public String getBirthdayError(){return driver.findElement(birthdayError).getText();}
    public String getPhoneNumberError(){return driver.findElement(phoneNumberError).getText();}



}
