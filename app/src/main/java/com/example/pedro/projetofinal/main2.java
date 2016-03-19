package com.example.pedro.projetofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class main2 extends AppCompatActivity {

    private View view;
    private final String QUADRADO = "quadrado";
    private final String BOLA = "0";
    private final String XIS = "X";

    private String lastPlay = "X";
    int[][] estadofinal = new int[][]
            {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {1, 4, 7},
                    {2, 5, 8},
                    {3, 6, 9},
                    {1, 5, 9},
                    {3, 5, 7}
            };

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setView(getLayoutInflater().inflate(R.layout.activity_main2, null));
        setContentView(getView());
    }

    public void clickQuadrado(View view) {
        if (!isFim()) {
            if (((Button) view).getText().equals("")) {
                if (getLastPlay().equals(XIS)) {
                    setLastPlay(BOLA);
                    ((Button) view).setText(BOLA);

                } else {
                    ((Button) view).setText(XIS);
                    setLastPlay(XIS);
                }
                isFim();
            } else {
                Toast.makeText(getView().getContext(), "Opa!! Escolha outro quadrado.", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void setColorBlack() {
        for (int i = 1; i <= 9; i++) {
            if (getQuadrado(i) != null) {
                setcolorQuadrados(i, R.color.black);
            }
        }
    }

    public void setcolorQuadrados(int btn, int coloX) {
        getQuadrado(btn).setTextColor(getResources().getColor(coloX));
    }

    public void newGame(View view) {
        setEnableQuadrado(true);
        setColorBlack();
        for (int i = 1; i <= 9; i++) {
            if (getQuadrado(i) != null) {
                getQuadrado(i).setText("");
            }
        }
        RadioButton rX = (RadioButton) getView().findViewById(R.id.rbX);
        RadioButton r0 = (RadioButton) getView().findViewById(R.id.rbO);
        if (rX.isChecked()) {
            setLastPlay(BOLA);
        } else {
            if (r0.isChecked()) {
                setLastPlay(XIS);
            }
        }
    }

    public void setEnableQuadrado(boolean b) {
        for (int i = 1; i <= 9; i++) {
            if (getQuadrado(i) != null) {
                getQuadrado(i).setEnabled(b);
            }
        }
    }


    public Button getQuadrado(int tagNum) {
        return (Button) getView().findViewWithTag(QUADRADO + tagNum);
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getLastPlay() {
        return this.lastPlay;
    }

    public void setLastPlay(String str) {
        this.lastPlay = str;
    }

    public boolean isFim() {
        for (int i = 0; i < 8; i++) {
            String s1 = getQuadrado(estadofinal[i][0]).getText().toString();
            String s2 = getQuadrado(estadofinal[i][1]).getText().toString();
            String s3 = getQuadrado(estadofinal[i][2]).getText().toString();
            if (!s1.equals("") && !s2.equals("") && !s3.equals("")) {
                if (s1.equals(s2) && (s2.equals(s3))) {

                    setcolorQuadrados(estadofinal[i][0], R.color.red);
                    setcolorQuadrados(estadofinal[i][1], R.color.red);
                    setcolorQuadrados(estadofinal[i][2], R.color.red);
                    Toast.makeText(getView().getContext(), "Fim de jogo", Toast.LENGTH_LONG).show();
                    return true;
                }
            }
        }
        return false;

    }
}
