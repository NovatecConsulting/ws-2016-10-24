package info.novatec.testit.livingdoc.training.exercises.call;

import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

import java.util.ArrayList;
import java.util.List;

@FixtureClass("Call History")
public class CallHistoryListFixture {

	private CreditManager creditMgr;

    public CallHistoryListFixture(CreditManager creditMgr) {
        this.creditMgr = creditMgr;
    }

    public List<CallWrapper> query(){
		List<CallWrapper> liste = new ArrayList<CallWrapper>();
		for(Call call : creditMgr.getCalls()){
			liste.add(new CallWrapper(call));
		}
		return liste;
	}

	public static class CallWrapper {

		private Call call;

		public CallWrapper(Call call) {
			this.call = call;
		}

		public CallTypeEnum getType() {
			return call.getType();
		}
		
		public double getPrice() {
			return call.getPrice();
		}
		
		public int getMinutes(){
			return call.getCountMinutes();
		}

	}

}
