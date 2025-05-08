package com.ramcosta.composedestinations.navargs.serializable;

import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer;
import com.ramcosta.composedestinations.navargs.utils.NavArgEncodingUtilsKt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\f\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0002J\u001b\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/serializable/DefaultSerializableNavTypeSerializer;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "Ljava/io/Serializable;", "<init>", "()V", "toRouteString", BuildConfig.FLAVOR, "value", "fromRouteString", "routeStr", "toBase64", "base64ToSerializable", "T", "base64", "(Ljava/lang/String;)Ljava/lang/Object;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultSerializableNavTypeSerializer implements DestinationsNavTypeSerializer<Serializable> {
    private final <T> T base64ToSerializable(String base64) {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(NavArgEncodingUtilsKt.base64ToByteArray(base64)));
        try {
            T t5 = (T) objectInputStream.readObject();
            CloseableKt.closeFinally(objectInputStream, null);
            return t5;
        } finally {
        }
    }

    private final String toBase64(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            String base64Str = NavArgEncodingUtilsKt.toBase64Str(byteArray);
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            return base64Str;
        } finally {
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
    public Serializable fromRouteString(String routeStr) {
        Intrinsics.checkNotNullParameter(routeStr, "routeStr");
        return (Serializable) base64ToSerializable(routeStr);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
    public String toRouteString(Serializable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return toBase64(value);
    }
}
