package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface LazyStringList extends List {
    void add(ByteString byteString);

    Object getRaw(int i5);

    List<?> getUnderlyingElements();
}
