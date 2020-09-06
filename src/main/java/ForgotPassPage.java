import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassPage {
    private WebDriver driver;

    public ForgotPassPage(WebDriver driver){
        this.driver = driver;
    }

    private By  logo = By.xpath("//*[@alt=\"TUT.BY\"]");
    private By  mailFild = By.xpath("//*[@name=\"email\"]");
    private By  ruMailError = By.xpath("//*[text()=\"Неправильная Эл. почта\"]");
    private By  findBtn = By.xpath("//*[@id=\"recovery-check\"]");


    public String getLogoText(){
        return driver.findElement(logo).getText();
    }
    public String getRuMailErrorText(){
        return driver.findElement(ruMailError).getText();
    }
    public ForgotPassPage typeMail(String mail){
        driver.findElement(mailFild).sendKeys(mail);
        return this;
    }
    public ForgotPassPage clickFindBtn(){
        driver.findElement(findBtn).click();
        return new ForgotPassPage(driver);
    }
    public ForgotPassPage findMail(String mail){
        this.typeMail(mail);
        clickFindBtn();
        return new ForgotPassPage(driver);
    }
}
