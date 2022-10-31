package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private  String dateOfBirth;
    private List<String> subjects;
    private List<String> hobbies;
    private String photoFile;
    private String currentAddress;
    private String state;
    private String city;
}
