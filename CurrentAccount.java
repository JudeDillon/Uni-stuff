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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author b00741734
 */
public class CurrentAccount extends AccountInterface
{
    //constructor
    public CurrentAccount(int startingAmount) 
    {
        super(startingAmount);
        timer();
    }
    
    // need to add first element then stop for 5000 but only once
    
    private int firstAmountAdded = 0;
    private int currentTrans = 0;
    private Integer ballanceInAccount = 0;
    
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
                    transactionsList.add(currentTrans);
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
    
    private void balances()
    {
        for (int i=0; i<getTransList().size(); i++)
        {
            Integer currentAmount = (Integer) getTransList().get(i);
            ballanceInAccount = ballanceInAccount + currentAmount;
            arrayOfBalances.add(ballanceInAccount);
            
        }
        System.out.print("current balance: " + arrayOfBalances);
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
    
    public void getResultText2(/*ArrayList sortedArray, ArrayList originalArray*/)
    {
        sortedArrayOfBalances = arrayOfBalances;
        System.out.println("These are the balances chronologically" + arrayOfBalances);
        getMaxAndMinBalances();
        System.out.println("This is the final balance "+ arrayOfBalances.get(arrayOfBalances.size()-1));
        Collections.sort(sortedArrayOfBalances);      
        System.out.println("This a list of the sorted balances" + sortedArrayOfBalances);
        
        String result = "arrayOfBalances";
        //return "result";
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
    
    public void stopTimer()
    {
        cancel();
        purge();
        balances();
        getResultText2();
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


