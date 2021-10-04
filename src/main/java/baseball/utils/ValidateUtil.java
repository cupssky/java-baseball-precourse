package baseball.utils;

import baseball.constants.Const;
import baseball.enums.ResultCode;

import java.util.Set;

public class ValidateUtil {

    public static boolean isValidInput(String value) {
        if (!isValidInputNumber(value)) {
            MessageUtil.errorMessage(ResultCode.NOT_NUMBER);
            return false;
        }
        if (!isValidInputLength(value) || !isValidInputDuplicateNumber(value)) {
            MessageUtil.errorMessage(ResultCode.NOT_VALID_NUMBER);
            return false;
        }
        return true;
    }

    private static boolean isValidInputLength(String value) {
        if (value.length() != Const.MAX_NUMBER_SIZE) {
            return false;
        }
        return true;
    }

    private static boolean isValidInputNumber(String value) {
        if (!value.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    private static boolean isValidInputDuplicateNumber(String value) {
        Set<Integer> set = ConvertUtil.convertStringToSet(value);
        if (set.size() < Const.MAX_NUMBER_SIZE) {
            return false;
        }
        return true;
    }
}
