package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\t\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bH\u0082@¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", BuildConfig.FLAVOR, "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "Lkotlinx/serialization/json/JsonElement;", "readObject", "()Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", BuildConfig.FLAVOR, "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readArray", BuildConfig.FLAVOR, "isString", "Lkotlinx/serialization/json/JsonPrimitive;", "readValue", "(Z)Lkotlinx/serialization/json/JsonPrimitive;", "readDeepRecursive", "read", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "isLenient", "Z", "trailingCommaAllowed", BuildConfig.FLAVOR, "stackDepth", "I", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonTreeReader {
    private final boolean isLenient;
    private final JsonReader lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    public JsonTreeReader(JsonConfiguration configuration, JsonReader lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.getIsLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte consumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            arrayList.add(read());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                JsonReader jsonReader = this.lexer;
                boolean z5 = consumeNextToken == 9;
                int i5 = jsonReader.currentPosition;
                if (!z5) {
                    JsonReader.fail$default(jsonReader, "Expected end of the array or comma", i5, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (consumeNextToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0096 -> B:10:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readObject(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readObject$2 jsonTreeReader$readObject$2;
        int i5;
        JsonTreeReader jsonTreeReader;
        LinkedHashMap linkedHashMap;
        JsonTreeReader$readObject$2 jsonTreeReader$readObject$22;
        byte b5;
        DeepRecursiveScope deepRecursiveScope2;
        if (continuation instanceof JsonTreeReader$readObject$2) {
            jsonTreeReader$readObject$2 = (JsonTreeReader$readObject$2) continuation;
            int i6 = jsonTreeReader$readObject$2.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                jsonTreeReader$readObject$2.label = i6 - Integer.MIN_VALUE;
                Object obj = jsonTreeReader$readObject$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = jsonTreeReader$readObject$2.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
                    if (this.lexer.peekNextToken() != 4) {
                        jsonTreeReader = this;
                        linkedHashMap = new LinkedHashMap();
                        jsonTreeReader$readObject$22 = jsonTreeReader$readObject$2;
                        b5 = consumeNextToken;
                        deepRecursiveScope2 = deepRecursiveScope;
                        if (jsonTreeReader.lexer.canConsumeValue()) {
                        }
                        if (b5 == 6) {
                        }
                        return new JsonObject(linkedHashMap);
                    }
                    JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str = (String) jsonTreeReader$readObject$2.L$3;
                linkedHashMap = (LinkedHashMap) jsonTreeReader$readObject$2.L$2;
                jsonTreeReader = (JsonTreeReader) jsonTreeReader$readObject$2.L$1;
                DeepRecursiveScope deepRecursiveScope3 = (DeepRecursiveScope) jsonTreeReader$readObject$2.L$0;
                ResultKt.throwOnFailure(obj);
                linkedHashMap.put(str, (JsonElement) obj);
                byte consumeNextToken2 = jsonTreeReader.lexer.consumeNextToken();
                if (consumeNextToken2 == 4) {
                    if (consumeNextToken2 != 7) {
                        JsonReader.fail$default(jsonTreeReader.lexer, "Expected end of the object or comma", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    b5 = consumeNextToken2;
                    if (b5 == 6) {
                        jsonTreeReader.lexer.consumeNextToken((byte) 7);
                    } else if (b5 == 4) {
                        if (jsonTreeReader.trailingCommaAllowed) {
                            jsonTreeReader.lexer.consumeNextToken((byte) 7);
                        } else {
                            JsonExceptionsKt.invalidTrailingComma$default(jsonTreeReader.lexer, null, 1, null);
                            throw new KotlinNothingValueException();
                        }
                    }
                    return new JsonObject(linkedHashMap);
                }
                jsonTreeReader$readObject$22 = jsonTreeReader$readObject$2;
                b5 = consumeNextToken2;
                deepRecursiveScope2 = deepRecursiveScope3;
                if (jsonTreeReader.lexer.canConsumeValue()) {
                    String consumeStringLenient = jsonTreeReader.isLenient ? jsonTreeReader.lexer.consumeStringLenient() : jsonTreeReader.lexer.consumeString();
                    jsonTreeReader.lexer.consumeNextToken((byte) 5);
                    Unit unit = Unit.INSTANCE;
                    jsonTreeReader$readObject$22.L$0 = deepRecursiveScope2;
                    jsonTreeReader$readObject$22.L$1 = jsonTreeReader;
                    jsonTreeReader$readObject$22.L$2 = linkedHashMap;
                    jsonTreeReader$readObject$22.L$3 = consumeStringLenient;
                    jsonTreeReader$readObject$22.label = 1;
                    Object callRecursive = deepRecursiveScope2.callRecursive(unit, jsonTreeReader$readObject$22);
                    if (callRecursive == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deepRecursiveScope3 = deepRecursiveScope2;
                    obj = callRecursive;
                    JsonTreeReader$readObject$2 jsonTreeReader$readObject$23 = jsonTreeReader$readObject$22;
                    str = consumeStringLenient;
                    jsonTreeReader$readObject$2 = jsonTreeReader$readObject$23;
                    linkedHashMap.put(str, (JsonElement) obj);
                    byte consumeNextToken22 = jsonTreeReader.lexer.consumeNextToken();
                    if (consumeNextToken22 == 4) {
                    }
                }
                if (b5 == 6) {
                }
                return new JsonObject(linkedHashMap);
            }
        }
        jsonTreeReader$readObject$2 = new JsonTreeReader$readObject$2(this, continuation);
        Object obj2 = jsonTreeReader$readObject$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = jsonTreeReader$readObject$2.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean isString) {
        String consumeStringLenient = (this.isLenient || !isString) ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
        return (isString || !Intrinsics.areEqual(consumeStringLenient, "null")) ? new JsonLiteral(consumeStringLenient, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        byte peekNextToken = this.lexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken == 6) {
            int i5 = this.stackDepth + 1;
            this.stackDepth = i5;
            this.stackDepth--;
            return i5 == 200 ? readDeepRecursive() : readObject();
        }
        if (peekNextToken == 8) {
            return readArray();
        }
        JsonReader.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(peekNextToken), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final JsonElement readObject() {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.lexer.canConsumeValue()) {
                    break;
                }
                String consumeStringLenient = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
                this.lexer.consumeNextToken((byte) 5);
                linkedHashMap.put(consumeStringLenient, read());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    if (consumeNextToken != 7) {
                        JsonReader.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (consumeNextToken == 6) {
                this.lexer.consumeNextToken((byte) 7);
            } else if (consumeNextToken == 4) {
                if (this.trailingCommaAllowed) {
                    this.lexer.consumeNextToken((byte) 7);
                } else {
                    JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }
            return new JsonObject(linkedHashMap);
        }
        JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }
}
