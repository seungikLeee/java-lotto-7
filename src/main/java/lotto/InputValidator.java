package lotto;

public class InputValidator {
    public static int validateInputAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 이루어져야 합니다.");
        }
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
