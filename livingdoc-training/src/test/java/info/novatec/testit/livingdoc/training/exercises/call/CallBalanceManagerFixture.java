package info.novatec.testit.livingdoc.training.exercises.call;

import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("Call Balance Manager")
public class CallBalanceManagerFixture {

	private CreditManager creditMgr;

	public CallBalanceManagerFixture(Double inlandPreis, Double auslandPreis) {
		this.creditMgr = new CreditManager(inlandPreis, auslandPreis);
	}

	@BeforeTable
	public void setup(){
		LivingDoc.register(new CallTypeConverter());
		LivingDoc.register(new PriceConverter());
	}

	@Alias("an account with as its balance")
	public boolean setCredit(Double credit) {
		creditMgr.setCredit(credit);
		return true;
	}

	@Alias("the user adds")
	public boolean addCredit(Double credit) {
		creditMgr.addCredit(credit);
		return true;
	}

	@Alias("the total balance is")
	public Double getCredit() {
		return creditMgr.getCredit();
	}

	@Alias("the user makes a call of min")
	public boolean placeCall(CallTypeEnum calltype, int minutes) {
		try {
			creditMgr.callDone(minutes, calltype);
			return true;
		} catch (RuntimeException re) {
			return false;
		}
	}

	@Alias("call history")
	public CallHistoryListFixture callsList(){
		return new CallHistoryListFixture(creditMgr);
	}

	@AfterTable
	public void cleanup(){
		LivingDoc.unregisterLastAddedCustomConverter();
		LivingDoc.unregisterLastAddedCustomConverter();
	}

}
