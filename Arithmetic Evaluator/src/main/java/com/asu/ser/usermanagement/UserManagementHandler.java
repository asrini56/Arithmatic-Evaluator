package com.asu.ser.usermanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asu.ser.authentication.AuthenticationUtil;
import com.asu.ser.db.DataSource;
import com.asu.ser.model.Student;
import com.asu.ser.model.Teacher;
import com.asu.ser.model.User;
import com.asu.ser.util.MailServer;
import org.apache.commons.lang3.StringUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 * @author Deepti
 * @author Aihaab
 */

public class UserManagementHandler {
	
	private static Logger LOGGER = Logger.getLogger(UserManagementHandler.class.getName());

	private static final String ROLE_ADMIN = "admin";
	private static final String ROLE_TEACHER = "teacher";
	private static final String ROLE_STUDENT = "student";
	private static Map<String, Integer> USER_ROLES;
	static {
		try {
			USER_ROLES = DataSource.fetchRoles();
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Error" , e);
			USER_ROLES = new HashMap<>();
		}

	}

	@PostConstruct
	public static void init(){
		try {
			USER_ROLES = DataSource.fetchRoles();
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Error" , e);
			USER_ROLES = new HashMap<>();
		}
	}

    public static void signUpAdminUser(String emailID, String password, String firstName, String lastName, String institutionName) throws Exception {
        Integer userID = DataSource.insertUser(emailID, password, firstName, lastName);
        Integer roleID = USER_ROLES.get(ROLE_ADMIN);
        if(roleID == null ) {
        	throw new Exception("Server error - Invalid role");
        }
        DataSource.insertUserToRole(userID, roleID);
        Integer institutionID = DataSource.insertInstitution(institutionName);
        DataSource.insertUserTOInstitution(userID, institutionID);
    }

    public static String loginUser(String emailID, String password) throws Exception {
        String message = "";
        List<User> userList = DataSource.selectUser(emailID);
        if(userList.isEmpty()){
            message = "Username does not exist. Please create an account";
            return message;
        } else if(StringUtils.equals(userList.get(0).getPassword(), password)) {
            message = "Success";
        } else {
            message = "Incorrect Password. Please provide correct password.";
            return message;
        }
        LOGGER.log(Level.INFO,"Trying to login user " + emailID + " status " + message);
        return message;
    }

	public static String resetPassword(String emailID, String password) throws Exception {
		String message = "";
		Integer rowsAffected = DataSource.resetPassword(emailID, password);
		if(rowsAffected>0){
			message = "Success";
			return message;
		} else {
			message = "Failed to update Password.";
			return message;
		}
	}

    public static void addTeacher(String firstName, String lastName, String emailID) throws Exception {
    	String loggedInUser = AuthenticationUtil.getLoggedInUser();
    	if(loggedInUser == null || loggedInUser.isEmpty()) {
    		throw new Exception("No user logged in");
    	}
    	int userID = DataSource.fetchUserID(loggedInUser);
    	int userRoleID = DataSource.fetchUserRole(userID);
    	int adminRoleID = USER_ROLES.get(ROLE_ADMIN);
    	if(userRoleID != adminRoleID) {
    		throw new Exception("Illegal operation - user does not have permission to add teacher");
    	}
    	Integer institutionID = DataSource.fetchUsersInstitutionID(loggedInUser);
    	if(institutionID == null) {
    		throw new Exception("Illegal operation - logged in user does not belong to any instituion");
    	}
    	String password = PasswordGenerator.generatePassword();
    	Integer teacherUserID = -1;
    	try {
    		teacherUserID = DataSource.insertUser(emailID, password, firstName, lastName);
    		Integer teacherRoleID = USER_ROLES.get(ROLE_TEACHER);
    		if(teacherRoleID == null ) {
    			throw new Exception("Server error - Invalid role " + teacherRoleID);
    		}
    		DataSource.insertUserToRole(teacherUserID, teacherRoleID);
    		DataSource.insertUserTOInstitution(teacherUserID, institutionID);
    		sendTeacherAccountPasswordEmail(firstName, lastName, emailID, password, loggedInUser);
    	} catch (Exception e) {
    		if(teacherUserID > 0) {
    			DataSource.deleteUserWithID(userID);
    		}
    		throw e;
    	}
    }

