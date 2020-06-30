package com.cengiztoru.samplenavigationexample.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

@Parcelize
data class User(val email: String, val name: String, val surname: String) : Parcelable