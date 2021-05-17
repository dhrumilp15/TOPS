// hey Mr. Jay I'm sorry for resubmitting - I thought there was something with my code so I resubmitted :)

class Date {
    private int mensis, dies;

    public Date(int mensis, int dies) {
        this.mensis = mensis;
        this.dies = dies;
    }

    public String toString() {
        return String.format("%d/%02d", mensis, dies);
    }

    public void advance() {
        if (mensis == 2 && dies == 28) {
            mensis = 3;
            dies = 1;
        } else if ((mensis == 4 || mensis == 6 || mensis == 9 || mensis == 11) && dies == 30) {
            mensis = (mensis) % 12 + 1;
            dies = 1;
        } else if (dies == 31) {
            mensis = (mensis) % 12 + 1;
            dies = 1;
        } else {
            dies++;
        }
    }
}

public class PD_weird_quiz {
    public static void main(String[] args) {
        Date epicdies = new Date(1, 1);
        epicdies.advance();
        System.out.print("The next day is " + epicdies.toString());
    }
}