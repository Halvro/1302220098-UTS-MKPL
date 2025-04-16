public class TaxFunction {

	private static final int BASIC_PTKP = 54000000;
	private static final int MARRIAGE_PTKP = 4500000;
	private static final int CHILD_PTKP = 1500000;
	private static final int MAX_CHILDREN = 3;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		// Batasi jumlah anak maksimum yang dihitung untuk PTKP
		numberOfChildren = Math.min(numberOfChildren, MAX_CHILDREN);

		int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
		int netTaxableIncome = totalIncome - deductible - nonTaxableIncome;

		int tax = (int) Math.round(0.05 * Math.max(netTaxableIncome, 0));

		return tax;
	}

	private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		int ptkp = BASIC_PTKP;
		if (isMarried) {
			ptkp += MARRIAGE_PTKP;
		}
		ptkp += numberOfChildren * CHILD_PTKP;
		return ptkp;
	}
}
