package model;
import java.util.regex.*;
public class Regex {
    private static final String pattern = "([+-]?(?:(?:\\d*x\\^\\d+)|(?:\\d*x)|(?:\\d+)))";

    public static Polinom convertInputToPolynom(String input){
        Pattern patternPolinom = Pattern.compile(pattern);
        input = input.replace(" ", "");
        Matcher matcher = patternPolinom.matcher(input);

        Polinom polinom = new Polinom();
        while (matcher.find()) {
            String s = "";
            if(matcher.group().charAt(0) == 'x'){
                s = "+";
            }
            Monom monom = Regex.convertInputToMonom(s+matcher.group());
            polinom.adauga(monom);
        }
        return polinom;
    }

    public static Monom convertInputToMonom(String input){
        Monom monom = new Monom(0, 0);
        int nrFind = 0;
        Pattern patternMonom = Pattern.compile("[+-]?(?:\\d+)|([+-])");
        Matcher matcher = patternMonom.matcher(input);
        while(matcher.find()){
            nrFind++;
            if(nrFind==1)
                if(matcher.group().equals("-")){
                    monom.setCoeficiet(-1);
                }else if(matcher.group().equals("+")){
                    monom.setCoeficiet(1);
                }else
                    monom.setCoeficiet(Integer.parseInt(matcher.group()));
            if(nrFind==2)
                monom.setGrad(Integer.parseInt(matcher.group()));
        }
        if(nrFind == 1){
            Pattern patternX = Pattern.compile("(?:x)");
            Matcher match = patternX.matcher(input);
            if(match.find())
                monom.setGrad(1);
        }
        return monom;
    }
}
