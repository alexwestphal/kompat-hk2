package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.HK2Loader
import org.glassfish.hk2.api.TypeLiteral
import java.lang.reflect.Type
import kotlin.reflect.KClass

typealias HK2NamedBindingBuilder<T> = org.glassfish.hk2.utilities.binding.NamedBindingBuilder<T>

interface NamedBindingBuilder<T: Any>: HK2NamedBindingBuilder<T> {

    override fun to(contract: Class<in T>): NamedBindingBuilder<T>

    /**
     * Bind a new contract to a service.
     *
     * @param contract contract type.
     * @return updated binder.
     */
    infix fun toContract(contract: KClass<in T>): NamedBindingBuilder<T>

    override fun to(contract: TypeLiteral<*>): NamedBindingBuilder<T>

    infix fun toContract(contract: TypeLiteral<*>): NamedBindingBuilder<T>

    override infix fun loadedBy(loader: HK2Loader): NamedBindingBuilder<T>

    override fun withMetadata(key: String, value: String): NamedBindingBuilder<T>

    override fun withMetadata(key: String, values: List<String>): NamedBindingBuilder<T>

    override infix fun qualifiedBy(annotation: Annotation): NamedBindingBuilder<T>

    override fun `in`(scopeAnnotation: Class<out Annotation>): ScopedNamedBindingBuilder<T>

    /**
     * Scope a binding.
     *
     * @param scopeAnnotation scope annotation.
     * @return updated binding.
     */
    infix fun inScope(scopeAnnotation: KClass<out Annotation>): ScopedNamedBindingBuilder<T>

    override fun proxy(proxiable: Boolean): NamedBindingBuilder<T>

    override infix fun asType(t: Type): NamedBindingBuilder<T>
}