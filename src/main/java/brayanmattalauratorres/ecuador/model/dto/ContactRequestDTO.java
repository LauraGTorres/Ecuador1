package brayanmattalauratorres.ecuador.model.dto;

import brayanmattalauratorres.ecuador.model.constant.ContactPurpose;
import brayanmattalauratorres.ecuador.model.entity.ContactRequest;

import java.time.LocalDateTime;

public record ContactRequestDTO(
        String name,
        String email,
        String phone,
        ContactPurpose purpose
) {
    public ContactRequest toEntity() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setName(name);
        contactRequest.setEmail(email);
        contactRequest.setPhone(phone);
        contactRequest.setPurpose(purpose);
        contactRequest.setCreatedAt(LocalDateTime.now());
        return contactRequest;
    }
}