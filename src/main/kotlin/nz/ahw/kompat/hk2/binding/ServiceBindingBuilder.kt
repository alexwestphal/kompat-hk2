/*-----------------------------------------------------*\
**                                                     **
**        kompat-hk2: Kompatibility for HK2            **
**        Kotlin Compatibility Project (Kompat)        **
**        Copyright 2017-2018, Alex Westphal           **
**        https://github.com/ahwnz/kompat-hk2          **
**                                                     **
\*-----------------------------------------------------*/
package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.HK2Loader
import org.glassfish.hk2.api.TypeLiteral
import java.lang.reflect.Type
import kotlin.reflect.KClass

typealias HK2ServiceBindingBuilder<T> = org.glassfish.hk2.utilities.binding.ServiceBindingBuilder<T>

interface ServiceBindingBuilder<T: Any>: HK2ServiceBindingBuilder<T> {

    override fun to(contract: Class<in T>): ServiceBindingBuilder<T>

    /**
     * Bind a new contract to a service.
     *
     * @param contract contract type.
     * @return updated binder.
     */
    infix fun toContract(contract: KClass<in T>): ServiceBindingBuilder<T>

    override fun to(contract: TypeLiteral<*>): ServiceBindingBuilder<T>

    infix fun toContract(contract: TypeLiteral<*>): ServiceBindingBuilder<T>

    override fun to(contract: Type): ServiceBindingBuilder<T>

    infix fun toContract(contract: Type): ServiceBindingBuilder<T>

    override infix fun loadedBy(loader: HK2Loader): ServiceBindingBuilder<T>

    override fun withMetadata(key: String, value: String): ServiceBindingBuilder<T>

    override fun withMetadata(key: String, values: List<String>): ServiceBindingBuilder<T>

    override infix fun qualifiedBy(annotation: Annotation): ServiceBindingBuilder<T>

    override fun `in`(scopeAnnotation: Annotation): ScopedBindingBuilder<T>

    /**
     * Scope a binding.
     *
     * @param scopeAnnotation scope annotation.
     * @return updated binding.
     */
    infix fun inScope(scopeAnnotation: Annotation): ScopedBindingBuilder<T>

    override fun `in`(scopeAnnotation: Class<out Annotation>): ScopedBindingBuilder<T>

    /**
     * Scope a binding.
     *
     * @param scopeAnnotation scope annotation.
     * @return updated binding.
     */
    infix fun inScope(scopeAnnotation: KClass<out Annotation>): ScopedBindingBuilder<T>

    override infix fun named(name: String): NamedBindingBuilder<T>

    override fun proxy(proxiable: Boolean): ServiceBindingBuilder<T>

    override fun proxyForSameScope(proxyForSameScope: Boolean): ServiceBindingBuilder<T>

    override fun analyzeWith(analyzer: String?): ServiceBindingBuilder<T>

    override infix fun asType(t: Type): org.glassfish.hk2.utilities.binding.ServiceBindingBuilder<T>
}
