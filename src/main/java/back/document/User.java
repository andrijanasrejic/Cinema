package back.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "database_sequence")
public class User {

    @MongoId
    private String _id;

    @Indexed(unique = true)
    private String userName;

    @Indexed(unique = true)
    private String email_adress;

    private String password;

    private boolean admin = false;

    List<Projection> reservedProjections;

    public User() {
        this.reservedProjections = new ArrayList<Projection>();
    }

    public List<Projection> getReservedProjections() {
        return reservedProjections;
    }

    public void addProjection(Projection newProjection){;
        this.reservedProjections.add(newProjection);
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

    public boolean isAdmin() {
        return admin;
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

    public void setAdmin() {
        this.admin = !this.admin;
    }

    public User(String userName, String password, String email_adress){
        this.userName = userName;
        this.password = password;
        this.email_adress = email_adress;
        this.reservedProjections = new ArrayList<Projection>();

    }

    @Override
    public String toString() {
        return this.userName + " " + this.email_adress;
    }
}
