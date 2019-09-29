package com.asu.ser.usermanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asu.ser.authentication.AuthenticationUtil;
import com.asu.ser.db.DataSource;
import com.asu.ser.util.MailServer;

public class UserManagementHandler {
	
	private static final String ROLE_ADMIN = "admin";
	private static final String ROLE_TEACHER = "teacher";
	private static Map<String, Integer> USER_ROLES;
	static {
		try {
			USER_ROLES = DataSource.fetchRoles();
		} catch(Exception e) {
			e.printStackTrace();
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
    
    public static void addTeacher(String firstName, String lastName, String emailID) throws Exception {
    	String loggedInUser = AuthenticationUtil.getLoggedInUser();
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
    	} catch (Exception e) {
    		if(teacherUserID > 0) {
    			DataSource.deleteUser(userID);
    		}
    		throw e;
    	}
    }
    
    public static List<Teacher> fetchTeachers() throws Exception {
    	String loggedInUser = AuthenticationUtil.getLoggedInUser();
    	Integer institutionID = DataSource.fetchUsersInstitutionID(loggedInUser);
    	return DataSource.fetchTeachers(institutionID);
    }
    
    public static boolean isInstitutionPresent(String institutionName) throws Exception {
        Integer institutionID = DataSource.fetchInstitutionID(institutionName);
        return institutionID == null ? false : true;
    }

	public static void sendTeacherAccountPasswordEmail(String firstName, String lastName, String teacherEmailID,
			String password, String adminEmailID) throws Exception {
    	String subject = "ArithmenticEvaluvator - Account created";
    	String content = "Your account has been created by user - " + adminEmailID + "\n";
    	content += "Your account email is - " + teacherEmailID + "\n";
    	content += "Your account password is - " + adminEmailID;
    	MailServer.sendMail(teacherEmailID, subject, content);
    	
    }
    
}
