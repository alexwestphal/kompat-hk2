package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.Factory
import org.glassfish.hk2.api.TypeLiteral
import java.lang.reflect.Type
import kotlin.reflect.KClass

abstract class AbstractBinder: org.glassfish.hk2.utilities.binding.AbstractBinder() {

    override fun <T: Any> bind(serviceType: Class<T>): ServiceBindingBuilder<T> =
            BindingBuilder(super.bind(serviceType))

    /**
     * Start building a new class-based service binding.
     *
     * Does NOT bind the service type itself as a contract type.
     *
     * @param <T>         service type.
     * @param serviceType service class.
     * @return initialized binding builder.
     */
    fun <T: Any> bind(serviceType: KClass<T>): ServiceBindingBuilder<T> =
            bind(serviceType.java)

    override fun <T: Any> bind(service: T): ScopedBindingBuilder<T> =
            BindingBuilder(super.bind(service))

    override fun <T: Any> bindAsContract(serviceType: Class<T>): ServiceBindingBuilder<T> =
            BindingBuilder(super.bindAsContract(serviceType))

    /**
     * Start building a new class-based service binding.
     *
     * Binds the service type itself as a contract type.
     *
     * @param <T>         service type.
     * @param serviceType service class.
     * @return initialized binding builder.
     */
    fun <T: Any> bindAsContract(serviceType: KClass<T>): ServiceBindingBuilder<T> =
            bindAsContract(serviceType.java)

    override fun <T: Any> bindAsContract(serviceType: TypeLiteral<T>): ServiceBindingBuilder<T> =
            BindingBuilder(super.bindAsContract(serviceType))

    override fun <T: Any> bindAsContract(serviceType: Type): ServiceBindingBuilder<T> =
            BindingBuilder(super.bindAsContract(serviceType))

    override fun <T: Any> bindFactory(factoryType: Class<out Factory<T>>): ServiceBindingBuilder<T> =
            BindingBuilder(super.bindFactory(factoryType))

    /**
     * Start building a new factory class-based service binding.
     *
     * The factory itself is bound in a {@link org.glassfish.hk2.api.PerLookup per-lookup} scope.
     *
     * @param <T>         service type.
     * @param factoryType service factory class.
     * @return initialized binding builder.
     */
    fun <T: Any> bindFactory(factoryType: KClass<out Factory<T>>): ServiceBindingBuilder<T> =
            bindFactory(factoryType.java)

    override fun <T: Any> bindFactory(factoryType: Class<out Factory<T>>, factoryScope: Class<out Annotation>): ServiceBindingBuilder<T> =
            BindingBuilder(super.bindFactory(factoryType, factoryScope))

    /**
     * Start building a new factory class-based service binding.
     *
     * @param <T>          service type.
     * @param factoryType  service factory class.
     * @param factoryScope factory scope.
     * @return initialized binding builder.
     */
    fun <T: Any> bindFactory(factoryType: KClass<out Factory<T>>, factoryScope: KClass<out Annotation>): ServiceBindingBuilder<T> =
            bindFactory(factoryType.java, factoryScope.java)

    override fun <T: Any> bindFactory(factory: Factory<T>): ServiceBindingBuilder<T> =
            BindingBuilder(super.bindFactory(factory))

}