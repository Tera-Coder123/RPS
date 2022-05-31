package Variables;

public class CheckParameter {
    public boolean checkString(String input) {
        if(input.equals(" ") || input == null) return false;
        return true;
    }
}
