package thriftbox.mobile;

import android.os.Parcel;

public class Impl2 extends AbstractParc {

    public String str;

    public Impl2() {
    }

    @Override
    protected String getString() {
        return "Impl2";
    }

    public static final Creator<Impl2> CREATOR
            = new Creator<Impl2>() {
        public Impl2 createFromParcel(Parcel in) {
            return new Impl2(in);
        }

        public Impl2[] newArray(int size) {
            return new Impl2[size];
        }
    };

    private Impl2(Parcel in) {
        str = in.readString();
    }

}
