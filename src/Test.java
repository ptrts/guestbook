import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//CREATE TABLE IF NOT EXISTS posts (
//		id          INT           NOT NULL AUTO_INCREMENT,
//		postText    TEXT          NOT NULL,
//		postTime    TIMESTAMP     NOT NULL,
//		userName    VARCHAR(25)   NOT NULL,
//		PRIMARY KEY (id)
//		)

public class Test {
	public static void main(String[] args) throws SQLException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {

			// Загрузили класс с драйвером JDBC
			Class.forName("com.mysql.jdbc.Driver");

			// Все. Драйвер загрузили, а остальной код вроде как должен быть универсальным
			// для разных ODBC драйверов, не важно какой там SQL сервер

			// Задача - как создать пользователя MySQL с паролем и логином, и как дать ему права на только что
			// созданную нами базу данных. Это как-то надо просто посмотреть в туториале

			// Открываем соединение. Соединение идет не просто так, а к базе данных. Здесь проверяется пароль, логин и
			// права пользователя на работу с указанной базой данных (может быть)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestbook", "mytest", "mytest");






			///////////////////////////////////////////////////////////////////////////////////
			// Спросить ПДФ у кого-нибудь
			///////////////////////////////////////////////////////////////////////////////////






			// Готовим запрос (компиллируем, видимо)
			preparedStatement = connection.prepareStatement("INSERT INTO 'table' (limad) value (?)");

			// Устанавливаем параметр запроса. Сие значение будет вставлено в таблицу
			preparedStatement.setString(1, "asdf");

			// Запускаем запрос на выполнение
			preparedStatement.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
