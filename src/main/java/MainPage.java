import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By logo = By.xpath("//a[@class = \"header-logo\"]");
    private By signInButton = By.xpath("//*[text()= \"Войти\"]");
    private By signInText = By.xpath("//*[text()= \"Вход\"]");
    private By loginField = By.xpath("//*[@name=\"login\"]");
    private By passwordField = By.xpath("//*[@name=\"password\"]");
    private By toLogInButton = By.xpath("//*[@value=\"Войти\"]");
    private By rememberRadioButton = By.xpath("//*[@id=\"memory\"]");
    private By forgotLink = By.xpath("//*[text()=\"Забыли пароль?\"]");
    private By mailOrPassError = By.xpath("//*[text()=\"Неверное имя пользователя или пароль\"]");
    /*private By singUpLink = By.xpath("");
    private By singUpLink = By.xpath("");
    private By singUpLink = By.xpath("");*/

    public String getLogoText(){
        return driver.findElement(logo).getText();
    }
    public MainPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new MainPage(driver);
    }
    public String getsignInText(){
        return driver.findElement(signInText).getText();
    }
    public MainPage typeMail(String mail){
        driver.findElement(loginField).sendKeys(mail);
        return this;
    }
    public MainPage typePass(String pass){
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }
    public MainPage clickToLogBtn(){
        driver.findElement(toLogInButton).click();
        return new MainPage(driver);
    }
    public MainPage signInMail(String mail, String pass){
        clickSignInButton();
        this.typeMail(mail);
        this.typePass(pass);
        clickToLogBtn();
        return new MainPage(driver);
    }
    public MainPage clickRememberRadioBtn(){
        WebElement checkbox = driver.findElement(rememberRadioButton);
        if(!checkbox.isSelected()){
            checkbox.click();
        }return new MainPage(driver);
    }
    public MainPage clickForgotLink(){
        driver.findElement(forgotLink).click();
        return new MainPage(driver);
    }
    public String getMailOrPassError(){
        return driver.findElement(mailOrPassError).getText();
    }



}


