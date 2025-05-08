package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", BuildConfig.FLAVOR, "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    static {
        final KeyMapping commonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m1830isCtrlPressedZmokQxo(((KeyEvent) obj).getNativeKeyEvent()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo479mapZmokQxo(android.view.KeyEvent event) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m1831isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m1830isCtrlPressedZmokQxo(event)) {
                    long m1826getKeyZmokQxo = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m504getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m505getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m506getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m503getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m1830isCtrlPressedZmokQxo(event)) {
                    long m1826getKeyZmokQxo2 = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m504getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m505getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m506getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m503getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m508getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m502getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m498getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m497getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m1831isShiftPressedZmokQxo(event)) {
                    long m1826getKeyZmokQxo3 = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m511getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m510getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m1829isAltPressedZmokQxo(event)) {
                    long m1826getKeyZmokQxo4 = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo4, mappedKeys4.m498getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m1799equalsimpl0(m1826getKeyZmokQxo4, mappedKeys4.m502getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? KeyMapping.this.mo479mapZmokQxo(event) : keyCommand;
            }
        };
    }

    public static final KeyMapping commonKeyMapping(final Function1<? super KeyEvent, Boolean> function1) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo479mapZmokQxo(android.view.KeyEvent event) {
                if (function1.invoke(KeyEvent.m1815boximpl(event)).booleanValue() && KeyEvent_androidKt.m1831isShiftPressedZmokQxo(event)) {
                    if (Key.m1799equalsimpl0(KeyEvent_androidKt.m1826getKeyZmokQxo(event), MappedKeys.INSTANCE.m519getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (function1.invoke(KeyEvent.m1815boximpl(event)).booleanValue()) {
                    long m1826getKeyZmokQxo = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m499getCEK5gGoQ()) ? true : Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m509getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m516getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m517getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m496getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m518getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, mappedKeys.m519getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m1830isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m1831isShiftPressedZmokQxo(event)) {
                    long m1826getKeyZmokQxo2 = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m504getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m505getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m506getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m503getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m513getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m512getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m511getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m510getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m1799equalsimpl0(m1826getKeyZmokQxo2, mappedKeys2.m509getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long m1826getKeyZmokQxo3 = KeyEvent_androidKt.m1826getKeyZmokQxo(event);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m504getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m505getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m506getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m503getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m513getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m512getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m511getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m510getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m507getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m498getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m502getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m514getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m501getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m500getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m1799equalsimpl0(m1826getKeyZmokQxo3, mappedKeys3.m515getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
