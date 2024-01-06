package dao;

import entity.User;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer, User>{
    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance(){
        return INSTANCE;
    }
    private static final String SAVE ="INSERT INTO users(name, birthday, email, password, role, gender,image) VALUES(?,?,?,?,?,?,?)";
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (var connection = ConnectionManager.get();var preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1,entity.getName());
            preparedStatement.setObject(2,entity.getBirthday());
            preparedStatement.setObject(3,entity.getEmail());
            preparedStatement.setObject(4,entity.getPassword());
            preparedStatement.setObject(5,entity.getRole().name());
            preparedStatement.setObject(6,entity.getGender().name());
            preparedStatement.setObject(7,entity.getImage());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id",Integer.class));
            return entity;
        }
    }
}
