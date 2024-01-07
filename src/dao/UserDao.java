package dao;

import entity.Gender;
import entity.Role;
import entity.User;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.nio.file.Path;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer, User>{
    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance(){
        return INSTANCE;
    }
    private static final String SAVE ="INSERT INTO users(name, birthday, email, password, role, gender,image) VALUES(?,?,?,?,?,?,?)";
    public static final String GET_BY_EMAIL_AND_PASSWORD_SQL ="SELECT * FROM users WHERE email=? AND password=?";
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
    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email,String password) {
        try (var connection = ConnectionManager.get();var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if(resultSet.next()){
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }}
    private static User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("bitrhday", Date.class).toLocalDate())
                .image(resultSet.getObject("image", String.class))
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
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
