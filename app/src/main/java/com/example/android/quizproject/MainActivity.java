package com.example.android.quizproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
        }

        private void checkQuestionOneAnswer(){
            CheckBox questionOneNuker = (CheckBox) findViewById(R.id.checkboxNuker);
            CheckBox questionOneCarry = (CheckBox) findViewById(R.id.checkboxCarry);
            CheckBox questionOneDurable = (CheckBox) findViewById(R.id.checkboxDurable);
            CheckBox questionOneSupport = (CheckBox) findViewById(R.id.checkboxSupport);
            boolean isQuestionOneNukerChecked = questionOneNuker.isChecked();
            boolean isQuestionOneCarryChecked = questionOneCarry.isChecked();
            boolean isQuestionOneDurable = questionOneDurable.isChecked();
            boolean isQuestionOneSupport = questionOneSupport.isChecked();
            if (!isQuestionOneNukerChecked && !isQuestionOneCarryChecked && isQuestionOneDurable && isQuestionOneSupport){
                correctAnswers += 1;
            }else{
                return;
            }

    }
    private void checkQuestionTwoAnswer(){
        RadioButton radioButtonKotl = (RadioButton) findViewById(R.id.radioKotl);
        RadioButton radioButtonDoom = (RadioButton) findViewById(R.id.radioDoom);
        RadioButton radioButtonZeus = (RadioButton) findViewById(R.id.radioZeus);
        RadioButton radioButtonLs = (RadioButton) findViewById(R.id.radioLs);
        boolean isQuestionTwoKotlCheck = radioButtonKotl.isChecked();
        boolean isQuestionTwoDoomCheck = radioButtonDoom.isChecked();
        boolean isQuestionTwoZeusCheck = radioButtonZeus.isChecked();
        boolean isQuestionTwoLsCheck = radioButtonLs.isChecked();
        if (isQuestionTwoKotlCheck &&!isQuestionTwoDoomCheck && !isQuestionTwoZeusCheck && !isQuestionTwoLsCheck){
            correctAnswers += 1;
        }else {
            return;
        }
    }
    private String getQuestionThreeUserInput(){
        EditText userInputViperAtribute = (EditText) findViewById(R.id.answerViperAtribute);
        String atribute = userInputViperAtribute.getText().toString();
        return atribute;
    }

    private void checkQuestionThreeAnswer(){
        String atribute = getQuestionThreeUserInput();
        if (atribute.trim().equalsIgnoreCase("agility")){
            correctAnswers += 1;
        }else {
            return;
        }
    }
    private void checkQuestionFourAnswer(){
        RadioButton radioButtonDyingToNeutral = (RadioButton) findViewById(R.id.radioDyingToNeutral);
        RadioButton radioButtonSuicide = (RadioButton) findViewById(R.id.radioSuicide);
        RadioButton radioButtonDyingToRoshan = (RadioButton) findViewById(R.id.radioDyingToRoshan);
        RadioButton radioButtonDyingToTower = (RadioButton) findViewById(R.id.radioDyingToTower);
        boolean isQuestionDyingToNeutralCheck = radioButtonDyingToNeutral.isChecked();
        boolean isQuestionSuicideCheck = radioButtonSuicide.isChecked();
        boolean isQuestionDyingToRoshanCheck = radioButtonDyingToRoshan.isChecked();
        boolean isQuestionDyingToTowerCheck = radioButtonDyingToTower.isChecked();
        if (!isQuestionDyingToNeutralCheck && !isQuestionSuicideCheck && !isQuestionDyingToRoshanCheck && isQuestionDyingToTowerCheck){
            correctAnswers += 1;
        }else {
            return;
        }

    }

    private void  checkAllQuestion(){
        checkQuestionOneAnswer();
        checkQuestionTwoAnswer();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswer();
    }
    private void resetCounterCorrectAnswer(){
        correctAnswers = 0;
    }
    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            checkAllQuestion();
            Toast.makeText(MainActivity.this,"CorrectAnswer: " + correctAnswers + "/4", Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswer();


        }
    };
}
