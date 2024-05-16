package TestData;

public class LoginData {

    public static String weakAuthUrl = "https://qlf-espaceclient.oney.fr/login?dl=true";
    //public static String weakAuthUrl = "https://oneyfr-stg-beta.azurewebsites.net/login?dl=true";

    public enum Customer_3x {

        USER_IAD("306137191"),
        USER_PASSWORD("12345");

        private final String value;

        Customer_3x(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_4x {

        USER_IAD("306137191"),
        USER_PASSWORD("12345");

        private final String value;

        Customer_4x(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
