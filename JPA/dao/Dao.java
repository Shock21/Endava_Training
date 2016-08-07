package com.endava.jpa.dao;

import com.endava.jpa.model.Department;

import java.util.List;

/**
 * Created by tvasile on 7/26/2016.
 */
public interface Dao<T> {

    public void save(T toBeSaved);

    public void update(T toBeUpdated);

    public void remove(T toBeRemoved);

}
