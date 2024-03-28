package practice.user;

import java.util.ArrayList;
import java.util.List;

public class ListCrudRepositoryImpl<T> implements CrudRepository<T> {

    private List<T> list = new ArrayList<>();

    @Override
    public void save(T element) {
        list.add(element);
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    @Override
    public T findByID(Long id) {
        return null;
    }

    @Override
    public void update(T element) {

    }

    @Override
    public void deleteByID(Long id) {

    }
}
