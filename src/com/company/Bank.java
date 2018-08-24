package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankRekening> rekeningen = new ArrayList<>();

    public Bank() {

    }

    public void addRekening(BankRekening bankRekening) {
        if (getRekening(bankRekening.getRekeningnummer()) != null) throw new IllegalArgumentException(String.format("Rekening %s is niet uniek.", bankRekening.getRekeningnummer()));
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

    public void stortGeld(String rekeningnr, int bedrag) {
        BankRekening tempRekeningnr = getRekening(rekeningnr);
        if (tempRekeningnr != null) {
            tempRekeningnr.storten(bedrag);
        } else throw new IllegalArgumentException(String.format("Rekening %s bestaat niet.", rekeningnr));
        }

    public void schrijfGeldOver(String afkomst, String ontvangt, int overschrijvenBedrag) {
        BankRekening tempAfhalen = getRekening(afkomst);
        BankRekening tempOntvangen = getRekening(ontvangt);
        if (tempAfhalen == null) throw new IllegalArgumentException (String.format("Rekening %s bestaat niet.", afkomst));
        if (tempOntvangen == null) throw new IllegalArgumentException (String.format("Rekening %s bestaat niet.", ontvangt));

        tempAfhalen.afhalen(overschrijvenBedrag);
        tempOntvangen.storten(overschrijvenBedrag);
    }
}
