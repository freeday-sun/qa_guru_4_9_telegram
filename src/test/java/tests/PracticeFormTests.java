package tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CompleteFormPage;
import pages.PracticeFormPage;

public class PracticeFormTests extends BaseTest {
  @BeforeAll
  static void beforeAll() {
    open("https://demoqa.com/automation-practice-form");
  }

  @Test
  void praticeFormTest(){
    addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    // preparation
    String firstName = faker.name().firstName(),
        lastName = faker.name().lastName(),
        email = faker.internet().emailAddress(),
        phoneNumber = faker.phoneNumber().subscriberNumber(10),
        address = faker.address().fullAddress(),
        gender = "Other",
        filePath = "trying.jpg",
        state = "NCR",
        city = "Delhi",
        day = String.valueOf(faker.random().nextInt(1, 30)),
        month = "April",
        year = String.valueOf(faker.random().nextInt(1950, 2000)),
        subjects = "Maths",
        hobbies = "Sports";

    PracticeFormPage practiceForm = new PracticeFormPage();
    CompleteFormPage completeFormPage = new CompleteFormPage();
    String expectedCompleteFormTitle = "Thanks for submitting the form";


    // action
    practiceForm
        .checkFormTitile()
        .fillFirstName(firstName)
        .fillLastName(lastName)
        .fillEmail(email)
        .selectGender(gender)
        .fillUserNumber(phoneNumber)
        .selectBirthDay(day, month, year)
        .selectSubjects(subjects)
        .selectHobbies(hobbies)
        .uploadPicture("src/test/resources/" + filePath)
        .fillAddress(address)
        .fillState(state)
        .fillCity(city)
        .clickSubmitButton();

    // assert
    completeFormPage
        .checkFormTitle(expectedCompleteFormTitle)
        .validateData(
            firstName,
            lastName,
            email,
            gender,
            phoneNumber,
            day,
            month,
            year,
            filePath,
            address,
            state,
            city,
            subjects,
            hobbies);

  }

  @Test
  @Tag("negative")
  void negativeTest(){
    addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    // preparation
    CompleteFormPage completeFormPage = new CompleteFormPage();
    String expectedCompleteFormTitle = "Thanks for submitting the form";

    // assert
    completeFormPage
        .checkFormTitle(expectedCompleteFormTitle);
  }
}
