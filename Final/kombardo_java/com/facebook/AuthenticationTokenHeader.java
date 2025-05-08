package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0016R\u0017\u0010#\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0016R\u0017\u0010%\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0016¨\u0006("}, d2 = {"Lcom/facebook/AuthenticationTokenHeader;", "Landroid/os/Parcelable;", BuildConfig.FLAVOR, "encodedHeaderString", "<init>", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "headerString", BuildConfig.FLAVOR, "isValidHeader", "(Ljava/lang/String;)Z", "dest", BuildConfig.FLAVOR, "flags", BuildConfig.FLAVOR, "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "()Lorg/json/JSONObject;", "toJSONObject", "alg", "Ljava/lang/String;", "getAlg", "typ", "getTyp", "kid", "getKid", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AuthenticationTokenHeader implements Parcelable {
    private final String alg;
    private final String kid;
    private final String typ;
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new Parcelable.Creator<AuthenticationTokenHeader>() { // from class: com.facebook.AuthenticationTokenHeader$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenHeader createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AuthenticationTokenHeader(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenHeader[] newArray(int size) {
            return new AuthenticationTokenHeader[size];
        }
    };

    public AuthenticationTokenHeader(String encodedHeaderString) {
        Intrinsics.checkNotNullParameter(encodedHeaderString, "encodedHeaderString");
        if (isValidHeader(encodedHeaderString)) {
            byte[] decodedBytes = Base64.decode(encodedHeaderString, 0);
            Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.UTF_8));
            String string = jSONObject.getString("alg");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"alg\")");
            this.alg = string;
            String string2 = jSONObject.getString("typ");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"typ\")");
            this.typ = string2;
            String string3 = jSONObject.getString("kid");
            Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(\"kid\")");
            this.kid = string3;
            return;
        }
        throw new IllegalArgumentException("Invalid Header");
    }

    private final boolean isValidHeader(String headerString) {
        Validate.notEmpty(headerString, "encodedHeaderString");
        byte[] decodedBytes = Base64.decode(headerString, 0);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.UTF_8));
            String alg = jSONObject.optString("alg");
            Intrinsics.checkNotNullExpressionValue(alg, "alg");
            boolean z5 = alg.length() > 0 && Intrinsics.areEqual(alg, "RS256");
            String optString = jSONObject.optString("kid");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"kid\")");
            boolean z6 = optString.length() > 0;
            String optString2 = jSONObject.optString("typ");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(\"typ\")");
            return z5 && z6 && (optString2.length() > 0);
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) other;
        return Intrinsics.areEqual(this.alg, authenticationTokenHeader.alg) && Intrinsics.areEqual(this.typ, authenticationTokenHeader.typ) && Intrinsics.areEqual(this.kid, authenticationTokenHeader.kid);
    }

    public final String getKid() {
        return this.kid;
    }

    public int hashCode() {
        return ((((527 + this.alg.hashCode()) * 31) + this.typ.hashCode()) * 31) + this.kid.hashCode();
    }

    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put("typ", this.typ);
        jSONObject.put("kid", this.kid);
        return jSONObject;
    }

    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "headerJsonObject.toString()");
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.alg);
        dest.writeString(this.typ);
        dest.writeString(this.kid);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.alg = Validate.notNullOrEmpty(parcel.readString(), "alg");
        this.typ = Validate.notNullOrEmpty(parcel.readString(), "typ");
        this.kid = Validate.notNullOrEmpty(parcel.readString(), "kid");
    }
}
