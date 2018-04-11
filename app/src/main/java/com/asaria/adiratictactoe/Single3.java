package com.asaria.adiratictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Single3 extends AppCompatActivity {
    private int [] buttonsPressed = new int[9]; //to hold the ids of buttons that have been pressed
    private int numberOfButtonsPressed = 0; //
    private char currentPlayerMark = 'x';
    char[] board = new char[9];
    Button arr[] = new Button[9];
    private int[] buttonsNotPressed = {8,7,6,5,4,3,2,1,0};
    int number_of_buttonsNotPressed = 9;

    boolean Xwon = false,Owon = false;

    int losesX = 0;
    int winsO = 0;
    char winner;

    boolean btn1Pressed=false,btn2Pressed=false,btn3Pressed=false,btn4pressed=false,btn5Pressed=false,btn6Pressed=false,
            btn7Pressed=false,btn8Pressed=false,btn9Pressed=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_single3);

        arr[0] = (Button) findViewById(R.id.button1);
        arr[1] = (Button) findViewById(R.id.button2);
        arr[2] = (Button) findViewById(R.id.button3);
        arr[3] = (Button) findViewById(R.id.button4);
        arr[4] = (Button) findViewById(R.id.button5);
        arr[5] = (Button) findViewById(R.id.button6);

        arr[6] = (Button) findViewById(R.id.button7);
        arr[7] = (Button) findViewById(R.id.button8);
        arr[8] = (Button) findViewById(R.id.button9);


        for(int i = 0;i < 9;i++){
            board[i] = '-';
        }
    }

    //to search for the index of a number in buttonsNotPressed
    public int search(int numberToBeSearched){
        int position  = 10; //default position

        for(int i = 0;i < number_of_buttonsNotPressed;i++){

            if(buttonsNotPressed[i] == numberToBeSearched){
                position = i;
                break;
            }
        }

        return position;

    }

    //to remove a button that has been pressed from buttonsNotPressed array
    public void remove(int button){
        int index = search(button);

        if( index != number_of_buttonsNotPressed - 1) {


            //minus one note
            for (int i = index; i < number_of_buttonsNotPressed - 1; i++) {
                buttonsNotPressed[i] = buttonsNotPressed[i + 1];
            }
        }else{

            Log.d("remove","last index detected");
        }
            number_of_buttonsNotPressed--;

            for(int i = 0;i < number_of_buttonsNotPressed;i++){
                Log.d("buttonsPressed"+Integer.toString(i),Integer.toString(buttonsNotPressed[i]));
            }

    }


    public void single5(View v) {
        startActivity(new Intent(Single3.this, Single5.class));
    }

    public void changePlayer() {


        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }


    }

    public void reset(View v) {
        arr[0].setText(Character.toString('-'));
        arr[1].setText(Character.toString('-'));
        arr[2].setText(Character.toString('-'));
        arr[3].setText(Character.toString('-'));
        arr[4].setText(Character.toString('-'));
        arr[5].setText(Character.toString('-'));
        arr[6].setText(Character.toString('-'));
        arr[7].setText(Character.toString('-'));
        arr[8].setText(Character.toString('-'));

        for(int i = 0;i < 9;i++){
            board[i] = '-';
        }

        buttonsNotPressed[0]=0;
        buttonsNotPressed[1]=1;
        buttonsNotPressed[2]=2;
        buttonsNotPressed[3]=3;
        buttonsNotPressed[4]=4;
        buttonsNotPressed[5]=5;
        buttonsNotPressed[6]=6;
        buttonsNotPressed[7]=7;
        buttonsNotPressed[8]=8;

        number_of_buttonsNotPressed = 9;
        numberOfButtonsPressed = 0;
        currentPlayerMark = 'x';
         btn1Pressed=false;
         btn2Pressed=false;
         btn3Pressed=false;
         btn4pressed=false;
         btn5Pressed=false;
         btn6Pressed=false;
                btn7Pressed=false;
                btn8Pressed=false;
                btn9Pressed=false;

    }

    public void updateScoreLoses(){
        TextView losesTextView = (TextView) findViewById(R.id.player1);
        losesTextView.setText(Integer.toString(losesX));

    }
    public void updateScoreWins() {
        TextView winsTextView = (TextView) findViewById(R.id.player2);
        winsTextView.setText(Integer.toString(winsO));

    }



    public void button1(View view) {
        if(!btn1Pressed){
            btn1Pressed = true;
            arr[0].setText(Character.toString(currentPlayerMark));
            board[0] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 0;
            remove(0);
            changePlayer();
            playerMarkO();
           checkForWinner();
           updateScoreLoses();
           updateScoreWins();
            Log.d("checkRows",Boolean.toString(checkRowsForWin()));
            Log.d("checkCol",Boolean.toString(checkColsForWin()));
            Log.d("checkDiagnol",Boolean.toString(checkDiagnolsForWin()));        }

    }

    public void button2(View view) {
        if(!btn2Pressed){
            btn2Pressed = true;
            arr[1].setText(Character.toString(currentPlayerMark));
            board[1] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 1;

            changePlayer();
            remove(1);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();
        }

    }

    public void button3(View view) {

        if(!btn3Pressed){
            btn3Pressed = true;
            arr[2].setText(Character.toString(currentPlayerMark));
            board[2] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 2;
            changePlayer();
            remove(2);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();
        }


    }

    public void button4(View view) {

        if(!btn4pressed){
            btn4pressed = true;
            arr[3].setText(Character.toString(currentPlayerMark));
            board[3] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 3;
            changePlayer();
            remove(3);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();
        }


    }

    public void button5(View view) {

        if(!btn5Pressed){
            btn5Pressed = true;
            arr[4].setText(Character.toString(currentPlayerMark));
            board[4] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 4;
            changePlayer();
            remove(4);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();
        }

    }

    public void button6(View view) {

        if(!btn6Pressed){
            btn6Pressed =  true;
            arr[5].setText(Character.toString(currentPlayerMark));
            board[5] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 5;
            changePlayer();
            remove(5);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();

        }

    }

    public void button7(View view) {
            if(!btn7Pressed){
                btn7Pressed = true;
                arr[6].setText(Character.toString(currentPlayerMark));
                board[6] = currentPlayerMark;
                buttonsPressed[numberOfButtonsPressed++] = 6;

                changePlayer();
                remove(6);
                playerMarkO();
                checkForWinner();

                updateScoreWins();
                updateScoreLoses();
            }


    }

    public void button8(View view) {

        if(!btn8Pressed){
            btn8Pressed = true;
            arr[7].setText(Character.toString(currentPlayerMark));
            board[7] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 7;

            changePlayer();
            remove(7);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();
        }

    }

    public void button9(View view) {


        if(!btn9Pressed){
            btn9Pressed = true;
            arr[8].setText(Character.toString(currentPlayerMark));
            board[8] = currentPlayerMark;
            buttonsPressed[numberOfButtonsPressed++] = 8;


            changePlayer();
            remove(8);
            playerMarkO();
            checkForWinner();

            updateScoreWins();
            updateScoreLoses();
        }

    }

    public void playerMarkO() {

        //because all buttons would have been pressed
        if(number_of_buttonsNotPressed > 0){

            if (currentPlayerMark == 'o') {
                Random r = new Random();
                int random = r.nextInt(number_of_buttonsNotPressed);
                Log.d("random index",Integer.toString(random));

                int index = buttonsNotPressed[random];
                Log.d("value of randomIndex",Integer.toString(index));
                arr[index].setText(Character.toString(currentPlayerMark));
                board[index] = currentPlayerMark;
                if(index == 0)
                    btn1Pressed = true;
                else if(index == 1) btn2Pressed = true;
                else if(index == 2) btn3Pressed = true;
                else if(index == 3) btn4pressed = true;
                else if(index == 4) btn5Pressed = true;
                else if (index == 5) btn6Pressed = true;
                else if(index == 6) btn7Pressed = true;
                else if(index == 7) btn8Pressed = true;
                else if(index == 8) btn9Pressed = true;
                remove(index);


                changePlayer();
            }

        }

    }

    private boolean checkText(char c1, char c2, char c3) {
        if ((c1 == 'x') && (c1 == c2) && (c2 == c3)){

            losesX++;
            winner = 'x';
            return true;
        }else if((c1 == 'o') && (c1 == c2) && (c2 == c3)){

            winsO++;
            winner = 'o';
            return true;
        }else return false;


    }


    private boolean checkRowsForWin() {
        if (checkText(board[0], board[1], board[2]))
            return true;
        else if (checkText(board[3], board[4], board[5]))
            return true;
        else if (checkText(board[6], board[7], board[8]))
            return true;
        else return false;
    }


    private boolean checkColsForWin() {
        if (checkText(board[0], board[3], board[6]))
            return true;
        else if (checkText(board[1], board[4], board[7]))
            return true;
        else if (checkText(board[2], board[5], board[8]))
            return true;
        else return false;
    }


    private boolean checkDiagnolsForWin(){
        if (checkText(board[0],board[4],board[8]))
            return true;
        else if (checkText(board[2],board[4],board[6]))
            return true;
        else return false;
    }

    private boolean checkForWinner(){
        return(checkColsForWin()||checkRowsForWin()||checkDiagnolsForWin());

    }
}
