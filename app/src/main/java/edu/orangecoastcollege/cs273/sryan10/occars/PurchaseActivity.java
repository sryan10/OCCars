package edu.orangecoastcollege.cs273.sryan10.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends AppCompatActivity {

    //Connection to VIEW
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    //connection to the MODEL
    private CarLoan mCarLoan = new CarLoan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        //Use findViewById to connect controller to each view.
        mPriceEditText = (EditText) findViewById(R.id.PriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.DownPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.ThreeYearRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.FourYearRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.FiveYearRadioButton);
    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if (mFourYearRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);
    }

    protected void reportSummary(View v)
    {
        collectCarLoanData();
        String report = "Monthly Payment : $" + mCarLoan.monthlyPayment();
        // More reporting

        //Intents start new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        //Put data into the Intent for Loan Summary to recieve
        launchLoanSummary.putExtra("loanReport", report);
        //Start the second activity
        startActivity(launchLoanSummary);
    }
}
