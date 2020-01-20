package com.example.newcalc;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean op_flag = false,clear_flag = true, dot_flag = false , equaL_flag = false;
    String opd_cs = " ";
    double opd_c = 0,opd_p = 0,result = 0;
    String c_op = "+";

    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    Button plus,minus,divide,multiply,equal,dot,btn_c,btn_sqrt,percentage,back;
    TextView tv_expression,tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        plus = findViewById(R.id.btn_plus);
        minus = findViewById(R.id.btn_minus);
        divide = findViewById(R.id.btn_div);
        multiply = findViewById(R.id.btn_mul);
        equal = findViewById(R.id.btn_equal);
        dot = findViewById(R.id.btn_dot);
        btn_sqrt = findViewById(R.id.btn_sqrt);
        btn_c = findViewById(R.id.btn_c);
        percentage = findViewById(R.id.btn_percent);
        back = findViewById(R.id.btn_back);

        tv_expression = findViewById(R.id.tv_expression);
        tv_result = findViewById(R.id.tv_result);

        setNumberButtonOperation();
        setOperatorButton();



    }

    void setExpression(String v)
    {
        if(equaL_flag == true){
            tv_result.setTypeface(null, Typeface.NORMAL);
            tv_result.setTextSize(45);
            tv_expression.setVisibility(View.INVISIBLE);
            equaL_flag = false ;
            tv_expression.setText("0");
            tv_result.setText("0");
        }
        String zeroValue = tv_expression.getText().toString();
        int zeroNum;

        try {
            zeroNum = Integer.parseInt(zeroValue);
        }
        catch(Exception ex){
            zeroNum = 1;
        }
        if(zeroNum != 0) {
            tv_expression.setText(tv_expression.getText() + v);
            if (op_flag == false) {
                opd_cs = opd_cs + v;
            }
            else {
                opd_cs = v;
            }
        }
        else{
            tv_expression.setText(v);
            opd_cs = v;
        }

        if(opd_cs.compareTo(".")!=0) {
            opd_c = Double.parseDouble(opd_cs);
            calculate();
        }
        else {
            opd_cs = "0.";
            tv_expression.setText(opd_cs);

        }
    }



    void setNumberButtonOperation(){

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_expression.setText("0");
                tv_result.setText("0");

                clear_flag = true;
                op_flag = false;
                dot_flag = false;

                opd_cs = "";
                opd_c = 0;
                opd_p = 0;
                result = 0;
                c_op = "+";

                tv_result.setTextSize(45);
                tv_expression.setVisibility(View.VISIBLE);
                tv_result.setTypeface(null, Typeface.NORMAL);
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("0");
                dot_flag = false;
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("1");
                dot_flag = false;
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("2");
                dot_flag = false;
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("3");
                dot_flag = false;
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("4");
                dot_flag = false;
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("5");
                dot_flag = false;
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("6");
                dot_flag = false;
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("7");
                dot_flag = false;
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("8");
                dot_flag = false;
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression("9");
                dot_flag = false;
            }
        });

    }

    void setOperatorButton(){

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_result.setTypeface(null, Typeface.BOLD);
                tv_result.setTextSize(60);
                tv_expression.setVisibility(View.INVISIBLE);
                equaL_flag = true ;

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c_op = "+";
                if(equaL_flag == true)
                    afterEqualOperation();
                    else{
                        if(op_flag!=true){
                            tv_expression.setText(tv_expression.getText() + "+");
                        }
                        else{
                            String cur_ex = tv_expression.getText().toString();
                            cur_ex = cur_ex.substring(0,cur_ex.length()-1);
                            tv_expression.setText(cur_ex + "+");
                        }

                        op_flag = true;
                    }
                }

        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c_op = "-";
                if(equaL_flag == true)
                    afterEqualOperation();
                    else{
                        if(op_flag!=true){
                            tv_expression.setText(tv_expression.getText() + "-");
                        }
                        else{
                            String cur_ex = tv_expression.getText().toString();
                            cur_ex = cur_ex.substring(0,cur_ex.length()-1);
                            tv_expression.setText(cur_ex + "-");
                        }

                        op_flag = true;
                    }
                }

        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c_op = "/";
                if(equaL_flag == true)
                    afterEqualOperation();
                    else{
                        if(op_flag!=true)
                            tv_expression.setText(tv_expression.getText() + "/");

                        else{
                            String cur_ex = tv_expression.getText().toString();
                            cur_ex = cur_ex.substring(0,cur_ex.length()-1);
                            tv_expression.setText(cur_ex + "/");
                        }

                        op_flag = true;
                    }
                }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c_op = "*";
                if(equaL_flag == true)
                    afterEqualOperation();
                    else{
                        if(op_flag!=true){
                            tv_expression.setText(tv_expression.getText() + "*");
                        }
                        else{
                            String cur_ex = tv_expression.getText().toString();
                            cur_ex = cur_ex.substring(0,cur_ex.length()-1);
                            tv_expression.setText(cur_ex + "*");
                        }

                        op_flag = true;
                    }

            }
        });

        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    tv_expression.setText("SQRT("+String.valueOf(result)+")");
                    result = Math.sqrt(result);
                    tv_result.setText(String.valueOf(result));
                }
                catch(Exception ex){
                    tv_result.setText("invalid operation");
                }
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    result = opd_c / 100 ;
                    tv_expression.setText(tv_expression.getText()+ "%");
                    tv_result.setText(String.valueOf(result));
                } catch(Exception ex){
                    tv_result.setText("invalid operation");
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dot_flag == false){
                    dot_flag = true;
                    setExpression(".");
                }


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               backOperation();


            }
        });



    }

    void afterEqualOperation(){
        tv_result.setTypeface(null, Typeface.NORMAL);
        tv_result.setTextSize(45);
        tv_expression.setVisibility(View.VISIBLE);
        equaL_flag = false ;
        tv_expression.setText(tv_result.getText()+c_op);
    }

    void calculate(){
        try{
            switch (c_op){

                case "+":
                    if(op_flag == true){
                        opd_p = result;
                        result = result + opd_c;
                    }
                    else
                        result = opd_p + opd_c;
                    break;

                case "*":
                    if(op_flag == true){
                        opd_p = result;
                        result = result * opd_c;
                    }
                    else
                        result = opd_p * opd_c;
                    break;

                case "-":
                    if(op_flag == true){
                        opd_p = result;
                        result = result - opd_c;
                    }
                    else
                        result = opd_p - opd_c;
                    break;

                case "/":
                    if(op_flag == true){
                            opd_p = result;
                        result = result / opd_c;
                    }
                    else
                        result = opd_p / opd_c;
                    break;
            }

            tv_result.setText(String.valueOf(result));
            op_flag = false;
            clear_flag = false;
        }catch (Exception ex){
            tv_result.setText("Invalid operation");
        }


    }
    void backOperation(){
        try {
            if(op_flag != true){
                opd_cs = opd_cs.substring(0,opd_cs.length()-1);
                opd_c = Double.parseDouble(opd_cs);
            }
            else
              op_flag = false;
            String cur_ex = tv_expression.getText().toString();
            cur_ex = cur_ex.substring(0, cur_ex.length() - 1);
            tv_expression.setText(cur_ex);
            calculate();

        }catch(Exception ex){
            tv_result.setText("invalid operation");
        }
    }


}
