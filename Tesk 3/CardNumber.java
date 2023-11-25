package ATM.Interface.System;

import java.util.Random;

class CardNumber {

    private long uniqueCardNumber = generateRandomCardNumber();
    protected String number = "" + uniqueCardNumber;
    protected String F4digit = number.substring(11);

    private final long generateRandomCardNumber() {
        Random random = new Random();
        long cardNumber = 0;
        long first14Digits = random.nextLong(90000000000000L) + 10000000000000L;

        // Generate a check digit using the Luhn algorithm
        int checkDigit = calculateLuhnCheckDigit(first14Digits);
        cardNumber = (first14Digits * 10) + checkDigit;
        return cardNumber;
    }

    private final int calculateLuhnCheckDigit(long cardNumber) {
        int sum = 0;
        boolean isSecondDigitDoubled = false;

        while (cardNumber > 0) {
            int digit = (int) (cardNumber % 10);
            if (isSecondDigitDoubled) {
                digit *= 2;
                if (digit >= 10) {
                    digit = digit - 9;
                }
            }

            sum += digit;
            isSecondDigitDoubled = !isSecondDigitDoubled;
            cardNumber /= 10;
        }

        int checkDigit = (10 - sum % 10) % 10;
        return checkDigit;
    }
}
