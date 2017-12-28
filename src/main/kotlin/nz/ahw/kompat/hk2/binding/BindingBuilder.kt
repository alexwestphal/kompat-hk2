package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.HK2Loader
import org.glassfish.hk2.api.TypeLiteral
import java.lang.reflect.Type
import kotlin.reflect.KClass

typealias HK2BindingBuilder<T> = org.glassfish.hk2.utilities.binding.BindingBuilder<T>

class BindingBuilder<T: Any>(private val parent: HK2BindingBuilder<T>): ServiceBindingBuilder<T>,
        ScopedBindingBuilder<T>, NamedBindingBuilder<T>, ScopedNamedBindingBuilder<T> {

    override fun to(contract: Class<in T>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).to(contract))

    override fun toContract(contract: KClass<in T>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).to(contract.java))

    override fun to(contract: TypeLiteral<*>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).to(contract))

    override fun toContract(contract: TypeLiteral<*>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).to(contract))

    override fun to(contract: Type): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).to(contract))

    override fun toContract(contract: Type): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).to(contract))

    override fun loadedBy(loader: HK2Loader): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).loadedBy(loader))

    override fun withMetadata(key: String, value: String): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).withMetadata(key, value))

    override fun withMetadata(key: String, values: List<String>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).withMetadata(key, values))

    override fun qualifiedBy(annotation: Annotation): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).qualifiedBy(annotation))

    override fun `in`(scopeAnnotation: Annotation): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).`in`(scopeAnnotation))

    override fun inScope(scopeAnnotation: Annotation): ScopedBindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).`in`(scopeAnnotation))

    override fun `in`(scopeAnnotation: Class<out Annotation>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).`in`(scopeAnnotation))

    override fun inScope(scopeAnnotation: KClass<out Annotation>): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).`in`(scopeAnnotation.java))

    override fun named(name: String): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).named(name))

    override fun ranked(rank: Int) {
        (parent as HK2ServiceBindingBuilder).ranked(rank)
    }

    override fun proxy(proxiable: Boolean): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).proxy(proxiable))

    override fun proxyForSameScope(proxyForSameScope: Boolean): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).proxyForSameScope(proxyForSameScope))

    override fun analyzeWith(analyzer: String?): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).analyzeWith(analyzer))

    override fun asType(t: Type): BindingBuilder<T> =
            BindingBuilder((parent as HK2ServiceBindingBuilder).asType(t))
}