package brayanmattalauratorres.ecuador.model.dto;

import brayanmattalauratorres.ecuador.model.entity.Testimony;

import java.time.LocalDateTime;

public record TestimonyDTO(
        String name,
        String imageUrl,
        String instagramUrl,
        String facebookUrl
) {
    public Testimony toEntity() {
        Testimony testimony = new Testimony();
        testimony.setName(name);
        testimony.setPhotoUrl(imageUrl);
        testimony.setInstagramUrl(instagramUrl);
        testimony.setFacebookUrl(facebookUrl);
        testimony.setCreatedAt(LocalDateTime.now());
        return testimony;
    }
}