package com.asu.ser.usermanagement;

import com.asu.ser.authentication.AuthenticationUtil;
import com.asu.ser.model.Student;
import com.asu.ser.model.Teacher;
import com.asu.ser.model.TestAnswers;
import com.asu.ser.model.TestQuestion;
import com.asu.ser.operations.TestHandler;
import com.asu.ser.model.TestScore;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import org.apache.commons.lang3.StringUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.regex.Pattern;
/**
 * @author Akhilesh
 * @author Ashwin
 * @author Srinivasan
 * @author Deepti
 * @author Aihaab 
 */

@Conversion()
public class UserManagementAction {

    private String emailID;
    private int testId;
    private String password;
    private String firstName;
    private String lastName;
    private String grade;
    private String message;
    private String institutionName;
    private List<Teacher> teachers;
    private List<Student> students;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private List<TestDetails> testDetails;
    private List<TestScore> testScoreList;
    private List<TestAnswers> testAnswersList;


    private static Logger LOGGER = Logger.getLogger(UserManagementAction.class.getName());

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    /**
     * This function is used to perform the sign up operation
     * @return
     */
    public String signUp(){
    	String returnType = Action.SUCCESS;
        try {
        	LOGGER.log(Level.INFO, "Creating admin user  " + emailID + " for institution " + institutionName);
            if(StringUtils.isEmpty(emailID) || !validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                LOGGER.log(Level.INFO,message);
                returnType = Action.ERROR;
            } else if(StringUtils.isEmpty(password) || !validPassword(password)){
                message = "Invalid Password. Please enter a valid Password.";
                returnType = Action.ERROR;
            } else if(StringUtils.isEmpty(institutionName) || UserManagementHandler.isInstitutionPresent(institutionName)){
                message = "Institution name exists. Kindly try another name";
                returnType = Action.ERROR;
            } else {
            	UserManagementHandler.signUpAdminUser(emailID, password, null, null, StringUtils.trimToNull(institutionName));
            	message = "Account successfully created!";
            }
        } catch (Exception e) {
            message = "Failed to create Admin Account!!!";
            LOGGER.log(Level.SEVERE, "Failed to create Admin Account" , e);
            returnType = Action.ERROR;
        }
        LOGGER.log(Level.INFO,message);
        return returnType;
    }

    /**
     * This function is used to perform the login operation
     * @return
     */
    public String login(){
        try {
            message = UserManagementHandler.loginUser(emailID, password);
            if(StringUtils.equalsIgnoreCase(message, "success")){
                AuthenticationUtil.setTokenForUser(emailID);
                return UserManagementHandler.getRoleNameForUser(emailID);
            }
        } catch (Exception e) {
            message = "Error while logging in. Please try again.";
            LOGGER.log(Level.SEVERE, "Error while logging in. Please try again." , e);
            return Action.ERROR;
        }
        return Action.ERROR;
    }

