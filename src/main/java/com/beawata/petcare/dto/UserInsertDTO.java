package com.beawata.petcare.dto;

import com.beawata.petcare.services.validation.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@UserInsertValid
public class UserInsertDTO extends UserDTO {

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "A senha deve conter pelo menos 8 caracteres")
    private String password;

    public UserInsertDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
