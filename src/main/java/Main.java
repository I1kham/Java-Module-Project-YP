import static java.util.Locale.ROOT;
import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(ROOT);
        ProductList.productList = "";           /*инициализируем переменные, содержащиеся в соответствующих классах*/
        ProductList.totalProductPrice = 0f;
        Calculate.priceToPay = 0f;
        UI.howManyPerson = 0;
        UI.minPersonForSplit = 2;
        UI.minProductPrice = 0.01f;


        System.out.print("Приветствую!!! программа предназначена для подсчета стоимости чека \nи разделение чека на двух и более персон\nввиде количество гостей: ");

        UI.getPersonsCount();

        System.out.println("Спасибо, Вы собираетесь разделить счет на " + UI.inputInt + " гостей");
        System.out.print("Введите название продукта: ");
        UI.makeProductList();
        System.out.println("Добавленные товары: ");
        ProductList.showProductList();
        ProductList.showTotalProductListPrice();
        Calculate.showBillPerPerson(ProductList.totalProductPrice, UI.inputInt);
        System.out.println("Спасибо, что используете отечественное ПО\nДосвидания!!!");
    }
}