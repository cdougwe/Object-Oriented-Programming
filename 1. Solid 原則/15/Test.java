interface NotificationSender {
    void send(String message);
}

class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.print("透過電子郵件 " + message + " 通知");
    }
}

class SmsNotificationSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.print("透過短信 " + message + " 通知");
    }
}

class NotificationService {
    private NotificationSender notificationSender;

    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public NotificationSender getNotificationSender() { return notificationSender; }
    public void setNotificationSender(NotificationSender notificationSender) { this.notificationSender = notificationSender; }
    boolean sendNotification(String title) {
        notificationSender.send(title);
        return true;
    }
}

public class Test {
    public void testEmailNotification() {
        NotificationSender emailSender = new EmailNotificationSender();
        NotificationService notificationService = new NotificationService(emailSender);
        boolean result = notificationService.sendNotification("test@example.com");// 顯示透過電子郵件通知成功或失敗
        System.out.println(result ? " -成功" : " -失敗");
    }

    public void testSmsNotification() {
        NotificationSender smsSender = new SmsNotificationSender();
        NotificationService notificationService = new NotificationService(smsSender);
        boolean result = notificationService.sendNotification("1234567890");// 顯示透過短信通知成功或失敗
        System.out.println(result ? " -成功" : " -失敗");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testEmailNotification();
        test.testSmsNotification();
    }
}