import java.util.ArrayList;

class User {
    private String Email, password;

    public User(String Email, String password) {
        this.Email = Email;
        this.password = password;
    }

    public String getEmail() { return Email; }
    public String getPassword() { return password; }
}

class Data {
    private ArrayList<User> users;

    public Data() {
        users = new ArrayList<>();
    }

    void adduser(User user) {
        users.add(user);
    }
    public void getUsers() {
        for (User user : users) {
            System.out.println(user.getEmail() + " " + user.getPassword());
        }
    }
}

class EmailNotificationService {
    boolean sendConfirmationEmail(String Email) {
        System.out.println("confirm mail sent successfuly");
        return true;
    }
}

class UserValidationService {
    public boolean validateUser(User user) {
        return user.getPassword().length() >= 8 && user.getEmail().contains("@") && user.getEmail().contains(".");
    }
}

class UserRegistrationService {
    private UserValidationService userValidationService = new UserValidationService();
    private Data data;

    public UserRegistrationService(Data data) {
        this.data = data;
    }

    public boolean register(User user) {
        if (userValidationService.validateUser(user)) {
            data.adduser(user);
            return true;
        }
        return false;
    }
}

public class Test {

    public void testUserValidationService() {
        UserValidationService validator = new UserValidationService();
        User user1 = new User("user@example.com", "secure123");
        System.out.println(validator.validateUser(user1)); // 顯示true
        User user2 = new User("invalid-email", "secure123");
        System.out.println(validator.validateUser(user2)); // 顯示false
    }

    public void testUserRegistration(Data data) {
        UserRegistrationService registrationService = new UserRegistrationService(data);
        User user3 = new User("test@example.com", "password");
        boolean result = registrationService.register(user3);
        System.out.println(result); // 在email與密碼合乎規定的情況下，顯示註冊成功
    }

    public void testEmailNotification() {
        EmailNotificationService emailService = new EmailNotificationService();
        String email = "test@example.com";
        boolean result = emailService.sendConfirmationEmail(email);// 顯示confirm mail sent successfuly
        System.out.println(result);// 顯示true
    }

    public static void main(String[] args) {
        Test test = new Test();
        Data data = new Data();

        test.testUserValidationService();
        test.testUserRegistration(data);
        test.testEmailNotification();
        data.getUsers();
    }
}