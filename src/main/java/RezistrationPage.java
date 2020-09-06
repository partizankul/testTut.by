import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RezistrationPage {
    private WebDriver driver;

    public RezistrationPage(WebDriver driver){
        this.driver=driver;
    }

    private By logo = By.xpath("//h1[text()=\"Регистрация\"]");
    private By  createMailBtn = By.xpath("//*[@for=\"field-create-email\"]");
    private By  mailField = By.xpath("//*[@id=\"field-email\"]");
    private By  passField = By.xpath("//*[@id=\"field-password\"]");
    private By  nameAndFamilyField = By.xpath("id=\"field-fio\"");
    private By  birthdayField = By.xpath("//*[@id=\"field-birthday\"]");
    private By  phoneNumberField = By.xpath("id=\"field-phone\"");
    private By  newsCheckbox = By.xpath("//*[@id=\"send-mailing\"]");
    private By  regBtn = By.xpath("//*[@id=\"reg_submit\"]");

    public String getLogoText(){return driver.findElement(logo).getText();}
    public RezistrationPage clickCreateMailBtn(){
        driver.findElement(createMailBtn).click();
        return new RezistrationPage(driver);
    }
    public RezistrationPage typeMail(String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    public RezistrationPage typePass(String pass){
        driver.findElement(passField).sendKeys(pass);
        return this;
    }
    public RezistrationPage typeNameAndFamily(String nameAndFamily){
        driver.findElement(nameAndFamilyField).sendKeys(nameAndFamily);
        return this;
    }
    public RezistrationPage typeBithday (String bithday){
        driver.findElement(birthdayField).sendKeys(bithday);
        return this;
    }
    public RezistrationPage typePhoneNumber (String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    public RezistrationPage clickNewsCheckbox(){
        WebElement checkbox = driver.findElement(newsCheckbox);
        if(checkbox.isSelected()){
            checkbox.click();
        }return new RezistrationPage(driver);
    }
    public RezistrationPage clickRegBtn(){
        driver.findElement(regBtn).click();
        return new RezistrationPage(driver);
    }
    public RezistrationPage regLogin(String mail, String pass, String nameAndFamily, String birthday, String phoneNumber){
this.typeMail(mail);
this.typePass(pass);
this.typeNameAndFamily(nameAndFamily);
this.typeBithday(birthday);
this.typePhoneNumber(phoneNumber);
clickNewsCheckbox();
clickRegBtn();
return new RezistrationPage(driver);
    }



}
