package iuh.fit.week5;

import com.neovisionaries.i18n.CountryCode;
import iuh.fit.week5.entities.Address;
import iuh.fit.week5.entities.Candidate;
import iuh.fit.week5.enums.CandidateStatus;
import iuh.fit.week5.repositories.AddressRepository;
import iuh.fit.week5.services.AddressService;
import iuh.fit.week5.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Week5Application {
    @Qualifier("addressImplement")
    @Autowired
    private AddressService service;
    @Autowired
    private CandidateService candidateService;

    public static void main(String[] args) {
        SpringApplication.run(Week5Application.class, args);
    }

//    @Bean
//    CommandLineRunner initData() {
//
//        return args -> {
//            Random rd = new Random();
//            for (int i = 1; i < 1000; i++) {
//                Address a = new Address("HCM", CountryCode.VN, rd.nextInt(70000, 80000) + "", "Truong Chinh", rd.nextInt(1, 1000) + "");
//                service.save(a);
//                Candidate c = new Candidate(rd.nextLong(1111111111L, 9999999999L) + "", LocalDate.of(rd.nextInt(1980, 2004), rd.nextInt(1, 13), rd.nextInt(1, 29)), "email_" + i + "@gmail.com", "Name #" + i,a, CandidateStatus.ACTIVE);
//                candidateService.save(c);
//            }
//        };
//    }
}
