package ur;

public class TestObserverUr {
    
    public static void main(String[] args) {
        Ur ur = new Ur();
        new ObserverAnalogtUr(ur);
        new ObserverDigitaltUr(ur);
        for (int i = 0; i < 4; i++) {
            ur.tiktak();
        }
    }
    
}
