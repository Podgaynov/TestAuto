import org.junit.Test;
public class MainTest extends MainSettings {
    private final static String BASE_URL = "https://demoqa.com/automation-practice-form";
    private final static String FIRST_NAME = "Thomas";
    private final static String LAST_NAME = "Anderson";
    private final static String USER_EMAIL = "neo@mail.ru";
    private final static String NEGATIVE_EMAIL = "@mail.ru";
    private final static String USER_NUMBER = "7777777777";
    private final static String SUBJECTS_CONTAINER = "Lorem ipsum dolor sit amet";
    private final static String CURRENT_ADDRESS = "Mathematics and computer science";

    @Test
    public void chkingValidValue(){
    СonnectionSite connectionSite = new СonnectionSite(BASE_URL);
    TestMetod testMetod = new TestMetod();
    testMetod.chekingFirstName(FIRST_NAME);
    testMetod.chekingLastName(LAST_NAME);
    testMetod.chekingUserEmail(USER_EMAIL);
    testMetod.chekingGender_radio_1();
    testMetod.chekingUserNumber(USER_NUMBER);
    testMetod.chekingDateOfBirthInput();
    testMetod.chekingHobbies_checkbox_3();
    testMetod.chekingCurrentAddress(CURRENT_ADDRESS);
    testMetod.chekingState();
    testMetod.chekingSity();
    testMetod.chekingSubmit();
    testMetod.cheking();
}

    @Test
    public void chkingNegativeValueFields(){
        СonnectionSite connectionSite = new СonnectionSite(BASE_URL);
        NegativeValidation negativeValidation = new NegativeValidation();
        negativeValidation.chekingHighlightingRequir();
        negativeValidation.chekingHighlightingRequiredFields();
    }

    @Test
    public void NegativeValueEmail(){
        СonnectionSite connectionSite = new СonnectionSite(BASE_URL);
        NegativeValidationEmail negativeValidationEmail = new NegativeValidationEmail();
        TestMetod testMetod = new TestMetod();
        testMetod.chekingFirstName(FIRST_NAME);
        testMetod.chekingLastName(LAST_NAME);
        testMetod.chekingUserEmail(NEGATIVE_EMAIL);
        testMetod.chekingUserNumber(USER_NUMBER);
        testMetod.chekingGender_radio_1();
        testMetod.chekingSubmit();
        negativeValidationEmail.ChekingNigativeEmail();
    }
}
