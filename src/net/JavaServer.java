package net;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.StudentProfile;
import models.StudentsBook;

@Path("StudentsBook")
public class JavaServer {

	private StudentsBook studentsBook;

	public JavaServer() {
		try {
			studentsBook = StudentsBook.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentProfile> getListOfStudents() {
		System.out.println("in get");
		return new ArrayList<StudentProfile>(studentsBook.getStudentProfiles().values());
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public StudentProfile getStudentProfile(@PathParam("id") String id) {
		return studentsBook.getStudentProfile(id);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public StudentProfile addStudentProfile(StudentProfile profile) {
		System.out.println("in add.");
		return studentsBook.addStudentProfile(profile);
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public StudentProfile editStudentProfile(StudentProfile studentProfile) {
		return studentsBook.updateStudentProfile(studentProfile.getId(), studentProfile);
	}

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void removeStudentProfile(@PathParam("id") String id) {
		studentsBook.deleteStudentProfile(id);
	}
}
