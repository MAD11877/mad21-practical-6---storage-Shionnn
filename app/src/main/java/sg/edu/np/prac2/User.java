package sg.edu.np.prac2;

import java.io.Serializable;

public class User implements Serializable {
    private int image;
    private String name;
    private String description;
    private int id;
    private boolean followed;



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public User(){


    }
    public User(int image,String name, String description, int id, boolean followed) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;

    }

}
