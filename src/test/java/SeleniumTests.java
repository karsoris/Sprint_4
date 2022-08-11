import pages.MainPage;
import pages.OrderPage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(DataProviderRunner.class)
public class SeleniumTests extends MainPageBase {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {MainPage.questions[0], MainPage.answers[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.questions[1], MainPage.answers[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.questions[2], MainPage.answers[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.questions[3], MainPage.answers[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.questions[4], MainPage.answers[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.questions[5], MainPage.answers[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.questions[6], MainPage.answers[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.questions[7], MainPage.answers[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test // Сравнение ответов на вопросы о важном
    @UseDataProvider("data")
    public void test(String question, String answer, String expected) {
        String actual = new MainPage(driver)
                .scrollToQuestionsAboutImportant()
                .clickToGetCookies()
                .getAnswerToQuestions(question, answer);
        assertEquals("Тест свалился, т.к. " + expected + " не равен ожидаемому" + actual, expected, actual);
    }

    private static String oneDayRent = ".//div[@class='Dropdown-option'][1]";
    private static String twoDayRent = ".//div[@class='Dropdown-option'][2]";
    private final static String isScouterColourBlack = ".//input[@id='black']";
    private final static String isScouterColourGray = ".//input[@id='grey']";

    @DataProvider
    public static Object[][] data2() {
        return new Object[][]{
                {"Ян", "Иванов", "Ул. Тверская 16", "+79998887766", "01.01.2000", oneDayRent, isScouterColourBlack, "ну-ка, давай-ка"},
                {"ЕвпатийЕвтьюшка", "Какаятооченьдлиннаяфамилия", "аа45б", "+01112223344", "11.08.2022", twoDayRent, isScouterColourGray, "Awesome comment for my reviewer :)"}
        };
    }

    @Test // Положительный сценарий заполнения первой формы заказа Самоката
    @UseDataProvider("data2")
    public void test2(String name, String family, String adress, String phone, String date, String countRentDays, String scouterColor, String comment) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickToOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.toWriteFormAboutClient(name, family, adress, phone);
        orderPage.isDisplayedNextForm();
        orderPage.toWriteFormAboutRent(date, countRentDays, scouterColor, comment);
        orderPage.isDisplayedOrderNumber();
        assertTrue("Тест свалился, т.к. не отобразилась страница с успешным заказом", false);
    }
}





