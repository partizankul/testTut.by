import Utilites.Driver;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Driver.getDriver().get("https://www.tut.by/");
        Logger logger = Logger.getLogger("new logger");


    }
}
