/*-----------------------------------------------------*\
**                                                     **
**        kompat-hk2: Kompatibility for HK2            **
**        Kotlin Compatibility Project (Kompat)        **
**        Copyright 2017-2018, Alex Westphal           **
**        https://github.com/ahwnz/kompat-hk2          **
**                                                     **
\*-----------------------------------------------------*/
package nz.ahw.kompat.hk2.locator

import kotlin.reflect.KClass

class NoAvailableServiceException(kClass: KClass<*>): Exception("So available service for ${kClass.simpleName}")