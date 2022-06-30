Feature: Smoke
  Как пользователь
  Я хочу войти на сайт и пройтись по его основным разделам
  Таким образом я проверю, что сайт в целом работает

  Scenario Outline: Войти и проверить навигацию
    Given Пользователь переходит по начальному адресу сайта 'http://localhost:8080/' и попадает на страницу входа
    When Пользователь входит на сайт, выбрав страну 'Россия', введя телефон '<phone>' и пароль '<password>'
    Then Пользователь попадает на страницу с заголовком 'Личный кабинет'
    Then Пользователь видит на панели навигации список из 21 заголовка разделов

    Examples:
      | phone       | password     |
      | 70000000000 | a123456      |
      | 79165787918 | 854280yNy!13 |
