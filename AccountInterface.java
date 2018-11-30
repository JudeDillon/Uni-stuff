/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ryan
 */
public class AccountInterface extends Timer
{
    //constructor
    public AccountInterface(int startingAmount)
    {
        currentValue=startingAmount;
        timer();
    }
    // need to add first element then stop for 5000 but only once
    
    private int firstAmountAdded = 0;
    private int currentValue = 0;
    private int ballanceInAccount = 0;
    
    //This will be the array that will keep track of the transactions each month 
     ArrayList<Integer> transactionsList = new ArrayList<Integer>();
    
    //This will be the array tracking the balances at each month
    ArrayList<Integer> arrayOfBalances = new ArrayList<Integer>();
    
    //A sorted copy of the arrayOfBalances to allow getting the max values by sorting it
    ArrayList<Integer> sortedArrayOfBalances = new ArrayList<Integer>();
    
    public void timer() 
    {
        schedule(new TimerTask() 
        {
            @Override
            public void run() 
            { 
                if (firstAmountAdded == 0)
                {
                    transactionsList.add(currentValue);
                    firstAmountAdded++;
                }
                else
                {
                    currentValue=getValue();
                    getCurrentValue();
                    ballanceInAccount = ballanceInAccount + currentValue;
                    arrayOfBalances.add(ballanceInAccount);
                
                transactionsList.add(currentValue);
                }
            }
        }, 0, 5000); 
    }
    
    public String getResultText(/*ArrayList sortedArray, ArrayList originalArray*/)
    {
        sortedArrayOfBalances = arrayOfBalances;
        System.out.println("These are the balances chronologically" + arrayOfBalances);
        getMaxAndMinBalances();
        System.out.println("This is the final balance "+ arrayOfBalances.get(arrayOfBalances.size()-1));
        Collections.sort(sortedArrayOfBalances);      
        System.out.println("This a list of the sorted balances" + sortedArrayOfBalances);
        
        String result = "arrayOfBalances";
        return "result";
    }
    
    protected void getMaxAndMinBalances()
    {
        System.out.println("This is the max value, " + Collections.max(sortedArrayOfBalances)+ " Which was during month " + findMonthOfBalance(Collections.max(sortedArrayOfBalances)));
        System.out.println("This is the min value, " + Collections.min(sortedArrayOfBalances)+ " Which was during month " + findMonthOfBalance(Collections.min(sortedArrayOfBalances)));
    }
    
    protected Integer findMonthOfBalance(Integer goalValue)
    {
        int i=0;
        while (true)
        {
            
            if (arrayOfBalances.get(i) == goalValue)
            {
                break;
            }
            i++;
        }
        return i;
    }
    
    public ArrayList getAmountList()
    {
        return transactionsList;
    }
    
    public int getCurrentValue()
    {
        System.out.println(currentValue);
        return currentValue;
    }
    
    public ArrayList getBalanceList()
    {
        return arrayOfBalances;
    }
    
    public Timer getTimer()
    {
        return this;
    }
    
    public void stopTimer()
    {
        cancel();
        purge();
    }
    
    public static int getValue()
    {
        return 0;
    }
}
