package JunitMethods;

public class C02_FirstLastTwoSame {

    public boolean check_First_Last_Two(String str) {

        if (str.length() <= 1) {
            return false;
        }
        if (str.length() == 2) {
            return true;
        }

        String ilkIkiKarakter = str.substring(0, 2);
        String sonIkiKarakter = str.substring(str.length() - 2);

        return ilkIkiKarakter.equals(sonIkiKarakter);

    }


}
