package baseball.model;

import java.util.ArrayList;
import java.util.List;
import baseball.config.BallConfig;

public class Player {

    private List<Integer> playerNumber = new ArrayList<>();
    private static final int INPUT_SIZE = BallConfig.INPUT_SIZE;

    /**
     * 플레이어가 선택한 숫자를 세팅한다.
     */
    public void setPlayerNumber(String inputNumber) {
        String[] inputNumbers = inputNumber.split("");
        int index = 0;

        while (this.playerNumber.size() != INPUT_SIZE) {
            addPlayerNumber(Integer.parseInt(inputNumbers[index++]));
        }
    }

    /**
     * 플레이어가 선택한 숫자 list에 추가한다.
     * 중복되지 않은 수만 추가한다.
     */
    public void addPlayerNumber(int number) {
        if (!isDuplication(number)) {
            playerNumber.add(number);
        }
    }

    /**
     * 사용자가 선택한 숫자를 초기화한다.
     */
    public void clearPlayerNumber() {
        if (!playerNumber.isEmpty()) {
            playerNumber.clear();
        }
    }

    /**
     * 플레이어가 선택한 숫자 list를 불러온다.
     */
    public List<Integer> getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     * 중복값을 체크한다.
     * 선택한 숫자 list에 포함되어 있는지 확인한다.
     * @return boolean
     */
    public boolean isDuplication(int number) {
        return this.playerNumber.contains(number);
    }
}
