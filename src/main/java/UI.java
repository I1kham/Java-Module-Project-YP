import static java.lang.System.in;
import static java.util.Locale.ROOT;
import java.util.Scanner;
/*класс предназначен для хранения переменных, необходимых для взаимодействия программы и пользователя
 * переменные инициализируются в классе Main
 * также в классе хранятся методы взаимодействия программы с пользователем*/
public class UI {
    public static int inputInt;
    public static float inputFloat;
    public static String inputStr;
    public static int minPersonForSplit;
    public static float minProductPrice;
    public static int howManyPerson;

    public static boolean readyToGo(Scanner input, String needVariableType) {/*метод, для получения разрешения на продолжения программы
    в зависимости от от двух аргументов, введенной переменной и строки, включающая в себя необходимый ти переменной,
    возвращает true или false, в ходе работы использует методы прооверки текущего класса*/
        switch (needVariableType) {
            case "needInt":
                return checkForIntAndMinPersons(input);
            case "needFloat":
                return checkForFloatAndMinProductPrice(input);
            case "needStr":
                return checkForStr(input);
            default:
                System.err.println("error in Ui class methods");
                break;
        }

        return false;
    }

    /*методы проверки введенных данных с консоли, на требуемый тип данных, возвращает логическую переменную
     * в ходе работы присваивает сооответствующим переменным класса соответствующие данные, методы, также
     * включает в себя вывод ошибки, в случае не сооответсвия типу данных, требуемому*/
    public static boolean checkForIntAndMinPersons(Scanner input) {
        boolean a = input.hasNextInt();
        if (a) {
            int b = input.nextInt();
            if (b == 1) {
                System.err.print("На одного человека нет смысла делить\nповторите ввод: ");
                return false;
            }
            if (b > UI.minPersonForSplit - 1) {
                inputInt = b;
                return true;
            } else {
                return errMsgIntPrint();
            }


        } else {
            return errMsgIntPrint();
        }
    }

    public static boolean checkForFloatAndMinProductPrice(Scanner input) {
        input = PriceFormatterToString.dotToPointReplacing(input);
        boolean a = input.hasNextFloat();
        if (a) {
            float b = input.nextFloat();
            if (b > (UI.minProductPrice - UI.minProductPrice)) {
                inputFloat = b;
                return true;
            }
        } else {
            return errMsgFloatPrint();//false
        }
        return errMsgFloatPrint();//false
    }

    public static boolean checkForStr(Scanner input) {
        inputStr = input.nextLine();
        return true;
    }

    public static boolean errMsgIntPrint() {

        System.err.print("Введите целое число, больше единицы\nповторите ввод колличества гостей: ");
        return false;
    }

    public static boolean errMsgFloatPrint() {
        System.err.print("Введите дробное число, больше нуля\nи повторите попытку ввода стоимости продукта: ");
        return false;
    }

    public static void getPersonsCount() {
        boolean a;
        do {
            Scanner scanner = new Scanner(in);
            a = UI.readyToGo(scanner, "needInt");

        } while (!a);
    }

    public static boolean getOneProduct() {
        boolean readProductName;
        int i = 0;
        do {
            boolean readProductPrice;
            i++;
            Scanner scanner = new Scanner(in);
            inputStr = scanner.nextLine();
            inputStr = inputStr.trim();
            inputStr = inputStr.toLowerCase(ROOT);
            readProductName = inputStr.equals("завершить");
            readProductPrice = readProductName;
            if (!readProductPrice) {
                getProductPrice();
                Product product = new Product(i, inputStr, inputFloat);
                ProductList.writeToProductList(product);
                System.out.print("продукт и его стоимость успешно добавлены\n" +
                        "если вы хотите закончить добавление товара, то введите \"завершить\" или\nвведите название продукта: ");
            }
        } while (!readProductName);

        return true;
    }

    public static void getProductPrice() {
        boolean readProductPrice;
        System.out.print("Введите стоимость продукта: ");
        do {
            Scanner scanner = new Scanner(in);
            readProductPrice = checkForFloatAndMinProductPrice(scanner);
        } while (!readProductPrice);
    }

    public static void makeProductList() {
        boolean a;
        do {
            a = getOneProduct();
        } while (!a);
    }
}



