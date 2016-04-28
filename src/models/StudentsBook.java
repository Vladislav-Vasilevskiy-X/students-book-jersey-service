package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import util.DBWorker;

public class StudentsBook {
	private HashMap<String, StudentProfile> studentProfiles = new HashMap<String, StudentProfile>();
	private DBWorker db = DBWorker.getInstance();
	private static StudentsBook instance = null;

	public static StudentsBook getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new StudentsBook();
		}
		return instance;
	}

	protected StudentsBook() throws ClassNotFoundException, SQLException {
		ResultSet db_data = this.db.getDBData("SELECT * FROM `student` ORDER BY `name` ASC");
		while (db_data.next()) {
			this.studentProfiles.put(db_data.getString("id"),
					new StudentProfile(db_data.getString("id"), db_data.getString("name"), db_data.getString("age"),
							db_data.getString("speciality"), db_data.getString("course"), db_data.getString("faculty"),
							db_data.getString("university"), db_data.getString("averageValue"),
							db_data.getString("description")));
		}
	}

	public StudentProfile addStudentProfile(StudentProfile student) {
		if (!studentProfiles.containsValue(student)) {
			String query = "INSERT INTO `student` (`name`, `age`, `speciality`, `course`, `faculty`, `university`, `averageValue`, `description`) VALUES ('"
					+ student.getName() + "', '" + student.getAge() + "', '" + student.getSpeciality() + "', '"
					+ student.getCourse() + "', '" + student.getFaculty() + "', '" + student.getUniversity() + "', '"
					+ student.getAverageValue() + "', '" + student.getDescription() + "')";

			Integer affected_rows = this.db.changeDBData(query);

			if (affected_rows > 0) {
				student.setId(this.db.getLastInsertId().toString());

				this.studentProfiles.put(student.getId(), student);

				return student;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	public StudentProfile updateStudentProfile(String id, StudentProfile student) {
		if (!studentProfiles.containsValue(student)) {
			Integer id_filtered = Integer.parseInt(student.getId());
			String query = "UPDATE `student` SET `name` = '" + student.getName() + "', `age` = '" + student.getAge()
					+ "', `speciality` = '" + student.getSpeciality() + "', `course` = '" + student.getCourse()
					+ "', `faculty` = '" + student.getFaculty() + "', `university` = '" + student.getUniversity()
					+ "', `averageValue` = '" + student.getAverageValue() + "', `description` = '"
					+ student.getDescription() + "' WHERE `id` = " + id_filtered;

			Integer affected_rows = this.db.changeDBData(query);

			if (affected_rows > 0) {
				this.studentProfiles.put(student.getId(), student);
				return student;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	public boolean deleteStudentProfile(String id) {
		if ((id != null) && (!id.equals("null"))) {
			int filtered_id = Integer.parseInt(id);

			Integer affected_rows = this.db.changeDBData("DELETE FROM `student` WHERE `id`=" + filtered_id);

			if (affected_rows > 0) {
				this.studentProfiles.remove(id);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public HashMap<String, StudentProfile> getStudentProfiles() {
		return studentProfiles;
	}

	public StudentProfile getStudentProfile(String id) {
		return this.studentProfiles.get(id);
	}
}
