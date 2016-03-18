package in.abhishek.fastdock.models;

/**
 * Created by abhishek on 18/03/16 at 10:03 PM.
 */
public class CurrencyWrapper {

    private String mText;
    private boolean mIsChecked;

    public CurrencyWrapper(String text, boolean isChecked) {
        mText = text;
        this.mIsChecked = isChecked;
    }

    public String getText() {
        return mText;
    }

    public boolean isChecked() {
        return mIsChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.mIsChecked = isChecked;
    }
}
