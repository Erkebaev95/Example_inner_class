package anonym_class;

public class WrapperString {
    private String str;

    public WrapperString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public String replace(char oldChar, char newChar) {// замена первого символа
        char[] arr = new char[str.length()];
        str.getChars(0, str.length(), arr, 0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldChar) {
                arr[i] = newChar;
                break;
            }
        }
        return new String(arr);
    }
}
