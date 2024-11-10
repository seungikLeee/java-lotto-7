package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> Lottos;
    private final int purchaseAmount;

    public LottoGenerator() {
        int amount = inputAmount();
        this.purchaseAmount = amount;
        this.Lottos = initializeLottos(calculateLottoCount(amount));
    }

    private List<Lotto> initializeLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(generateLottoNumbers()));
        }
        return lottoList;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private int inputAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputAmount = Console.readLine().trim();
                System.out.println();

                int amount = InputValidator.validateInputAmount(inputAmount);
                InputValidator.validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 오류 메시지 출력
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    private int calculateLottoCount(int amount) {
        return amount/1000;
    }

    public List<Lotto> getLottos() {
        return Lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public String generateOutput() {
        StringBuilder result = new StringBuilder();
        result.append(Lottos.size()).append("개를 구매했습니다.\n");

        for (Lotto lotto : Lottos) {
            result.append(lotto).append("\n");
        }
        return result.toString();
    }

}
