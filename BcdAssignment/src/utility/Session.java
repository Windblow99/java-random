
package utility;


public class Session {
    private static String UUID;
    private static String role;

    public static String getUuid() {
        return UUID;
    }

    public static void setUuid(String uuid) {
        Session.UUID = uuid;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        Session.role = role;
    }
}
