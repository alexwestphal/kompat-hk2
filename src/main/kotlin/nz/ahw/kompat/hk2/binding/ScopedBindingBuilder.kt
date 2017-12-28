package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.HK2Loader
import org.glassfish.hk2.api.TypeLiteral
import kotlin.reflect.KClass

typealias HK2ScopedBindingBuilder<T> = org.glassfish.hk2.utilities.binding.ScopedBindingBuilder<T>


interface ScopedBindingBuilder<T: Any>: HK2ScopedBindingBuilder<T> {

    override fun to(contract: Class<in T>): ScopedBindingBuilder<T>

    /**
     * Bind a new contract to a service.
     *
     * @param contract contract type.
     * @return updated binder.
     */
    infix fun toContract(contract: KClass<in T>): ScopedBindingBuilder<T>

    override fun to(contract: TypeLiteral<*>): ScopedBindingBuilder<T>

    infix fun toContract(contract: TypeLiteral<*>): ScopedBindingBuilder<T>

    override infix fun loadedBy(loader: HK2Loader): ScopedBindingBuilder<T>

    override fun withMetadata(key: String, value: String): ScopedBindingBuilder<T>

    override fun withMetadata(key: String, values: List<String>): ScopedBindingBuilder<T>

    override infix fun qualifiedBy(annotation: Annotation): ScopedBindingBuilder<T>

    override infix fun named(name: String): ScopedNamedBindingBuilder<T>

    override fun proxy(proxiable: Boolean): ScopedBindingBuilder<T>

    override fun proxyForSameScope(proxyForSameScope: Boolean): ScopedBindingBuilder<T>

    override fun analyzeWith(analyzer: String?): ScopedBindingBuilder<T>
}