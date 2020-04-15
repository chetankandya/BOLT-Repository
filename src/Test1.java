
public class Test1 {
	public static void main(String[] args) {

		// 6 on paper in anticlock
		// circle on the floor clockwise

		SavingsAccount sa = new SavingsAccount(5000);
		
		System.out.println("sa "+sa);
		
		Cashier cash = new Cashier();
		
		cash.issueCash(sa,500);
		
		System.out.println("sa "+sa);
		
		
			
	}
} 



class Cashier {

	void issueCash(SavingsAccount x,float amt) {
		x.withdraw(amt);
	}
}

class SavingsAccount {
	float balance;

	SavingsAccount(float a) {
		balance = a;
	}

	void withdraw(float amtToWithdraw) {
		System.out.println("withdrawing... " + amtToWithdraw);
		balance = balance - amtToWithdraw;
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + "]";
	}
	
}
