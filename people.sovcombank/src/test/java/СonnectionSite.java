import com.codeborne.selenide.Selenide;

public class ÑonnectionSite {

    public  ÑonnectionSite (String url){
        Selenide.open(url);
    }
}
