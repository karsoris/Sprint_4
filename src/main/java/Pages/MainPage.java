package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(pageUrl);
    }

    WebDriver driver;
    public final String pageUrl = "https://qa-scooter.praktikum-services.ru/";
    // путь до Вопросы о важном
    @FindBy(xpath = ".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']")
    private WebElement questionsAboutImportant;
    public final static String[] questions = {
            ".//div[@id='accordion__heading-0']", //Вопрос Сколько стоит
            ".//div[@id='accordion__heading-1']", //Вопрос Хочу сразу несколько самокатов! Так можно?
            ".//div[@id='accordion__heading-2']", //Вопрос Как рассчитывается время аренды?
            ".//div[@id='accordion__heading-3']", //Вопрос Можно ли заказать самокат прямо на сегодня?
            ".//div[@id='accordion__heading-4']", //Вопрос Можно ли продлить заказ или вернуть самокат раньше?
            ".//div[@id='accordion__heading-5']", //Вопрос Вы привозите зарядку вместе с самокатом?
            ".//div[@id='accordion__heading-6']", //Вопрос Можно ли отменить заказ?
            ".//div[@id='accordion__heading-7']", //Вопрос Я жизу за МКАДом, привезёте?
    };
    public final static String[] answers = {
            "accordion__panel-0", //Ответ на вопрос Сколько стоит?
            "accordion__panel-1", //Ответ на вопрос Хочу сразу несколько самокатов! Так можно?
            "accordion__panel-2", //Ответ на вопрос Как рассчитывается время аренды?
            "accordion__panel-3", //Ответ на вопрос Можно ли заказать самокат прямо на сегодня?
            "accordion__panel-4", //Ответ на вопрос Можно ли продлить заказ или вернуть самокат раньше?
            "accordion__panel-5", //Ответ на вопрос Вы привозите зарядку вместе с самокатом?
            "accordion__panel-6", //Ответ на вопрос Можно ли отменить заказ?
            "accordion__panel-7", //Ответ на вопрос Я жизу за МКАДом, привезёте?
    };
    /*
    @FindBy(id = "accordion__heading-0") //Вопрос Сколько стоит
    public static WebElement question0;
    @FindBy(id = "accordion__heading-1") //Вопрос Хочу сразу несколько самокатов! Так можно?
    private static WebElement question1;
    @FindBy(id = "accordion__heading-2") //Вопрос Как рассчитывается время аренды?
    private static WebElement question2;
    @FindBy(id = "accordion__heading-3") //Вопрос Можно ли заказать самокат прямо на сегодня?
    private static WebElement question3;
    @FindBy(id = "accordion__heading-4") //Вопрос Можно ли продлить заказ или вернуть самокат раньше?
    private static WebElement question4;
    @FindBy(id = "accordion__heading-5") //Вопрос Вы привозите зарядку вместе с самокатом?
    private static WebElement question5;
    @FindBy(id = "accordion__heading-6") //Вопрос Можно ли отменить заказ?
    private static WebElement question6;
    @FindBy(id = "accordion__heading-7") //Вопрос Я жизу за МКАДом, привезёте?
    private static WebElement question7;
    @FindBy(id = "accordion__panel-0") //Ответ на вопрос Сколько стоит?
    public static WebElement answers0;
    @FindBy(id = "accordion__panel-1") //Ответ на вопрос Хочу сразу несколько самокатов! Так можно?
    private static WebElement answers1;
    @FindBy(id = "accordion__panel-2") //Ответ на вопрос Как рассчитывается время аренды?
    private static WebElement answers2;
    @FindBy(id = "accordion__panel-3") //Ответ на вопрос Можно ли заказать самокат прямо на сегодня?
    private static WebElement answers3;
    @FindBy(id = "accordion__panel-4") //Ответ на вопрос Можно ли продлить заказ или вернуть самокат раньше?
    private static WebElement answers4;
    @FindBy(id = "accordion__panel-5") //Ответ на вопрос Вы привозите зарядку вместе с самокатом?
    private static WebElement answers5;
    @FindBy(id = "accordion__panel-6") //Ответ на вопрос Можно ли отменить заказ?
    private static WebElement answers6;
    @FindBy(id = "accordion__panel-7") //Ответ на вопрос Я жизу за МКАДом, привезёте?
    private static WebElement answers7;


     */

    // Блок с текстом ответов на вопросы о Самом важном в подвале страницы
    public String getAnswerToQuestions(String question, String answer) {
        driver.findElement(By.xpath(question)).click();
        return driver.findElement(By.id(answer)).getText();

    }

    //Скролл до блока Вопросы о важном
    public MainPage scrollToQuestionsAboutImportant() {

        this.questionsAboutImportant = questionsAboutImportant;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionsAboutImportant);
        return this;
    }

    // Клик по модальному окну получить куки
    public MainPage clickToGetCookies() {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        return this;
    }

    public MainPage clickToOrderButton() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        return this;
    }

}


