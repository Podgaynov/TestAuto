import com.codeborne.selenide.Condition;
public class NegativeValidation extends TestMetod {

   public void chekingHighlightingRequir(){
      chekingSubmit();
   }

   public void chekingHighlightingRequiredFields(){
      firstName.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
      lastName.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
      userNumber.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
   }
}
