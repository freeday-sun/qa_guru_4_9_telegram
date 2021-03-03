package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.io.File;

public class PracticeFormPage {
  private SelenideElement
      mainHeader = $(".main-header"),
      firstName = $("#firstName"),
      lastName = $("#lastName"),
      email = $("#userEmail"),
      userNumber = $("#userNumber"),
      dataOfBirthWrapper = $(".react-datepicker-wrapper"),
      mountSelector = $(".react-datepicker__month-select"),
      yearSelector = $(".react-datepicker__year-select"),
      uploadButton = $("#uploadPicture"),
      currentAddress = $("#currentAddress"),
      stateSelector = $("#state input"),
      citySelector = $("#city input"),
      submitButton = $("#submit");

  private ElementsCollection
      daysSelectors = $$x("//*[contains(@class, \"react-datepicker__day--\")]"),
      subjectsInput = $$("#subjectsContainer input");

  @Step("Check form titile")
  public PracticeFormPage checkFormTitile(){
    mainHeader.shouldBe(Condition.visible);
    return this;
  }

  @Step("Fill First Name")
  public PracticeFormPage fillFirstName(String firstNameValue){
    firstName.setValue(firstNameValue);
    return this;
  }

  @Step("Fill Last Name")
  public PracticeFormPage fillLastName(String lastNameValue){
    lastName.setValue(lastNameValue);
    return this;
  }

  @Step("Fill email")
  public PracticeFormPage fillEmail(String emailValue){
    email.setValue(emailValue);
    return this;
  }

  @Step("Fill User Number")
  public PracticeFormPage fillUserNumber(String userNumberValue){
    userNumber.setValue(userNumberValue);
    return this;
  }

  @Step("Select Gender")
  public PracticeFormPage selectGender(String gender) {
    $(byText(gender)).click();
    return this;
  }

  @Step("Select Birth Day")
  public PracticeFormPage selectBirthDay(String day, String month, String year) {
    dataOfBirthWrapper.click();
    mountSelector.selectOption(month);
    yearSelector.selectOption(year);
    daysSelectors.findBy(Condition.text(day)).click();
    return this;
  }

  @Step("Select Subjects")
  public PracticeFormPage selectSubjects(String subjects){
    subjectsInput.get(0).setValue(subjects).pressEnter();
    return this;
  }

  @Step("Select Hobbies")
  public PracticeFormPage selectHobbies(String hobbies){
      $(Selectors.withText(hobbies)).click();
    return this;
  }

  @Step("Upload picture")
  public PracticeFormPage uploadPicture(String imagePath){
    uploadButton.uploadFile(new File(imagePath));
    return this;
  }

  @Step("Fill address")
  public PracticeFormPage fillAddress(String address){
    currentAddress.setValue(address);
    return this;
  }

  @Step("Fill state")
  public PracticeFormPage fillState(String state){
    stateSelector.setValue(state).pressEnter();
    return this;
  }

  @Step("Fill city")
  public PracticeFormPage fillCity(String city){
    citySelector.setValue(city).pressEnter();
    return this;
  }

  @Step("Click sumbit")
  public PracticeFormPage clickSubmitButton(){
    submitButton.click();
    return this;
  }

}
