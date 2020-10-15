package veryAdvanced.objects.studentplaner;

public class Lecturer extends Person {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((workerId == null) ? 0 : workerId.hashCode());
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
		Lecturer other = (Lecturer) obj;
		if (workerId == null) {
			if (other.workerId != null)
				return false;
		} else if (!workerId.equals(other.workerId))
			return false;
		return true;
	}

	private String workerId;

	public Lecturer(String firstName, String lastName, String workerId) {
		super(firstName, lastName);
		this.workerId = workerId;
	}

	public String getWorkerId() {
		return workerId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getLastName();
	}
}
