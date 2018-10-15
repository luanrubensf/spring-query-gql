package com.luanrubensf.springquerygql.core;

import java.io.Serializable;

public interface IEntity<T> extends Serializable {
    T getId();
}
