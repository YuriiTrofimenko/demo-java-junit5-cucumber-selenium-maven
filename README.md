# Demo JUnit5 Testing with Cucumber Reporting
Проект примеров тестирования закрытого веб-приложения restylist на основе каркаса JUnit5 со сценариями тестов на основе Cucumber и с построением отчетов при помощи Cucumber Reporting
## Предварительные требования
- MS Windows 10 / Linux Ubuntu 20.04 / Другие современные настольные OS (не проверено)
- JDK 18
- Maven 3.8.6
- браузер Chrome
## Скачивание и запуск
- скачать:

**git clone** https://github.com/YuriiTrofimenko/demo-java-junit5-cucumber-selenium-maven.git

- драйверы скачиваются по адресу https://www.selenium.dev/downloads/ и добавляются в каталог _src/main/resources/chromedriver_

- модифицировать модели страниц, фасад и сценарий для любого подобного веб-приложения, свободно доступного в сети

- запустить тесты:

**mvn verify**

- файлы отчета будут сгененрированы в каталоге _target/cucumber-html-reports_

## Показаны техники:
- JUnit5
- Selenium 4
- написание сценария теста в формате Gherkin для контейнера Cucumber (в файле src/main/resources/smoke.feature)
- построение отчетов при помощи Maven-плагина Cucumber Reporting