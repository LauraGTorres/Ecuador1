package brayanmattalauratorres.ecuador.config;

import brayanmattalauratorres.ecuador.model.constant.ContactPurpose;
import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.entity.AdminUser;
import brayanmattalauratorres.ecuador.model.entity.ContactRequest;
import brayanmattalauratorres.ecuador.model.entity.News;
import brayanmattalauratorres.ecuador.model.entity.Testimony;
import brayanmattalauratorres.ecuador.model.repository.AdminUserRepository;
import brayanmattalauratorres.ecuador.model.repository.ContactRequestRepository;
import brayanmattalauratorres.ecuador.model.repository.NewsRepository;
import brayanmattalauratorres.ecuador.model.repository.TestimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(
            AdminUserRepository adminUserRepository,
            NewsRepository newsRepository,
            TestimonyRepository testimonyRepository,
            ContactRequestRepository contactRequestRepository) {

        return args -> {

            if (adminUserRepository.findByEmail("admin@alianzaecuador.org").isEmpty()) {
                AdminUser admin = new AdminUser();
                admin.setEmail("admin@alianzaecuador.org");
                admin.setPassword(passwordEncoder.encode("Admin1234"));
                admin.setFullName("Admin Team");
                admin.setRole("ADMIN");
                adminUserRepository.save(admin);
            }

            if (newsRepository.count() == 0) {
                News n1 = new News();
                n1.setTitle("Resiliencia en comunidades del Ecuador");
                n1.setSummary("Nuestra fundación trabaja incansablemente para brindar apoyo a las comunidades más vulnerables del país.");
                n1.setContent("La Fundación Alianza Ecuador continúa su labor de transformación social, llegando a miles de familias que necesitan apoyo en educación, salud y bienestar. Nuestros programas de resiliencia han impactado positivamente a más de 5.000 personas durante el último trimestre.");
                n1.setImageUrl("https://images.unsplash.com/photo-1488521787991-ed7bbaae773c?w=800");
                n1.setAuthor("Elena M.");
                n1.setState(NewsState.PURPOSE_PUBLISHED);
                n1.setPublicationDate(LocalDateTime.now().minusDays(3));
                newsRepository.save(n1);

                News n2 = new News();
                n2.setTitle("Reforma educativa: un nuevo horizonte");
                n2.setSummary("Iniciamos una nueva fase de nuestro programa educativo con alianzas estratégicas en todo el país.");
                n2.setContent("El programa de reforma educativa de Alianza Ecuador está abriendo nuevas oportunidades para niños y jóvenes de escasos recursos. Con el apoyo de aliados internacionales, hemos logrado equipar 20 aulas digitales en zonas rurales.");
                n2.setImageUrl("https://images.unsplash.com/photo-1503676260728-1c00da094a0b?w=800");
                n2.setAuthor("David C.");
                n2.setState(NewsState.PURPOSE_DRAFT);
                n2.setPublicationDate(LocalDateTime.now().minusDays(6));
                newsRepository.save(n2);

                News n3 = new News();
                n3.setTitle("Acceso al agua: avances significativos");
                n3.setSummary("El proyecto de acceso al agua potable beneficia a 1.200 familias en zonas rurales de la sierra ecuatoriana.");
                n3.setContent("Gracias a la generosidad de nuestros donantes y el trabajo arduo de nuestro equipo, hemos instalado sistemas de agua potable en 15 comunidades rurales de la sierra ecuatoriana, mejorando la calidad de vida de más de 1.200 familias.");
                n3.setImageUrl("https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=800");
                n3.setAuthor("Elena M.");
                n3.setState(NewsState.PURPOSE_PUBLISHED);
                n3.setPublicationDate(LocalDateTime.now().minusDays(9));
                newsRepository.save(n3);
            }

            if (testimonyRepository.count() == 0) {
                String[] names = {"María García", "Carlos Mendoza", "Ana Torres", "José Rodríguez"};
                String[] photos = {
                    "https://randomuser.me/api/portraits/women/44.jpg",
                    "https://randomuser.me/api/portraits/men/32.jpg",
                    "https://randomuser.me/api/portraits/women/68.jpg",
                    "https://randomuser.me/api/portraits/men/75.jpg"
                };
                for (int i = 0; i < names.length; i++) {
                    Testimony t = new Testimony();
                    t.setName(names[i]);
                    t.setPhotoUrl(photos[i]);
                    t.setInstagramUrl("https://instagram.com");
                    t.setFacebookUrl("https://facebook.com");
                    t.setCreatedAt(LocalDateTime.now().minusDays(i * 2L));
                    testimonyRepository.save(t);
                }
            }

            if (contactRequestRepository.count() == 0) {
                Object[][] requests = {
                    {"Mateo López", "mateo.l@example.ec", "+593 98 123 4567", ContactPurpose.PURPOSE_SERVICE},
                    {"Elena Castro", "e.castro@mail.com", "+593 99 876 5432", ContactPurpose.PURPOSE_BUILDING_PROGRAM},
                    {"Ricardo Alvear", "r.alvear@foundation.org", "+593 97 555 0199", ContactPurpose.PURPOSE_SHOWS_AND_CONFERENCES},
                    {"Sofia Mendoza", "sofia.m@outlook.ec", "+593 95 222 3344", ContactPurpose.PURPOSE_BUILDING_PROGRAM}
                };
                for (Object[] req : requests) {
                    ContactRequest cr = new ContactRequest();
                    cr.setName((String) req[0]);
                    cr.setEmail((String) req[1]);
                    cr.setPhone((String) req[2]);
                    cr.setPurpose((ContactPurpose) req[3]);
                    cr.setCreatedAt(LocalDateTime.now().minusDays((int)(Math.random() * 5)));
                    contactRequestRepository.save(cr);
                }
            }
        };
    }
}
