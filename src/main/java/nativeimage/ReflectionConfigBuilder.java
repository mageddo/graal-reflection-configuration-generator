package nativeimage;

import lombok.experimental.UtilityClass;
import nativeimage.core.ReflectionConfig;

import javax.lang.model.element.Element;
import java.util.LinkedHashSet;
import java.util.Set;

@UtilityClass
public class ReflectionConfigBuilder {

	public static Set<ReflectionConfig> of(Element element){

		final RuntimeReflection runtimeReflectionAnn = element.getAnnotation(RuntimeReflection.class);
		final Set<ReflectionConfig> reflectionConfigs = new LinkedHashSet<>();

		for (Class clazz : ClassBuilder.of(element, runtimeReflectionAnn)) {
			reflectionConfigs.add(
				toBuilder(runtimeReflectionAnn)
				.clazz(clazz)
				.build()
			);
		}
		return reflectionConfigs;
	}

	private static ReflectionConfig.ReflectionConfigBuilder toBuilder(RuntimeReflection runtimeReflectionAnn) {
		return ReflectionConfig
			.builder()
			.allPublicConstructors(runtimeReflectionAnn.allPublicConstructors())
			.allDeclaredConstructors(runtimeReflectionAnn.allDeclaredConstructors())

			.allPublicFields(runtimeReflectionAnn.allPublicFields())
			.allDeclaredFields(runtimeReflectionAnn.allDeclaredFields())

			.allPublicMethods(runtimeReflectionAnn.allPublicMethods())
			.allDeclaredMethods(runtimeReflectionAnn.allDeclaredMethods())
		;
	}
}