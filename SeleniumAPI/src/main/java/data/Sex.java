package data;

public enum Sex {
    MALE("Мужские", "мужское имя"),
    FEMALE("Женские", "женское имя"),
    ALL("Все", "Значение не определено");

    private String searchTypeSex;
    private String resultNameType;

    private Sex(String searchTypeSex, String resultNameType){
        this.searchTypeSex = searchTypeSex;
        this.resultNameType = resultNameType;
    }

    public String getSearchTypeSex() {
        return searchTypeSex;
    }

    public String getResultNameType() {
        return resultNameType;
    }
}
