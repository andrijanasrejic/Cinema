package back.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "database_sequence")
public class User {

    @MongoId
    private String _id;

    @Indexed(unique = true)
    private String name;

    @Indexed(unique = true)
    private String email_adress;

    private String password;

    public String getName() {
        return this.name;
    }

    public String getEmail_adress() {
        return this.email_adress;
    }

    public User(String name, String password, String email_adress){
        this.name = name;
        this.password = password;
        this.email_adress = email_adress;

    }

}
