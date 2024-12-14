package cainong.jimi.DTO;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private String userID;
    private String username;
    private String userGender;
    private String userImg;
    private String userAddress;
    private String userPhone;
    private String userEmail;

}
