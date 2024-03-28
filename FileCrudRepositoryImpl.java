package practice.user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCrudRepositoryImpl<T> implements CrudRepository<T>{

    private String fileName;

    public FileCrudRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(T element) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(element);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл.");
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                T object = createObjectFromCells(cells); // Создать объект из ячеек
                list.add(object); // Добавить объект в список
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла.");
            e.printStackTrace();
        }
        return list;
    }

    private T createObjectFromCells(String[] cells) {
        long id = Long.parseLong(cells[0]);
        String name = cells[1];
        String email = cells[2];
        return new T (id, name, email);

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
