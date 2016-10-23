package info.novatec.testit.livingdoc.training.exercises.call;

import java.util.ArrayList;
import java.util.List;

public class CreditManager {

    private Double credit = 0.0;
    private Double inlandPreis;
    private Double auslandPreis;
    private List<Call> calls = new ArrayList<Call>();

    public CreditManager(Double inlandPreis, Double auslandPreis) {
        super();
        this.inlandPreis = inlandPreis;
        this.auslandPreis = auslandPreis;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public void addCredit(Double credit) {
        this.credit += credit;
    }

    public void callDone(int countMins, CallTypeEnum calltype) {
        Double price = 0.0;
        switch (calltype) {
            case INLAND:
                price = inlandPreis * countMins;
                break;
            case ABROAD:
                price = auslandPreis * countMins;
            default:
                break;
        }

        Call call = new Call();
        call.setCountMinutes(countMins);
        call.setPrice(price);
        call.setType(calltype);
        if (price > credit)
            throw new IllegalStateException("Not enough credit!");
        credit -= price;
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }
}
