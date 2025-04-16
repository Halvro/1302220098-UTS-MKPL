// Refactor untuk setMonthlySalary
public void setMonthlySalary(int grade) {
	int baseSalary = calculateBaseSalaryByGrade(grade);
	if (isForeigner) {
		baseSalary *= 1.5;
	}
	this.monthlySalary = baseSalary;
}

// Method baru untuk mendapatkan gaji dasar berdasarkan grade
private int calculateBaseSalaryByGrade(int grade) {
	switch (grade) {
		case 1: return 3000000;
		case 2: return 5000000;
		case 3: return 7000000;
		default: return 0;
	}
}

// Fix bug pada setSpouse
public void setSpouse(String spouseName, String spouseIdNumber) {
	this.spouseName = spouseName;
	this.spouseIdNumber = spouseIdNumber; // diperbaiki dari sebelumnya idNumber
}