	public static void addStudent(String firstName, String lastName, String emailID) throws Exception {
		String loggedInUser = AuthenticationUtil.getLoggedInUser();
		if(loggedInUser == null || loggedInUser.isEmpty()) {
			throw new Exception("No user logged in");
		}
		int userID = DataSource.fetchUserID(loggedInUser);
		int userRoleID = DataSource.fetchUserRole(userID);
		int adminRoleID = USER_ROLES.get(ROLE_ADMIN);
		if(userRoleID != adminRoleID) {
			throw new Exception("Illegal operation - user does not have permission to add teacher");
		}
		Integer institutionID = DataSource.fetchUsersInstitutionID(loggedInUser);
		if(institutionID == null) {
			throw new Exception("Illegal operation - logged in user does not belong to any instituion");
		}
		String password = PasswordGenerator.generatePassword();
		Integer studentUserID = -1;
		try {
			studentUserID = DataSource.insertUser(emailID, password, firstName, lastName);
			Integer studentRoleID = USER_ROLES.get(ROLE_STUDENT);
			if(studentRoleID == null ) {
				throw new Exception("Server error - Invalid role " + studentRoleID);
			}
			DataSource.insertUserToRole(studentUserID, studentRoleID);
			DataSource.insertUserTOInstitution(studentUserID, institutionID);
			sendStudentAccountPasswordEmail(firstName, lastName, emailID, password, loggedInUser);
		} catch (Exception e) {
			throw e;
		}
	}

    public static List<Teacher> fetchTeachers() throws Exception {
    	String loggedInUser = AuthenticationUtil.getLoggedInUser();
    	Integer institutionID = DataSource.fetchUsersInstitutionID(loggedInUser);
    	return DataSource.fetchTeachers(institutionID);
    }

	public static List<Student> fetchStudents() throws Exception {
		String loggedInUser = AuthenticationUtil.getLoggedInUser();
		Integer institutionID = DataSource.fetchUsersInstitutionID(loggedInUser);
		return DataSource.fetchStudents(institutionID);
	}

    public static List<TestDetails> fetchTestDetails() throws Exception {
        String loggedInUser = AuthenticationUtil.getLoggedInUser();
        if(loggedInUser == null || loggedInUser.isEmpty()) {
            throw new Exception("No user logged in");
        }
        int userID = DataSource.fetchUserID(loggedInUser);
        int userRoleID = DataSource.fetchUserRole(userID);
        int teacherRoleID = USER_ROLES.get(ROLE_TEACHER);
        if(userRoleID != teacherRoleID) {
            throw new Exception("Illegal operation - user does not have permission to remove teacher");
        }
        return DataSource.fetchTestDetails(userID);
    }

    public static boolean isInstitutionPresent(String institutionName) throws Exception {
        Integer institutionID = DataSource.fetchInstitutionID(institutionName);
        return institutionID != null;
    }

    public static void removeTeacher(String teacherEmailID) throws Exception {
    	String loggedInUser = AuthenticationUtil.getLoggedInUser();
    	if(loggedInUser == null || loggedInUser.isEmpty()) {
    		throw new Exception("No user logged in");
    	}
    	int userID = DataSource.fetchUserID(loggedInUser);
    	int userRoleID = DataSource.fetchUserRole(userID);
    	int adminRoleID = USER_ROLES.get(ROLE_ADMIN);
    	if(userRoleID != adminRoleID) {
    		throw new Exception("Illegal operation - user does not have permission to remove teacher");
    	}
    	DataSource.deleteUserWithEmailID(teacherEmailID);
    }

	public static void sendTeacherAccountPasswordEmail(String firstName, String lastName, String teacherEmailID,
			String password, String adminEmailID) throws Exception {
    	String subject = "ArithmenticEvaluvator - Account created";
    	String content = "Your account has been created by user - " + adminEmailID + "\n";
    	content += "Your account email is - " + teacherEmailID + "\n";
    	content += "Your account password is - " + password;
    	MailServer.sendMail(teacherEmailID, subject, content);

    }

	public static void sendStudentAccountPasswordEmail(String firstName, String lastName, String studentEmailID,
													   String password, String adminEmailID) throws Exception {
		String subject = "ArithmenticEvaluvator - Account created";
		String content = "Your account has been created by user - " + adminEmailID + "\n";
		content += "Your account email is - " + studentEmailID + "\n";
		content += "Your account password is - " + password;
		MailServer.sendMail(studentEmailID, subject, content);
	}

	public static String getRoleNameForUser(String emailID) throws Exception {
		return DataSource.fetchUserRoleName(emailID);
	}

    public static List<TestDetails> fetchGradeTestDetails() throws Exception {
        String loggedInUser = AuthenticationUtil.getLoggedInUser();
        if(loggedInUser == null || loggedInUser.isEmpty()) {
            throw new Exception("No user logged in");
        }
        int userRoleID = DataSource.fetchUserID(loggedInUser);
        int gradeID = DataSource.fetchGradeID(userRoleID);
        int studentRoleID = USER_ROLES.get(ROLE_STUDENT);
        if(userRoleID != studentRoleID) {
            throw new Exception("Illegal operation - only students have permission to view tests");
        }
        return DataSource.fetchGradeTestDetails(gradeID);
    }

}
