package characters;

import java.util.ArrayList;

public class Character{
    private String firstName;
    private String lastname;
    private int age;
    private char gender;
    private Religion religion;
    private Occupation occupation;
    private Nationality nationality;
    private Family family;
    private int children;
    private ArrayList<Languages> languages;
    private ArrayList<String> qualifications;
    private ArrayList<String> characteristics;

    Character(String firstName, String lastname, int age, char gender, Religion religion, Occupation occupation, Nationality nationality, Family family, int children){
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.religion = religion;
        this.occupation = occupation;
        this.nationality = nationality;
        this.family = family;
        this.children = children;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String toString() {
        String info;
        info = "----------------------------\n" +
                "👤 Person Information: \n" +
                "----------------------------\n" +
                "👤 Name: " + firstName + " " + lastname + "\n" +
                "🎂 Age: " + age + " years old\n" +
                "⚥ Gender: " + gender + "\n" +
                "🙏 Religion: " + religion + "\n" +
                "💼 Occupation: " + occupation + "\n" +
                "🌍 Nationality: " + nationality + "\n" +
                "👨‍👩‍👧‍👦 Family: " + family + "\n" +
                "👶 Children: " + children + " child(ren)\n" +
                "🗣 Languages: " + languages.get(0);
        for(int i = 1; i < languages.size(); i++){
            info += ", " + languages.get(i);
        }
        info += "\n" + "🎓 Qualifications: ";
        for(int i = 0; i < qualifications.size(); i++){
            info += "\n- " + qualifications.get(i);
        }
        info += "\n" + "📝 Characteristics: ";
        for(int i = 0; i < characteristics.size(); i++){
            info += "\n- " + characteristics.get(i);
        }
        info += "----------------------------\n";
        return info;
    }
}