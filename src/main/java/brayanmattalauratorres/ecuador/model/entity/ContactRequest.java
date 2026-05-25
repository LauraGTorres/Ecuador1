package brayanmattalauratorres.ecuador.model.entity;

import brayanmattalauratorres.ecuador.model.constant.ContactPurpose;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_request")
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_request_id")
    private Long contactRequestId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContactPurpose purpose;

    @Column(name = "created_At", nullable = false)
    private LocalDateTime createdAt;

    public ContactRequest() {}

    public Long getId() { return contactRequestId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public ContactPurpose getPurpose() { return purpose; }
    public void setPurpose(ContactPurpose purpose) { this.purpose = purpose; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}