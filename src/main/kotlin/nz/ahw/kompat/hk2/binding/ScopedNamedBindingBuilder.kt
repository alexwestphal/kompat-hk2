package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.HK2Loader
import org.glassfish.hk2.api.TypeLiteral
import kotlin.reflect.KClass

typealias HK2ScopedNamedBindingBuilder<T> = org.glassfish.hk2.utilities.binding.ScopedNamedBindingBuilder<T>


interface ScopedNamedBindingBuilder<T: Any>: HK2ScopedNamedBindingBuilder<T> {

    override fun to(contract: Class<in T>): ScopedNamedBindingBuilder<T>

    /**
     * Bind a new contract to a service.
     *
     * @param contract contract type.
     * @return updated binder.
     */
    infix fun toContract(contract: KClass<in T>): ScopedNamedBindingBuilder<T>

    override fun to(contract: TypeLiteral<*>): ScopedNamedBindingBuilder<T>

    infix fun toContract(contract: TypeLiteral<*>): ScopedNamedBindingBuilder<T>

    override infix fun loadedBy(loader: HK2Loader): ScopedNamedBindingBuilder<T>

    override fun withMetadata(key: String, value: String): ScopedNamedBindingBuilder<T>

    override fun withMetadata(key: String, values: List<String>): ScopedNamedBindingBuilder<T>

    override infix fun qualifiedBy(annotation: Annotation): ScopedNamedBindingBuilder<T>

    override fun proxy(proxiable: Boolean): ScopedNamedBindingBuilder<T>

    override fun analyzeWith(analyzer: String?): ScopedNamedBindingBuilder<T>
}
