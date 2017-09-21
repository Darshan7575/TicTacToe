package com.example.darshan.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {
  Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    int count=0,mcount=0;
    char[][] str=new char[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        reset=(Button)findViewById(R.id.reset);
        int i=2,j;
        while(i!=-1)
        { j=2;
            while(j!=-1)
            {
                str[i][j]='.';
                j--;
            }
            i--;
        }
        class holdvalue
        {
            int res,p,q;
        }
        class immidiate {
            int i, countX, countO, countdot, j, res = 0, m, n, p = -1, q = -1;

            holdvalue newval() {
                if((str[0][1]=='X'&&str[1][0]=='X'&&str[0][0]=='.')||(str[0][1]=='O'&&str[1][0]=='O'&&str[0][0]=='.'))
                {p=q=0;res=1;}
                if((str[2][1]=='X'&&str[1][2]=='X'&&str[2][2]=='.')||(str[2][1]=='O'&&str[1][2]=='O'&&str[2][2]=='.'))
                {p=q=2;res=1;}
                if((str[0][1]=='X'&&str[1][2]=='X'&&str[0][2]=='.')||(str[0][1]=='X'&&str[1][2]=='X'&&str[0][2]=='.'))
                {p=0;q=2;res=1;}
                if((str[1][0]=='X'&&str[2][1]=='X'&&str[2][0]=='.')||(str[1][0]=='O'&&str[2][1]=='O'&&str[2][0]=='.'))
                {p=2;q=0;res=1;}
                for (i = 0; i < 3; i++) {
                    countX = countO = countdot = 0;
                    for (j = 0; j < 3; j++) {
                        if (str[i][j] == 'X')
                            countX++;
                        else if (str[i][j] == 'O')
                            countO++;
                        else {
                            countdot++;
                            m = i;
                            n = j;
                        }
                    }
                    if (countO == 2 && countdot == 1) {
                        res = 1;
                        p = m;
                        q = n;
                        break;
                    }
                    if(countX==2&&countdot==1)
                    {res=1;
                    p=m;
                        q=n;}
                    countX = countO = countdot = 0;
                    for (j = 0; j < 3; j++) {
                        if (str[j][i] == 'X')
                            countX++;
                        else if (str[j][i] == 'O')
                            countO++;
                        else {
                            countdot++;
                            m = j;
                            n = i;
                        }
                    }
                    if (countO == 2 && countdot == 1) {
                        res = 1;
                        p = m;
                        q = n;
                        break;
                    }
                    if(countX==2&&countdot==1)
                    {res=1;
                        p=m;
                        q=n;}
                }
                countX = countO = countdot = 0;
                for (j = 0; j < 3; j++) {
                    if (str[j][j] == 'X')
                        countX++;
                    else if (str[j][j] == 'O')
                        countO++;
                    else {
                        countdot++;
                        m = j;
                    }
                }
                if ((countX == 2 && countdot == 1) || (countO == 2 && countdot == 1)) {
                    res = 1;
                    p = q = m;
                }
                countX = countO = countdot = 0;
                for(j=2;j>=0;j--) {
                    if (str[j][2 - j] == 'X')
                        countX++;
                    else if (str[j][2 - j] == 'O')
                        countO++;
                    else {
                        countdot++;
                        m = j;
                        n = 2 - j;
                    }
                }
                if ((countX == 2 && countdot == 1) || (countO == 2 && countdot == 1)) {
                    res = 1;
                    p = m;
                    q = n;
                }
                countX = countO = countdot = 0;
                for(j=0;j<3;j++) {
                    if (str[j][2 - j] == 'X')
                        countX++;
                    else if (str[j][2 - j] == 'O')
                        countO++;
                    else {
                        countdot++;
                        m = j;
                        n = 2 - j;
                    }
                }
                if ((countX == 2 && countdot == 1) || (countO == 2 && countdot == 1)) {
                    res = 1;
                    p = m;
                    q = n;
                }
                if (p != -1 && q != -1)
                    str[p][q] = 'O';
                holdvalue h = new holdvalue();
                h.p = p;
                h.q = q;
                h.res = res;
                return h;
            }
        }
    class setval
        {
            void settingvalue(int m,int n)
            {
                if(m==0&&n==0){b1.setText("O");return;}
                if(m==0&&n==1){b2.setText("O");return;}
                if(m==0&&n==2){b3.setText("O");return;}
                if(m==1&&n==0){b4.setText("O");return;}
                if(m==1&&n==1){b5.setText("O");return;}
                if(m==1&&n==2){b6.setText("O");return;}
                if(m==2&&n==0){b7.setText("O");return;}
                if(m==2&&n==1){b8.setText("O");return;}
                if(m==2&&n==2){b9.setText("O");return;}
            }
        }
        class check
        {
            void checked() {   int i;
                boolean end=false;
                for(i=0;i<3;i++)
                {
                    if(str[0][i]=='X' && str[1][i]=='X' && str[2][i]=='X')
                    {
                        Toast.makeText(MainActivity.this,"Human Wins",Toast.LENGTH_SHORT).show();
                    end=true;}
                    if(str[0][i]=='O'&&str[1][i]=='O'&&str[2][i]=='O')
                    {
                        Toast.makeText(MainActivity.this,"Machine Wins",Toast.LENGTH_SHORT).show();
                        end=true;}
                    if(str[i][0]=='X'&&str[i][1]=='X'&&str[i][2]=='X')
                    {
                        Toast.makeText(MainActivity.this,"Human Wins",Toast.LENGTH_SHORT).show();
                        end=true;}
                    if(str[i][0]=='O'&&str[i][1]=='O'&&str[i][2]=='O')
                    {
                        Toast.makeText(MainActivity.this,"machine Wins",Toast.LENGTH_SHORT).show();
                        end=true;}
                }
                if(str[0][0]=='X'&&str[1][1]=='X'&&str[2][2]=='X')
                {
                    Toast.makeText(MainActivity.this,"Human Wins",Toast.LENGTH_SHORT).show();
                    end=true;}
                if(str[0][0]=='O'&&str[1][1]=='O'&&str[2][2]=='O')
                {
                    Toast.makeText(MainActivity.this,"machine Wins",Toast.LENGTH_SHORT).show();
                    end=true;}
                if(str[0][2]=='X'&&str[1][1]=='X'&&str[2][0]=='X')
                {
                    Toast.makeText(MainActivity.this,"Human Wins",Toast.LENGTH_SHORT).show();
                    end=true;}
                if(str[0][2]=='O'&&str[1][1]=='O'&&str[2][0]=='O')
                {
                    Toast.makeText(MainActivity.this,"Machine Wins",Toast.LENGTH_SHORT).show();
                    end=true;}
                if(end==false && count==9)
                {
                    Toast.makeText(MainActivity.this,"No one won",Toast.LENGTH_SHORT).show();}
                if(end==true||count==9)
                {
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                }
            }
        }
        class check1
        {
            int checking(int i,int j)
            {
                if(str[i][j]!='.')
                {
                    return(0);
                }
                else
                    return(1);
            }
        }
        class computer extends check1
        {
            setval set=new setval();
            holdvalue hv=new holdvalue();
            immidiate im=new immidiate();
            Random rnd=new Random();
            int m=1,n=1;
            void rand() {
                if (str[m][n] == '.') {
                    str[m][n] = 'O';
                    set.settingvalue(m, n);}
                  else {
                    hv = im.newval();
                    if (hv.res != 1) {
                        m = rnd.nextInt(3);
                        n = rnd.nextInt(3);
                        if (checking(m, n) == 0) {
                            computer cp = new computer();
                            cp.rand();
                        } else {
                            str[m][n] = 'O';
                            set.settingvalue(m, n);
                        }
                    } else
                        set.settingvalue(hv.p, hv.q);
                }
            }
        }
        Toast.makeText(MainActivity.this,"You should start the game",Toast.LENGTH_SHORT).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1.getText().toString().equals(""))
                { check checkval=new check();
                    b1.setText("X");
                    str[0][0]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                    checkval.checked();}
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b2.getText().toString().equals(""))
                {check checkval=new check();
                    b2.setText("X");
                    str[0][1]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b3.getText().toString().equals(""))
                {check checkval=new check();
                    b3.setText("X");
                    str[0][2]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b4.getText().toString().equals(""))
                {check checkval=new check();
                    b4.setText("X");
                    str[1][0] = 'X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b5.getText().toString().equals(""))
                {
                    if(count==0)
                    {
                        str[1][1]='X';
                        b5.setText("X");
                        str[0][0]='O';
                        b1.setText("O");
                        count+=2;
                    }
                    else {
                        check checkval = new check();
                        b5.setText("X");
                        str[1][1] = 'X';
                        count++;
                        checkval.checked();
                        if (count<9) {
                            computer cmp = new computer();
                            cmp.rand();
                            count++;
                            checkval.checked();
                        }
                    }
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b6.getText().toString().equals(""))
                {check checkval=new check();
                    b6.setText("X");
                    str[1][2]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b7.getText().toString().equals(""))
                {check checkval=new check();
                    b7.setText("X");
                    str[2][0]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b8.getText().toString().equals(""))
                {check checkval=new check();
                    b8.setText("X");
                    str[2][1]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b9.getText().toString().equals(""))
                {   check checkval=new check();
                    b9.setText("X");
                    str[2][2]='X';
                    count++;
                    checkval.checked();
                    if(count<9){
                    computer cmp=new computer();
                    cmp.rand();
                    count++;
                        checkval.checked();}
                }

            }
        });
reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int i,j;
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        count=0;
        mcount++;
        for(i=0;i<3;i++) {
            {for (j = 0; j < 3; j++)
                str[i][j] = '.';}
        }
        Random rnd=new Random();
        int choice=rnd.nextInt(2);
        if(choice==0)
        {
            int m=rnd.nextInt(3);
            int n=rnd.nextInt(3);
            str[m][n]='O';
            count++;
            setval st=new setval();
            st.settingvalue(m,n);
            Toast.makeText(MainActivity.this,"Machine has started the game",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(MainActivity.this,"You should start the game",Toast.LENGTH_SHORT).show();
    }
});

    }
}
