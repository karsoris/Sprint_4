package Pages;

import com.sun.tools.javac.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
    @FindBy(className = "Order_Header__BZXOb")
    private WebElement isDisplayedSecondFormOrder;
    public boolean isDisplayedNextForm() {
        return isDisplayedSecondFormOrder.isDisplayed();
    }

    @FindBy(linkText = ".//div[text()='Заказ оформлен']")
    private WebElement succesOrder;

    public boolean toSuccesOrder() {
        return succesOrder.isDisplayed();
    }
    @FindBy(xpath = ".//input[@placeholder='* Имя']")
    private WebElement isName; //Путь к полю Имя
    @FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private WebElement isFamily; // Путь к полю Фамилия
    @FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement isAdress; // Путь к полю Адрес
    @FindBy(xpath = ".//input[@placeholder='* Станция метро']")
    private WebElement isMetroStation; // Путь к полю Станция метро
    private final static String isMetroStationChoise = ".//input[@class='select-search__input' and @value='Улица Академика Янгеля']"; // Путь к полю Станция метро
    @FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement isPhone; // Путь к полю Телефон
    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement isButtonNext; // Путь к кнопке Далее

    public OrderPage toWriteFormAboutClient(String name, String family, String adress, String phone) {
        setValidName(name);
        setValidFamily(family);
        setValidAdress(adress);
        setMetroStation();
        setValidPhone(phone);
        clickNextButtonToForm2();
        return new OrderPage(driver);
    }


    public void setValidName(String name) {
        isName.sendKeys(name);

    }

    public void setValidFamily(String family) {
        isFamily.sendKeys(family);

    }

    public void setValidAdress(String adress) {
        isAdress.sendKeys(adress);

    }

    public void setMetroStation() {
        isMetroStation.click();
        isMetroStation.sendKeys(Keys.DOWN);
        isMetroStation.sendKeys(Keys.ENTER);

    }

    public void setValidPhone(String phone) {
        isPhone.sendKeys(phone);

    }

    public OrderPage clickNextButtonToForm2() {
        isButtonNext.click();
        return new OrderPage(driver);
    }
    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private WebElement isCalendar;
    @FindBy(xpath = ".//div[@class='Dropdown-placeholder']")
    private WebElement isRentTime;
    @FindBy(xpath = ".//input[@placeholder='Комментарий для курьера']")
    private WebElement isComment;
@FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
private WebElement finalOrderButton;
    @FindBy(xpath = ".//button[text()='Да']")
    private WebElement confirmOrderButton;
    @FindBy(xpath = ".//div[@class='Order_ModalHeader__3FDaJ']")
    private WebElement orderNumber;


    public OrderPage toWriteFormAboutRent(String date, String countRentDays,String scouterColor,String comment) {
        setDateCalendar(date);
        setRentTime(countRentDays);
        setScooterColor(scouterColor);
        setIsComment(comment);
        toFinishOrder();
        toConfirmOrder();
        return new OrderPage(driver);
    }
    public void setDateCalendar (String date) {
        isCalendar.click();
        isCalendar.sendKeys(date);
        isCalendar.sendKeys(Keys.ENTER);

    }
    public void setRentTime(String countRentDays) {
        isRentTime.click();
        driver.findElement(By.xpath(countRentDays)).click();
        }
public void setScooterColor(String scooterColor) {
        driver.findElement(By.xpath(scooterColor));
}
public void setIsComment(String comment) {
        isComment.sendKeys(comment);
}
public void toFinishOrder(){
    finalOrderButton.click();
}
public void toConfirmOrder(){
    confirmOrderButton.click();
    }
public boolean isDisplayedOrderNumber(){
    return orderNumber.isDisplayed();

}

}
