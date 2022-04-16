package model;
public class Monom implements Comparable<Monom>{
    private float coeficiet;
    private int grad;

    public Monom(){}
    public Monom(float coeficiet, int grad) {
        this.coeficiet = coeficiet;
        this.grad = grad;
    }



    public float getCoeficiet() {
        return coeficiet;
    }

    public void setCoeficiet(float coeficiet) {
        this.coeficiet = coeficiet;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }


    @Override
    public int compareTo(Monom otherMonom) {
        return otherMonom.grad - this.grad;
    }

    @Override
    public String toString() {
        float coeficientAux = this.getCoeficiet();
        if(coeficientAux < 0 )
            coeficientAux= -coeficientAux;
        if(this.getGrad() == 1)
            if(coeficientAux != 1)
                return (coeficientAux==(int)coeficientAux ? (int)coeficientAux : String.format("%.2f", coeficientAux)) + "x";
            else
                return "x";
        else if(this.getGrad() == 0)
            return (coeficientAux==(int)coeficientAux ? (int)coeficientAux : String.format("%.2f", coeficientAux)) + "";
        else
            if(coeficientAux == 1)
                return "x^" + this.getGrad();
            else
                return (coeficientAux==(int)coeficientAux ? (int)coeficientAux : String.format("%.2f", coeficientAux)) + "x^" + this.getGrad();
    }
}
