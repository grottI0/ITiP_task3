import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("task N1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
        System.out.println();

        System.out.println("task N2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println();

        System.out.println("task N3");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));
        System.out.println();

        System.out.println("task N4");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
        System.out.println();

        System.out.println("task N5");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));
        System.out.println();

        int[] firstArray = {1, 3, 4, 4, 4};
        int[] secondArray = {2, 5, 7};
        int[] thirdArray = {9, 8, 7, 6};
        int[] fourthArray = {4, 4, 3, 1};
        int[] fifthArray = {2};
        int[] sixthArray = {3, 3, 3, 3, 3};
        System.out.println("task N6");
        System.out.println(same(firstArray, secondArray));
        System.out.println(same(thirdArray, fourthArray));
        System.out.println(same(fifthArray, sixthArray));
        System.out.println();

        System.out.println("task N7");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
        System.out.println();

        System.out.println("task N8");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
        System.out.println();

        System.out.println("task N9");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
        System.out.println();

        System.out.println("task N10");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
        System.out.println();
    }

    // возвращает количество решений квадратного уравнения по его коэффициентам
    public static int solutions(double first, double second, double third) {
        double d = Math.pow(second, 2) - 4 * first * third;
        if (d > 0) {
            return 2;
        } else if (d == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // возвращает позицию второго вхождения "zip" в строку
    public static int findZip(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 1) == 'i' && str.charAt(i + 2) == 'p' ) {
                count += 1;
                if (count == 2) {
                    return i;
                }
            }
        }
        return -1;
    }

    // проверяет, является ли целое число совершенным
    public static boolean checkPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    //принимает строку и возвращает новую строку с заменой ее первого и последнего символов
    public static String flipEndChars(String str) {
        if (str.length() < 2) {
            return "Incompatible.";
        }

        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length()-1);

        if (firstChar == lastChar) {
            return "Two's a pair.";
        }

        StringBuilder result = new StringBuilder();
        result.append(lastChar);
        for (int i = 1; i < str.length()-1; i++) {
            result.append(str.charAt(i));
        }
        result.append(firstChar);
        return result.toString();
    }

    // определяет, является ли строка допустимым шестнадцатеричным кодом
    public static boolean isValidHexCode(String str) {
        if (str.charAt(0) != '#' || str.length() != 7) {
            return false;
        }
        String lowerString = str.toLowerCase();
        for (int i = 1; i <= 6; i++) {
            if (!Character.isDigit(lowerString.charAt(i)) &&
                    !(lowerString.charAt(i) >= 'a' && lowerString.charAt(i) <= 'f')) {
                return false;
            }
        }
        return true;
    }

    // возвращает true, если два массива имеют одинаковое количество уникальных элементов
    public static boolean same(int[] first, int[] second) {
        ArrayList<Integer> firstAsList = new ArrayList<>();
        ArrayList<Integer> secondAsList = new ArrayList<>();

        for (int i = 0; i < first.length; i++) {
            if (!firstAsList.contains(first[i])) {
                firstAsList.add(first[i]);
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (!secondAsList.contains(second[i])) {
                secondAsList.add(second[i]);
            }
        }
        return firstAsList.size() == secondAsList.size();
    }

    // проверяет является ли число числом Капрекара
    public static boolean isKaprekar(int number) {
        String squareString = String.valueOf((int) Math.pow(number, 2));

        StringBuilder left = new StringBuilder().append(0);
        StringBuilder right = new StringBuilder().append(0);

        for (int i = 0; i < squareString.length()/2; i++) {
            left.append(squareString.charAt(i));
        }
        for (int i = squareString.length()/2; i < squareString.length(); i++) {
            right.append(squareString.charAt(i));
        }

        return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString()) == number;
    }

    // возвращает самую длинную последовательность последовательных нулей в двоичной строке
    public static String longestZero(String str) {
        StringBuilder result = new StringBuilder();
        int sum = 0, biggestSum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                sum += 1;
                if (sum > biggestSum) {
                    biggestSum = sum;
                }
            } else {
                sum = 0;
            }
        }
        result.append("0".repeat(biggestSum));
        return result.toString();
    }

    // возвращает следующее простое число
    public static int nextPrime(int number) {
        while (true) {
            int count = 0;
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    count += 1;
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                break;
            } else {
                number += 1;
            }
        }
        return number;
    }

    public static boolean rightTriangle(int x, int y, int z) {
        int hypotenuse = 0, first = 0, second = 0;
        if (x > y && x > z) {
            hypotenuse = x;
            first = y;
            second = z;
        } else if (y > x && y > z) {
            hypotenuse = y;
            first = x;
            second = z;
        } else {
            hypotenuse = z;
            first = y;
            second = x;
        }

        return Math.pow(hypotenuse, 2) == Math.pow(first, 2) + Math.pow(second, 2);
    }
}
