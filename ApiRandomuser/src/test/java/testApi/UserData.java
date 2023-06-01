package testApi;

public class UserData {

        public  String seed;
        public  Integer results;
        public  Integer page;
        public  String version;


    public UserData(String seed, Integer results, Integer page, String version) {
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public String getSeed() {
        return seed;
    }

    public Integer getResults() {
        return results;
    }

    public Integer getPage() {
        return page;
    }

    public String getVersion() {
        return version;
    }
}
