package thriftbox.mobile

import android.os.Bundle
import android.os.Parcel
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val parcel = Parcel.obtain()
        Impl1().let { it.writeToParcel(parcel, it.describeContents() )}
        Bundle().putParcelable("key", Impl1())
    }
}
