package entities;

import java.util.List;

public class Users {
    public User getValidUser(){
        return new User.UserBuilder()
                .firstName("Firstname")
                .lastName("LastName")
                .email("email@gmail.com")
                .gender("Female")
                .phoneNumber("1234567891")
                .dateOfBirth("25 October,1990")
                .subjects(List.of("Maths", "English", "Computer Science"))
                .hobbies(List.of("Reading", "Music"))
                .photoFile("src/test/java/entities/photo.jpg")
                .currentAddress("Current Address, 25 - 104A")
                .state("NCR")
                .city("Delhi")
                .build();
    }
}
