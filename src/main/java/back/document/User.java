package back.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "database_sequence")
public class User {

    @MongoId
    private String _id;

    @Indexed(unique = true)
    private String userName;

    @Indexed(unique = true)
    private String email_adress;

    private String password;

    public User() {

    }

    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return this.userName;
    }

    public String getEmail_adress() {
        return this.email_adress;
    }

    public void setEmail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password, String email_adress){
        this.userName = userName;
        this.password = password;
        this.email_adress = email_adress;

    }

    @Override
    public String toString() {
        return this.userName + " " + this.email_adress;
    }
}
