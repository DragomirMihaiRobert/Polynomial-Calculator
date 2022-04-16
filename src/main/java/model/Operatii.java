package model;

public class Operatii {
    public static Polinom aduna(Polinom firstPolinom, Polinom secondPolinom){
        Polinom rezultat = firstPolinom;
        for(Monom monom : secondPolinom.getMonomList())
            rezultat.adauga(monom);
        return rezultat;
    }

    public static Polinom scade(Polinom firstPolinom, Polinom secondPolinom){
        Polinom rezultat = firstPolinom;
        for(Monom monom : secondPolinom.getMonomList())
            rezultat.adauga(new Monom(-monom.getCoeficiet(), monom.getGrad()));
        return rezultat;
    }

    public static Polinom[] imparte(Polinom firstPolinom, Polinom secondPolinom){
        Polinom q = new Polinom();
        Polinom r = new Polinom();
        if(firstPolinom.lead().getGrad() < secondPolinom.lead().getGrad()){
            Polinom aux = firstPolinom;
            firstPolinom = secondPolinom;
            secondPolinom = aux;
        }
        q.adauga(new Monom(0, 0));
        r.setMonomList(firstPolinom.getMonomList());
        Monom lead_r = r.lead();
        Monom lead_d = secondPolinom.lead();
        while(lead_r.getGrad() >= lead_d.getGrad() && !(lead_r.getCoeficiet()== 0 && lead_r.getGrad() == 0)){
            Monom t = new Monom(lead_r.getCoeficiet()/lead_d.getCoeficiet(), lead_r.getGrad()-lead_d.getGrad());
            q.adauga(t);
            Polinom tPolinom = new Polinom();
            tPolinom.adauga(t);
            r = Operatii.scade(r, Operatii.inmulteste(tPolinom, secondPolinom));
            lead_r = r.lead();
            lead_d = secondPolinom.lead();
        }
        return new Polinom[] {q, r};
    }

    public static Polinom inmulteste(Polinom firstPolinom, Polinom secondPolinom){
        Polinom polinomRezultat = new Polinom();
        polinomRezultat.adauga(new Monom());
        for (Monom monom1 : firstPolinom.getMonomList())
            for (Monom monom2 : secondPolinom.getMonomList()){
                Monom monomAux = new Monom((monom1.getCoeficiet() * monom2.getCoeficiet()), (monom1.getGrad()) + monom2.getGrad());
                if (monomAux.getCoeficiet() != 0)
                    polinomRezultat.adauga(monomAux);
            }
        return polinomRezultat;
    }

    public static Polinom integreaza(Polinom polinom){
        Polinom polinomRezultat= new Polinom();
        polinomRezultat.adauga(new Monom());
        for(Monom monom : polinom.getMonomList()){
            if(monom.getCoeficiet() != 0)
                polinomRezultat.adauga(new Monom(monom.getCoeficiet()/(monom.getGrad()+1), monom.getGrad()+1));
        }
        return polinomRezultat;
    }

    public static Polinom deriveaza(Polinom polinom) {
        Polinom polinomRezultat = new Polinom();
        polinomRezultat.adauga(new Monom());
        for (Monom monom : polinom.getMonomList()) {
            if (monom.getGrad() != 0)
                polinomRezultat.adauga(new Monom((monom.getCoeficiet() * monom.getGrad()), (monom.getGrad() - 1)));
        }
        return polinomRezultat;
    }
}
