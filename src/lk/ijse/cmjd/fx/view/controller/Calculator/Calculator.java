package lk.ijse.cmjd.fx.view.controller.Calculator;

public class Calculator implements CalcInterface {
    double[] num;
    char[] op;
    String s;
    int len; int prev; String temp;
    int pos;
    int OpPos; int NumPos; double result;
    double Result(){ return result; }
    Calculator(String s){
        result = 0;
        this.s = s;
        len = s.length();
        num = new double[20];
        op = new char[20];
        prev = 0; pos = 0; OpPos=1; NumPos = 0;
        GetNumOp();

        Calculate();
        result = num[0];

    }

    public void GetNumOp(){

        while(pos<len){
            if(s.charAt(pos)=='+')
            { op[OpPos] = '+'; OpPos+=2;  temp = s.substring(prev,pos);
                num[NumPos]= Double.parseDouble(temp); NumPos+=2; prev = pos+1;
            }else  if(s.charAt(pos)=='-')
            { op[OpPos] = '-'; OpPos+=2;  temp = s.substring(prev,pos);
                num[NumPos]= Double.parseDouble(temp); NumPos+=2; prev = pos+1;
            }else  if(s.charAt(pos)=='*')
            { op[OpPos] = '*'; OpPos+=2;  temp = s.substring(prev,pos);
                num[NumPos]= Double.parseDouble(temp); NumPos+=2; prev = pos+1;
            }else  if(s.charAt(pos)=='/')
            { op[OpPos] = '/'; OpPos+=2;  temp = s.substring(prev,pos);
                num[NumPos]= Double.parseDouble(temp); NumPos+=2; prev = pos+1;
            }else{}
            pos++;
        }
        temp = s.substring(prev);
        num[NumPos] = Double.parseDouble(temp);
    }


    public void Calculate(){
        for(int i=1; i<=OpPos; i+=2){ if(op[i]=='*'){num[i-1] =num[i-1]*num[i+1]; ChangeNumPos(i+1); ChangeOpPos(i);} }
        for(int i=1; i<=OpPos; i+=2){ if(op[i]=='/'){num[i-1] =num[i-1]/num[i+1]; ChangeNumPos(i+1); ChangeOpPos(i);} }
        for(int i=1; i<=OpPos; i+=2){ if(op[i]=='-'){num[i-1] =num[i-1]-num[i+1]; ChangeNumPos(i+1); ChangeOpPos(i);} }
        for(int i=1; i<=OpPos; i+=2){ if(op[i]=='+'){num[i-1] =num[i-1]+num[i+1]; ChangeNumPos(i+1); ChangeOpPos(i);} }
    }


    public void ChangeNumPos(int pos1){ for(int i = pos1; i<NumPos; i+=2) num[i] = num[i+2];}

    public void ChangeOpPos(int pos1){ for(int i = pos1; i<OpPos; i+=2) op[i] = op[i+2];}
}