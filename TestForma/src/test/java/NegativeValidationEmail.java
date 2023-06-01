import com.codeborne.selenide.Condition;
public class NegativeValidationEmail extends TestMetod {

    public void ChekingNigativeEmail(){
        userEmail.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
