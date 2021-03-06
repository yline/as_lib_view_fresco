package com.yline.fresco.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;

/**
 * Interface for decoder (and region decoder) factories.
 * @param <T> the class of decoder that will be produced.
 */
public interface DecoderFactory<T> {
  /**
   * Produce a new instance of a decoder with type {@link T}.
   * @return a new instance of your decoder.
   * @throws IllegalAccessException if the factory class cannot be instantiated.
   * @throws InstantiationException if the factory class cannot be instantiated.
   * @throws NoSuchMethodException if the factory class cannot be instantiated.
   * @throws InvocationTargetException if the factory class cannot be instantiated.
   */
  T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
