package in.abhishek.fastdock.models;

import java.util.ArrayList;

/**
 * Created by abhishek on 18/03/16 at 8:28 PM.
 */
public enum Currency {

    CUR_1000(1000, 4, " The Mahatma Gandhi Series of banknotes contain the Mahatma Gandhi watermark with a light and shade effect and multi-directional lines in the watermark window.",
            "Rs.1000 notes introduced in October 2000 contain a readable, windowed security thread alternately visible on the obverse with the inscriptions ‘Bharat’ (in Hindi), ‘1000’ and ‘RBI’, but totally embedded on the reverse. The Rs.500 and Rs.100 notes have a security thread with similar visible features and inscription ‘Bharat’ (in Hindi), and ‘RBI’. When held against the light, the security thread on Rs.1000, Rs.500 and Rs.100 can be seen as one continuous line. The Rs.5, Rs.10, Rs.20 and Rs.50 notes contain a readable, fully embedded windowed security thread with the inscription ‘Bharat’ (in Hindi), and ‘RBI’. The security thread appears to the left of the Mahatma's portrait. Notes issued prior to the introduction of the Mahatma Gandhi Series have a plain, non-readable fully embedded security thread.",
            "On the obverse side of Rs.1000, Rs.500, Rs.100, Rs.50 and Rs.20 notes, a vertical band on the right side of the Mahatma Gandhi’s portrait contains a latent image showing the respective denominational value in numeral. The latent image is visible only when the note is held horizontally at eye level.",
            "This feature appears between the vertical band and Mahatma Gandhi portrait. It contains the word ‘RBI’ in Rs.5 and Rs.10. The notes of Rs.20 and above also contain the denominational value of the notes in microletters. This feature can be seen better under a magnifying glass.",
            "The portrait of Mahatma Gandhi, the Reserve Bank seal, guarantee and promise clause, Ashoka Pillar Emblem on the left, RBI Governor's signature are printed in intaglio i.e. in raised prints, which  can be felt by touch, in Rs.20, Rs.50, Rs.100, Rs.500 and Rs.1000 notes.",
            "A special feature in intaglio has been introduced on the left of the watermark window on all notes except Rs.10/- note. This feature is in different shapes for various denominations (Rs. 20-Vertical Rectangle, Rs.50-Square, Rs.100-Triangle, Rs.500-Circle, Rs.1000-Diamond) and helps the visually impaired to identify the denomination."),
    CUR_500(500, 3, "", "")
    ;

    private int mDenom;
    private String[] mConditions;
    private int mPassValue;

    Currency(int denom, int passValue, String... conditions) {
        mDenom = denom;
        mConditions = conditions;
        mPassValue = passValue;
    }

    public static Currency getCurrencyByDenom(int value) {

        for(Currency currency : Currency.values()) {
            if(currency.getDenom() == value) {
                return currency;
            }
        }
        return CUR_1000;

    }

    public int getDenom() {
        return mDenom;
    }

    public String[] getConditions() {
        return mConditions;
    }

    public int getPassValue() {
        return mPassValue;
    }
}
