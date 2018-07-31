package bjfu.bit.db;
//存储历史记录的数据库
public class data {
    private int year;
    private int month;
    private int day;
    private double vision;

    public double getVision() {
        return vision;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setVision(double vision) {
        this.vision = vision;
    }
}
