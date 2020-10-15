package veryAdvanced.objects.studentplaner;

public class Student extends Person {

	private String matriculationNumber;
	
	
	public Student(String firstName, String lastName, String matriculationNumber) {
		super(firstName, lastName);
		this.matriculationNumber = matriculationNumber;
	}

	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matriculationNumber == null) ? 0 : matriculationNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matriculationNumber == null) {
			if (other.matriculationNumber != null)
				return false;
		} else if (!matriculationNumber.equals(other.matriculationNumber))
			return false;
		return true;
	}
}
