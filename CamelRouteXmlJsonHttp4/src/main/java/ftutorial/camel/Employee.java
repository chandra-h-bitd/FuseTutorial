package ftutorial.camel;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "employee")
public class Employee {

		private String empName;
		private int empId;

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}
}
