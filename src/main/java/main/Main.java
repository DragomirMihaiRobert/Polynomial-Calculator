package main;

import controller.Controller;
import view.Dashboard;

public class Main {
    public static void main( String args[] ){
        Dashboard d = new Dashboard();
        Controller c = new Controller(d);
        d.setVisible(true);
    }
}