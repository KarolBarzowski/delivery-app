package com.delivery.backend.service.implementation;

import com.delivery.backend.entity.ActivationEmail;
import com.delivery.backend.entity.Customer;
import com.delivery.backend.entity.EmailBody;
import com.delivery.backend.repository.ActivationEmailRepository;
import com.delivery.backend.service.ActivationEmailService;
import com.delivery.backend.service.implementation.MailService.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ActivationEmailServiceImpl implements ActivationEmailService {

    private final ActivationEmailRepository activationEmailRepository;
    private MailService mailService;

    //TODO ACTIVATION EMAIL DO REFACTORU
    public boolean createActivationEmailLink(Customer customer) {
        ActivationEmail activationEmail = new ActivationEmail();
        activationEmail.setActivationCode(createActivationLink());
        activationEmail.setCustomer(customer);
        activationEmail.setSentOn(LocalDateTime.now());
        activationEmail.setValidatedTo(LocalDateTime.now().plusHours(2));
        activationEmailRepository.save(activationEmail);
        mailService.sendMail(new EmailBody("Account confirmation", customer.getEmail(), "localhost:8080/activation/" + createActivationLink()));
        return true;
    }


    private String createActivationLink() {
        return createUUIDActivationLink().toString();
    }

    private UUID createUUIDActivationLink() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }
}
