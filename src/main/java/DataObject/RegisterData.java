package DataObject;
import com.github.javafaker.Faker;

public interface RegisterData {
    Faker fk = new Faker();

    String
            firstName = "example",
            lastName = "example",
            phoneNumber = "59595959",
            password = "Test1234",
            birthDay = fk.number().digits(1),
            birthMonth = "Dec",
            birthYear = "19" + fk.number().digits(2);
}
