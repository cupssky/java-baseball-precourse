package baseball.model;

import baseball.config.BallConfig;
import java.util.ArrayList;
import java.util.List;
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
        while (this.randomNumbers.size() != this.INPUT_SIZE) {
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
            this.randomNumbers.add(randomNumber);
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
        return this.randomNumbers.contains(randomNumber);
    }
}
