package com.asu.ser.usermanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asu.ser.authentication.AuthenticationUtil;
import com.asu.ser.db.DataSource;
import com.asu.ser.model.User;
import com.asu.ser.util.MailServer;
import org.apache.commons.lang3.StringUtils;

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

    public static String loginUser(String emailID, String password) throws Exception {
        String message = "";
        List<User> userList = DataSource.selectUser(emailID);
        if(userList.isEmpty()){
            message = "Username does not exist. Please create an account";
            return message;
        } else if(StringUtils.equals(userList.get(0).getPassword(), password)) {
            message = "Success";
        } else {
            message = "Incorrect Password. Please provide correct password or try to reset password.";
            return message;
        }
        return message;
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
    	return DataSource.fetchTeachers(1);
    }

    public static boolean isInstitutionPresent(String institutionName) throws Exception {
        Integer institutionID = DataSource.fetchInstitutionID(institutionName);
        return institutionID != null;
    }

	public static void sendTeacherAccountPasswordEmail(String firstName, String lastName, String teacherEmailID,
			String password, String adminEmailID) throws Exception {
    	String subject = "ArithmenticEvaluvator - Account created";
    	String content = "Your account has been created by user - " + adminEmailID + "\n";
    	content += "Your account email is - " + teacherEmailID + "\n";
    	content += "Your account password is - " + adminEmailID;
    	MailServer.sendMail(teacherEmailID, subject, content);

    }

	public static String getRoleNameForUser(String emailID) throws Exception {
		return DataSource. fetchUserRoleName(emailID);
	}
}
