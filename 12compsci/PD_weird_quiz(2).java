class Date {
    private int month, day;

    public Date(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return String.format("%d/%02d", month, day);
    }

    public void advance() {
        if (month == 2 && day == 28) {
            month = 3;
            day = 1;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
            month = (month) % 12 + 1;
            day = 1;
        } else if (day == 31) {
            month = (month) % 12 + 1;
            day = 1;
        } else {
            day++;
        }
    }
}

public class PD_weird_quiz {
    public static void main(String[] args) {
        Date lastday = new Date(1, 1);
        lastday.advance();
        System.out.print("The next day is " + lastday.toString());
    }
}