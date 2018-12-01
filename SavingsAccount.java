/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import static guitest.TimerTest.getValue;
import static guitest.TimerTest.isDeposit;
import static guitest.TimerTest.randomValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class SavingsAccount extends AccountInterface
{
    //constructor
    public SavingsAccount(int startingAmount) 
    {
        super(startingAmount);
    
        firstAmount = startingAmount;
    }
    
    private int firstAmount;
    private int firstAmountAdded = 0;
    private int currentTrans = 0;
    private Integer ballanceInAccount = 0;
    private int numOfWithdrawals = 0;
    
    //This will be the array that will keep track of the transactions each month 
     ArrayList<Integer> transactionsList = new ArrayList<Integer>();
    
    //This will be the array tracking the balances at each month
    ArrayList<Integer> arrayOfBalances = new ArrayList<Integer>();
    
    //A sorted copy of the arrayOfBalances to allow getting the max values by sorting it
    ArrayList<Integer> sortedArrayOfBalances = new ArrayList<Integer>();
    
    @Override
    public void timer() 
    {
        schedule(new TimerTask() 
        {
            @Override
            public void run() 
            { 
                if (firstAmountAdded == 0)
                {
                    transactionsList.add(firstAmount);
                    firstAmountAdded++;
                }
                else
                {
                    currentTrans=getValue(isDeposit(), randomValue());
                    getCurrentValue();
                    transactionsList.add(currentTrans);
                }
            }
        }, 0, 5000); 
    }
    
    //this for loop updates the array of balances to ensure a running balance is kept
    private void balances()
    {
        for (int i=0; i<getTransList().size(); i++)
        {
            Integer currentAmount = (Integer) getTransList().get(i);
            ballanceInAccount = ballanceInAccount + currentAmount;
            arrayOfBalances.add(ballanceInAccount);
        }
    }
    
    //TODO this method should be in super class as is used in savings account
    //TODO turn this method to spit out a string that goes to the text pane
    //This method gets and sorts the balancesarray and displaying the values
    public void getResultText2()
    {
        //Move this method to the result panel have a parameter for this method be the reference for the current account class
    	sortedArrayOfBalances = getBalanceList();
        
        System.out.println("These are the balances chronologically" + getBalanceList());
        //getMaxAndMinBalances2();
        System.out.println("This is the final balance "+ getBalanceList().get(getBalanceList().size()-1));
       
        Collections.sort(sortedArrayOfBalances);      
        System.out.println("This a list of the sorted balances" + sortedArrayOfBalances);
    }
    
    //TODO this method should be in super class as is used in savings account
    //this method finds the month that a value was obtained
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

    //TODO this method should be in super class as is used in savings account
    //This method gets the min and Max balance and their dates 
    protected String getMaxAndMinBalances2(ArrayList<Integer> array)
    {
        //System.out.println("This is the max value, " + Collections.max(sortedArrayOfBalances)+ " Which was during month " + findMonthOfBalance(Collections.max(sortedArrayOfBalances)));
        //System.out.println("This is the min value, " + Collections.min(sortedArrayOfBalances)+ " Which was during month " + findMonthOfBalance(Collections.min(sortedArrayOfBalances)));
        
        String s = "The max balance was " + Collections.max(array)+ "  during month " + findMonthOfBalance(Collections.max(array));
        s += "\nThe min balance was " + Collections.min(array)+ " during month " + findMonthOfBalance(Collections.min(array));
        
        return s;
    }
    
    public ArrayList getTransList()
    {
        return transactionsList;
    }
    
    public int getCurrentValue()
    {
        System.out.println(currentTrans);
        return currentTrans;
    }
    
    public ArrayList getBalanceList()
    {
        return arrayOfBalances;
    }
    
    public Timer getTimer()
    {
        return this;
    }
    
    
    //this is called to stop the timer and create the balancearray and show the results 
    public void stopTimer()
    {
        cancel();
        purge();
        balances();
    }
    
    public static boolean isDeposit() 
    {
        Random r = new Random();
        boolean i = r.nextBoolean();
        return i;
    }
    
    public static int randomValue()
    {
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

