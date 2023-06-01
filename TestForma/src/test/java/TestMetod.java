import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class TestMetod extends MainTest {

    public final SelenideElement firstName = $x("//*[@id='firstName']");
    public final SelenideElement lastName = $x("//*[@id='lastName']");
    public final SelenideElement userEmail = $x("//*[@id='userEmail']");
    public final SelenideElement gender_radio_1 = $x("//div[@class='custom-control custom-radio custom-control-inline'][1]");
    public final SelenideElement userNumber = $x("//*[@id='userNumber']");
    public final SelenideElement dateOfBirthInput = $x("//*[@id='dateOfBirthInput']");
    public final SelenideElement dateOfBirthInputInt = $x("//*[text()='20']");
    public final SelenideElement subjectsContainer = $x("//*[@id='subjectsContainer']");
    public final SelenideElement hobbies_checkbox_3 = $x("//*[text()='Sports']");
    public final SelenideElement currentAddress = $x("//*[@id='currentAddress']");
    public final SelenideElement state = $x("//*[@id='state']");
    public final SelenideElement haryana = $x("//*[text()='Uttar Pradesh']");
    public final SelenideElement city = $x("//*[@id='city']");
    public final SelenideElement lucknow = $x("//*[text()='Lucknow']");
    public final SelenideElement submit = $x("//*[@id='submit']");
    public final SelenideElement chekingSubmittingTheForm = $x("//*[text()='Thanks for submitting the form']");

    public void chekingFirstName(String nameFirst){
        firstName.setValue(nameFirst);
    }

    public void chekingLastName(String name){
        lastName.setValue(name);
    }

    public void chekingUserEmail(String email){
        userEmail.setValue(email);
    }

    public void chekingGender_radio_1(){
        gender_radio_1.click();
    }

    public void chekingUserNumber(String number){
        userNumber.setValue(number);
    }

  public void chekingDateOfBirthInput(){
      dateOfBirthInput.click();
      dateOfBirthInputInt.click();
  }

    public void chekingHobbies_checkbox_3(){
        hobbies_checkbox_3.click();
    }

    public void chekingCurrentAddress(String current){
        currentAddress.setValue(current);
    }

    public void chekingState(){
        state.click();
        haryana.click();
    }

    public void chekingSity(){
        city.click();
        lucknow.click();
    }

    public void chekingSubmit(){
       submit.click();
    }

    public void cheking(){
        chekingSubmittingTheForm.shouldHave();
    }
}




