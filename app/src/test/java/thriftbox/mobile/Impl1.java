package thriftbox.mobile;

import android.os.Parcel;
import android.os.Parcelable;

public class Impl1 extends AbstractParc {

    public String str;

    public Impl1() {
    }

    @Override
    protected String getString() {
        return "Impl1";
    }

    public static final Parcelable.Creator<Impl1> CREATOR
            = new Parcelable.Creator<Impl1>() {
        public Impl1 createFromParcel(Parcel in) {
            return new Impl1(in);
        }

        public Impl1[] newArray(int size) {
            return new Impl1[size];
        }
    };

    private Impl1(Parcel in) {
        str = in.readString();
    }

}
