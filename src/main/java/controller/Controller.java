package controller;

import model.Operatii;
import model.Polinom;
import model.Regex;
import view.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Controller {
    private Dashboard view;
    public Controller(Dashboard view){
        this.view = view;
        this.view.adunareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyInput(view.getPrimulPolinom()) && verifyInput(view.getAlDoileaPolinom())){
                    Polinom polinomRezultat = Operatii.aduna(Regex.convertInputToPolynom(view.getPrimulPolinom()), Regex.convertInputToPolynom(view.getAlDoileaPolinom()));
                    view.setRezultat(polinomRezultat.toString());
                }
            }
        });

        this.view.scadereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyInput(view.getPrimulPolinom()) && verifyInput(view.getAlDoileaPolinom())){
                    Polinom polinomRezultat = Operatii.scade(Regex.convertInputToPolynom(view.getPrimulPolinom()), Regex.convertInputToPolynom(view.getAlDoileaPolinom()));
                    view.setRezultat(polinomRezultat.toString());
                }
            }
        });

        this.view.impartireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyInput(view.getPrimulPolinom()) && verifyInput(view.getAlDoileaPolinom())) {
                    if (Regex.convertInputToPolynom(view.getAlDoileaPolinom()).toString().compareTo("0") == 0 || view.getPrimulPolinom().toString().compareTo("0") == 0) {
                        view.showError("Nu se poate face impartire la 0 !");
                    } else {
                        Polinom polinomRezultat[] = new Polinom[2];
                        polinomRezultat = Operatii.imparte(Regex.convertInputToPolynom(view.getPrimulPolinom()), Regex.convertInputToPolynom(view.getAlDoileaPolinom()));
                        view.setRezultat("Cat: " + polinomRezultat[0] + "; Rest: " + polinomRezultat[1]);
                    }
                }
            }
        });

        this.view.inmultireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyInput(view.getPrimulPolinom()) && verifyInput(view.getAlDoileaPolinom())){
                    Polinom polinomRezultat = Operatii.inmulteste(Regex.convertInputToPolynom(view.getPrimulPolinom()), Regex.convertInputToPolynom(view.getAlDoileaPolinom()));
                    view.setRezultat(polinomRezultat + "");
                }
            }
        });

        this.view.integrareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyInput(view.getPrimulPolinom())){
                    Polinom polinomRezultat = Operatii.integreaza(Regex.convertInputToPolynom(view.getPrimulPolinom()));
                    if(polinomRezultat.toString().equals("0"))
                        view.setRezultat("C");
                    else
                        view.setRezultat(polinomRezultat + " + C");
                }
            }
        });

        this.view.derivareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verifyInput(view.getPrimulPolinom())){
                    Polinom polinomRezultat = Operatii.deriveaza(Regex.convertInputToPolynom(view.getPrimulPolinom()));
                    view.setRezultat(polinomRezultat + "");
                }
            }
        });

        this.view.exitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.closeWindow();
            }
        });

        this.view.clearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setRezultat("");
                view.setAlDoileaPolinom("");
                view.setPrimulPolinom("");
            }
        });

        this.view.helpListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showInstructions("Utilizatorul trebuie sa introduca un polinom de variabila x, drept suma de monoame forma (coeficient)x^(putere).\n" +
                        "In cazul termenilor de tipul x^0 sau x^1, puterea poate sa lipseasca. In cazul in care coeficientul este 1, acesta poate sa lipseasca.\nPentru operatiile de integrare si derivare, " +
                        "primul polinom este cel asupra caruia se aplica operatia." + "\n" + "In cazul operatiei de impartire, polinomul de grad mai mare "+
                        "va fi impartit la polinomul de grad mai mic, indiferent de ordinea inserarii lor. Daca gradele sunt egale, \nva fi impartit primul"+
                        " polinom introdus la cel de al doilea, indiferent de coeficienti.");
            }
        });

    }

    public boolean verifyInput (String polinomString){
        polinomString = polinomString.replace(" ", "");
        polinomString = polinomString.replace("x^1", "x");
        String rezultat = Regex.convertInputToPolynom(polinomString).toString().replace(" ", "");

        char[] polinomAux = polinomString.toCharArray();
        Arrays.sort(polinomAux);
        polinomString = String.valueOf(polinomAux);

        polinomAux = rezultat.toCharArray();
        Arrays.sort(polinomAux);
        rezultat = String.valueOf(polinomAux);

        if(polinomString.compareTo(rezultat) == 0 && polinomString.compareTo("") != 0 )
            return true;
        view.showError("Nu ati introdus corect datele ! Apasati Help pentru detalii legate de modul de introducere al polinoamelor.");
        return false;
    }


}
