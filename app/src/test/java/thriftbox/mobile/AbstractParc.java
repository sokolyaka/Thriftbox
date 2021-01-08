package thriftbox.mobile;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbstractParc implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getString());
    }

    protected abstract String getString();
}
