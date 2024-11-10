import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class AddEventTestStep {

    public static WebDriver driver;

    public static void setUp() {

        // Настройка WebDriverManager для Chrome

        WebDriverManager.chromedriver().setup();

        // Инициализация ChromeDriver

        driver = new ChromeDriver();

    }

    public  static  void openURL(String URL)
    {
        driver.get(URL);
    }
    public static void findFrime (String frame)
    {
        int seconds = 1;
        // Корректное создание Duration из seconds
        Duration duration = Duration.ofSeconds(seconds);
        // Ожидание появления iframe
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
    public static void clickCreate (ChromeDriver driver)
    {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Create')]"));
        element.click();
    }
    public  static String titleName()
    {
        double randomValue = Math.random();
        int randomInt = (int) (randomValue * 10000);
        String titleName = new String("Event"+randomInt);
        return titleName;
    }
    public static void fillTitle(String titlename)
    {
        WebElement title = driver.findElement(By.xpath("//*[@id=\"textfield-1039-inputEl\"]"));
        title.sendKeys(titlename);

    }
    public static  void clickForm()
    {
        WebElement from = driver.findElement(By.xpath("//*[@id=\"datefield-1041-trigger-picker\"]"));
        from.click();
    }
    public static String getMounth()
    {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return monthName;
    }
    public static int getDay()
    {
        LocalDate today = LocalDate.now();
        // Получаем последнее число текущего месяца
        LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        // Получаем имя текущего месяца в формате "November"
        int dayOfMonth = lastDayOfMonth.getDayOfMonth();
        return dayOfMonth;
    }
    public static void SetDay(String getMounth,int getDay,String fillName)
    {
        //date 1
        if(fillName.equals("from"))
        {
            String xpathExpression1 = String.format("(//*[@aria-label=\"%s %d\"])",getMounth,getDay);
            WebElement date1 = driver.findElement(By.xpath(xpathExpression1));
            date1.click();
        }
        else if(fillName.equals("to"))
        {
            String xpathExpression1 = String.format("(//*[@aria-label=\"%s %d\"])[2]",getMounth,getDay);
            WebElement date1 = driver.findElement(By.xpath(xpathExpression1));
            date1.click();
        }
        else System.out.println("Неверное значение");

    }

    public static  void allDayClick()
    {
        //allDAY
        WebElement allDay = driver.findElement(By.xpath("//*[@id=\"checkbox-1046-inputEl\"]"));
        allDay.click();
    }

    public static  void timeClickFrom(String fillName)
    {
        if(fillName.equals("from"))
        {
            WebElement timeclick = driver.findElement(By.xpath("//*[@id=\"timefield-1042-trigger-picker\"]"));
            timeclick.click();
        }
        else if(fillName.equals("to"))
        {
            WebElement timeclick2 = driver.findElement(By.xpath("//*[@id=\"timefield-1045-trigger-picker\"]"));
            timeclick2.click();
        }
    }


    public static  void scroolTimeFrom(String time,String fillName)
    {
        Actions actions = new Actions(driver);
        if(fillName.equals("from"))
        {

            WebElement timeElement = driver.findElement(By.xpath("//li[@data-boundview=\"timefield-1042-picker\" and text()='" + time + "']"));
            actions.moveToElement(timeElement).click().perform();
        }
        else if(fillName.equals("to"))
        {
            WebElement timeElement1 = driver.findElement(By.xpath("//li[@data-boundview=\"timefield-1045-picker\" and text()='"+ time +"']"));
            actions.moveToElement(timeElement1).click().perform();
        }
    }
    public static  void setDescription(String titlevalue)
    {
        WebElement description = driver.findElement(By.xpath("//div[@id=\"textarea-1047-inputWrap\"]/textarea"));
        description.click();
        description.sendKeys(titlevalue);
    }


    public static  void clickTo()
    {
        WebElement to = driver.findElement(By.xpath("//*[@id=\"datefield-1044-trigger-picker\"]"));
        to.click();
    }

    public static void clickSave ()
    {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Save')]"));
        element.click();
    }

    public static void clickButton(String buttonName)
    {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), '" + buttonName + "')]"));
        element.click();
    }

    public static void findText(String titleName) {// Определите текст для поиска

        String searchText = "Event"; // Замените на текст, который вы хотите найти


        // Поиск элемента и проверка текста

        boolean textFound = false;


        // Получите все элементы на странице

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + titleName + "')]"));


        // Проверка содержания текста в каждом элементе

        for (WebElement element : elements) {

            if (element.getText().contains(searchText)) {

                textFound = true;

                System.out.println("Ивент найден: " + element.getText());

                break; // Выходим из цикла, если текст найден

            }

        }

        if (!textFound) {

            System.out.println("Ивент не найден на странице.");

        }
    }

}
