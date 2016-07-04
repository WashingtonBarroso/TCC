package br.com.ifg.ifeventos.utils.gson.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import br.com.caelum.vraptor.serialization.SkipSerialization;

public class SkipSerializationExclusionStrategy implements ExclusionStrategy {
	public boolean shouldSkipClass(Class<?> clazz) {
		return clazz.getAnnotation(SkipSerialization.class) != null;
	}

	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(SkipSerialization.class) != null;
	}
}