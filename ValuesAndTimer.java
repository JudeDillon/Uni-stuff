
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ValuesAndTimer {

    public static void main(String[] args) {
        timer();
    }

    public static void timer() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(getValue(isDeposit(), randomValue()));
            }
        }, 0, 5000);
    }

    public static boolean isDeposit() {
        Random r = new Random();
        boolean i = r.nextBoolean();
        return i;
    }
    
    public static int randomValue() {
        Random r = new Random();
        int value = 100 + r.nextInt(2000);
        return value;
    }
    
    public static int getValue(boolean isDeposit, int value)
    {
        if(isDeposit)
        {
            return value;
        }
        else
        {
            return (-1 * value);
        }
    }
}
