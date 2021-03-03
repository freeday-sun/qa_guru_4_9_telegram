package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CompleteFormPage {
  SelenideElement modalTitle = $x("//*[@class='modal-title h4']");

  ElementsCollection formDate = $$x("//tbody//tr//td");

  public CompleteFormPage checkFormTitle(String formTitle){
    modalTitle.shouldHave(text(formTitle));
    return this;
  }

  @Step("Verify successful form submit")
  public CompleteFormPage validateData(
      String firstName,
      String lastName,
      String email,
      String gender,
      String phoneNumber,
      String day,
      String month,
      String year,
      String filePath,
      String address,
      String state,
      String city,
      String subjects,
      String hobbies){
    formDate.get(0).shouldHave(text("Student Name"));
    formDate.get(1).shouldHave(text(firstName +" " +lastName));
    formDate.get(2).shouldHave(text("Student Email"));
    formDate.get(3).shouldHave(text(email));
    formDate.get(4).shouldHave(text("Gender"));
    formDate.get(5).shouldHave(text(gender));
    formDate.get(6).shouldHave(text("Mobile"));
    formDate.get(7).shouldHave(text(phoneNumber));
    formDate.get(8).shouldHave(text("Date of Birth"));
    formDate.get(9).shouldHave(text(day + " " + month + "," + year));
    formDate.get(10).shouldHave(text("Subjects"));
    formDate.get(11).shouldHave(text(subjects));
    formDate.get(12).shouldHave(text("Hobbies"));
    formDate.get(13).shouldHave(text(hobbies));
    formDate.get(14).shouldHave(text("Picture"));
    formDate.get(15).shouldHave(text(filePath));
    formDate.get(16).shouldHave(text("Address"));
    formDate.get(17).shouldHave(text(address));
    formDate.get(18).shouldHave(text("State and City"));
    formDate.get(19).shouldHave(text(state + " " + city));

    return this;
  }


}
