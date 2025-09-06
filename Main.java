import java.util.Scanner;


class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    public void displayInfo() {
        System.out.println("User: " + username);
    }
}


class AdminUser extends User {
    private String password; 

    public AdminUser(String username, String password) {
        super(username);
        this.password = password;
    }

    public void showPassword() {
        System.out.println("Password for " + username + ": " + password);
    }

    public void runCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Command executed: " + command);
        } catch (Exception e) {
            System.out.println("Error running command.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        AdminUser admin = new AdminUser(user, pass);
        admin.displayInfo();
        admin.showPassword(); 

        System.out.print("Enter a system command to run: ");
        String command = scanner.nextLine();
        admin.runCommand(command); 

        scanner.close();
    }
}
