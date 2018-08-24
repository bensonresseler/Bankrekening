package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankRekening> rekeningen = new ArrayList<>();

    public Bank() {

    }

    public void addRekening(BankRekening bankRekening) {
        rekeningen.add(bankRekening);
    }

    public ArrayList<String> getRekeningnummers() {
        ArrayList<String> rekeningnummers = new ArrayList<>();

        for (BankRekening bankRekening: rekeningen){
            String rekeningnummer = bankRekening.getRekeningnummer();
            rekeningnummers.add(rekeningnummer);
        }
        return rekeningnummers;
    }

    public BankRekening getRekening(String rekeningnummer) {
        for(BankRekening bankRekening :rekeningen){
            if (bankRekening.getRekeningnummer().equals(rekeningnummer)) return bankRekening;
        }
        return null;
    }
}
