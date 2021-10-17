package anonym_class;

public class Runner {
    public static void main(String[] args) {
        String ob = "qweRtRRR";
        WrapperString wrFirst = new WrapperString(ob);

        // анонимный класс #1
        WrapperString wrLast = new WrapperString(ob) {

            // замена последнего символа
            @Override
            public String replace(char oldChar, char newChar) {
                char[] arr = new char[getStr().length()];
                getStr().getChars(0, getStr().length(), arr, 0);
                for (int i = arr.length - 1; i > 0; i--) {
                    if (arr[i] == oldChar) {
                        arr[i] = newChar;
                        break;
                    }
                }
                return new String(arr);
            }
        };// конец объявления анонимного класса

        // анонимный класс #2
        WrapperString wr2 = new WrapperString(ob) {

            // собственное поле
            private int pos = 2;

            // замена символа по позиции
            public String replace(char oldChar, char newChar) {
                int counter = 0;

                char[] array = new char[getStr().length()];
                getStr().getChars(0, getStr().length(), array, 0);
                if (verify(oldChar, array)) {
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == oldChar) {
                            counter++;

                            if (counter == pos) {
                                array[i] = newChar;
                                break;
                            }
                        }
                    }
                }
                return new String(array);
            }

            // собственный метод
            public boolean verify(char oldChar, char[] arr) {
                int counter = 0;
                for (char c : arr) {
                    if (c == oldChar) {
                        counter++;
                    }
                }
                return counter >= pos;
            }
        };// конец объявления анонимного класса

        System.out.println(wrLast.replace('R', 'Y'));
        System.out.println(wr2.replace('R', 'Y'));
        System.out.println(wrFirst.replace('R', 'Y'));
    }
}
