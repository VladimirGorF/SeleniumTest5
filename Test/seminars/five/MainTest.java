package seminars.five;

import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class MainTest {
    //5.1.

//    Создайте два модуля. Первый модуль генерирует список случайных чисел.
//    Второй модуль находит максимальное число в этом списке.
//    Вам нужно сначала написать юнит-тесты для каждого модуля, затем
//    написать интеграционный тест, который проверяет, что оба модуля работают
//    вместе правильно

@Test    // Юнит-Тест
    void testRandomGen(){
    RandomNumberModule random = new RandomNumberModule();
    ArrayList <Integer> array = random.getList(5);
    assertThat(array.size()).isEqualTo(5);

}
    @Test   // Юнит-Тест
    void testMaxNumberModule(){
        ArrayList <Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4,5,8)) ;
        MaxNumberModule maxModule = new MaxNumberModule();
        assertThat(maxModule.getMax(array)).isEqualTo(8);

    }

    @Test   // Интеграционный-Тест
    void testMaxAndRandomModules(){
        // Создаем рандомный array в модуле рандомов
        RandomNumberModule random = new RandomNumberModule();
        ArrayList <Integer> array = random.getList(5);

        // Создаем модуль опредедения максимума в массиве
        MaxNumberModule maxModule = new MaxNumberModule();


        // Интеграционный тест
        assertThat(maxModule.getMax(array)).isEqualTo(Collections.max(array));
    }

    //5.2.

//У вас есть два класса - UserService и UserRepository.
//        UserService использует UserRepository для
//        получения информации о пользователе. Ваша
//        задача - написать интеграционный тест, который
//        проверяет, что UserService и UserRepository
//        работают вместе должным образом.

    @Test
    void userReposTest(){
        UserRepository repository = new UserRepository();
    assertThat(repository.getUserById(1)).isEqualTo("User 1");
    }

    @Test
    void userServiceTest(){
        UserRepository repository = mock(UserRepository.class);
        String result = repository.getUserById(1);
        UserService service = new UserService(repository);
        assertThat(service.getUserName(1)).isEqualTo(result);
    }

    @Test
    void userServiceRepositoryTest(){
    // Интеграционный тест
        UserRepository repository = new UserRepository();
        String result = repository.getUserById(1);
        UserService service = new UserService(repository);
        assertThat(service.getUserName(1)).isEqualTo(result);
    }



    //5.3.
//    У вас есть сервис по обработке заказов, состоящий из двух классов:
//    OrderService и PaymentService. Класс OrderService обрабатывает заказы
//    и делает вызовы к PaymentService для обработки платежей. Ваша задача
//        - написать интеграционный тест, который проверяет, что
//    OrderService и PaymentService взаимодействуют корректно
    @Test
    void orderServicePaymentTest(){
        PaymentService payment = new PaymentService();
        OrderService order = new OrderService(payment);
        Boolean result = payment.processPayment("1", 22.20);
        assertThat(order.placeOrder("1", 22.20)).isEqualTo(result);
    }


}