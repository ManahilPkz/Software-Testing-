package dalTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import dal.DatabaseConnection;

class DatabaseConnectionTest {

    @Test
    void testSingletonInstance() {

        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    void testConstructorIsPrivate() throws Exception {

        Constructor<DatabaseConnection> constructor =
                DatabaseConnection.class.getDeclaredConstructor();

        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }
}
