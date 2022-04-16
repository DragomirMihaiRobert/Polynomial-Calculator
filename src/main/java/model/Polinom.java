package model;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Polinom {
    private Set<Monom> monomList = new TreeSet<>();

    public Monom lead(){
        Iterator iterator1 = monomList.iterator();
        return (Monom)iterator1.next();
    }

    public Set<Monom> getMonomList() {
        return monomList;
    }


    public void setMonomList(Set<Monom> monomList) {
        this.monomList = monomList;
    }

    public void adauga(Monom monom){
        Set<Monom> monomListAux = new TreeSet<>();
        if(this.getMonomList().contains(monom)) {
            for (Monom iterator : this.getMonomList()) {
                if (iterator.getGrad() == monom.getGrad()) {
                    iterator.setCoeficiet(iterator.getCoeficiet() + monom.getCoeficiet());
                    if (iterator.getCoeficiet() != 0) {
                        monomListAux.add(iterator);
                    }
                } else
                    monomListAux.add(iterator);
            }
            monomList = monomListAux;
        }
        else
            this.getMonomList().add(monom);
        if(monomList.isEmpty())
            monomList.add(new Monom(0, 0));
    }

    @Override
    public String toString() {
        Iterator iterator = this.getMonomList().iterator();
        String s = "";
        if(iterator.hasNext()){
            Monom monom = (Monom) iterator.next();
            if(monom.getCoeficiet() < 0)
                s = "-" + monom;
            else
                s += monom;
            while(iterator.hasNext()){
                monom = (Monom) iterator.next();
                if(monom.getCoeficiet() < 0)
                    s = s + " - " + monom;
                else if(monom.getCoeficiet() > 0)
                    s = s + " + " + monom;
            }
        }
        return s;
    }
}
