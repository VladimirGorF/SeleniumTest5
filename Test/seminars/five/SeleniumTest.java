package seminars.five;

//Напишите автоматизированный тест, который выполнит следующие шаги:
//1. Открывает главную страницу Google.
//2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
//3. В результатах поиска ищет ссылку на официальный сайт Selenium
//(https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди результатов поиска.
//

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    @Test
    void findSelenium() {
        WebDriver driver = new ChromeDriver();  // создали драйвер хрома
        driver.get("https://www.google.com");  // вошли в гугл
        // нашли поисковую строку по имени "q"
        WebElement element = driver.findElement(By.name("q"));
        // отправили запрос в строку ввода через найденный элемент
        element.sendKeys("Selenium");
        // нажали Enter и запустили поиск
        element.submit();
        // находим элемент "https://www.selenium.dev" по xpath
        element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/cite"));
        assertThat(element.getText()).isEqualTo("https://www.selenium.dev");
        driver.quit();
    }

    //    Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя
//    на сайте https://www.saucedemo.com/.
//    Данные для входа - логин: "standard_user", пароль: "secret_sauce". Проверить, что
//    авторизация прошла успешно и отображаются товары.
//    Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys()
//    для ввода данных в поля формы, и submit() для отправки формы. После этого, проверьте,
//    что на странице отображаются продукты (productsLabel.getText() = "Products").
   @Test
    void testSaucedemo(){
       WebDriver driver = new ChromeDriver();  // создали драйвер хрома
       driver.get("https://www.saucedemo.com/");  // вошли в saucedemo.com
       // нашли ввод имени и отправили
       WebElement elemenName = driver.findElement(By.name("user-name"));
       elemenName.sendKeys("standard_user");
       // нашли ввод пароля и отправили
       WebElement elementPassword = driver.findElement(By.name("password"));
       elementPassword.sendKeys("secret_sauce");
       elementPassword.submit();
       WebElement elementProductsLabel = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
       assertEquals(elementProductsLabel.getText(), "Products"  );
       driver.quit();

       // отправка формы

   }



}














