@file:Suppress("UnstableApiUsage")

package org.anvilpowered.registry

import com.google.common.reflect.TypeToken as GuaTypeToken
import io.leangen.geantyref.TypeToken as GenTypeToken

@Suppress("UNCHECKED_CAST")
fun <T> GenTypeToken<T>.toGuava(): GuaTypeToken<T> = GuaTypeToken.of(type) as GuaTypeToken<T>

@Suppress("UNCHECKED_CAST")
fun <T> GuaTypeToken<T>.toGen(): GenTypeToken<T> = GenTypeToken.get(type) as GenTypeToken<T>
