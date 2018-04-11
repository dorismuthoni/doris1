package com.asaria.adiratictactoe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Multi3 extends AppCompatActivity {
    private char currentPlayerMark = 'x';
    Button arr[] = new Button[9];
    char[] board = new char[9];
    int losesX = 0;
    int winsO = 0;
    char winner;

    boolean btn1Pressed=false,btn2Pressed=false,btn3Pressed=false,btn4pressed=false,btn5Pressed=false,btn6Pressed=false,
            btn7Pressed=false,btn8Pressed=false,btn9Pressed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi3);
        arr [0] =(Button)  findViewById(R.id.button1);

        arr[1] = (Button) findViewById(R.id.button2);

        arr[2] = (Button) findViewById(R.id.button3);

        arr[3] = (Button) findViewById(R.id.button4);

        arr[4] =  (Button)findViewById(R.id.button5);

        arr[5] =(Button)  findViewById(R.id.button6);

        arr[6] =  (Button) findViewById(R.id.button7);

        arr[7] = (Button) findViewById(R.id.button8);

        arr[8] =  (Button) findViewById(R.id.button9);




    }
    public void multi5(View v){
        startActivity(new Intent(Multi3.this,Multi5.class));
    }


    public void changePlayer(){


        if(currentPlayerMark=='x'){
            currentPlayerMark='o';
        }
        else {
            currentPlayerMark='x';
        }


    }
    public void updateScoreLoses(){
        TextView losesTextView = (TextView) findViewById(R.id.loses_0);
        losesTextView.setText(Integer.toString(losesX));

    }
    public void updateScoreWins() {
        TextView winsTextView = (TextView) findViewById(R.id.wins_0);
        winsTextView.setText(Integer.toString(winsO));

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


    public void reset(View v){
        arr[0].setText(" ");
        arr[1].setText(" ");
        arr[2].setText(" ");
        arr[3].setText(" ");
        arr[4].setText(" ");
        arr[5].setText(" ");
        arr[6].setText(" ");
        arr[7].setText(" ");
        arr[8].setText(" ");

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

        for(int i =0;i<9;i++){

            board[i] = '-';
        }
    }

    public void reset2(){
        arr[0].setText(" ");
        arr[1].setText(" ");
        arr[2].setText(" ");
        arr[3].setText(" ");
        arr[4].setText(" ");
        arr[5].setText(" ");
        arr[6].setText(" ");
        arr[7].setText(" ");
        arr[8].setText(" ");

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

        for(int i =0;i<9;i++){

            board[i] = '-';
        }
    }



    public void button1(View view){
        if(!btn1Pressed){
            btn1Pressed = true;
            arr[0].setText(Character.toString(currentPlayerMark));
            board[0] = currentPlayerMark;
            changePlayer();

            //when someone wins the board resets itself
            checkForWinner();

            updateScoreLoses();
            updateScoreWins();

        }

    }



    public void button2(View view){
        if(!btn2Pressed){
            btn2Pressed = true;
            arr[1].setText(Character.toString(currentPlayerMark));
            board[1] = currentPlayerMark;
            changePlayer();
            checkForWinner();

            updateScoreLoses();
            updateScoreWins();

        }

    }
    public void button3(View view){

        if(!btn3Pressed){
            btn3Pressed = true;
            arr[2].setText(Character.toString(currentPlayerMark));
            board[2] = currentPlayerMark;
            changePlayer();

            checkForWinner();

            updateScoreLoses();
            updateScoreWins();

        }

    }
    public void button4(View view) {

        if(!btn4pressed){
            btn4pressed = true;
            arr[3].setText(Character.toString(currentPlayerMark));
            board[3] = currentPlayerMark;
            changePlayer();
            if(checkForWinner()){
                reset2();
            }

            updateScoreLoses();
            updateScoreWins();



        }

    }
    public void button5(View view){

        if(!btn5Pressed){
            btn5Pressed = true;
            arr[4].setText(Character.toString(currentPlayerMark));
            board[4] = currentPlayerMark;
            changePlayer();
            checkForWinner();

            updateScoreLoses();
            updateScoreWins();

        }

    }
    public void button6(View view){

        if(!btn6Pressed){
            btn6Pressed = true;
            arr[5].setText(Character.toString(currentPlayerMark));
            board[5] = currentPlayerMark;
            changePlayer();
           checkForWinner();

            updateScoreLoses();
            updateScoreWins();

        }

    }
    public void button7(View view){

        if(!btn7Pressed){
            btn7Pressed = true;
            arr[6].setText(Character.toString(currentPlayerMark));
            board[6] = currentPlayerMark;
            changePlayer();
            checkForWinner();

            updateScoreLoses();
            updateScoreWins();

        }

    }
    public void button8(View view){

        if(!btn8Pressed){
            btn8Pressed = true;
            arr[7].setText(Character.toString(currentPlayerMark));
            board[7] = currentPlayerMark;
            changePlayer();
            checkForWinner();

            updateScoreLoses();
            updateScoreWins();
        }


    }
    public void button9(View view) {

        if(!btn9Pressed){
            btn9Pressed = true;
            arr[8].setText(Character.toString(currentPlayerMark));
            board[8] = currentPlayerMark;
            changePlayer();
            checkForWinner();

            updateScoreLoses();
            updateScoreWins();
        }

    }

}


