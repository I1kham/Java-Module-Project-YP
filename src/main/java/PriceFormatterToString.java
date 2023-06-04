import java.util.Locale;
import java.util.Scanner;

public class PriceFormatterToString { /*класс предназначен для работы с ценой, для формирования строки*/
    public static int abbreviationDigit(float inputDigit, int howManyCharacters) {         /* метод для получения нескольких последних целых знаков*/
        int b = (int) inputDigit;                                   // отбрасываем дробную часть переменной путем перевода в другой тип данных (int целые числа)
        int d = 10;                                                 // пременная для отсечения количества знаков, чем больше нулей тем больше знаков останется
        if (howManyCharacters > 1) {                             // проверяем, сколко знаков нам нужно, если О`дин, то не входим в цикл
            for (int i = 1; i < howManyCharacters; i++) {       // тут в цикле подготавливаем переменную для получения соответствующего колличества знаков, десятку
                d = d * 10;                                     // умножаем на десятку для увеличения количества нуле
            }
        }
        return (b - (b / d) * d);                               //возвращаем обработанный аргумент, в виде целого числа, в количестве необходимых знаков
    }

    public static String priceFormattingToString(float price) {

        short c = (short) abbreviationDigit(price, 2);                             // этим действием оставляем два последних знака для выбора соответствующего падежа


        if (c == 11 || c == 12 || c == 13 || c == 14) {        /*проверяем два последних знака на первое условие */
            return String.format( "%.2f", price) + " рублей";
        } else {
            c = (short) abbreviationDigit(price, 1);                          /*оставляем один последний знак до запятой*/
            switch (c) {
                case 1:
                    return String.format( "%.2f", price) + " рубль ";               /*проверяем на оставшиеся условия, формируя строку, для возврата*/
                case 2, 3, 4:
                    return String.format( "%.2f", price) + " рубля";
                case 0, 5, 6, 7, 8, 9:
                    return String.format( "%.2f", price) + " рублей";


            }
        }
        return "error in <printNumberToString> method";   /*выводим сообщение в случае ошибки*/
    }

    public static Scanner dotToPointReplacing(Scanner input) {  /*метод для замены запятой на точку*/
        String str = input.nextLine();
        str = str.replace(",", ".");
        Scanner scanner = new Scanner(str);
        return scanner;
    }

}
