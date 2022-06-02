package JunitMethods;

public class C01StringModifier {

    public String deleteStr(String str) {
        if (str.length() < 3) {
            return str.replaceAll("C", "");
        }

        String ilkIkiKarakter = str.substring(0, 2);
        String sonrakiKarakterler = str.substring(2);

        return ilkIkiKarakter.replaceAll("C", "") + sonrakiKarakterler;
    }


}
