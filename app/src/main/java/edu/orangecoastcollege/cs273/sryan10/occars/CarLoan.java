package edu.orangecoastcollege.cs273.sryan10.occars;

/**
 * Created by sryan10 on 9/14/2017.
 */

public class CarLoan {

    private static final double STATE_TAX = .08;
    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    public int getTerm() {
        return mTerm;
    }

    public void setTerm(int term) {
        mTerm = term;
    }

    public double taxAmount()
    {
        return mPrice * STATE_TAX;
    }

    public double totalAmount()
    {
        return mPrice +taxAmount();
    }

    public double borrowedAmount()
    {
        return mPrice - mDownPayment;
    }

    public double interestAmount()
    {
        double interestRate;
        switch (mTerm)
        {
            case 3:
                interestRate = .0462;
                break;
            case 4:
                interestRate = .0416;
                break;
            case 5:
                interestRate = .0416;
                break;
            default:
                //should never be used
                interestRate = .5;
                break;
        }
        return borrowedAmount() * interestRate;
    }

    public double monthlyPayment()
    {
        return (borrowedAmount() + interestAmount()) / (mTerm*12);
    }


}