    /**
     * This function is used to perform the logout operation
     * @return
     */
    public String logout(){
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            return Action.ERROR;
        }
        AuthenticationUtil.reomveTokenForUser(emailID);
        return Action.SUCCESS;
    }

    /**
     * This function is invoked while adding teachers
     * @return
     */
    public String addTeacher() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            LOGGER.log(Level.INFO,message);
            return Action.LOGIN;
        }
    	try {
    		LOGGER.log(Level.INFO,"Creating teacher " + firstName + " " + lastName);
    		if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                LOGGER.log(Level.INFO,message);
                return Action.ERROR;
            } else {
            	UserManagementHandler.addTeacher(firstName, lastName, emailID);
            	message = "Successfully created teacher account for " + emailID + ". Their details is mailed to them.";
                LOGGER.log(Level.INFO,message);
            }
    	} catch(SQLIntegrityConstraintViolationException sicve) {
    		message = "An account with email " + emailID + "already exists";
            LOGGER.log(Level.INFO,message);
            return Action.ERROR;
    	} catch (Exception e) {

			message = "Failed to add teacher " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to add teacher" , e);
			if(e.getMessage().equals("No user logged in")) {
				message = "Login as admin to add teacher";
                LOGGER.log(Level.INFO,message);
                return Action.LOGIN;
			}
            LOGGER.log(Level.INFO,message);
            return Action.ERROR;
		}
    	return Action.SUCCESS;
    }

    /**
     * This function is used to fetch various teacher information
     * @return
     */
    public String fetchTeachers() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
    	try {
    	    teachers = UserManagementHandler.fetchTeachers();
    	}catch (Exception e) {
    		message = "Failed to fetch teachers - " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to fetch teacher" , e);
		}
    	return Action.SUCCESS;
    }

    /**
     * This function is used to fetch various student information
     * @return
     */
    public String fetchStudents() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
        try {
            students = UserManagementHandler.fetchStudents();
        }catch (Exception e) {
            message = "Failed to fetch STUDENTS - " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to fetch students" , e);
        }
        return Action.SUCCESS;
    }

    /**
     * This function is used to remove user
     * @return
     */
    public String removeUser() {
    	try {
    		UserManagementHandler.removeUser(emailID);
    		message = "Successfully removed user " + emailID;
    	} catch(Exception e) {
    		message = "Failed to remove user " + emailID;
            LOGGER.log(Level.SEVERE, message , e);
		}
    	return Action.SUCCESS;
    }

    /**
     * This function is used to perform student addition operation
     * @return
     */
    public String addStudent() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            LOGGER.log(Level.INFO,message);
            return Action.LOGIN;
        }
        try {
            LOGGER.log(Level.INFO,"Creating Student " + firstName + " " + lastName);
            if(!validEmailID(emailID)){
                message = "Invalid Email ID. Please enter a valid Email ID.";
                LOGGER.log(Level.INFO,message);
                return Action.ERROR;
            } else {
                UserManagementHandler.addStudent(firstName, lastName, emailID, grade);
                message = "Successfully created Student account for " + emailID + ". Their details is mailed to them.";
                LOGGER.log(Level.INFO,message);
            }
        } catch(SQLIntegrityConstraintViolationException sicve) {
            message = "An account with email " + emailID + "already exists";
            LOGGER.log(Level.INFO,message);
            return Action.ERROR;
        } catch (Exception e) {

            message = "Failed to add student " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to add student" , e);
            if(e.getMessage().equals("No user logged in")) {
                message = "Login as admin to add student";
                LOGGER.log(Level.INFO,message);
                return Action.LOGIN;
            }
            LOGGER.log(Level.INFO,message);
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    /**
     * This function is invoked while password reset
     * @return
     */

    public String resetPassword() {
        if(!newPassword.equals(confirmPassword)){
            message = "Passwords does not match. Please re-enter a new password.";
            return Action.ERROR;
        } else if(!validPassword(newPassword)){
            message = "Invalid Password. Please enter a valid Password.";
            return Action.ERROR;
        } else{
            try {
                message = UserManagementHandler.loginUser(emailID, oldPassword);
                if (StringUtils.equalsIgnoreCase(message, "success")) {
                    AuthenticationUtil.setTokenForUser(emailID);
                    message = UserManagementHandler.resetPassword(emailID, newPassword);
                    if (StringUtils.equalsIgnoreCase(message, "success")) {
                        return Action.SUCCESS;
                    }
                }
            } catch (Exception e){
                message = "Error occurred while resetting password. Please try again!!";
                LOGGER.log(Level.SEVERE, message , e);
                return Action.ERROR;
            }
        }
        return Action.ERROR;
    }

    /**
     * This function is used to fetch test details
     * @return
     */
    public String fetchTestDetails() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
        try {
            testDetails = TestHandler.fetchTestDetails();
        }catch (Exception e) {
            message = "Failed to fetch test details - " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to fetch test details" , e);
        }
        return Action.SUCCESS;
    }


    /**
     * This function is used to fetch grade during test details
     * @return
     */

    public String fetchGradeTestDetails() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
        try {
            testDetails = UserManagementHandler.fetchGradeTestDetails();
        }catch (Exception e) {
            message = "Failed to fetch test details - " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to fetch test details" , e);
        }
        return Action.SUCCESS;
    }

    /**
     * This function is used to return test score
     * @return
     */
    public String fetchTestScoreDetails() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
        try {
            testScoreList = UserManagementHandler.fetchStudentTestScore();
        }catch (Exception e) {
            message = "Failed to fetch test details - " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to fetch test score details" , e);
        }
        return Action.SUCCESS;
    }

    /**
     * This function is used to fetch correct answers
     * @return
     */
    public String fetchStudentTestCorrectAnswers() {
        if(StringUtils.isEmpty(AuthenticationUtil.getLoggedInUser())){
            message = "Please log in to access the page.";
            return Action.ERROR;
        }
        try {
            testAnswersList = UserManagementHandler.fetchStudentTestCorrectAnswers(testId);
        }catch (Exception e) {
            message = "Failed to fetch test details - " + e.getMessage();
            LOGGER.log(Level.SEVERE, "Failed to fetch test score details" , e);
        }
        return Action.SUCCESS;
    }

    /**
     * This function is used to fetch student grade
     * @return
     */
    public String fetchStudentGrade(){
        try {
            grade = UserManagementHandler.fetchGrade().toLowerCase().replace("-", "");
        } catch (Exception e) {
            message = "Failed to fetch Student Grade - " + e.getMessage();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    /**
     * This function is used to validate email id
     * @return
     */

    private boolean validEmailID(String emailID) {
    	return EMAIL_PATTERN.matcher(emailID).matches();
    }

    /**
     * This function is used to validate password
     * @return
     */
    private boolean validPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<TestDetails> getTestDetails() {
        return testDetails;
    }

    public void setTestDetails(List<TestDetails> testDetails) {
        this.testDetails = testDetails;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public List<TestScore> getTestScoreList() {
        return testScoreList;
    }

    public void setTestScoreList(List<TestScore> testScoreList) {
        this.testScoreList = testScoreList;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public List<TestAnswers> getTestAnswersList() {
        return testAnswersList;
    }

    public void setTestAnswersList(List<TestAnswers> testAnswersList) {
        this.testAnswersList = testAnswersList;
    }
}
