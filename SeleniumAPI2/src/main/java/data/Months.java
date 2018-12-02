package data;

public enum Months {
    January("Январь"),
    Febrary("Февраль"),
    March("Март"),
    April("Апрель"),
    May("Май"),
    June("Июнь"),
    July("Июль"),
    August("Август"),
    September("Сентябрь"),
    October("Октябрь"),
    November("Ноябрь"),
    December("Декабрь");

    private String month;

    public String getMonth() {
        return month;
    }

    Months(String month) {
        this.month = month;
    }
}
