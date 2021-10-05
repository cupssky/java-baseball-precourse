package baseball.model;

import baseball.config.BallConfig;
import java.util.ArrayList;
import java.util.List;

import baseball.config.GameMessage;
import nextstep.utils.Randoms;

public class Computer {

    private List<Integer> randomNumbers = new ArrayList<>();
    private final int MIN_NUMBER = BallConfig.MIN_NUMBER;
    private final int MAX_NUMBER = BallConfig.MAX_NUMBER;
    private final int INPUT_SIZE = BallConfig.INPUT_SIZE;

    /**
     * 랜덤값 list 가져오기
     * @return randomNumbers
     */
    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    /**
     * 랜덤값 생성
     * MIN_NUMBER 부터 MAX_NUMBER 까지 INPUT_SIZE 만큼 생성
     */
    public void setRandomNumbers() {
        int randomNumber;
        while (randomNumbers.size() != INPUT_SIZE) {
            randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addRandomNumbers(randomNumber);
        }
    }

    /**
     * 랜덤값 추가
     * 중복된 수가 없을 경우 추가된다.
     */
    public void addRandomNumbers(int randomNumber) {
        if (!isDuplication(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

    /**
     * 랜덤값 초기화
     * 랜덤값 list가 비어있지 않을 경우 모두 clear 한다.
     */
    public void clearRandomNumber() {
        if (!randomNumbers.isEmpty()) {
            randomNumbers.clear();
        }
    }

    /**
     * 중복값 체크
     * 받아온 랜덤값이 list에 포함되어 있는지 체크한다.
     * @return boolean
     */
    public boolean isDuplication(int randomNumber) {
        return randomNumbers.contains(randomNumber);
    }

    /**
     * 힌트를 생성한다.
     * @return String
     */
    public String makeHint(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        String hint = "";
        int strikeScore = strikeScore(computerNumberList, playerNumberList);
        int ballScore = ballScore(computerNumberList, playerNumberList);

        if (strikeScore > 0) {
            hint += strikeScore + GameMessage.STRIKE;
        }

        if (ballScore > 0) {
            hint += ballScore + GameMessage.BALL;
        }

        if (strikeScore == 0 && ballScore == 0) {
            hint += GameMessage.NOTHING;
        }

        return hint.trim();
    }

    /**
     * Strike 점수를 구한다. <br/>
     * 같은 위치에 같은 수가 있으면 스트라이크
     * @return int
     */
    public int strikeScore(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int strikeScore = 0;

        for (int i=0; i<INPUT_SIZE; i++) {
            strikeScore += isStrike(computerNumberList.get(i), playerNumberList.get(i));
        }
        return strikeScore;
    }

    /**
     * Ball 점수를 구한다. <br/>
     * 다른 자리에 포함하는 숫자가 있으면 볼
     * @return int
     */
    public int ballScore(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int ballScore = 0;

        for (int i=0; i<INPUT_SIZE; i++) {
            ballScore += isBall(i, computerNumberList, playerNumberList);
        }
        return ballScore;
    }

    /**
     * Strike 여부를 확인한다. <br/>
     * 같은 위치에 같은 숫자가 있을 경우 1을 반환한다.
     * @return int
     */
    private int isStrike(int computerNumber, int playerNumber) {
        int score = 0;

        if (computerNumber == playerNumber) {
            score = 1;
        }
        return score;
    }

    /**
     * Ball 여부를 확인한다. <br/>
     * 같은 위치가 아니면서, 선택한 숫자가 포함되어 있을 경우 1을 반환한다.
     * @return int
     */
    private int isBall(int index, List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int score = 0;
        int computerNumber = computerNumberList.get(index);
        int playerNumber = playerNumberList.get(index);

        if (computerNumber != playerNumber && computerNumberList.contains(playerNumber)) {
            score = 1;
        }
        return score;
    }
}
