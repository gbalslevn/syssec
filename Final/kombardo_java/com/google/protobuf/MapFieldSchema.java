package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.Map;

/* loaded from: classes2.dex */
interface MapFieldSchema {
    Map<?, ?> forMapData(Object obj);

    MapEntryLite.Metadata<?, ?> forMapMetadata(Object obj);

    int getSerializedSize(int i5, Object obj, Object obj2);

    Object mergeFrom(Object obj, Object obj2);

    Object toImmutable(Object obj);
}
