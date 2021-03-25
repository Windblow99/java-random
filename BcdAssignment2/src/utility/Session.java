package utility;

public class Session {
    private static String UUID;

    public static String getUuid() {
        return UUID;
    }

    public static void setUuid(String uuid) {
        Session.UUID = uuid;
    }
}
